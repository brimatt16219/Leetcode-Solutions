class Bank {

    private long[] balance;
    private int n;

    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        account1 --;
        account2 --;
        if (0 <= account1 && account1 < n && 0 <= account2 && account2 < n) {
            if (balance[account1] < money) return false;
            balance[account1] -= money;
            balance[account2] += money;
            return true;
        }
        else return false;
    }
    
    public boolean deposit(int account, long money) {
        account --;
        if (0 <= account && account < n) {
            balance[account] += money;
            return true;
        }
        else return false;
    }
    
    public boolean withdraw(int account, long money) {
        account --;
        if (0 <= account && account < n) {
            if (balance[account] < money) return false;
            balance[account] -= money;
            return true;
        }
        else return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */