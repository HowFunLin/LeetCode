package company;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Ke {
    public void calculateNumbersWhichModSumOfBitsEqualsOne() {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        int[] table = new int[1000001]; // 缓存已得到的结果，-1 不是，0 未计算，1 是

        for (int i = 0; i < t; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt();
            int res = 0;

            for (int j = l; j <= r; j++) {
                if (table[j] == 0) {
                    int sum = 0, cur = j;

                    while (cur > 0) {
                        sum += cur % 10;
                        cur /= 10;
                    }

                    if (j % sum == 1) {
                        table[j] = 1;
                        res++;
                    } else
                        table[j] = -1;
                } else if (table[j] == 1)
                    res++;
            }

            System.out.println(res);
        }
    }

    public void matchCharactersInMatrix() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // 换行
        String str = scanner.nextLine();
        int len = str.length();
        int res = 0;

        // 匹配字符矩阵中是否与字符串对应
        char[][] table = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            for (int j = 0; j < n; j++)
                table[i][j] = line.charAt(j);

            // 从左到右匹配
            tra:
            for (int j = 0; j < n - len + 1; j++) {
                for (int k = j, index = 0; index < len; index++, k++) {
                    if (str.charAt(index) != line.charAt(k))
                        continue tra;
                }

                res++;
            }
        }

        for (int i = 0; i < n; i++) {
            // 从上到下匹配
            tra:
            for (int j = 0; j < n - len + 1; j++) {
                for (int k = j, index = 0; index < len; index++, k++) {
                    if (str.charAt(index) != table[k][i])
                        continue tra;
                }

                res++;
            }
        }

        System.out.println(res);
    }
}
