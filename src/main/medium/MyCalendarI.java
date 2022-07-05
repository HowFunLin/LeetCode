package main.medium;

import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("unused")
public class MyCalendarI {
    /**
     * 729. 我的日程安排表 I
     */
    class MyCalendar {
        private TreeMap<Integer, Integer> book;

        public MyCalendar() {
            book = new TreeMap<>();
        }

        /**
         * @return 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
         * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end
         */
        public boolean book(int start, int end) {
            if (!book.isEmpty()) {
                // start -> end 之后的 key 不能小于 end
                Integer after = book.ceilingKey(start);

                if (after != null && after < end)
                    return false;

                // start -> end 之前的 value 不能大于 start
                Map.Entry<Integer, Integer> before = book.floorEntry(start);

                if (before != null && before.getValue() > start)
                    return false;
            }

            book.put(start, end);

            return true;
        }
    }
}
