package project.android.com.tw.dbtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

import static java.util.Arrays.fill;

public class CatsOtherData {

    private Context context;
    private final String[] enemy_property = {"白","赤い敵","黒い敵","浮いてる敵","メタル","天使","エイリアン","ゾンビ","魔女","無属性"};
    private final String[] enemy_property_zh = {"白敵","紅敵","黑敵","浮敵","鋼鐵敵","天使敵","異星敵","殭屍敵","魔女","無屬敵"};
    private ArrayList<String> characteristic ;
    private ArrayList<String> characteristic_zh ;

    public CatsOtherData(Context context){
        this.context = context;
    }

    public CatsItem start(CatsItem anItem){

        Log.d("AAA","\t"+anItem.cats_uid);
        anItem.cats_image = get_Image_base64(anItem.cats_uid) ;
        anItem.cats_zh_name = get_zh_name(anItem.cats_uid) ;
        anItem.cats_image_URL = get_image_URL(anItem.cats_uid);
        anItem.cats_zh_class = get_class_name(anItem.cats_uid);

        characteristic = new ArrayList<>();
        characteristic_zh = new ArrayList<>();
        for(String s : anItem.cats_characteristic)
            if(!s.equals("") && !s.equals("-"))
                characteristic.add(s);

        anItem.cats_continuous_attack = get_continuous_attack_characteristic( anItem.cats_continuous_attack_proportion );
        get_continuous_attack_zh( anItem.cats_continuous_attack , anItem.cats_continuous_attack_proportion );
        int[][] temp = get_addition_characteristic( characteristic ) ;
        anItem.set_cats_attr_proportion( temp );
        get_addition_characteristic_zh( temp );
        temp = get_abnormal_state_characteristic( characteristic ) ;
        anItem.set_cats_abnormal_state( temp );
        get_abnormal_state_zh( temp );
        anItem.set_cats_invalid( get_invalid_characteristic( characteristic ) );
        anItem.cats_resuscitation = get_zombie_killer_characteristic( characteristic );
        anItem.cats_critical = get_critical_characteristic( characteristic );
        int[] tmp = get_wave_characteristic( characteristic );
        anItem.cats_wave_probability = tmp[0];
        anItem.cats_wave_level = tmp[1];
        tmp = get_distant_attack_characteristic( characteristic );
        anItem.cats_distant_attack_min = tmp[0];
        anItem.cats_distant_attack_max = tmp[1];
        tmp = get_increase_attack_characteristic( characteristic );
        anItem.cats_increase_attack_hp = tmp[0];
        anItem.cats_increase_attack_proportion = tmp[1];
        anItem.cats_bounty = get_bounty_characteristic( characteristic );
        anItem.cats_survived_probability = get_survived_characteristic( characteristic );
        anItem.cats_metal = get_metal_characteristic( characteristic );
        anItem.cats_wave_remove = get_wave_remove_characteristic( characteristic ) ;
        anItem.cats_tower_attack = get_tower_attack_characteristic( characteristic ) ;
        for(int i=0 ; i<characteristic_zh.size() ; i++){
            anItem.cats_characteristic_zh[i] = characteristic_zh.get(i);
        }

        return anItem ;
    }

    private int[] str2intArray(String s){
        return str2intArray(s,false);
    }

    private int[] str2intArray(String s,boolean x){
        String s1="";
        boolean check = false ;
        int w = 0 ;
        for(int i=0 ; i<s.length() ; i++){
            if( s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                s1 += s.charAt(i);
                check = true ;
            }else if( check ){
                s1 += " ";
                check = false ;
            }
        }
        if (s.contains("～") && x) w = 1;
        String[] ss = s1.split(" ");
        int[] num = new int[ss.length - w];
        for(int i=0 ; i<ss.length-w ; i++ ){
                num[i] = Integer.parseInt(ss[ i>1? i+w : i ]);
        }
        return num;
    }

    private int str2int(String s){
        String s1="";
        boolean check = false ;
        for(int i=0 ; i<s.length() ; i++){
            if( s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                s1 += s.charAt(i);
                check = true ;
            }else if( check ){
                return Integer.parseInt(s1);
            }
        }
        return Integer.parseInt(s1);
    }

