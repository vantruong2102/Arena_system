package model;

/**
 * Đại diện cho tác nhân Nhà quảng cáo / Nhà tài trợ (Advertiser).
 * Tài trợ cho các giải đấu để hiển thị biểu ngữ quảng cáo trong các trận đấu
 */
public class Advertiser extends User {
	
	/** Tài khoản tài chính phục vụ việc thanh toán phí tài trợ. */
    private Account account;
    
    /**
     * Khởi tạo nhà quảng cáo mới kèm theo tài khoản thanh toán.
     *
     * @param name           Tên công ty hoặc nhà tài trợ.
     * @param contact        Email hoặc địa chỉ liên hệ.
     * @param initialBalance Số dư tài khoản ban đầu cấp cho nhà tài trợ.
     */
    public Advertiser(String name, String contact, double initialBalance) {
        super(name, contact);
        this.account = new Account(initialBalance);
    }

    /**
     * Lấy tài khoản thanh toán của nhà quảng cáo.
     *
     * @return Đối tượng Account liên kết.
     */
    public Account getAccount() {
        return account;
    }
}