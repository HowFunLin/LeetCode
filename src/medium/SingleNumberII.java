package medium;

@SuppressWarnings("unused")
public class SingleNumberII {
    /**
     * 剑指 Offer 56 - II. 数组中数字出现的次数 II
     *
     * @param nums 数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次
     * @return 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        //HashMap效率较低
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//            if (map.get(num) == 3)
//                map.remove(num);
//        }
//
//        for (int i : map.keySet())
//            return i;
//
//        return 0;

        // 32位数组存储数字的二进制形式
        int[] counts = new int[32];

        // 32位数组叠加数字在二进制位上的值
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>= 1;
            }
        }

        int result = 0;

        // 32位数组各位均对三求余，还原出仅出现一次的数字
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= counts[31 - i] % 3;
        }

        return result;
    }
}