    private String int2str(int num){
        if( ( (float)num / 30 ) == (num/30) )
            return ""+num/30;
        else if( ( (float)num*10 / 3 ) == (num*10/3) )
            return ""+num/30.0;
        else
            return String.format(Locale.US,"%.2f",num/30.0);
    }

    private String get_Image_base64(String uid ){
        try {
            URL url = new URL("http://imgs-server.com/battlecats/" + uid.replace("_","-") + ".png");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Referer", "http://battlecats-db.com/unit/"+uid.substring(1,4)+".html");
            connection.connect();
            //Log.d("XXX",connection.getResponseCode()+"");
            InputStream stream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            return get_Image_base64(bitmap,uid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return get_Image_base64(null,uid);
    }

    private String get_Image_base64(Bitmap bmp,String uid){
        //Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier( uid , "drawable", context.getPackageName()));
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        assert bmp != null ;
        if(bmp==null) {
            Log.d("ZZZ", "Image NULL：" + uid);
            //bmp = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier( "u000_1" , "drawable", context.getPackageName()));
        }
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

        byte bytes[] = stream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private String get_zh_name(String uid){
        return get_txt_data( uid , 2 , "待補");
    }

    private String get_class_name(String uid){
        return get_txt_data( uid , 3 , "未分類");
    }

    private String get_txt_data(String uid , int n , String m){
        try {
            InputStream is = context.getAssets().open("translation_zh.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader((is)));
            String line ;
            while( ( line = br.readLine() ) != null ){
                String[]ss = line.split("\t");
                if( ss.length > 2 && ss[0].equals( uid ) ){
                    if( ss[2].length() > 0 )
                        br.close();
                        return ss[n];
                }
            }
        }catch ( IOException e ){
            e.printStackTrace();
        }
        return m;
    }

    private String get_image_URL(String uid){
        return "<tr><td><img src=D:\\android_project\\DBtest\\app\\src\\main\\res\\drawable\\"+uid+".png height=32 width=85></td></tr>";
    }

    private int[][] get_addition_characteristic( ArrayList<String> s ){
        int[][] attr = new int[ 2 ][ enemy_property.length ];
        String[] ss = (String[])s.toArray(new String[0]);
        for ( String s1 : ss) {
            if ( s1.contains( "めっぽう強い" ) ) {
                attr = get_enemy_property_judge( attr , s1 , 1 , 0 );
                attr = get_enemy_property_judge( attr , s1 , 1 , 1 );
                characteristic.remove(s1);
            }
            else if ( s1.contains("超ダメージ") ) {
                attr = get_enemy_property_judge( attr , s1 , 2 , 0 );
                characteristic.remove(s1);
            }
            else if ( s1.contains("打たれ強い") ) {
                attr = get_enemy_property_judge( attr , s1 , 2 , 1 );
                characteristic.remove(s1);
            }
            else if ( s1.contains("魔女キラー") ) {
                attr = get_enemy_property_judge( attr , s1 , 3 , 0 );
                attr = get_enemy_property_judge( attr , s1 , 3 , 1 );
                characteristic.remove(s1);
            }else if ( s1.contains("のみに攻撃") ) {
                fill(attr[0],-1);
                attr = get_enemy_property_judge( attr , s1 , 0 , 0 );
                characteristic.remove(s1);
            }
            if( s1.contains("除く") ){
                attr = get_enemy_property_except_judge( attr , s1 , "超ダメージ" , 0 );
                attr = get_enemy_property_except_judge( attr , s1 , "めっぽう強い" , 0 );
                attr = get_enemy_property_except_judge( attr , s1 , "のみに攻撃" , -1 , 0 );
                attr = get_enemy_property_except_judge( attr , s1 , "打たれ強い" , 1 );
                attr = get_enemy_property_except_judge( attr , s1 , "めっぽう強い" , 1 );
            }
        }
        return attr;
    }

    private int[][] get_enemy_property_judge( int[][] attr, String s , int num ,int flag ){
        boolean check = s.contains( "全ての敵" ) ;
        for ( int i = 0 ; i < enemy_property.length ; i++) {
            if ( check || s.contains( enemy_property[i] ) ) {
                attr[flag][i] = num ;
            }
        }
        return attr;
    }

    private int[][] get_enemy_property_except_judge( int[][] attr , String s1 , String s2, int flag ){
        return  get_enemy_property_except_judge( attr , s1 , s2 , 0 , flag );
    }

    private int[][] get_enemy_property_except_judge( int[][] attr , String s1 , String s2,int num, int flag ){
        if ( s1.contains(s2) ) {
            for ( int i = 0; i < enemy_property.length; i++) {
                if (s1.indexOf("(") < s1.indexOf(enemy_property[i])) {
                    attr[flag][i] = num ;
                }
            }
        }
        return attr;
    }

    private int[][] get_abnormal_state_characteristic( ArrayList<String> s ){
        int[][] attr = new int[ 8 ][ enemy_property.length ];
        String[] ss = (String[])s.toArray(new String[0]);
        for( String s1 : ss ){
            if( s1.contains("確率") ) {
                if ( s1.contains("ふっとばす") ) {
                    attr = get_enemy_property_judge( attr , s1 , str2int(s1) , 0 ) ;
                    characteristic.remove(s1);
                }
                else if ( s1.contains("遅くする") ) {
                    int[] p = str2intArray( s1 , true );
                    attr = get_enemy_property_judge( attr , s1 , p[0] , 1 ) ;
                    attr = get_enemy_property_judge( attr , s1 , p[1] , 2 ) ;
                    characteristic.remove(s1);
                }
                else if ( s1.contains("止める") ) {
                    int[] p = str2intArray( s1 , true );
                    attr = get_enemy_property_judge( attr , s1 , p[0] , 3 ) ;
                    attr = get_enemy_property_judge( attr , s1 , p[1] , 4 ) ;
                    characteristic.remove(s1);
                }
                else if ( s1.contains("に低下") ) {
                    int[] p = str2intArray( s1 , true );
                    attr = get_enemy_property_judge( attr , s1 , p[0] , 5 ) ;
                    attr = get_enemy_property_judge( attr , s1 , p[1] , 6 ) ;
                    attr = get_enemy_property_judge( attr , s1 , p[2] , 7 ) ;
                    characteristic.remove(s1);
                }
                if( s1.contains("除く") ){
                    attr = get_enemy_property_except_judge( attr , s1 , "ふっとばす" , 0 );
                    attr = get_enemy_property_except_judge( attr , s1 , "遅くする" , 1 );
                    attr = get_enemy_property_except_judge( attr , s1 , "遅くする" , 2 );
                    attr = get_enemy_property_except_judge( attr , s1 , "止める" , 3 );
                    attr = get_enemy_property_except_judge( attr , s1 , "止める" , 4 );
                    attr = get_enemy_property_except_judge( attr , s1 , "に低下" , 5 );
                    attr = get_enemy_property_except_judge( attr , s1 , "に低下" , 6 );
                    attr = get_enemy_property_except_judge( attr , s1 , "に低下" , 7 );
                }
            }
        }
        return attr;
    }

    private void get_addition_characteristic_zh(int[][] attr){
        String tmp ;
        tmp = get_enemy(attr,1,0) ;
        if(!tmp.equals(""))
            characteristic_zh.add( "對 " + tmp + " 傷害150%、傷害減免50%");
        tmp = get_enemy(attr,2,0) ;
        if(!tmp.equals(""))
            characteristic_zh.add( "對 " + tmp + " 傷害300%");
        tmp = get_enemy(attr,2,1) ;
        if(!tmp.equals(""))
            characteristic_zh.add( "對 " + tmp + " 傷害減免75%");
        tmp = get_enemy(attr,3,0) ;
        if(!tmp.equals(""))
            characteristic_zh.add( "對 " + tmp + " 傷害500%、傷害減免90%");
        tmp = get_enemy(attr,-1,0) ;
        if(!tmp.equals(""))
            characteristic_zh.add( "僅對 " + tmp + " 攻擊");
    }

    private String get_enemy( int[][] attr , int num , int flag){
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int cnt = 0 ;
        boolean check1 = false ;
        boolean check2 = false ;
        for( int i=0 ; i<enemy_property.length ; i++ ){
            if( attr[flag][i] == num ){
                if( check1 ) {
                    s1.append("、");
                }
                s1.append(enemy_property_zh[i]);
                check1 = true ;
                cnt++;
            }
            else{
                if ( check2 ){
                    s2.append("、");
                }
                s2.append(enemy_property_zh[i]);
                check2 = true ;

            }
        }
        if( cnt==0 )
            return "";
        else if( cnt<5 )
            return s1.toString();
        else if( cnt<enemy_property.length )
            return "全屬性敵（除了 " + s2.toString() + " 以外）";
        else
            return "全屬性敵" ;
    }

    private void get_abnormal_state_zh( int[][] attr ){
        String tmp;
        int[] var;
        tmp = get_enemy( attr , 0 );
        if(!tmp.equals("")){
            var = get_var(attr,0);
            characteristic_zh.add("對 "+ tmp +" " + var[0] + "%機率造成擊退");
        }
        tmp = get_enemy( attr , 1 );
        if(!tmp.equals("")){
            var = get_var( attr , 1 );
            characteristic_zh.add("對 "+ tmp +" " + var[0] + "%機率造成" + int2str(var[1]) + "秒緩速"  );
        }
        tmp = get_enemy( attr , 3 );
        if(!tmp.equals("")){
            var = get_var( attr , 3 );
            characteristic_zh.add("對 "+ tmp +" " + var[0] + "%機率造成" + int2str(var[1]) + "秒暫停" );
        }
        tmp = get_enemy( attr , 5 );
        if(!tmp.equals("")){
            var = get_var( attr , 5 );
            characteristic_zh.add("對 "+ tmp +" " + var[0] + "%機率造成" + int2str(var[1]) + "秒攻擊力下降至" + var[2] + "%" );
        }
    }

    private String get_enemy( int[][] attr , int flag){
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int cnt = 0 ;
        boolean check1 = false ;
        boolean check2 = false ;
        for( int i=0 ; i<enemy_property.length; i++ ){
            if( attr[flag][i] > 0 ){
                if( check1 ) {
                    s1.append("、");
                }
                s1.append(enemy_property_zh[i]);
                check1 = true ;
                cnt++;
            }
            else{
                if ( check2 ){
                    s2.append("、");
                }
                s2.append(enemy_property_zh[i]);
                check2 = true ;
            }
        }
        if( cnt==0 )
            return "";
        else if( cnt<5 )
            return s1.toString();
        else if( cnt<enemy_property.length )
            return "全屬性敵（除了 " + s2.toString() + " 以外）";
        else
            return "全屬性敵" ;
    }

    private int[] get_var( int[][] attr , int flag ){
        int tmp[] = new int[3];
        for(int i=0 ; i<enemy_property.length ; i++){
            for(int j=0 ; j<3 ; j++) {
                if (attr[flag+j][i] != 0) {
                    tmp[j] = attr[flag+j][i];
                }
            }
        }
        return tmp;
    }

    private int[] get_invalid_characteristic( ArrayList<String> s ){
        final String[] invalid = {"波動","ふっとばす","遅くする","止める","攻撃力低下","ワープ"};
        final String[] invalid_zh = {"波動","擊退","緩速","暫停","攻撃力降低","傳送"};
        int[] attr = new int[ invalid.length ];
        boolean check = false;
        String str = "";
        for( String s1 : s){
            if( s1.contains("無効")) {
                for (int i = 0; i < invalid.length; i++) {
                    if ( s1.contains(invalid[i]) ) {
                        attr[i] = 1;
                        if(!str.equals(""))
                            str += "、" ;
                        str += invalid_zh[i];
                        check = true;
                    }
                }
            }
            if(check) {
                characteristic.remove(s1);
                characteristic_zh.add("免疫（" + str + "）");
                return attr;
            }
        }
        return attr;
    }

    private int get_some_characteristic( ArrayList<String> als , String s1 , String s2 ){
        for( String s : als ){
            if( s.contains( s1 ) ){
                characteristic_zh.add( s2 );
                characteristic.remove( s );
                return 1 ;
            }
        }
        return 0 ;
    }

    private int get_zombie_killer_characteristic( ArrayList<String> s ){
        return  get_some_characteristic( s , "ゾンビキラー" , "擊倒殭屍敵時，阻止復活");
    }

    private int get_metal_characteristic( ArrayList<String> s ){
        return get_some_characteristic( s , "被ダメージ1" , "非暴擊之傷害降低至1點" );
    }

    private int get_wave_remove_characteristic( ArrayList<String> s ){
        return get_some_characteristic( s , "波動打ち消し" , "消除波動" );
    }

    private int get_tower_attack_characteristic( ArrayList<String> s ) {
        return get_some_characteristic( s , "敵城" , "對敵城 4倍傷害" );
    }

    private int get_bounty_characteristic( ArrayList<String> s ){
        return get_some_characteristic( s , "貰えるお金" , "打倒敵人時，獲得兩倍金錢" );
    }

    private int get_some_characteristic_1( ArrayList<String> als , String s1 , String s2 ){
        for( String s : als ){
            if( s.contains( s1 ) ){
                characteristic.remove(s);
                int tmp = str2int(s);
                characteristic_zh.add(tmp + s2 );
                return  tmp;
            }
        }
        return 0 ;
    }

    private int get_critical_characteristic( ArrayList<String> s ){
        return get_some_characteristic_1( s , "でクリティカル攻撃" , "%機率造成暴擊" ) ;
    }

    private int get_survived_characteristic( ArrayList<String> s ){
        return get_some_characteristic_1( s , "だけ生き残る" , "%機率，生還一次" );
    }

    private int get_barrier_breaker( ArrayList<String> s ){
        return get_some_characteristic_1( s , "バリアブレイカー" , "%機率，破壞護盾");
    }

    private int[] get_some_characteristic_2( ArrayList<String> als , String s1 , String s2 , String s3 ,String s4 ){
        for( String s : als ){
            if (s.contains( s1 ) ) {
                characteristic.remove(s);
                int[] tmp = str2intArray(s);
                characteristic_zh.add( s2 + tmp[0] + s3 + tmp[1] + s4 );
                return tmp;
            }
        }
        return new int[]{0,0};
    }

    private int[] get_distant_attack_characteristic( ArrayList<String> s ){
        return get_some_characteristic_2( s , "遠方" , "遠方攻擊（" , "~" , "）" );
    }

    private int[] get_increase_attack_characteristic( ArrayList<String> s ){
        return get_some_characteristic_2( s , "攻撃力上昇" , "體力小於" , "%時，攻擊力增加" , "%" );
    }

    private int[] get_wave_characteristic( ArrayList<String> s ){
        for( String s1 : s ){
            if (s1.contains("波動") && s1.contains("確率")) {
                characteristic.remove(s1);
                int[] tmp = str2intArray(s1);
                characteristic_zh.add( "擊中時，" + tmp[0] + "%機率釋放" + tmp[1] + "個波動");
                return tmp;
            }
        }
        return new int[]{0,0};
    }

    private int get_continuous_attack_characteristic(int[] n){
        int j=0;
        for(int i : n){
            if(i>0) j++ ;
        }
        return j;
    }

    private void get_continuous_attack_zh(int num,int[] attr){
        if(num>1) {
            String s="";
            int sum = 0;
            for (int anAttr : attr) {
                sum += anAttr;
            }
            for (int i = 0; i < num; i++) {
                int tmp = attr[i]*100/sum ;
                if(tmp>0)
                    s += " " + tmp + "%" ;
            }
            characteristic_zh.add(num + "連續攻擊（" + s + " ）");
        }
    }

}
