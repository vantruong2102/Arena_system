package model;

/**
 * Đại diện cho tác nhân Người chơi/ Vận động viên (Player).
 * Tham gia đăng ký và thi đấu các trận đấu trong phạm vi giải đấu
 */
public class Player extends User {
	
	/**
     * Khởi tạo một tài khoản Player mới.
     *
     * @param name    Tên của người chơi.
     * @param contact Thông tin liên hệ.
     */
    public Player(String name, String contact) {
        super(name, contact);
    }
}