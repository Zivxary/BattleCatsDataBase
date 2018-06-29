package project.android.com.tw.dbtest;

public class CatsItem {

    public int cats_id ;
    public boolean cats_check ;
    public String cats_uid ;
    public String cats_jp_name ;
    public String cats_zh_name ;
    public String cats_zh_class ;
    public String cats_jp_class ;
    public String cats_image_URL ;
    public String cats_image ;
    public int cats_rarity ;
    public int cats_max_level ;
    public int cats_max_bonus_level ;
    public int cats_custom_level ;
    public int cats_custom_bonus_level ;
    public int cats_basic_hp ;
    public int cats_basic_attack ;
    public int cats_attack_frequency ;
    public int cats_attack_occurs ;
    public int cats_attack_interval ;
    public int cats_attack_distance ;
    public int cats_attack_type ;
    public int cats_move_speed ;
    public int cats_knock_back ;
    public int cats_cost ;
    public int cats_cooling_time ;
    public String []cats_characteristic = new String[6] ;
    public String []cats_characteristic_zh = new String[6] ;

    public int cats_critical ;

    public int cats_white_damage ;
    public int cats_white_resistance ;
    public int cats_red_damage ;
    public int cats_red_resistance ;
    public int cats_black_damage ;
    public int cats_black_resistance ;
    public int cats_fly_damage ;
    public int cats_fly_resistance ;
    public int cats_steel_damage ;
    public int cats_steel_resistance ;
    public int cats_angel_damage ;
    public int cats_angel_resistance ;
    public int cats_alien_damage ;
    public int cats_alien_resistance ;
    public int cats_zombie_damage ;
    public int cats_zombie_resistance ;
    public int cats_witch_damage ;
    public int cats_witch_resistance ;
    public int cats_noattr_damage ;
    public int cats_noattr_resistance ;

    public int cats_evolution_green ;
    public int cats_evolution_purple ;
    public int cats_evolution_red ;
    public int cats_evolution_blue ;
    public int cats_evolution_yellow ;
    public int cats_evolution_colorful ;

    public int cats_survived_probability ;  //生還
    public int cats_bounty ;    //賞金
    public int cats_wave_level ;   //波動Lv
    public int cats_wave_probability ;  //波動機率
    public int cats_resuscitation ; //殭屍復活
    public int cats_tower_attack ; //對塔
    public int cats_metal ; //鋼鐵特性
    public int cats_wave_remove ; //消波動
    public int cats_barrier_break ; //護盾破壞

    public int cats_continuous_attack ;  //連續攻擊
    public int cats_continuous_attack_proportion[] = new int[3];
    public int cats_distant_attack_min ;
    public int cats_distant_attack_max ;
    public int cats_increase_attack_hp ;
    public int cats_increase_attack_proportion ;
    public int cats_teleport_invalid ;

    public int cats_wave_invalid ;
    public int cats_repel_invalid ;
    public int cats_slow_invalid ;
    public int cats_stop_invalid ;
    public int cats_reduce_attack_invalid ;

    public int cats_white_repel_probability ; //擊退
    public int cats_white_slow_probability ;
    public int cats_white_slow_time ;
    public int cats_white_stop_probability ;
    public int cats_white_stop_time ;
    public int cats_white_reduce_attack_probability ;
    public int cats_white_reduce_attack_time ;
    public int cats_white_reduce_attack_proportion ;

    public int cats_red_repel_probability ;
    public int cats_red_slow_probability ;
    public int cats_red_slow_time ;
    public int cats_red_stop_probability ;
    public int cats_red_stop_time ;
    public int cats_red_reduce_attack_probability ;
    public int cats_red_reduce_attack_time ;
    public int cats_red_reduce_attack_proportion ;

    public int cats_black_repel_probability ;
    public int cats_black_slow_probability ;
    public int cats_black_slow_time ;
    public int cats_black_stop_probability ;
    public int cats_black_stop_time ;
    public int cats_black_reduce_attack_probability ;
    public int cats_black_reduce_attack_time ;
    public int cats_black_reduce_attack_proportion ;

