package medium;

@SuppressWarnings("unused")
public class SingleNumberII {
    public int singleNumber(int[] nums) {
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

        int[] counts = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>= 1;
            }
        }

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= counts[31 - i] % 3;
        }

        return result;
    }
}
