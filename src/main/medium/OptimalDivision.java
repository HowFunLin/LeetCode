package main.medium;

@SuppressWarnings("unused")
public class OptimalDivision {
    /**
     * 553. 最优除法
     *
     * @param nums 正整数，相邻的整数之间将会进行浮点除法操作
     * @return 最大的结果相应的不含有冗余的括号的字符串格式的表达式。可以在任意位置添加任意数目的括号，来改变算数的优先级
     */
    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();

        for (int num : nums)
            builder.append(num).append("/");

        builder.deleteCharAt(builder.length() - 1);

        if (nums.length > 2) {
            builder.insert(builder.indexOf("/") + 1, '(');
            builder.append(')');
        }

        return builder.toString();
    }
}