    public int cats_fly_repel_probability ;
    public int cats_fly_slow_probability ;
    public int cats_fly_slow_time ;
    public int cats_fly_stop_probability ;
    public int cats_fly_stop_time ;
    public int cats_fly_reduce_attack_probability ;
    public int cats_fly_reduce_attack_time ;
    public int cats_fly_reduce_attack_proportion ;

    public int cats_steel_repel_probability ;
    public int cats_steel_slow_probability ;
    public int cats_steel_slow_time ;
    public int cats_steel_stop_probability ;
    public int cats_steel_stop_time ;
    public int cats_steel_reduce_attack_probability ;
    public int cats_steel_reduce_attack_time ;
    public int cats_steel_reduce_attack_proportion ;

    public int cats_angel_repel_probability ;
    public int cats_angel_slow_probability ;
    public int cats_angel_slow_time ;
    public int cats_angel_stop_probability ;
    public int cats_angel_stop_time ;
    public int cats_angel_reduce_attack_probability ;
    public int cats_angel_reduce_attack_time ;
    public int cats_angel_reduce_attack_proportion ;

    public int cats_alien_repel_probability ;
    public int cats_alien_slow_probability ;
    public int cats_alien_slow_time ;
    public int cats_alien_stop_probability ;
    public int cats_alien_stop_time ;
    public int cats_alien_reduce_attack_probability ;
    public int cats_alien_reduce_attack_time ;
    public int cats_alien_reduce_attack_proportion ;

    public int cats_zombie_repel_probability ;
    public int cats_zombie_slow_probability ;
    public int cats_zombie_slow_time ;
    public int cats_zombie_stop_probability ;
    public int cats_zombie_stop_time ;
    public int cats_zombie_reduce_attack_probability ;
    public int cats_zombie_reduce_attack_time ;
    public int cats_zombie_reduce_attack_proportion ;

    public int cats_witch_repel_probability ;
    public int cats_witch_slow_probability ;
    public int cats_witch_slow_time ;
    public int cats_witch_stop_probability ;
    public int cats_witch_stop_time ;
    public int cats_witch_reduce_attack_probability ;
    public int cats_witch_reduce_attack_time ;
    public int cats_witch_reduce_attack_proportion ;

    public int cats_noattr_repel_probability ;
    public int cats_noattr_slow_probability ;
    public int cats_noattr_slow_time ;
    public int cats_noattr_stop_probability ;
    public int cats_noattr_stop_time ;
    public int cats_noattr_reduce_attack_probability ;
    public int cats_noattr_reduce_attack_time ;
    public int cats_noattr_reduce_attack_proportion ;

    public CatsItem(){
        init();
    }

