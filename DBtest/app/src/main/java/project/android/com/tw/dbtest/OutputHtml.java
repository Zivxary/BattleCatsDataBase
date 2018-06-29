package project.android.com.tw.dbtest;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

import static android.Manifest.permission.*;

public class OutputHtml {

    private final String TAG = "XXX";

    //private final String PERMISSION_WRITE_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private int outputflag = 1 ;

    private Context context ;
    private Activity activity;
    private final String path ;
    private final String filename ;
    private FileOutputStream fos;
    private FileOutputStream fosn;

    int no_ = 2;

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public OutputHtml(Context context,Activity activity){
        this.context = context ;
        this.activity = activity ;
        //path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/_database" ;
        path = context.getFilesDir().getPath();
        filename = "database.html";
    };

    public void check_permission(){
        int permission = ContextCompat.checkSelfPermission(context, WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions( activity , PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }else{
                file_create();
                //file_build();
        }
    }

    private boolean check_app_rw(){
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            Log.d(TAG, "可以讀寫");
            return true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            Log.d(TAG, "只可以讀取，無法寫入");
        } else {
            Log.d(TAG, "無法讀寫");
        }
        return false ;
    }

    //apk內部儲存
    private void file_create(){
        try {
            fos = activity.openFileOutput(filename,Context.MODE_PRIVATE);
            if( outputflag == 0)
                title_column2excel() ;
            else if( outputflag == 1)
                write_html_title();
                //title_column2html() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        file_create_name();
    }

    public String read_html(){
        try {
            FileInputStream fis = activity.openFileInput(filename);
            byte[] bytes = new byte[1024];
            StringBuilder sb = new StringBuilder();
            while ( fis.read(bytes) != -1 ){
                sb.append(new String(bytes));
            }
            fis.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    //內置SD儲存
    private void file_build(){
        File dir = new File( path );
        if(!dir.exists()){
            dir.mkdir();
        }
        File file = new File(dir.getAbsolutePath() + "/" + filename );
        try {
            fos = new FileOutputStream(file);
            if( outputflag == 0)
                title_column2excel() ;
            else if( outputflag == 1)
                write_html_title();
            //title_column2html() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG,file.getAbsolutePath());
    }

    public String readhtml(){
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader( path + "/" + filename ));
            String line = "" ;
            while( (line = br.readLine() ) != null ){
                sb.append(line).append("\n");
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private boolean writefile( String s ){
        try {
            fos.write(s.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean writefile_td(int num , String s1 ,String s2 ){
        StringBuffer s = new StringBuffer();
        for(int i=0 ; i<num ; i++){
            s.append("\t");
        }
        s.append("<td");
        if(s1.length()>0)
            s.append(" "+s1);
        if(s2.length()>0)
            s.append(">").append(s2).append("</td>\n");
        else
            s.append("></td>\n");
        return writefile(s.toString());
    }

    private boolean writefile_td( int num , String s1 ){
        return writefile_td( num , "" ,  s1 );
    }

    private boolean writefile_td( int num ){
        return writefile_td( num , "" , "" );
    }

    private boolean writefile_td( int num , String s1 , int i ){
        return writefile_td( num , s1 , i+"" );
    }

    private boolean writefile_td( int num , int i ){
        return writefile_td( num , "" , i+"" );
    }

    private boolean writefile_td( int num , String s1 , float i ){
        return writefile_td( num , s1 , i+"" );
    }

    private boolean writefile_td( int num , float i ){
        return writefile_td( num , "" , i+"" );
    }

    private boolean writefile_td_class( int num , String s1 , float i ){
        return writefile_td( num , "class=\""+s1+"\"" , i+"" );
    }

    private void title_column2excel() {
        final String[] strarray = {
                "類別", "稀有", "編號", "圖片",
                "基礎血", "基礎攻", "攻頻", "攻發", "間隔", "範圍", "產時",
                "砍半1","砍半2","計等",
                "中文名", "日文名", "等級",
                "體力", "攻擊", "硬度", "DPS",
                "攻頻", "攻發", "間隔",
                "KB", "速度", "射程", "範圍", "再生產", "金額",
                "特性1", "特性2", "特性3", "特性4",

        };
        writefile("<table>\n");
        writefile("\t<tr>\n");
        for (String aStrarray : strarray) {
            writefile_td(2 , aStrarray);
        }
        writefile("\t</tr>\n");
    }

    private void title_column2html(){
        final String[] strarray = {
                "類別", "rare" , "稀有", "編號", "圖片",
                "bhp", "batk", "aff", "aof" , "aif","type", "cd",
                "clv", "hlv1" , "hlv2" , "mlv1" , "mlv2" ,
                "中文名", "日文名", "等級",
                "體力", "攻擊", "硬度", "DPS",
                "攻頻", "攻發", "間隔",
                "KB", "速度", "射程", "範圍", "再生產", "金額",
                "特性"
        };
        write_html_title();
        int[] index = {1,5,6,7,8,9,10,11,12,13,14,15,16,999};
        int j=0 ;
        for (int i=0 ; i<strarray.length ; i++) {
            if(index[j]==i) {
                writefile("\t\t\t\t\t<th class=\"behide\">" + strarray[i] + "</th>\n");
                j++;
            }
            else
                writefile("\t\t\t\t\t<th>"+strarray[i]+"</th>\n");
        }
        writefile("\t\t\t\t</tr>\n");
        writefile("\t\t\t</thead>\n");
        writefile("\t\t\t<tbody>\n");
    }

    private boolean write_html_title(){
        try {
            InputStream is = context.getAssets().open("html_title.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader((is)));
            String line ;
            while( ( line = br.readLine() ) != null ){
                writefile(line+"\n");
            }
            return true;
        }catch ( IOException e ){
            e.printStackTrace();
        }
        return false;
    }

    public void outputfile(CatsItem item){
        if( outputflag == 0 ){
            outputfile2excel(item);
        }else if(outputflag == 1){
            outputfile2html(item);
        }
        outputfilename(item);
    }

    private void file_create_name(){
        try {
            fosn = activity.openFileOutput("translation_zh.txt",Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void outputfilename(CatsItem item){
        try {
            fosn.write( (item.cats_uid +"\t" + item.cats_jp_name + "\t" + ( item.cats_zh_name.equals("待補")?"":item.cats_zh_name ) + "\n" ).getBytes() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void outputfile2excel(CatsItem item) {

        final int tn = 2 ;

        writefile("\t<tr>\n");
        /*
        writefile_td( tn );
        writefile_td( tn , cats_rarity( item.cats_rarity ) );
        writefile_td( tn , item.cats_uid );

        writefile_td( tn , "<img src=\"D:\\android_project\\DBtest\\app\\src\\main\\res\\drawable\\" + item.cats_uid + ".png\">" );
        //writefile_td("<img src=\"http://imgs-server.com/battlecats/"+item.cats_uid.replace("_","-")+".png\">");
        //writefile_td( tn , "<img src=\"data:image/png;base64,"+item.cats_image+"\">");

        writefile_td( tn , item.cats_basic_hp );
        writefile_td( tn , item.cats_basic_attack );
        writefile_td( tn , item.cats_attack_frequency );
        writefile_td( tn , item.cats_attack_occurs );
        writefile_td( tn , item.cats_attack_interval );
        writefile_td( tn , item.cats_attack_type );
        writefile_td( tn , item.cats_cooling_time );

        writefile_td( tn , hlv_judge(item.cats_rarity , item.cats_zh_name));
        writefile_td( tn , hlv_judge(item.cats_rarity) );
        writefile_td( tn , "=Q" + no_ + "-MAX(Q" + no_ + "-L" + no_ + ",0)/2-MAX(Q" + no_ + "-M" + no_ + ",0)/4+4" );

        writefile_td( tn , item.cats_zh_name );
        writefile_td( tn , item.cats_jp_name );
        writefile_td( tn , item.cats_max_level + item.cats_custom_bonus_level );

        writefile_td( tn , "E" + no_  + "*N" + no_ + "/2" );
        writefile_td( tn , "F" + no_  + "*N" + no_ + "/2" );
        writefile_td( tn );
        writefile_td( tn );

        writefile_td( tn );
        writefile_td( tn );
        writefile_td( tn );

        writefile_td( tn , item.cats_knock_back );
        writefile_td( tn , item.cats_move_speed );
        writefile_td( tn , item.cats_attack_distance );
        writefile_td( tn );
        writefile_td( tn );
        writefile_td( tn , item.cats_cost );

        writefile_td( tn , item.cats_characteristic_zh[0] );
        writefile_td( tn , item.cats_characteristic_zh[1] );
        writefile_td( tn , item.cats_characteristic_zh[2] );
        writefile_td( tn , item.cats_characteristic_zh[3] );

        writefile( "\t</tr>\n" );

        no_ ++ ;
        */
        writefile_td( tn , item.cats_uid );
        writefile_td( tn , item.cats_jp_name );
        writefile_td( tn , item.cats_zh_name );
        writefile_td( tn , item.cats_zh_class );
        writefile_td( tn , item.cats_jp_class );
        writefile_td( tn , item.cats_image );
        writefile_td( tn , item.cats_rarity );
        writefile_td( tn , item.cats_max_level );
        writefile_td( tn , item.cats_max_bonus_level );
        writefile_td( tn , item.cats_custom_level );
        writefile_td( tn , item.cats_custom_bonus_level );
        writefile_td( tn , item.cats_basic_hp );
        writefile_td( tn , item.cats_basic_attack );
        writefile_td( tn , item.cats_attack_frequency );
        writefile_td( tn , item.cats_attack_occurs );
        writefile_td( tn , item.cats_attack_interval );
        writefile_td( tn , item.cats_attack_distance );
        writefile_td( tn , item.cats_attack_type );
        writefile_td( tn , item.cats_move_speed );
        writefile_td( tn , item.cats_knock_back );
        writefile_td( tn , item.cats_cost );
        writefile_td( tn , item.cats_cooling_time );
        writefile_td( tn , item.cats_characteristic[0] );
        writefile_td( tn , item.cats_characteristic[1] );
        writefile_td( tn , item.cats_characteristic[2] );
        writefile_td( tn , item.cats_characteristic[3] );
        writefile_td( tn , item.cats_characteristic_zh[0] );
        writefile_td( tn , item.cats_characteristic_zh[1] );
        writefile_td( tn , item.cats_characteristic_zh[2] );
        writefile_td( tn , item.cats_characteristic_zh[3] );

        writefile_td( tn , item.cats_critical );

        writefile_td( tn , item.cats_white_damage );
        writefile_td( tn , item.cats_white_resistance );
        writefile_td( tn , item.cats_red_damage );
        writefile_td( tn , item.cats_red_resistance );
        writefile_td( tn , item.cats_black_damage );
        writefile_td( tn , item.cats_black_resistance );
        writefile_td( tn , item.cats_fly_damage );
        writefile_td( tn , item.cats_fly_resistance );
        writefile_td( tn , item.cats_steel_damage );
        writefile_td( tn , item.cats_steel_resistance );
        writefile_td( tn , item.cats_angel_damage );
        writefile_td( tn , item.cats_angel_resistance );
        writefile_td( tn , item.cats_alien_damage );
        writefile_td( tn , item.cats_alien_resistance );
        writefile_td( tn , item.cats_zombie_damage );
        writefile_td( tn , item.cats_zombie_resistance );
        writefile_td( tn , item.cats_witch_damage );
        writefile_td( tn , item.cats_witch_resistance );
        writefile_td( tn , item.cats_noattr_damage );
        writefile_td( tn , item.cats_noattr_resistance );

        writefile_td( tn , item.cats_evolution_green );
        writefile_td( tn , item.cats_evolution_purple );
        writefile_td( tn , item.cats_evolution_red );
        writefile_td( tn , item.cats_evolution_blue );
        writefile_td( tn , item.cats_evolution_yellow );
        writefile_td( tn , item.cats_evolution_colorful );

        writefile_td( tn , item.cats_survived_probability );
        writefile_td( tn , item.cats_bounty );
        writefile_td( tn , item.cats_wave_level );
        writefile_td( tn , item.cats_wave_probability );
        writefile_td( tn , item.cats_resuscitation );
        writefile_td( tn , item.cats_tower_attack );
        writefile_td( tn , item.cats_metal );
        writefile_td( tn , item.cats_wave_remove );

        writefile_td( tn , item.cats_continuous_attack );
        writefile_td( tn , item.cats_continuous_attack_proportion[0] );
        writefile_td( tn , item.cats_continuous_attack_proportion[1] );
        writefile_td( tn , item.cats_continuous_attack_proportion[2] );
        writefile_td( tn , item.cats_distant_attack_min );
        writefile_td( tn , item.cats_distant_attack_max );
        writefile_td( tn , item.cats_increase_attack_hp );
        writefile_td( tn , item.cats_increase_attack_proportion );

        writefile_td( tn , item.cats_wave_invalid );
        writefile_td( tn , item.cats_repel_invalid );
        writefile_td( tn , item.cats_slow_invalid );
        writefile_td( tn , item.cats_stop_invalid );
        writefile_td( tn , item.cats_reduce_attack_invalid );

        writefile_td( tn , item.cats_white_repel_probability );
        writefile_td( tn , item.cats_white_slow_probability );
        writefile_td( tn , item.cats_white_slow_time );
        writefile_td( tn , item.cats_white_stop_probability );
        writefile_td( tn , item.cats_white_stop_time );
        writefile_td( tn , item.cats_white_reduce_attack_probability );
        writefile_td( tn , item.cats_white_reduce_attack_time );
        writefile_td( tn , item.cats_white_reduce_attack_proportion );

        writefile_td( tn , item.cats_red_repel_probability );
        writefile_td( tn , item.cats_red_slow_probability );
        writefile_td( tn , item.cats_red_slow_time );
        writefile_td( tn , item.cats_red_stop_probability );
        writefile_td( tn , item.cats_red_stop_time );
        writefile_td( tn , item.cats_red_reduce_attack_probability );
        writefile_td( tn , item.cats_red_reduce_attack_time );
        writefile_td( tn , item.cats_red_reduce_attack_proportion );

        writefile_td( tn , item.cats_black_repel_probability );
        writefile_td( tn , item.cats_black_slow_probability );
        writefile_td( tn , item.cats_black_slow_time );
        writefile_td( tn , item.cats_black_stop_probability );
        writefile_td( tn , item.cats_black_stop_time );
        writefile_td( tn , item.cats_black_reduce_attack_probability );
        writefile_td( tn , item.cats_black_reduce_attack_time );
        writefile_td( tn , item.cats_black_reduce_attack_proportion );

        writefile_td( tn , item.cats_fly_repel_probability );
        writefile_td( tn , item.cats_fly_slow_probability );
        writefile_td( tn , item.cats_fly_slow_time );
        writefile_td( tn , item.cats_fly_stop_probability );
        writefile_td( tn , item.cats_fly_stop_time );
        writefile_td( tn , item.cats_fly_reduce_attack_probability );
        writefile_td( tn , item.cats_fly_reduce_attack_time );
        writefile_td( tn , item.cats_fly_reduce_attack_proportion );

        writefile_td( tn , item.cats_steel_repel_probability );
        writefile_td( tn , item.cats_steel_slow_probability );
        writefile_td( tn , item.cats_steel_slow_time );
        writefile_td( tn , item.cats_steel_stop_probability );
        writefile_td( tn , item.cats_steel_stop_time );
        writefile_td( tn , item.cats_steel_reduce_attack_probability );
        writefile_td( tn , item.cats_steel_reduce_attack_time );
        writefile_td( tn , item.cats_steel_reduce_attack_proportion );

        writefile_td( tn , item.cats_angel_repel_probability );
        writefile_td( tn , item.cats_angel_slow_probability );
        writefile_td( tn , item.cats_angel_slow_time );
        writefile_td( tn , item.cats_angel_stop_probability );
        writefile_td( tn , item.cats_angel_stop_time );
        writefile_td( tn , item.cats_angel_reduce_attack_probability );
        writefile_td( tn , item.cats_angel_reduce_attack_time );
        writefile_td( tn , item.cats_angel_reduce_attack_proportion );

        writefile_td( tn , item.cats_alien_repel_probability );
        writefile_td( tn , item.cats_alien_slow_probability );
        writefile_td( tn , item.cats_alien_slow_time );
        writefile_td( tn , item.cats_alien_stop_probability );
        writefile_td( tn , item.cats_alien_stop_time );
        writefile_td( tn , item.cats_alien_reduce_attack_probability );
        writefile_td( tn , item.cats_alien_reduce_attack_time );
        writefile_td( tn , item.cats_alien_reduce_attack_proportion );

        writefile_td( tn , item.cats_zombie_repel_probability );
        writefile_td( tn , item.cats_zombie_slow_probability );
        writefile_td( tn , item.cats_zombie_slow_time );
        writefile_td( tn , item.cats_zombie_stop_probability );
        writefile_td( tn , item.cats_zombie_stop_time );
        writefile_td( tn , item.cats_zombie_reduce_attack_probability );
        writefile_td( tn , item.cats_zombie_reduce_attack_time );
        writefile_td( tn , item.cats_zombie_reduce_attack_proportion );

        writefile_td( tn , item.cats_witch_repel_probability );
        writefile_td( tn , item.cats_witch_slow_probability );
        writefile_td( tn , item.cats_witch_slow_time );
        writefile_td( tn , item.cats_witch_stop_probability );
        writefile_td( tn , item.cats_witch_stop_time );
        writefile_td( tn , item.cats_witch_reduce_attack_probability );
        writefile_td( tn , item.cats_witch_reduce_attack_time );
        writefile_td( tn , item.cats_witch_reduce_attack_proportion );

        writefile_td( tn , item.cats_noattr_repel_probability );
        writefile_td( tn , item.cats_noattr_slow_probability );
        writefile_td( tn , item.cats_noattr_slow_time );
        writefile_td( tn , item.cats_noattr_stop_probability );
        writefile_td( tn , item.cats_noattr_stop_time );
        writefile_td( tn , item.cats_noattr_reduce_attack_probability );
        writefile_td( tn , item.cats_noattr_reduce_attack_time );
        writefile_td( tn , item.cats_noattr_reduce_attack_proportion );

    }

    private void outputfile2html(CatsItem item) {
        final int tn = 5 ;
        String ts = "\t\t\t\t\t" ;
        String tmp;
        writefile("\t\t\t\t<tr>\n");

        writefile_td( tn );
        writefile_td( tn , "class=\"behide crare\"" ,item.cats_rarity );
        writefile_td( tn , "class=\"cra\"" , cats_rarity( item.cats_rarity ) );
        writefile_td( tn , "class=\"cid\"" , item.cats_uid );

        //writefile_td_html("<img src=\"D:\\android_project\\DBtest\\app\\src\\main\\res\\drawable\\" + item.cats_uid + ".png\">" );
        //writefile_td_html("<img src=\"http://imgs-server.com/battlecats/"+item.cats_uid.replace("_","-")+".png\">");
        writefile_td( tn , "class=\"cpic\"" , "<img src=\"data:image/png;base64,"+item.cats_image+"\">");

        writefile_td( tn , "class=\"behide cbhp\"" , item.cats_basic_hp );
        writefile_td( tn , "class=\"behide cbatk\"" , item.cats_basic_attack );
        writefile_td( tn , "class=\"behide caff\"" , item.cats_attack_frequency );
        writefile_td( tn , "class=\"behide caof\"" , item.cats_attack_occurs );
        writefile_td( tn , "class=\"behide caif\"" , item.cats_attack_interval );
        writefile_td( tn , "class=\"behide ciat\"" , item.cats_attack_type );
        writefile_td( tn , "class=\"behide ccd\"" , item.cats_cooling_time );

        float clv = lv_calculate( item.cats_custom_level + item.cats_custom_bonus_level ) ;

        //writefile_td( tn , "class=\"behide cclv\"" , clv );
        writefile_td( tn , "class=\"behide chlv1\"" , hlv_judge( item.cats_rarity ,item.cats_zh_name ) );
        writefile_td( tn , "class=\"behide chlv2\"" , hlv_judge( item.cats_rarity ) );
        writefile_td( tn , "class=\"behide cmlv1\"" , item.cats_max_level );
        writefile_td( tn , "class=\"behide cmlv2\"" , item.cats_max_bonus_level );

        writefile_td( tn , "class=\"czn\"" , item.cats_zh_name );
        tmp = "<a href=\"http://battlecats-db.com/unit/" + (item.cats_uid+"").substring(1,4) + ".html\">" + item.cats_jp_name + "</a>";
        writefile_td( tn , "class=\"cjn\"" , tmp );
        String s = "<input type=\"text\" class=\"inputlv\" value=\""+ ( item.cats_max_level + item.cats_custom_bonus_level ) +"\">";
        writefile_td( tn , "class=\"clv\"" , s );

        writefile_td( tn , "class=\"chp\"" , (int) (item.cats_basic_hp * clv) );
        writefile_td( tn , "class=\"catk\"" , (int)(item.cats_basic_attack * clv) );
        writefile_td( tn , "class=\"chn\"" , int2str( (int) (item.cats_basic_hp * clv) , item.cats_knock_back));
        writefile_td( tn , "class=\"cdps\"" , int2str( (int)(item.cats_basic_attack * clv) , item.cats_attack_frequency/((item.cats_critical+100)/100f)/30) );

        writefile_td( tn , "class=\"cafs\"" , int2str(item.cats_attack_frequency) );
        writefile_td( tn , "class=\"caos\"" , int2str(item.cats_attack_occurs) );
        writefile_td( tn , "class=\"cais\"" , int2str(item.cats_attack_interval) );

        writefile_td( tn , "class=\"ckb\"" , item.cats_knock_back );
        writefile_td( tn , "class=\"cspd\"" , item.cats_move_speed );
        writefile_td( tn , "class=\"cad\"" , item.cats_attack_distance );
        writefile_td( tn , "class=\"csat\"" , attack_type_int( item.cats_attack_type ) );
        writefile_td( tn , "class=\"cct\"" , cd_calculate(item.cats_cooling_time) );
        writefile_td( tn , "class=\"cco\"" , item.cats_cost*3/2 );


        tmp = "\n" + ts + item.cats_characteristic_zh[0] + "\n" + ts + "<br>" +
                item.cats_characteristic_zh[1] + "\n" + ts + "<br>" +
                item.cats_characteristic_zh[2] + "\n" + ts + "<br>" +
                item.cats_characteristic_zh[3] + "\n" + ts ;
        writefile_td( tn , "class=\"cch\"" , tmp );



        writefile( "\t\t\t\t</tr>\n" );
    }

    private float lv_calculate(int lv){
        return lv>60? (lv-60)/4+32 : lv/2+2 ;
    }

    private String cats_rarity(int i){
        switch (i){
            case 1 :
                return "基本";
            case 2 :
                return "EX" ;
            case 3 :
                return "稀有" ;
            case 4 :
                return "激稀有" ;
            case 5 :
                return "超激稀有" ;
            default :
                return "Error";
        }
    }

    private int hlv_judge(int rare , String name){
        if( rare == 3 )
            return 70 ;
        else if( rare == 4 && name.contains("狂亂") )
            return 20 ;
        return 60 ;
    }

    private int hlv_judge(int rare){
        return rare==3 ? 90 : ( ( rare==4 || rare==5) ? 80 : 999 ) ;
    }

    public void end_close(){
        if( outputflag == 0 ){
            end_close2excel();
        }else if( outputflag == 1){
            end_close2html();
        }
    }

    private String int2str(int num){
        return int2str( num , 30f );
    }

    private String int2str(int num , int num2 ){
        return int2str( num , (float) num2 );
    }

    private String int2str(int num , float x){
        float ans = num/x ;
        if( ans ==(int)ans ){
            return ""+(int)ans;
        }else if( ans*100 == (int)(ans*100) ){
            return ""+ans;
        }else{
            return String.format(Locale.US, "%.2f", ans);
        }
    }

    private String attack_type_int(int i){
        switch (i){
            case 1:
                return "單體" ;
            case 2:
                return "範圍" ;
            default:
                return "NULL" ;
        }
    }

    private String cd_calculate(int x){
        x -= 264 ;
        if(x<=60)
            return "2";
        else if( x%30==0 ){
            return ""+x/30;
        }else if( x*100%30 == 0){
            return  ""+ x/30f;
        }else {
            return String.format(Locale.US, "%.2f", x/30f);
        }
    }

    private void end_close2excel(){
        try {
            writefile("</table>");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void end_close2html(){
        try {
            writefile("\t\t\t</tbody>\n");
            writefile("\t\t</table>\n");
            writefile("\t</body>\n");
            writefile("</html>\n");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
