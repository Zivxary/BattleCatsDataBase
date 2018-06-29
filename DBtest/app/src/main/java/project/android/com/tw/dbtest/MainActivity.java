package project.android.com.tw.dbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private CatsDAO catsDAO;
    private boolean show_log = false ;
    private OutputHtml outputHtml ;
    private TextView tv ;

    private fcn_timer[] ft = new fcn_timer[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        catsDAO = new CatsDAO( getApplicationContext() );
        outputHtml = new OutputHtml( getApplicationContext() ,this ) ;
        tv = (TextView)findViewById(R.id.textview);

        for(int i=0;i<4;i++){
            ft[i]=new fcn_timer();
        }

        new Thread(){
            @Override
            public void run() {
                outputHtml.check_permission() ;
                CatsJsoup cj = new CatsJsoup();
                CatsOtherData cod = new CatsOtherData(getApplicationContext()) ;
                int i = 1 ;
                int j = 0 ;
                do{
                    //if(i==161) i++;
                    ft[0].start();
                    String s1 = String.format(Locale.US,"%03d",i);
                    String s = "http://battlecats-db.com/unit/"+s1+".html";
                    cj.gettestHtml(s);
                    ft[0].record();
                    ft[1].start();
                    CatsItem[] item = cj.getHtmlData();
                    ft[1].record();
                    if (item != null) {
                        for (CatsItem anItem : item) {
                            ft[2].start();
                            anItem = cod.start(anItem);
                            ft[2].record();
                            //Log_show(anItem);
                            ft[3].start();
                            if(catsDAO.check_data(anItem.cats_uid)){
                                catsDAO.update(anItem);
                            }else{
                                catsDAO.insert(anItem);
                            }
                            anItem.cats_id = catsDAO.get_Key_ID(anItem.cats_uid);
                            ft[3].record();
                            //outputHtml.outputfile( anItem );
                        }
                        j=0;
                        //Log.d("ZZZ", s1 );
                        Textview_show( s1 );
                    } else {
                        Log.d("ZZZ", "Item ERROR_" + String.format(Locale.US,"%03d",i) );
                        j++;
                    }
                    i++;
                }while(j<5);
                outputHtml.end_close();
                Log.d("ZZZ","OVER");

                ft[0].logt("html");
                ft[1].logt("doc");
                ft[2].logt("data");
                ft[3].logt("DAO");

            }
        }.start();

    }

    private void Log_show(final CatsItem anItem){
        new Thread() {
            @Override
            public void run() {
                if (show_log)
                {
                    String s = "" ;
                    String[] fs ;
                    Log.d("ZZZ", "號碼：\t " + anItem.cats_uid);
                    Log.d("ZZZ", "日名：\t " + anItem.cats_jp_name);
                    Log.d("ZZZ", "中名：\t " + anItem.cats_zh_name);
                    Log.d("ZZZ", "稀有：\t " + anItem.cats_rarity);
                    Log.d("ZZZ", "大等：\t " + anItem.cats_max_level + " + " + anItem.cats_max_bonus_level);
                    Log.d("ZZZ", "訂等：\t " + anItem.cats_custom_level + " + " + anItem.cats_custom_bonus_level);
                    Log.d("ZZZ", "基血：\t " + anItem.cats_basic_hp);
                    Log.d("ZZZ", "基攻：\t " + anItem.cats_basic_attack);
                    Log.d("ZZZ", "攻頻：\t " + anItem.cats_attack_frequency);
                    Log.d("ZZZ", "攻發：\t " + anItem.cats_attack_occurs);
                    Log.d("ZZZ", "間隔：\t " + anItem.cats_attack_interval);
                    Log.d("ZZZ", "攻距：\t " + anItem.cats_attack_distance);
                    Log.d("ZZZ", "類型：\t " + anItem.cats_attack_type);
                    Log.d("ZZZ", "跑速：\t " + anItem.cats_move_speed);
                    Log.d("ZZZ", "  KB：\t " + anItem.cats_knock_back);
                    Log.d("ZZZ", "金額：\t " + anItem.cats_cost);
                    Log.d("ZZZ", "再產：\t " + anItem.cats_cooling_time);

                    for (int i = 0; i < anItem.cats_characteristic.length; i++) {
                        Log.d("ZZZ", "____\t" + anItem.cats_characteristic[i]);
                    }

                    int[] num = anItem.get_cats_evolution();
                    fs = new String[]{"綠", "紫", "紅", "藍", "黃", "虹"};
                    s = "" ;
                    for(int i = 0 ; i<num.length ; i++){
                        s += fs[i] + ( num[i] / 100 ) + " ";
                    }
                    Log.d("ZZZ","果實：\t" + s );

                    s = "" ;
                    for(int i=0 ; i<num.length-1 ; i++){
                        s += fs[i] + ( num[i] % 100 ) + " ";
                    }
                    Log.d("ZZZ","種子：\t" + s );

                    int[][] nums = anItem.get_cats_attr_proportion();
                    s = "" ;
                    fs = new String[]{"白", "紅", "黑", "浮", "鋼", "天", "異", "疆", "魔", "無"};
                    for(int i=0 ; i< nums[0].length ; i++){
                        if( nums[0][i]>0 || nums[1][i]>0 ){
                            s += fs[i] + nums[0][i] + nums[1][i] + " " ;
                        }
                    }
                    Log.d("ZZZ","倍率：\t" + s ) ;
                    Log.d("ZZZ","暴擊：\t" + anItem.cats_critical);
                }
            }
        }.start();
    }

    private void Textview_show(final String s){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.setText(s);
            }
        });
    }

    private class fcn_timer{

        long Ttime ;
        long time ;

        public fcn_timer(){
            Ttime = 0 ;
        }

        private void start(){
            time = System.currentTimeMillis();
        }

        private void record(){
            Ttime += System.currentTimeMillis() - time ;
        }

        private void logt(String s){
            String sm = String.format(Locale.US,"%02d",Ttime/1000/60);
            String ss = String.format(Locale.US,"%02d",Ttime/1000%60);
            String sss = String.format(Locale.US,"%03d",Ttime%1000);
            Log.d("TTT",s+": "+sm+" 分 "+ss+"."+sss+" 秒");
        }

        private void clear(){
            Ttime = 0 ;
            time = 0 ;
        }
    }

}