    public void init(){
        cats_id = 0 ;
        cats_check = false ;
        cats_uid = "u000_0" ;
        cats_jp_name = "NULL" ;
        cats_zh_name = "待補" ;
        cats_jp_class = "" ;
        cats_zh_class = "" ;
        cats_image = "";
        cats_rarity = 0 ;
        cats_max_level = 0 ;
        cats_max_bonus_level = 0 ;
        cats_custom_level = 0 ;
        cats_custom_bonus_level = 0 ;
        cats_basic_hp = 0 ;
        cats_basic_attack = 0 ;
        cats_attack_frequency = 0 ;
        cats_attack_occurs = 0 ;
        cats_attack_interval = 0 ;
        cats_attack_distance = 0 ;
        cats_attack_type = 0 ;
        cats_move_speed = 0 ;
        cats_knock_back = 0 ;
        cats_cost = 0 ;
        cats_cooling_time = 0 ;

        for(int i=0 ; i<6 ; i++ ) {
            cats_characteristic[i] = "";
            cats_characteristic_zh[i] = "";
        }

        cats_critical = 0 ;

        cats_white_damage = 0 ;
        cats_white_resistance = 0 ;
        cats_red_damage = 0 ;
        cats_red_resistance = 0 ;
        cats_black_damage = 0 ;
        cats_black_resistance = 0 ;
        cats_fly_damage = 0 ;
        cats_fly_resistance = 0 ;
        cats_steel_damage = 0 ;
        cats_steel_resistance = 0 ;
        cats_angel_damage = 0 ;
        cats_angel_resistance = 0 ;
        cats_alien_damage = 0 ;
        cats_alien_resistance = 0 ;
        cats_zombie_damage = 0 ;
        cats_zombie_resistance = 0 ;
        cats_witch_damage = 0 ;
        cats_witch_resistance = 0 ;
        cats_noattr_damage = 0 ;
        cats_noattr_resistance = 0 ;

        cats_evolution_green = 0 ;
        cats_evolution_purple = 0 ;
        cats_evolution_red = 0 ;
        cats_evolution_blue = 0 ;
        cats_evolution_yellow = 0 ;
        cats_evolution_colorful = 0 ;

        cats_survived_probability = 0 ;
        cats_bounty = 0 ;
        cats_wave_level = 0 ;
        cats_wave_probability = 0 ;
        cats_resuscitation = 0 ;
        cats_tower_attack = 0 ;
        cats_metal = 0 ;
        cats_wave_remove = 0 ;
        cats_barrier_break = 0 ;

        cats_continuous_attack = 1 ;

        cats_distant_attack_min = 0 ;
        cats_distant_attack_max = 0 ;
        cats_increase_attack_hp = 0 ;
        cats_increase_attack_proportion = 0 ;

        cats_wave_invalid = 0 ;
        cats_repel_invalid = 0 ;
        cats_slow_invalid = 0 ;
        cats_stop_invalid = 0 ;
        cats_reduce_attack_invalid = 0 ;
        cats_teleport_invalid = 0 ;

        cats_white_repel_probability = 0 ;//擊退
        cats_white_slow_probability = 0 ;
        cats_white_slow_time = 0 ;
        cats_white_stop_probability = 0 ;
        cats_white_stop_time = 0 ;
        cats_white_reduce_attack_probability = 0 ;
        cats_white_reduce_attack_time = 0 ;
        cats_white_reduce_attack_proportion = 0 ;

        cats_red_repel_probability = 0 ;
        cats_red_slow_probability = 0 ;
        cats_red_slow_time = 0 ;
        cats_red_stop_probability = 0 ;
        cats_red_stop_time = 0 ;
        cats_red_reduce_attack_probability = 0 ;
        cats_red_reduce_attack_time = 0 ;
        cats_red_reduce_attack_proportion = 0 ;

        cats_black_repel_probability = 0 ;
        cats_black_slow_probability = 0 ;
        cats_black_slow_time = 0 ;
        cats_black_stop_probability = 0 ;
        cats_black_stop_time = 0 ;
        cats_black_reduce_attack_probability = 0 ;
        cats_black_reduce_attack_time = 0 ;
        cats_black_reduce_attack_proportion = 0 ;

        cats_fly_repel_probability = 0 ;
        cats_fly_slow_probability = 0 ;
        cats_fly_slow_time = 0 ;
        cats_fly_stop_probability = 0 ;
        cats_fly_stop_time = 0 ;
        cats_fly_reduce_attack_probability = 0 ;
        cats_fly_reduce_attack_time = 0 ;
        cats_fly_reduce_attack_proportion = 0 ;

        cats_steel_repel_probability = 0 ;
        cats_steel_slow_probability = 0 ;
        cats_steel_slow_time = 0 ;
        cats_steel_stop_probability = 0 ;
        cats_steel_stop_time = 0 ;
        cats_steel_reduce_attack_probability = 0 ;
        cats_steel_reduce_attack_time = 0 ;
        cats_steel_reduce_attack_proportion = 0 ;

        cats_angel_repel_probability = 0 ;
        cats_angel_slow_probability = 0 ;
        cats_angel_slow_time = 0 ;
        cats_angel_stop_probability = 0 ;
        cats_angel_stop_time = 0 ;
        cats_angel_reduce_attack_probability = 0 ;
        cats_angel_reduce_attack_time = 0 ;
        cats_angel_reduce_attack_proportion = 0 ;

        cats_alien_repel_probability = 0 ;
        cats_alien_slow_probability = 0 ;
        cats_alien_slow_time = 0 ;
        cats_alien_stop_probability = 0 ;
        cats_alien_stop_time = 0 ;
        cats_alien_reduce_attack_probability = 0 ;
        cats_alien_reduce_attack_time = 0 ;
        cats_alien_reduce_attack_proportion = 0 ;

        cats_zombie_repel_probability = 0 ;
        cats_zombie_slow_probability = 0 ;
        cats_zombie_slow_time = 0 ;
        cats_zombie_stop_probability = 0 ;
        cats_zombie_stop_time = 0 ;
        cats_zombie_reduce_attack_probability = 0 ;
        cats_zombie_reduce_attack_time = 0 ;
        cats_zombie_reduce_attack_proportion = 0 ;

        cats_witch_repel_probability = 0 ;
        cats_witch_slow_probability = 0 ;
        cats_witch_slow_time = 0 ;
        cats_witch_stop_probability = 0 ;
        cats_witch_stop_time = 0 ;
        cats_witch_reduce_attack_probability = 0 ;
        cats_witch_reduce_attack_time = 0 ;
        cats_witch_reduce_attack_proportion = 0 ;

        cats_noattr_repel_probability = 0 ;
        cats_noattr_slow_probability = 0 ;
        cats_noattr_slow_time = 0 ;
        cats_noattr_stop_probability = 0 ;
        cats_noattr_stop_time = 0 ;
        cats_noattr_reduce_attack_probability = 0 ;
        cats_noattr_reduce_attack_time = 0 ;
        cats_noattr_reduce_attack_proportion = 0 ;
    }

