package eendtech.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ author Seale
 * @ Description:自定义常用的工具类
 * @ QQ:1801157108
 * @ Date 2019/5/13 19:47
 */
public class EUtils {

    /**
     * 获取当前时间并且进行对应与数据库的友好时间格式化
     * @param date 传入当前获取的时间
     * @return String 格式化后的时间
     */
    public static String getCurrentDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
    @Test
    public void test(){
        System.out.println(getCurrentDate(new Date()));
    }




}
