package main.easy;

@SuppressWarnings("unused")
public class JewelsAndStones {
    /**
     * 771. 宝石与石头
     *
     * @param jewels 字符串 jewels 代表石头中宝石的类型，jewels 中的所有字符都是 唯一的
     * @param stones stones 中每个字符代表了一种拥有的石头的类型
     * @return 拥有的石头中有多少是宝石
     */
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[128];

        for (int i = 0; i < jewels.length(); i++)
            isJewel[jewels.charAt(i)] = true;

        int count = 0;

        for (int i = 0; i < stones.length(); i++)
            if (isJewel[stones.charAt(i)])
                count++;

        return count;
    }
}
