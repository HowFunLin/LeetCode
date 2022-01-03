package main.easy;

@SuppressWarnings("unused")
public class DayOfTheWeek {
    /**
     * 1185. 一周中的第几天
     *
     * @param day   日
     * @param month 月
     * @param year  年
     * @return 判断日期是对应一周中的哪一天。日期是在 1971 到 2100 年之间的有效日期
     */
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        int days = 365 * (year - 1971) + (year - 1969) / 4;

        for (int i = 0; i < month - 1; i++)
            days += months[i];

        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3)
            days++;

        days += day;

        return week[(days + 3) % 7];
    }
}
