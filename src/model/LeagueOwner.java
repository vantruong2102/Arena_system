package model;

/**
 * Đại diện cho tác nhân Ban tổ chức/Chủ quản liên đoàn (LeagueOwner).
 * Chịu trách nhiệm khởi tạo League, tạo giải đấu (Tournament), và quản lý quy trình thi đấu.
 */
public class LeagueOwner extends User {
	
	/**
     * Khởi tạo một tài khoản LeagueOwner mới.
     *
     * @param name    Tên của chủ quản liên đoàn.
     * @param contact Thông tin liên hệ.
     */
    public LeagueOwner(String name, String contact) {
        super(name, contact);
    }
}
