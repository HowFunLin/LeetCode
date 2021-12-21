package main.easy;

@SuppressWarnings("unused")
public class DayOfTheYear {
    private static int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

    /**
     * 1154. 一年中的第几天
     *
     * @param date 字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期
     * @return 日期 date 是当年的第几天
     */
    public int dayOfYear(String date) {
        String[] d = date.split("-");

        int year = Integer.valueOf(d[0]);
        int month = Integer.valueOf(d[1]);
        int day = Integer.valueOf(d[2]);
        int ans = 0;

        for (int i = 0; i < month - 1; i++)
            ans += months[i];

        if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month > 2)
            ans += day + 1;
        else
            ans += day;

        return ans;
    }
}
