package main.easy;

@SuppressWarnings("unused")
public class PrimeArrangements {
    /**
     * 1175. 质数排列
     *
     * @return 从 1 到 n 的数，所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上，可能的方案总数
     */
    public int numPrimeArrangements(int n) {
        int primes = -1, limit = (int) Math.sqrt(n);
        boolean[] table = new boolean[n];

        for (int i = 2; i <= limit; i++) {
            for (int j = i; i * j <= n; j++) {
                table[i * j - 1] = true;
            }
        }

        for (boolean b : table) {
            if (!b)
                primes++;
        }

        long res = 1, composites = n - primes;

        for (int i = 2; i <= primes; i++) {
            res *= i;
            res %= (int) (1e9) + 7;
        }

        for (int i = 2; i <= composites; i++) {
            res *= i;
            res %= (int) (1e9) + 7;
        }

        return (int) res;
    }
}
