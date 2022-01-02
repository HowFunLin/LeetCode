package main.medium;

@SuppressWarnings("unused")
public class EliminationGame {
    /**
     * 390. 消除游戏
     *
     * @param n 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。对 arr 应用下述算法：
     *          <p>
     *          1. 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾；
     *          <p>
     *          2. 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个；
     *          <p>
     *          3. 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字
     * @return arr 最后剩下的数字
     */
    public int lastRemaining(int n) {
        int a1 = 1, an = n, count = n, step = 1;
        boolean isEven = true;

        while (count > 1) {
            if (isEven) {
                a1 += step;
                an = count % 2 == 0 ? an : an - step; // 若等差数列为偶数个，则最后一个数不被删除，否则最后一个数为等差的前一个
            } else {
                a1 = count % 2 == 0 ? a1 : a1 + step; // 若等差数列为偶数个，则第一个数不被删除，否则第一个数为等差的后一个
                an -= step;
            }

            isEven = !isEven;
            count >>= 1;
            step <<= 1; // 每次删除之后剩下的等差数列的差为原来的 2 倍
        }

        return a1;
    }
}
