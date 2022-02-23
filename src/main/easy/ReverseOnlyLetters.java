package main.easy;

@SuppressWarnings("unused")
public class ReverseOnlyLetters {
    /**
     * 917. 仅仅反转字母
     *
     * @param s 字符串 s
     * @return 反转后的 s 。所有非英文字母保留在原有位置；所有英文字母（小写或大写）位置反转
     */
    public String reverseOnlyLetters(String s) {
//        StringBuilder builder = new StringBuilder();
//
//        int r = s.length() - 1;
//
//        for (int i = 0; i < s.length(); i++) {
//            char cur = s.charAt(i);
//
//            if (Character.isLetter(cur)) {
//                while (!Character.isLetter(s.charAt(r)))
//                    r--;
//
//                builder.append(s.charAt(r--));
//            } else
//                builder.append(cur);
//        }
//
//        return builder.toString();

        char[] arr = s.toCharArray();

        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetter(arr[left]))
                left++;

            while (left < right && !Character.isLetter(arr[right]))
                right--;

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
}
