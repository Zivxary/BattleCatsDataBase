package project.android.com.tw.dbtest;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class CatsJsoup {

    private Document doc;

    public CatsJsoup(){}

    public void gettestHtml(String urlString){
        int check = 5 ;
        doc  = null ;
        while( check > 0 ) {
            try {
                URL url = new URL(urlString);
                doc = Jsoup.parse(url, 3000);
                check = -1 ;
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("ZZZ", "Connect ERROR");
                check --;
            }
        }
    }

    public CatsItem[] getHtmlData(){
        if (doc!=null && testHtml()) {
            return ReadHtml();
        }
        return null ;
    }

    private boolean testHtml(){
        Elements data = doc.select("title");
        return !"にゃんこ大戦争データベース".equals(data.get(0).text());
    }

    private CatsItem[] ReadHtml(){

        String temp = doc.html().replace("<br>","@");
        doc = Jsoup.parse(temp);

        Elements data = doc.select("td[class=R]");
        Elements data2 = doc.select("font[class=c07 hide]");
        Elements data3 = doc.select("font[class=c11 hide]");
        Elements data4 = doc.select("font[class=c17 hide]");
        Elements data5 = doc.select("font[class=c19 hide]");
        Elements data6 = doc.select("td[class=bgc12]:contains(特性)+td[colspan=9]");
        Elements data7 = doc.select("tr[class=bgc12]>td");
        Elements data8 = doc.select("font[class=c02]>a");
        Elements data9 = doc.select("td[class=bgc12]:contains(MaxLv)+td");
        Elements data10 = doc.select("font[class=c05 finger]");
        Elements data11 = doc.select("font[class=c06 finger]");
        Elements data12 = doc.select("td[class=bgc12]:contains(開放条件)+td[class=kai][colspan=9]");
        Elements data13 = doc.select("font[class=at1 hide]");
        Elements data14 = doc.select("font[class=at2 hide]");
        Elements data15 = doc.select("font[class=at3 hide]");

        CatsItem []item = new CatsItem[ data.size()/16 ];

        for(int i=0 ; i< item.length ; i++){
            int j = i*16 ;
            int k = i*4 +1;
            item[i] = new CatsItem();

            item[i].cats_uid = data7.get(k).text().replace("No.","u").replace("-","_") ;
            item[i].cats_jp_name = data7.get(k+1).text() ;
            item[i].cats_rarity = rarity_str( data8.get(i).text() ) ;
            item[i].cats_max_level = max_level_str( data9.get(i).text() , 0 ) ;
            item[i].cats_max_bonus_level = max_level_str( data9.get(i).text() , 1 ) ;
            item[i].cats_custom_level = Integer.parseInt( data10.get(i).text() );
            item[i].cats_custom_bonus_level = Integer.parseInt( data11.get(i).text() );
            item[i].cats_basic_hp = Integer.parseInt( data2.get(i).text() ) ;
            item[i].cats_basic_attack = Integer.parseInt( data3.get(i).text() ) ;
            item[i].cats_attack_frequency =  Integer.parseInt( data.get(2+j).text() ) ;
            item[i].cats_attack_occurs =  Integer.parseInt( data.get(6+j).text() ) ;
            item[i].cats_attack_interval =  Integer.parseInt( data.get(10+j).text() ) ;
            item[i].cats_attack_distance =  Integer.parseInt( data.get(9+j).text().replace(",","") ) ;
            item[i].cats_attack_type =  attack_type_str( data.get(12+j).text() ) ;
            item[i].cats_move_speed =  Integer.parseInt( data.get(5+j).text() ) ;
            item[i].cats_knock_back =  Integer.parseInt( data.get(1+j).text() ) ;
            item[i].cats_cost =  Integer.parseInt( data4.get(i).text() ) ;
            item[i].cats_cooling_time =  Integer.parseInt( data5.get(i).text() ) ;
            item[i].cats_continuous_attack_proportion[0] = Integer.parseInt(data13.get(i).text());
            item[i].cats_continuous_attack_proportion[1] = Integer.parseInt(data14.get(i).text());
            item[i].cats_continuous_attack_proportion[2] = Integer.parseInt(data15.get(i).text());

            String []ss = characteristic_str( data6.get(i).text() ).split("@");
            System.arraycopy(ss, 0, item[i].cats_characteristic, 0, ss.length);

            if(i==2) {
                int[] tmp = evolution_str(data12.get(i).text());
                item[i].cats_evolution_green = tmp[0];
                item[i].cats_evolution_purple = tmp[1];
                item[i].cats_evolution_red = tmp[2];
                item[i].cats_evolution_blue = tmp[3];
                item[i].cats_evolution_yellow = tmp[4];
                item[i].cats_evolution_colorful = tmp[5];
            }
        }
        return item;
    }

    //稀有度
    private int rarity_str(String s){
        switch (s) {
            case "基本":
                return 1 ;
            case "EX":
                return 2 ;
            case "レア":
                return 3 ;
            case "激レア":
                return 4 ;
            case "超激レア":
                return 5 ;
            default:
                return 0 ;
        }
    }

    //最大等級
    private int max_level_str(String s , int index ){
        char[] ch = s.toCharArray() ;
        String ss = "" ;
        int j = 0 ;
        for (char aCh : ch) {
            if (aCh == ' ' && j <= index * 2) {
                j++;
            } else if (j > index * 2) {
                if (aCh == ' ')
                    break;
                ss += aCh;
            }
        }
        return Integer.parseInt(ss);
    }

    //攻擊類型
    private int attack_type_str(String s){
        switch (s){
            case "単体":
                return 1 ;
            case "範囲":
                return 2 ;
            default:
                return 0 ;
        }
    }

    private String characteristic_str(String s){
        char[] ch = s.toCharArray();
        int i = ch.length-1 ;
        for(;i>=0;i--){
            if( ch[i] < '0' || ch[i] > '9' )
                break;
        }
        if( s.contains("2連続攻撃") )
            return s.substring( 0 , i-1 ) + ")" ;
        else
            return s.substring( 0 , i+1 );
    }

    private int[] evolution_str(String s){
        int[] count = {0,0,0,0,0,0};
        String []ss = s.replace("　種"," #").split("@");
        if( ( ss[0].length()>1 && ss[0].charAt(0) == 'マ' && ss[0].charAt(1) =='タ' ) ){
            String []s1 = ss[0].split(" ");
            int scale = 100 ;
            for (String aS1 : s1) {
                final char[] ch = {'緑', '紫', '赤', '青', '黄', '虹'};
                for (int j = 0; j < ch.length; j++) {
                    if (ch[j] == aS1.charAt(0))
                        count[j] = Integer.parseInt(aS1.substring(1)) * scale;
                }
                if (aS1.charAt(0) == '#')
                    scale = 1;
            }
        }
        return count ;
    }
}
