package test;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
//        System.out.println(calendar.getTime());
        calendar.add(Calendar.DATE, -20);
        System.out.println(calendar.get(Calendar.MONTH) + "" + calendar.get(Calendar.DATE));
    }
}
