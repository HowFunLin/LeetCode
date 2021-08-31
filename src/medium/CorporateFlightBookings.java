package medium;

@SuppressWarnings("unused")
public class CorporateFlightBookings {
    /**
     * 1109. 航班预订统计
     *
     * @param bookings 航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [first, last, seats] ，
     *                 意味着在从 first 到 last （包含 first 和 last ）的 每个航班 上预订了 seats 个座位
     * @param n         n 个航班
     * @return 长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];

        for (int[] booking : bookings) {
            int first = booking[0], last = booking[1], seats = booking[2];

            // 模拟，耗时较长
//            for (int i = first - 1; i < last; i++)
//                answer[i] += seats;

            // 起始的航班号加上座位数
            answer[first - 1] += seats;

            // 若结束航班号不延续到最后一个，结束之后的第一个航班号减去座位数，防止之后计算错误叠加
            if (last < n)
                answer[last] -= seats;
        }

        // 利用上一个数加上原本应该加上的座位数
        for (int i = 1; i < n; i++)
            answer[i] += answer[i - 1];

        return answer;
    }
}
