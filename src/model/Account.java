package model;

/**
 * Đại diện cho tài khoản tài chính của Nhà quảng cáo (Advertiser).
 * Quản lý số dư, lịch sử tính phí và thực hiện giao dịch khấu trừ khi tài trợ.
 */
public class Account {
	
	/** Số dư tài khoản hiện tại. */
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Trừ phí tài trợ vào tài khoản.
     * 
     * @param amount Số tiền cần trừ
     * @return true nếu trừ tiền thành công, false nếu số dư không đủ
     */
    public boolean charge(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * Lấy số dư tài khoản hiện tại.
     *
     * @return Số dư dưới dạng tiền tệ (double).
     */
    public double getBalance() {
        return balance;
    }
}
