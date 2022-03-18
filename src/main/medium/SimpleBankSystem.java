package main.medium;

@SuppressWarnings("unused")
public class SimpleBankSystem {
    /**
     * 2043. 简易银行系统
     */
    class Bank {
        private long[] balance;
        private int length;

        /**
         * 使用整数数组 balance 初始化该对象（编号：1 ~ n，下标：0 ~ n - 1）
         *
         * @param balance 整数数组
         */
        public Bank(long[] balance) {
            this.balance = balance;
            length = balance.length;
        }

        /**
         * 从编号为 account1 的账户向编号为 account2 的账户转帐 money 美元
         *
         * @param account1 账户编号
         * @param account2 账户编号
         * @param money    转账金额
         * @return 交易是否成功
         */
        public boolean transfer(int account1, int account2, long money) {
            if (account1 <= length && account2 <= length && balance[account1 - 1] >= money) {
                balance[account1 - 1] -= money;
                balance[account2 - 1] += money;

                return true;
            }

            return false;
        }

        /**
         * 向编号为 account 的账户存款 money 美元
         *
         * @param account 账户编号
         * @param money   存款金额
         * @return 交易是否成功
         */
        public boolean deposit(int account, long money) {
            if (account <= length) {
                balance[account - 1] += money;

                return true;
            }

            return false;
        }

        /**
         * 从编号为 account 的账户取款 money 美元
         *
         * @param account 账户编号
         * @param money   取款金额
         * @return 交易是否成功
         */
        public boolean withdraw(int account, long money) {
            if (account <= length && balance[account - 1] >= money) {
                balance[account - 1] -= money;

                return true;
            }

            return false;
        }
    }
}
