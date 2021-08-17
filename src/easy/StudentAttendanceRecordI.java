package easy;

@SuppressWarnings("unused")
public class StudentAttendanceRecordI {
    /**
     * <h3>551. 学生出勤记录 I</h3>
     * 按 总出勤 计，学生缺勤（'A'）严格 少于两天 且 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录，可以获得出勤奖励
     *
     * @param s 学生的出勤记录，每个字符用来标记当天的出勤情况（缺勤'A'、迟到'L'、到场'P'）
     * @return 学生能否获得出勤奖励
     */
    public boolean checkRecord(String s) {
        char[] record = s.toCharArray();
        int absent = 0, late = 0;

        for (char attendance : record) {
            if (attendance == 'P') {
                late = 0;
                continue;
            }

            if (attendance == 'A') {
                absent++;
                late = 0;

                if (absent >= 2)
                    return false;
            }

            if (attendance == 'L') {
                late++;

                if (late >= 3)
                    return false;
            }
        }

        return true;
    }
}
