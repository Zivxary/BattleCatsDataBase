package project.android.com.tw.dbtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CatsDAO {

    public static final String TABLE_NAME = "cats";

    public static final String KEY_ID = "_id";

    public static final String CATS_UID_COL = "cats_uid" ;
    public static final String CATS_JP_NAME_COL = "cats_jp_name" ;
    public static final String CATS_ZH_NAME_COL = "cats_zh_name" ;
    public static final String CATS_JP_CLASS_COL = "cats_jp_class" ;
    public static final String CATS_ZH_CLASS_COL = "cats_zh_class" ;
    public static final String CATS_IMAGE_COL = "cats_image" ;
    public static final String CATS_IMAGE_URL_COL = "cats_image_URL" ;
    public static final String CATS_RARITY_COL = "cats_rarity" ;
    public static final String CATS_MAX_LEVEL_COL = "cats_max_level" ;
    public static final String CATS_MAX_BONUS_LEVEL_COL = "cats_max_bonus_level" ;
    public static final String CATS_CUSTOM_LEVEL_COL = "cats_custom_level" ;
    public static final String CATS_CUSTOM_BONUS_LEVEL_COL = "cats_custom_bonus_level" ;
    public static final String CATS_BASIC_HP_COL = "cats_basic_hp" ;
    public static final String CATS_BASIC_ATTACK_COL = "cats_basic_attack" ;
    public static final String CATS_ATTACK_FREQUENCY_COL = "cats_attack_frequency" ;
    public static final String CATS_ATTACK_OCCURS_COL = "cats_attack_occurs" ;
    public static final String CATS_ATTACK_INTERVAL_COL = "cats_attack_interval" ;
    public static final String CATS_ATTACK_DISTANCE_COL = "cats_attack_distance" ;
    public static final String CATS_ATTACK_TYPE_COL = "cats_attack_type" ;
    public static final String CATS_MOVE_SPEED_COL = "cats_move_speed" ;
    public static final String CATS_COST_COL = "cats_cost" ;
    public static final String CATS_COOLING_TIME_COL = "cats_cooling_time" ;

    public static final String CATS_CHARACTERISTIC_1_COL = "cats_characteristic_1" ;
    public static final String CATS_CHARACTERISTIC_2_COL = "cats_characteristic_2" ;
    public static final String CATS_CHARACTERISTIC_3_COL = "cats_characteristic_3" ;
    public static final String CATS_CHARACTERISTIC_4_COL = "cats_characteristic_4" ;
    public static final String CATS_CHARACTERISTIC_5_COL = "cats_characteristic_5" ;
    public static final String CATS_CHARACTERISTIC_6_COL = "cats_characteristic_6" ;

    public static final String CATS_CHARACTERISTIC_ZH_1_COL = "cats_characteristic_zh_1" ;
    public static final String CATS_CHARACTERISTIC_ZH_2_COL = "cats_characteristic_zh_2" ;
    public static final String CATS_CHARACTERISTIC_ZH_3_COL = "cats_characteristic_zh_3" ;
    public static final String CATS_CHARACTERISTIC_ZH_4_COL = "cats_characteristic_zh_4" ;
    public static final String CATS_CHARACTERISTIC_ZH_5_COL = "cats_characteristic_zh_5" ;
    public static final String CATS_CHARACTERISTIC_ZH_6_COL = "cats_characteristic_zh_6" ;

    public static final String CATS_CRITICAL_COL = "cats_critical" ;

    public static final String CATS_WHITE_DAMAGE_COL = "cats_white_damage" ;
    public static final String CATS_WHITE_RESISTANCE_COL = "cats_white_resistance" ;
    public static final String CATS_RED_DAMAGE_COL = "cats_red_damage" ;
    public static final String CATS_RED_RESISTANCE_COL = "cats_red_resistance" ;
    public static final String CATS_BLACK_DAMAGE_COL = "cats_black_damage" ;
    public static final String CATS_BLACK_RESISTANCE_COL = "cats_black_resistance" ;
    public static final String CATS_FLY_DAMAGE_COL = "cats_fly_damage" ;
    public static final String CATS_FLY_RESISTANCE_COL = "cats_fly_resistance" ;
    public static final String CATS_STEEL_DAMAGE_COL = "cats_steel_damage" ;
    public static final String CATS_STEEL_RESISTANCE_COL = "cats_steel_resistance" ;
    public static final String CATS_ANGEL_DAMAGE_COL = "cats_angel_damage" ;
    public static final String CATS_ANGEL_RESISTANCE_COL = "cats_angel_resistance" ;
    public static final String CATS_ALIEN_DAMAGE_COL = "cats_alien_damage" ;
    public static final String CATS_ALIEN_RESISTANCE_COL = "cats_alien_resistance" ;
    public static final String CATS_ZOMBIE_DAMAGE_COL = "cats_zombie_damage" ;
    public static final String CATS_ZOMBIE_RESISTANCE_COL = "cats_zombie_resistance" ;
    public static final String CATS_WITCH_DAMAGE_COL = "cats_witch_damage" ;
    public static final String CATS_WITCH_RESISTANCE_COL = "cats_witch_resistance" ;
    public static final String CATS_NOATTR_DAMAGE_COL = "cats_noattr_damage" ;
    public static final String CATS_NOATTR_RESISTANCE_COL = "cats_noattr_resistance" ;

    public static final String CATS_EVOLUTION_GREEN_COL = "cats_evolution_green" ;
    public static final String CATS_EVOLUTION_PURPLE_COL = "cats_evolution_purple" ;
    public static final String CATS_EVOLUTION_RED_COL = "cats_evolution_red" ;
    public static final String CATS_EVOLUTION_BLUE_COL = "cats_evolution_blue" ;
    public static final String CATS_EVOLUTION_YELLOW_COL = "cats_evolution_yellow" ;
    public static final String CATS_EVOLUTION_COLORFUL_COL = "cats_evolution_colorful" ;

    public static final String CATS_SURVIVED_PROBABILITY_COL = "cats_survived_probability" ;
    public static final String CATS_BOUNTY_COL = "cats_bounty" ;
    public static final String CATS_WAVE_LEVEL_COL = "cats_wave_level" ;
    public static final String CATS_WAVE_PROBABILITY_COL = "cats_wave_probability" ;
    public static final String CATS_RESUSCITATION_COL = "cats_resuscitation" ;
    public static final String CATS_TOWER_ATTACK_COL = "cats_tower_attack" ;
    public static final String CATS_METAL_COL = "cats_metal" ;
    public static final String CATS_WAVE_REMOVE_COL = "cats_wave_remove" ;
    public static final String CATS_BARRIER_BREAK_COL = "cats_barrier_break";

    public static final String CATS_CONTINUOUS_ATTACK_COL = "cats_continuous_attack" ;
    public static final String CATS_CONTINUOUS_ATTACK_PROPORTION_1_COL = "cats_continuous_attack_proportion_1" ;
    public static final String CATS_CONTINUOUS_ATTACK_PROPORTION_2_COL = "cats_continuous_attack_proportion_2" ;
    public static final String CATS_CONTINUOUS_ATTACK_PROPORTION_3_COL = "cats_continuous_attack_proportion_3" ;

    public static final String CATS_DISTANT_ATTACK_MIN_COL = "cats_distant_attack_min" ;
    public static final String CATS_DISTANT_ATTACK_MAX_COL = "cats_distant_attack_max" ;
    public static final String CATS_INCREASE_ATTACK_HP_COL = "cats_increase_attack_hp" ;
    public static final String CATS_INCREASE_ATTACK_PROPORTION_COL = "cats_increase_attack_proportion" ;

    public static final String CATS_WAVE_INVALID_COL = "cats_wave_invalid" ;
    public static final String CATS_REPEL_INVALID_COL = "cats_repel_invalid" ;
    public static final String CATS_SLOW_INVALID_COL = "cats_slow_invalid" ;
    public static final String CATS_STOP_INVALID_COL = "cats_stop_invalid" ;
    public static final String CATS_REDUCE_ATTACK_INVALID_COL = "cats_reduce_attack_invalid" ;
    public static final String CATS_TELEPORT_INVALID_COL = "cats_teleport_invalid";

    public static final String CATS_WHITE_REPEL_PROBABILITY_COL = "cats_white_repel_probability" ;
    public static final String CATS_WHITE_SLOW_PROBABILITY_COL = "cats_white_slow_probability" ;
    public static final String CATS_WHITE_SLOW_TIME_COL = "cats_white_slow_time" ;
    public static final String CATS_WHITE_STOP_PROBABILITY_COL = "cats_white_stop_probability" ;
    public static final String CATS_WHITE_STOP_TIME_COL = "cats_white_stop_time" ;
    public static final String CATS_WHITE_REDUCE_ATTACK_PROBABILITY_COL = "cats_white_reduce_attack_probability" ;
    public static final String CATS_WHITE_REDUCE_ATTACK_TIME_COL = "cats_white_reduce_attack_time" ;
    public static final String CATS_WHITE_REDUCE_ATTACK_PROPORTION_COL = "cats_white_reduce_attack_proportion" ;

    public static final String CATS_RED_REPEL_PROBABILITY_COL = "cats_red_repel_probability" ;
    public static final String CATS_RED_SLOW_PROBABILITY_COL = "cats_red_slow_probability" ;
    public static final String CATS_RED_SLOW_TIME_COL = "cats_red_slow_time" ;
    public static final String CATS_RED_STOP_PROBABILITY_COL = "cats_red_stop_probability" ;
    public static final String CATS_RED_STOP_TIME_COL = "cats_red_stop_time" ;
    public static final String CATS_RED_REDUCE_ATTACK_PROBABILITY_COL = "cats_red_reduce_attack_probability" ;
    public static final String CATS_RED_REDUCE_ATTACK_TIME_COL = "cats_red_reduce_attack_time" ;
    public static final String CATS_RED_REDUCE_ATTACK_PROPORTION_COL = "cats_red_reduce_attack_proportion" ;

    public static final String CATS_BLACK_REPEL_PROBABILITY_COL = "cats_black_repel_probability" ;
    public static final String CATS_BLACK_SLOW_PROBABILITY_COL = "cats_black_slow_probability" ;
    public static final String CATS_BLACK_SLOW_TIME_COL = "cats_black_slow_time" ;
    public static final String CATS_BLACK_STOP_PROBABILITY_COL = "cats_black_stop_probability" ;
    public static final String CATS_BLACK_STOP_TIME_COL = "cats_black_stop_time" ;
    public static final String CATS_BLACK_REDUCE_ATTACK_PROBABILITY_COL = "cats_black_reduce_attack_probability" ;
    public static final String CATS_BLACK_REDUCE_ATTACK_TIME_COL = "cats_black_reduce_attack_time" ;
    public static final String CATS_BLACK_REDUCE_ATTACK_PROPORTION_COL = "cats_black_reduce_attack_proportion" ;

    public static final String CATS_FLY_REPEL_PROBABILITY_COL = "cats_fly_repel_probability" ;
    public static final String CATS_FLY_SLOW_PROBABILITY_COL = "cats_fly_slow_probability" ;
    public static final String CATS_FLY_SLOW_TIME_COL = "cats_fly_slow_time" ;
    public static final String CATS_FLY_STOP_PROBABILITY_COL = "cats_fly_stop_probability" ;
    public static final String CATS_FLY_STOP_TIME_COL = "cats_fly_stop_time" ;
    public static final String CATS_FLY_REDUCE_ATTACK_PROBABILITY_COL = "cats_fly_reduce_attack_probability" ;
    public static final String CATS_FLY_REDUCE_ATTACK_TIME_COL = "cats_fly_reduce_attack_time" ;
    public static final String CATS_FLY_REDUCE_ATTACK_PROPORTION_COL = "cats_fly_reduce_attack_proportion" ;

    public static final String CATS_STEEL_REPEL_PROBABILITY_COL = "cats_steel_repel_probability" ;
    public static final String CATS_STEEL_SLOW_PROBABILITY_COL = "cats_steel_slow_probability" ;
    public static final String CATS_STEEL_SLOW_TIME_COL = "cats_steel_slow_time" ;
    public static final String CATS_STEEL_STOP_PROBABILITY_COL = "cats_steel_stop_probability" ;
    public static final String CATS_STEEL_STOP_TIME_COL = "cats_steel_stop_time" ;
    public static final String CATS_STEEL_REDUCE_ATTACK_PROBABILITY_COL = "cats_steel_reduce_attack_probability" ;
    public static final String CATS_STEEL_REDUCE_ATTACK_TIME_COL = "cats_steel_reduce_attack_time" ;
    public static final String CATS_STEEL_REDUCE_ATTACK_PROPORTION_COL = "cats_steel_reduce_attack_proportion" ;

    public static final String CATS_ANGEL_REPEL_PROBABILITY_COL = "cats_angel_repel_probability" ;
    public static final String CATS_ANGEL_SLOW_PROBABILITY_COL = "cats_angel_slow_probability" ;
    public static final String CATS_ANGEL_SLOW_TIME_COL = "cats_angel_slow_time" ;
    public static final String CATS_ANGEL_STOP_PROBABILITY_COL = "cats_angel_stop_probability" ;
    public static final String CATS_ANGEL_STOP_TIME_COL = "cats_angel_stop_time" ;
    public static final String CATS_ANGEL_REDUCE_ATTACK_PROBABILITY_COL = "cats_angel_reduce_attack_probability" ;
    public static final String CATS_ANGEL_REDUCE_ATTACK_TIME_COL = "cats_angel_reduce_attack_time" ;
    public static final String CATS_ANGEL_REDUCE_ATTACK_PROPORTION_COL = "cats_angel_reduce_attack_proportion" ;

    public static final String CATS_ALIEN_REPEL_PROBABILITY_COL = "cats_alien_repel_probability" ;
    public static final String CATS_ALIEN_SLOW_PROBABILITY_COL = "cats_alien_slow_probability" ;
    public static final String CATS_ALIEN_SLOW_TIME_COL = "cats_alien_slow_time" ;
    public static final String CATS_ALIEN_STOP_PROBABILITY_COL = "cats_alien_stop_probability" ;
    public static final String CATS_ALIEN_STOP_TIME_COL = "cats_alien_stop_time" ;
    public static final String CATS_ALIEN_REDUCE_ATTACK_PROBABILITY_COL = "cats_alien_reduce_attack_probability" ;
    public static final String CATS_ALIEN_REDUCE_ATTACK_TIME_COL = "cats_alien_reduce_attack_time" ;
    public static final String CATS_ALIEN_REDUCE_ATTACK_PROPORTION_COL = "cats_alien_reduce_attack_proportion" ;

    public static final String CATS_ZOMBIE_REPEL_PROBABILITY_COL = "cats_zombie_repel_probability" ;
    public static final String CATS_ZOMBIE_SLOW_PROBABILITY_COL = "cats_zombie_slow_probability" ;
    public static final String CATS_ZOMBIE_SLOW_TIME_COL = "cats_zombie_slow_time" ;
    public static final String CATS_ZOMBIE_STOP_PROBABILITY_COL = "cats_zombie_stop_probability" ;
    public static final String CATS_ZOMBIE_STOP_TIME_COL = "cats_zombie_stop_time" ;
    public static final String CATS_ZOMBIE_REDUCE_ATTACK_PROBABILITY_COL = "cats_zombie_reduce_attack_probability" ;
    public static final String CATS_ZOMBIE_REDUCE_ATTACK_TIME_COL = "cats_zombie_reduce_attack_time" ;
    public static final String CATS_ZOMBIE_REDUCE_ATTACK_PROPORTION_COL = "cats_zombie_reduce_attack_proportion" ;

    public static final String CATS_WITCH_REPEL_PROBABILITY_COL = "cats_witch_repel_probability" ;
    public static final String CATS_WITCH_SLOW_PROBABILITY_COL = "cats_witch_slow_probability" ;
    public static final String CATS_WITCH_SLOW_TIME_COL = "cats_witch_slow_time" ;
    public static final String CATS_WITCH_STOP_PROBABILITY_COL = "cats_witch_stop_probability" ;
    public static final String CATS_WITCH_STOP_TIME_COL = "cats_witch_stop_time" ;
    public static final String CATS_WITCH_REDUCE_ATTACK_PROBABILITY_COL = "cats_witch_reduce_attack_probability" ;
    public static final String CATS_WITCH_REDUCE_ATTACK_TIME_COL = "cats_witch_reduce_attack_time" ;
    public static final String CATS_WITCH_REDUCE_ATTACK_PROPORTION_COL = "cats_witch_reduce_attack_proportion" ;

    public static final String CATS_NOATTR_REPEL_PROBABILITY_COL = "cats_noattr_repel_probability" ;
    public static final String CATS_NOATTR_SLOW_PROBABILITY_COL = "cats_noattr_slow_probability" ;
    public static final String CATS_NOATTR_SLOW_TIME_COL = "cats_noattr_slow_time" ;
    public static final String CATS_NOATTR_STOP_PROBABILITY_COL = "cats_noattr_stop_probability" ;
    public static final String CATS_NOATTR_STOP_TIME_COL = "cats_noattr_stop_time" ;
    public static final String CATS_NOATTR_REDUCE_ATTACK_PROBABILITY_COL = "cats_noattr_reduce_attack_probability" ;
    public static final String CATS_NOATTR_REDUCE_ATTACK_TIME_COL = "cats_noattr_reduce_attack_time" ;
    public static final String CATS_NOATTR_REDUCE_ATTACK_PROPORTION_COL = "cats_noattr_reduce_attack_proportion" ;

    public static final String CATS_RESERVED_COL = "cats_reserved" ;

    public static final String SET_INT_0 = " INTEGER DEFAULT 0, " ;
    public static final String SET_TEXT_NULL = " TEXT DEFAULT '', " ;

    private SQLiteDatabase db;

    public CatsDAO(Context context) {
        db = DBHelper.getDatabase(context);
    }

    public void close() {
        db.close();
    }

    public void insert(CatsItem item){
        long id = db.insert(TABLE_NAME, null, ContentValues_Cv(item) );
    }
    //------------------------------------------------
    public static final String get_create_table_str(){

        String s = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CATS_UID_COL + " TEXT DEFAULT 'u000_0', " +
                CATS_JP_NAME_COL + SET_TEXT_NULL +
                CATS_ZH_NAME_COL + SET_TEXT_NULL +
                CATS_JP_CLASS_COL + SET_TEXT_NULL +
                CATS_ZH_CLASS_COL + SET_TEXT_NULL +
                CATS_IMAGE_URL_COL + SET_TEXT_NULL +
                CATS_IMAGE_COL + SET_TEXT_NULL +
                CATS_RARITY_COL + SET_INT_0 +
                CATS_MAX_LEVEL_COL + SET_INT_0 +
                CATS_MAX_BONUS_LEVEL_COL + SET_INT_0 +
                CATS_CUSTOM_LEVEL_COL + SET_INT_0 +
                CATS_CUSTOM_BONUS_LEVEL_COL + SET_INT_0 +
                CATS_BASIC_HP_COL + SET_INT_0 +
                CATS_BASIC_ATTACK_COL + SET_INT_0 +
                CATS_ATTACK_FREQUENCY_COL + SET_INT_0 +
                CATS_ATTACK_OCCURS_COL + SET_INT_0 +
                CATS_ATTACK_INTERVAL_COL + SET_INT_0 +
                CATS_ATTACK_DISTANCE_COL + SET_INT_0 +
                CATS_ATTACK_TYPE_COL + SET_INT_0 +
                CATS_MOVE_SPEED_COL + SET_INT_0 +
                CATS_COST_COL + SET_INT_0 +
                CATS_COOLING_TIME_COL + SET_INT_0 ;

        for (String s1 : get_cats_characteristic_col()) {
            s += s1 + SET_TEXT_NULL ;
        }
        for (String s1 : get_cats_characteristic_zh_col()) {
            s += s1 + SET_TEXT_NULL ;
        }
        for(String s1 : get_cats_evolution_col()){
            s += s1 + SET_INT_0 ;
        }
        s += CATS_CRITICAL_COL + SET_INT_0 ;
        for (String[] s1 : get_cats_attr_proportion_col()) {
            for (String s2 : s1) {
                s += s2 + SET_INT_0;
            }
        }
        s +=
                CATS_SURVIVED_PROBABILITY_COL + SET_INT_0 +
                CATS_BOUNTY_COL + SET_INT_0 +
                CATS_WAVE_LEVEL_COL + SET_INT_0 +
                CATS_WAVE_PROBABILITY_COL + SET_INT_0 +
                CATS_RESUSCITATION_COL + SET_INT_0 +
                CATS_TOWER_ATTACK_COL + SET_INT_0 +
                CATS_METAL_COL + SET_INT_0 +
                CATS_WAVE_REMOVE_COL + SET_INT_0 +
                CATS_BARRIER_BREAK_COL + SET_INT_0 +
                CATS_CONTINUOUS_ATTACK_COL + SET_INT_0 ;
        for(String s1 : get_cats_continuous_attack_proportion_col() ){
            s += s1 + SET_INT_0 ;
        }
        s +=
                CATS_DISTANT_ATTACK_MIN_COL + SET_INT_0 +
                CATS_DISTANT_ATTACK_MAX_COL + SET_INT_0 +
                CATS_INCREASE_ATTACK_HP_COL + SET_INT_0 +
                CATS_INCREASE_ATTACK_PROPORTION_COL + SET_INT_0 ;
        for(String s1 : get_cats_invalid_col()){
            s += s1 + SET_INT_0 ;
        }
        for(String[] s1 : get_cats_abnormal_state_col()){
            for(String s2 : s1){
                s += s2 + SET_INT_0;
            }
        }
        s +=  CATS_RESERVED_COL + " TEXT DEFAULT '' )" ;
        return s;
    }

    public static String[][] get_cats_attr_proportion_col(){
        return new String[][]{
                { CATS_WHITE_DAMAGE_COL , CATS_WHITE_RESISTANCE_COL },
                { CATS_RED_DAMAGE_COL , CATS_RED_RESISTANCE_COL },
                { CATS_BLACK_DAMAGE_COL , CATS_BLACK_RESISTANCE_COL },
                { CATS_FLY_DAMAGE_COL , CATS_FLY_RESISTANCE_COL },
                { CATS_STEEL_DAMAGE_COL , CATS_STEEL_RESISTANCE_COL },
                { CATS_ANGEL_DAMAGE_COL , CATS_ANGEL_RESISTANCE_COL },
                { CATS_ALIEN_DAMAGE_COL , CATS_ALIEN_RESISTANCE_COL },
                { CATS_ZOMBIE_DAMAGE_COL , CATS_ZOMBIE_RESISTANCE_COL },
                { CATS_WITCH_DAMAGE_COL , CATS_WITCH_RESISTANCE_COL },
                { CATS_NOATTR_DAMAGE_COL , CATS_NOATTR_RESISTANCE_COL }
        };
    }

    public static String[][] get_cats_abnormal_state_col(){
        return new String[][]{
                { CATS_WHITE_REPEL_PROBABILITY_COL , CATS_WHITE_SLOW_PROBABILITY_COL , CATS_WHITE_SLOW_TIME_COL , CATS_WHITE_STOP_PROBABILITY_COL , CATS_WHITE_STOP_TIME_COL , CATS_WHITE_REDUCE_ATTACK_PROBABILITY_COL , CATS_WHITE_REDUCE_ATTACK_TIME_COL , CATS_WHITE_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_RED_REPEL_PROBABILITY_COL , CATS_RED_SLOW_PROBABILITY_COL , CATS_RED_SLOW_TIME_COL , CATS_RED_STOP_PROBABILITY_COL , CATS_RED_STOP_TIME_COL , CATS_RED_REDUCE_ATTACK_PROBABILITY_COL , CATS_RED_REDUCE_ATTACK_TIME_COL , CATS_RED_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_BLACK_REPEL_PROBABILITY_COL , CATS_BLACK_SLOW_PROBABILITY_COL , CATS_BLACK_SLOW_TIME_COL , CATS_BLACK_STOP_PROBABILITY_COL , CATS_BLACK_STOP_TIME_COL , CATS_BLACK_REDUCE_ATTACK_PROBABILITY_COL , CATS_BLACK_REDUCE_ATTACK_TIME_COL , CATS_BLACK_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_FLY_REPEL_PROBABILITY_COL , CATS_FLY_SLOW_PROBABILITY_COL , CATS_FLY_SLOW_TIME_COL , CATS_FLY_STOP_PROBABILITY_COL , CATS_FLY_STOP_TIME_COL , CATS_FLY_REDUCE_ATTACK_PROBABILITY_COL , CATS_FLY_REDUCE_ATTACK_TIME_COL , CATS_FLY_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_STEEL_REPEL_PROBABILITY_COL , CATS_STEEL_SLOW_PROBABILITY_COL , CATS_STEEL_SLOW_TIME_COL , CATS_STEEL_STOP_PROBABILITY_COL , CATS_STEEL_STOP_TIME_COL , CATS_STEEL_REDUCE_ATTACK_PROBABILITY_COL , CATS_STEEL_REDUCE_ATTACK_TIME_COL , CATS_STEEL_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_ANGEL_REPEL_PROBABILITY_COL , CATS_ANGEL_SLOW_PROBABILITY_COL , CATS_ANGEL_SLOW_TIME_COL , CATS_ANGEL_STOP_PROBABILITY_COL , CATS_ANGEL_STOP_TIME_COL , CATS_ANGEL_REDUCE_ATTACK_PROBABILITY_COL , CATS_ANGEL_REDUCE_ATTACK_TIME_COL , CATS_ANGEL_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_ALIEN_REPEL_PROBABILITY_COL , CATS_ALIEN_SLOW_PROBABILITY_COL , CATS_ALIEN_SLOW_TIME_COL , CATS_ALIEN_STOP_PROBABILITY_COL , CATS_ALIEN_STOP_TIME_COL , CATS_ALIEN_REDUCE_ATTACK_PROBABILITY_COL , CATS_ALIEN_REDUCE_ATTACK_TIME_COL , CATS_ALIEN_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_ZOMBIE_REPEL_PROBABILITY_COL , CATS_ZOMBIE_SLOW_PROBABILITY_COL , CATS_ZOMBIE_SLOW_TIME_COL , CATS_ZOMBIE_STOP_PROBABILITY_COL , CATS_ZOMBIE_STOP_TIME_COL , CATS_ZOMBIE_REDUCE_ATTACK_PROBABILITY_COL , CATS_ZOMBIE_REDUCE_ATTACK_TIME_COL , CATS_ZOMBIE_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_WITCH_REPEL_PROBABILITY_COL , CATS_WITCH_SLOW_PROBABILITY_COL , CATS_WITCH_SLOW_TIME_COL , CATS_WITCH_STOP_PROBABILITY_COL , CATS_WITCH_STOP_TIME_COL , CATS_WITCH_REDUCE_ATTACK_PROBABILITY_COL , CATS_WITCH_REDUCE_ATTACK_TIME_COL , CATS_WITCH_REDUCE_ATTACK_PROPORTION_COL },
                { CATS_NOATTR_REPEL_PROBABILITY_COL , CATS_NOATTR_SLOW_PROBABILITY_COL , CATS_NOATTR_SLOW_TIME_COL , CATS_NOATTR_STOP_PROBABILITY_COL , CATS_NOATTR_STOP_TIME_COL , CATS_NOATTR_REDUCE_ATTACK_PROBABILITY_COL , CATS_NOATTR_REDUCE_ATTACK_TIME_COL , CATS_NOATTR_REDUCE_ATTACK_PROPORTION_COL }
        };
    }

    public static String[] get_cats_characteristic_col(){
        return new String[]{
                CATS_CHARACTERISTIC_1_COL ,
                CATS_CHARACTERISTIC_2_COL ,
                CATS_CHARACTERISTIC_3_COL ,
                CATS_CHARACTERISTIC_4_COL ,
                CATS_CHARACTERISTIC_5_COL ,
                CATS_CHARACTERISTIC_6_COL
        };
    }

    public static String[] get_cats_characteristic_zh_col(){
        return new String[]{
                CATS_CHARACTERISTIC_ZH_1_COL ,
                CATS_CHARACTERISTIC_ZH_2_COL ,
                CATS_CHARACTERISTIC_ZH_3_COL ,
                CATS_CHARACTERISTIC_ZH_4_COL ,
                CATS_CHARACTERISTIC_ZH_5_COL ,
                CATS_CHARACTERISTIC_ZH_6_COL
        };
    }

    public static String[] get_cats_continuous_attack_proportion_col(){
        return  new String[]{
                CATS_CONTINUOUS_ATTACK_PROPORTION_1_COL,
                CATS_CONTINUOUS_ATTACK_PROPORTION_2_COL,
                CATS_CONTINUOUS_ATTACK_PROPORTION_3_COL
        };
    }

    public static String[] get_cats_evolution_col(){
        return new String[]{
                CATS_EVOLUTION_GREEN_COL ,
                CATS_EVOLUTION_PURPLE_COL ,
                CATS_EVOLUTION_RED_COL ,
                CATS_EVOLUTION_BLUE_COL ,
                CATS_EVOLUTION_YELLOW_COL ,
                CATS_EVOLUTION_COLORFUL_COL ,
        };
    }

    public static String[] get_cats_invalid_col(){
        return new String[]{
                CATS_WAVE_INVALID_COL ,
                CATS_REPEL_INVALID_COL ,
                CATS_SLOW_INVALID_COL ,
                CATS_STOP_INVALID_COL ,
                CATS_REDUCE_ATTACK_INVALID_COL,
                CATS_TELEPORT_INVALID_COL
        };
    }

    private ContentValues ContentValues_Cv(CatsItem item){

        ContentValues cv = new ContentValues();

        String[] s1 ;
        String[] s2 ;
        String[][] ss ;
        int[] ints ;
        int[][] intss ;

        cv.put( CATS_UID_COL , item.cats_uid );
        cv.put( CATS_JP_NAME_COL , item.cats_jp_name );
        cv.put( CATS_ZH_NAME_COL , item.cats_zh_name );
        cv.put( CATS_JP_CLASS_COL , item.cats_jp_class);
        cv.put( CATS_ZH_CLASS_COL , item.cats_zh_class);
        cv.put( CATS_IMAGE_URL_COL , item.cats_image_URL );
        cv.put( CATS_IMAGE_COL , item.cats_image );
        cv.put( CATS_RARITY_COL , item.cats_rarity );
        cv.put( CATS_MAX_LEVEL_COL , item.cats_max_level );
        cv.put( CATS_MAX_BONUS_LEVEL_COL , item.cats_max_bonus_level );
        cv.put( CATS_CUSTOM_LEVEL_COL , item.cats_custom_level );
        cv.put( CATS_CUSTOM_BONUS_LEVEL_COL , item.cats_custom_bonus_level );
        cv.put( CATS_BASIC_HP_COL , item.cats_basic_hp );
        cv.put( CATS_BASIC_ATTACK_COL , item.cats_basic_attack );
        cv.put( CATS_ATTACK_FREQUENCY_COL , item.cats_attack_frequency );
        cv.put( CATS_ATTACK_OCCURS_COL , item.cats_attack_occurs );
        cv.put( CATS_ATTACK_INTERVAL_COL , item.cats_attack_interval );
        cv.put( CATS_ATTACK_DISTANCE_COL , item.cats_attack_distance );
        cv.put( CATS_ATTACK_TYPE_COL , item.cats_attack_type );
        cv.put( CATS_MOVE_SPEED_COL , item.cats_move_speed );
        cv.put( CATS_COST_COL , item.cats_cost );
        cv.put( CATS_COOLING_TIME_COL , item.cats_cooling_time );

        s1 = get_cats_characteristic_col();
        s2 = get_cats_characteristic_zh_col();
        for(int i=0 ; i<s1.length ; i++){
            cv.put( s1[i] , item.cats_characteristic[i] );
            cv.put( s2[i] , item.cats_characteristic_zh[i] );
        }

        cv.put( CATS_CRITICAL_COL , item.cats_critical );

        ss = get_cats_attr_proportion_col() ;
        intss = item.get_cats_attr_proportion();
        for(int i=0 ; i<ss.length ; i++){
            for(int j=0 ; j<ss[i].length ; j++){
                cv.put(ss[i][j],intss[i][j]);
            }
        }

        s1 = get_cats_evolution_col();
        ints = item.get_cats_evolution();
        for(int i=0 ; i<s1.length ;i++){
            cv.put(s1[i],ints[i]);
        }

        cv.put( CATS_SURVIVED_PROBABILITY_COL , item.cats_survived_probability );
        cv.put( CATS_BOUNTY_COL , item.cats_bounty );
        cv.put( CATS_WAVE_LEVEL_COL , item.cats_wave_level );
        cv.put( CATS_WAVE_PROBABILITY_COL , item.cats_wave_probability );
        cv.put( CATS_RESUSCITATION_COL , item.cats_resuscitation );
        cv.put( CATS_TOWER_ATTACK_COL , item.cats_tower_attack );
        cv.put( CATS_METAL_COL , item.cats_metal );
        cv.put( CATS_WAVE_REMOVE_COL , item.cats_wave_remove );
        cv.put( CATS_BARRIER_BREAK_COL , item.cats_barrier_break );

        cv.put( CATS_CONTINUOUS_ATTACK_COL , item.cats_continuous_attack );
        s1 = get_cats_continuous_attack_proportion_col();
        for( int i=0 ; i<s1.length ; i++ ){
            cv.put(s1[i],item.cats_continuous_attack_proportion[i]);
        }

        cv.put( CATS_DISTANT_ATTACK_MIN_COL , item.cats_distant_attack_min );
        cv.put( CATS_DISTANT_ATTACK_MAX_COL , item.cats_distant_attack_max );
        cv.put( CATS_INCREASE_ATTACK_HP_COL , item.cats_increase_attack_hp );
        cv.put( CATS_INCREASE_ATTACK_PROPORTION_COL , item.cats_increase_attack_proportion );

        s1 = get_cats_invalid_col() ;
        ints = item.get_cats_invalid() ;
        for(int i=0 ; i<s1.length ; i++){
            cv.put(s1[i],ints[i]);
        }

        ss = get_cats_abnormal_state_col();
        intss = item.get_cats_abnormal_state();
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < ss[i].length; j++) {
                cv.put(ss[i][j],intss[i][j]);
            }
        }

        return cv;
    }

    public boolean check_data(String uid){
        Cursor c  = db.rawQuery("select _id from cats where cats_uid = ?", new String[]{uid});
        return c.getCount() > 0;
    }

    public boolean update(CatsItem item){
        String where = KEY_ID + "=" + get_Key_ID(item.cats_uid);
        return db.update(TABLE_NAME, ContentValues_Cv(item) , where, null) > 0;
    }

    public boolean delete(String uid){
        String where = KEY_ID + "=" + get_Key_ID(uid);
        return db.delete(TABLE_NAME, where , null) > 0;
    }

    public int get_Key_ID( String uid ){
        Cursor c  = db.rawQuery("select _id from cats where cats_uid = ?", new String[]{uid});
        c.moveToFirst();
       return c.getInt(c.getColumnIndex(KEY_ID));
    }

    public CatsItem[] getAll(){
        return CatItemAll(db.query(TABLE_NAME, null, null, null, null, null, null, null)) ;
    }

    private CatsItem[] CatItemAll(Cursor cur){

        CatsItem[] item = new CatsItem[ cur.getCount() ] ;

        for(int i=0 ;i < cur.getCount() ; i++ ){

            item[i] = new CatsItem() ;
            String[] s1 ;
            String[] s2 ;
            String[][] ss ;
            int[] ints ;
            int[][] intss ;

            cur.moveToFirst();

            item[i].cats_id = cur.getInt(cur.getColumnIndex(KEY_ID));
            item[i].cats_uid = cur.getString(cur.getColumnIndex(CATS_UID_COL));
            item[i].cats_jp_name = cur.getString(cur.getColumnIndex(CATS_JP_NAME_COL));
            item[i].cats_zh_name = cur.getString(cur.getColumnIndex(CATS_ZH_NAME_COL));
            item[i].cats_jp_class = cur.getString(cur.getColumnIndex(CATS_JP_CLASS_COL));
            item[i].cats_zh_class = cur.getString(cur.getColumnIndex(CATS_ZH_CLASS_COL));
            item[i].cats_image = cur.getString(cur.getColumnIndex(CATS_IMAGE_COL));
            item[i].cats_rarity = cur.getInt(cur.getColumnIndex(CATS_RARITY_COL));
            item[i].cats_max_level = cur.getInt(cur.getColumnIndex(CATS_MAX_LEVEL_COL));
            item[i].cats_max_bonus_level = cur.getInt(cur.getColumnIndex(CATS_MAX_BONUS_LEVEL_COL));
            item[i].cats_custom_level = cur.getInt(cur.getColumnIndex(CATS_CUSTOM_LEVEL_COL));
            item[i].cats_custom_bonus_level = cur.getInt(cur.getColumnIndex(CATS_CUSTOM_BONUS_LEVEL_COL));
            item[i].cats_basic_hp = cur.getInt(cur.getColumnIndex(CATS_BASIC_HP_COL));
            item[i].cats_basic_attack = cur.getInt(cur.getColumnIndex(CATS_BASIC_ATTACK_COL));
            item[i].cats_attack_frequency = cur.getInt(cur.getColumnIndex(CATS_ATTACK_FREQUENCY_COL));
            item[i].cats_attack_occurs = cur.getInt(cur.getColumnIndex(CATS_ATTACK_OCCURS_COL));
            item[i].cats_attack_interval = cur.getInt(cur.getColumnIndex(CATS_ATTACK_INTERVAL_COL));
            item[i].cats_attack_distance = cur.getInt(cur.getColumnIndex(CATS_ATTACK_DISTANCE_COL));
            item[i].cats_attack_type = cur.getInt(cur.getColumnIndex(CATS_ATTACK_TYPE_COL));
            item[i].cats_move_speed = cur.getInt(cur.getColumnIndex(CATS_MOVE_SPEED_COL));
            item[i].cats_cost = cur.getInt(cur.getColumnIndex(CATS_COST_COL));
            item[i].cats_cooling_time = cur.getInt(cur.getColumnIndex(CATS_COOLING_TIME_COL));

            s1 = get_cats_characteristic_col();
            s2 = get_cats_characteristic_zh_col();
            for(int j=0 ; j<s1.length ; j++){
                item[i].cats_characteristic[j] = cur.getString(cur.getColumnIndex(s1[j]));
                item[i].cats_characteristic_zh[j] = cur.getString(cur.getColumnIndex(s2[j]));
            }

            item[i].cats_critical = cur.getInt(cur.getColumnIndex( CATS_CRITICAL_COL ) );

            ss = get_cats_attr_proportion_col();
            intss = new int[ss.length][ss[0].length];
            for (int j = 0; j < ss.length; j++) {
                for (int k = 0; k < ss[j].length; k++) {
                    intss[j][k] = cur.getInt(cur.getColumnIndex(ss[j][k]));
                }
            }
            item[i].set_cats_attr_proportion(intss);

            s1 = get_cats_evolution_col();
            ints = new int[s1.length];
            for (int j = 0; j < s1.length; j++) {
                ints[j] = cur.getInt(cur.getColumnIndex(s1[j]));
            }
            item[i].set_cats_evolution(ints);

            item[i].cats_survived_probability = cur.getInt(cur.getColumnIndex( CATS_SURVIVED_PROBABILITY_COL ) );
            item[i].cats_bounty = cur.getInt(cur.getColumnIndex( CATS_BOUNTY_COL ) );
            item[i].cats_wave_level = cur.getInt(cur.getColumnIndex( CATS_WAVE_LEVEL_COL ) );
            item[i].cats_wave_probability = cur.getInt(cur.getColumnIndex( CATS_WAVE_PROBABILITY_COL ) );
            item[i].cats_resuscitation = cur.getInt(cur.getColumnIndex( CATS_RESUSCITATION_COL ) );
            item[i].cats_tower_attack = cur.getInt(cur.getColumnIndex( CATS_TOWER_ATTACK_COL ) );
            item[i].cats_metal = cur.getInt(cur.getColumnIndex( CATS_METAL_COL ) );
            item[i].cats_wave_remove = cur.getInt(cur.getColumnIndex( CATS_WAVE_REMOVE_COL ) );
            item[i].cats_barrier_break = cur.getInt(cur.getColumnIndex( CATS_BARRIER_BREAK_COL ) );

            item[i].cats_continuous_attack = cur.getInt(cur.getColumnIndex( CATS_CONTINUOUS_ATTACK_COL ) );
            s1 = get_cats_continuous_attack_proportion_col();
            for( int j=0 ; j<s1.length ; j++ ){
                item[i].cats_continuous_attack_proportion[j] = cur.getInt(cur.getColumnIndex(s1[j]));
            }

            item[i].cats_distant_attack_min = cur.getInt(cur.getColumnIndex( CATS_DISTANT_ATTACK_MIN_COL ) );
            item[i].cats_distant_attack_max = cur.getInt(cur.getColumnIndex( CATS_DISTANT_ATTACK_MAX_COL ) );
            item[i].cats_increase_attack_hp = cur.getInt(cur.getColumnIndex( CATS_INCREASE_ATTACK_HP_COL ) );
            item[i].cats_increase_attack_proportion = cur.getInt(cur.getColumnIndex( CATS_INCREASE_ATTACK_PROPORTION_COL ) );

            s1 = get_cats_invalid_col();
            ints = new int[s1.length];
            for (int j = 0; j < s1.length; j++) {
                ints[j] = cur.getInt(cur.getColumnIndex(s1[j]));
            }
            item[i].set_cats_invalid(ints);

            ss = get_cats_abnormal_state_col();
            intss = new int[ss.length][ss[0].length];
            for (int j = 0; j < ss.length; j++) {
                for (int k = 0; k < ss[j].length; k++) {
                    intss[j][k] = cur.getInt(cur.getColumnIndex(ss[j][k]));
                }
            }
            item[i].set_cats_abnormal_state(intss);

        }
        return item;
    }
}
