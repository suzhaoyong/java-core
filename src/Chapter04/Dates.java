package Chapter04;

import java.time.LocalDate;
import java.util.Date;

public class Dates {
    public static void main(String[] args) {
        //TODO 对象和对象变量
        /*
            birthday 引用Date对象
            deadline 无引用对象
            new 操作符的返回值是一个引用
         */
        Date birthday = new Date();
        Date deadline = null;
        System.out.println(birthday);

        //TODO 拷贝对象
        /*
            clone() 获取对象完整拷贝
       */
        if (deadline == null) {
            deadline = (Date) birthday.clone();
            System.out.println(deadline);
        }

        //TODO 显示将对象变量设置为null
        birthday = null;
        //TODO 打印当月日历
        CalendarTest();

    }
    public static void CalendarTest() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        String[] weekHead = { "Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat" };
        for (String h: weekHead) {
            System.out.printf("%5s", h);
        }
        System.out.println();
        int value = date.getDayOfWeek().getValue();
        for (int i = 0; i < value; i ++) {
            System.out.print("     ");
        }
        while (date.getMonthValue() == month) {
            int day = date.getDayOfMonth();
            System.out.printf("%4d", day);
            if ( day == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }

    }
}