    public int[][] get_cats_attr_proportion(){
        return new int[][]{
                { cats_white_damage , cats_white_resistance },
                { cats_red_damage , cats_red_resistance },
                { cats_black_damage , cats_black_resistance },
                { cats_fly_damage , cats_fly_resistance },
                { cats_steel_damage , cats_steel_resistance },
                { cats_angel_damage , cats_angel_resistance },
                { cats_alien_damage , cats_alien_resistance },
                { cats_zombie_damage , cats_zombie_resistance },
                { cats_witch_damage , cats_witch_resistance },
                { cats_noattr_damage , cats_noattr_resistance }
        };
    }

    public int[][] get_cats_abnormal_state(){
        return new int[][]{
            { cats_white_repel_probability , cats_white_slow_probability , cats_white_slow_time , cats_white_stop_probability , cats_white_stop_time , cats_white_reduce_attack_probability , cats_white_reduce_attack_time , cats_white_reduce_attack_proportion },
            { cats_red_repel_probability , cats_red_slow_probability , cats_red_slow_time , cats_red_stop_probability , cats_red_stop_time , cats_red_reduce_attack_probability , cats_red_reduce_attack_time , cats_red_reduce_attack_proportion },
            { cats_black_repel_probability , cats_black_slow_probability , cats_black_slow_time , cats_black_stop_probability , cats_black_stop_time , cats_black_reduce_attack_probability , cats_black_reduce_attack_time , cats_black_reduce_attack_proportion },
            { cats_fly_repel_probability , cats_fly_slow_probability , cats_fly_slow_time , cats_fly_stop_probability , cats_fly_stop_time , cats_fly_reduce_attack_probability , cats_fly_reduce_attack_time , cats_fly_reduce_attack_proportion },
            { cats_steel_repel_probability , cats_steel_slow_probability , cats_steel_slow_time , cats_steel_stop_probability , cats_steel_stop_time , cats_steel_reduce_attack_probability , cats_steel_reduce_attack_time , cats_steel_reduce_attack_proportion },
            { cats_angel_repel_probability , cats_angel_slow_probability , cats_angel_slow_time , cats_angel_stop_probability , cats_angel_stop_time , cats_angel_reduce_attack_probability , cats_angel_reduce_attack_time , cats_angel_reduce_attack_proportion },
            { cats_alien_repel_probability , cats_alien_slow_probability , cats_alien_slow_time , cats_alien_stop_probability , cats_alien_stop_time , cats_alien_reduce_attack_probability , cats_alien_reduce_attack_time , cats_alien_reduce_attack_proportion },
            { cats_zombie_repel_probability , cats_zombie_slow_probability , cats_zombie_slow_time , cats_zombie_stop_probability , cats_zombie_stop_time , cats_zombie_reduce_attack_probability , cats_zombie_reduce_attack_time , cats_zombie_reduce_attack_proportion },
            { cats_witch_repel_probability , cats_witch_slow_probability , cats_witch_slow_time , cats_witch_stop_probability , cats_witch_stop_time , cats_witch_reduce_attack_probability , cats_witch_reduce_attack_time , cats_witch_reduce_attack_proportion },
            { cats_noattr_repel_probability , cats_noattr_slow_probability , cats_noattr_slow_time , cats_noattr_stop_probability , cats_noattr_stop_time , cats_noattr_reduce_attack_probability , cats_noattr_reduce_attack_time , cats_noattr_reduce_attack_proportion }
        };
    }

