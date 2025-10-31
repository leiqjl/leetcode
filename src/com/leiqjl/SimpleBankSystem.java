package com.leiqjl;

/**
 * 2043. Simple Bank System - Medium
 */
public class SimpleBankSystem {
    class Bank {
        private long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (money < 0 || account1 > balance.length || account2 > balance.length || balance[account1 - 1] < money) {
                return false;
            }
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (money < 0 || account > balance.length) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (money < 0 || account > balance.length || balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }
    }
}
