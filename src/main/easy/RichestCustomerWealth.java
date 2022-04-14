package main.easy;

@SuppressWarnings("unused")
public class RichestCustomerWealth {
    /**
     * 1672. 最富有客户的资产总量
     *
     * @param accounts m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量
     * @return 最富有客户所拥有的 资产总量。客户的 资产总量 就是他们在各家银行托管的资产数量之和
     */
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                accounts[i][0] += accounts[i][j];

        int max = 0;

        for (int[] account : accounts)
            max = Math.max(max, account[0]);

        return max;
    }
}