    public int[] get_cats_invalid(){
        return new int[]{
                cats_wave_invalid,
                cats_repel_invalid,
                cats_slow_invalid,
                cats_stop_invalid,
                cats_reduce_attack_invalid,
                cats_teleport_invalid
        };
    }

    public int[] get_cats_evolution(){
        return new int[]{
                cats_evolution_green ,
                cats_evolution_purple ,
                cats_evolution_red ,
                cats_evolution_blue ,
                cats_evolution_yellow ,
                cats_evolution_colorful
        };
    }

    public boolean set_cats_attr_proportion( int[][] attr ){
        try {
            cats_white_damage = attr[0][0];
            cats_white_resistance = attr[1][0];
            cats_red_damage = attr[0][1];
            cats_red_resistance = attr[1][1];
            cats_black_damage = attr[0][2];
            cats_black_resistance = attr[1][2];
            cats_fly_damage = attr[0][3];
            cats_fly_resistance = attr[1][3];
            cats_steel_damage = attr[0][4];
            cats_steel_resistance = attr[1][4];
            cats_angel_damage = attr[0][5];
            cats_angel_resistance = attr[1][5];
            cats_alien_damage = attr[0][6];
            cats_alien_resistance = attr[1][6];
            cats_zombie_damage = attr[0][7];
            cats_zombie_resistance = attr[1][7];
            cats_witch_damage = attr[0][8];
            cats_witch_resistance = attr[1][8];
            cats_noattr_damage = attr[0][9];
            cats_noattr_resistance = attr[1][9];
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean set_cats_invalid( int[] attr ){
        try{
                cats_wave_invalid = attr[0] ;
                cats_repel_invalid = attr[1] ;
                cats_slow_invalid = attr[2] ;
                cats_stop_invalid = attr[3] ;
                cats_reduce_attack_invalid = attr[4] ;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean set_cats_evolution( int[] attr ){
        try{
                cats_evolution_green = attr[0] ;
                cats_evolution_purple = attr[1] ;
                cats_evolution_red = attr[2] ;
                cats_evolution_blue = attr[3] ;
                cats_evolution_yellow = attr[4] ;
                cats_evolution_colorful = attr[5] ;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean set_cats_abnormal_state( int[][] attr ) {
        try{
            cats_white_repel_probability = attr[0][0] ;
            cats_white_slow_probability = attr[1][0] ;
            cats_white_slow_time = attr[2][0] ;
            cats_white_stop_probability = attr[3][0] ;
            cats_white_stop_time = attr[4][0] ;
            cats_white_reduce_attack_probability = attr[5][0] ;
            cats_white_reduce_attack_time = attr[6][0] ;
            cats_white_reduce_attack_proportion = attr[7][0] ;

            cats_red_repel_probability = attr[0][1] ;
            cats_red_slow_probability = attr[1][1] ;
            cats_red_slow_time = attr[2][1] ;
            cats_red_stop_probability = attr[3][1] ;
            cats_red_stop_time = attr[4][1] ;
            cats_red_reduce_attack_probability = attr[5][1] ;
            cats_red_reduce_attack_time = attr[6][1] ;
            cats_red_reduce_attack_proportion = attr[7][1] ;

            cats_black_repel_probability = attr[0][2] ;
            cats_black_slow_probability = attr[1][2] ;
            cats_black_slow_time = attr[2][2] ;
            cats_black_stop_probability = attr[3][2] ;
            cats_black_stop_time = attr[4][2] ;
            cats_black_reduce_attack_probability = attr[5][2] ;
            cats_black_reduce_attack_time = attr[6][2] ;
            cats_black_reduce_attack_proportion = attr[7][2] ;

            cats_fly_repel_probability = attr[0][3] ;
            cats_fly_slow_probability = attr[1][3] ;
            cats_fly_slow_time = attr[2][3] ;
            cats_fly_stop_probability = attr[3][3] ;
            cats_fly_stop_time = attr[4][3] ;
            cats_fly_reduce_attack_probability = attr[5][3] ;
            cats_fly_reduce_attack_time = attr[6][3] ;
            cats_fly_reduce_attack_proportion = attr[7][3] ;

            cats_steel_repel_probability = attr[0][4] ;
            cats_steel_slow_probability = attr[1][4] ;
            cats_steel_slow_time = attr[2][4] ;
            cats_steel_stop_probability = attr[3][4] ;
            cats_steel_stop_time = attr[4][4] ;
            cats_steel_reduce_attack_probability = attr[5][4] ;
            cats_steel_reduce_attack_time = attr[6][4] ;
            cats_steel_reduce_attack_proportion = attr[7][4] ;

            cats_angel_repel_probability = attr[0][5] ;
            cats_angel_slow_probability = attr[1][5] ;
            cats_angel_slow_time = attr[2][5] ;
            cats_angel_stop_probability = attr[3][5] ;
            cats_angel_stop_time = attr[4][5] ;
            cats_angel_reduce_attack_probability = attr[5][5] ;
            cats_angel_reduce_attack_time = attr[6][5] ;
            cats_angel_reduce_attack_proportion = attr[7][5] ;

            cats_alien_repel_probability = attr[0][6] ;
            cats_alien_slow_probability = attr[1][6] ;
            cats_alien_slow_time = attr[2][6] ;
            cats_alien_stop_probability = attr[3][6] ;
            cats_alien_stop_time = attr[4][6] ;
            cats_alien_reduce_attack_probability = attr[5][6] ;
            cats_alien_reduce_attack_time = attr[6][6] ;
            cats_alien_reduce_attack_proportion = attr[7][6] ;

            cats_zombie_repel_probability = attr[0][7] ;
            cats_zombie_slow_probability = attr[1][7] ;
            cats_zombie_slow_time = attr[2][7] ;
            cats_zombie_stop_probability = attr[3][7] ;
            cats_zombie_stop_time = attr[4][7] ;
            cats_zombie_reduce_attack_probability = attr[5][7] ;
            cats_zombie_reduce_attack_time = attr[6][7] ;
            cats_zombie_reduce_attack_proportion = attr[7][7] ;

            cats_witch_repel_probability = attr[0][8] ;
            cats_witch_slow_probability = attr[1][8] ;
            cats_witch_slow_time = attr[2][8] ;
            cats_witch_stop_probability = attr[3][8] ;
            cats_witch_stop_time = attr[4][8] ;
            cats_witch_reduce_attack_probability = attr[5][8] ;
            cats_witch_reduce_attack_time = attr[6][8] ;
            cats_witch_reduce_attack_proportion = attr[7][8] ;

            cats_noattr_repel_probability = attr[0][9] ;
            cats_noattr_slow_probability = attr[1][9] ;
            cats_noattr_slow_time = attr[2][9] ;
            cats_noattr_stop_probability = attr[3][9] ;
            cats_noattr_stop_time = attr[4][9] ;
            cats_noattr_reduce_attack_probability = attr[5][9] ;
            cats_noattr_reduce_attack_time = attr[6][9] ;
            cats_noattr_reduce_attack_proportion = attr[7][9] ;

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
