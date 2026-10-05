package model;

/**
 * Lớp trừu tượng đại diện cho thông tin người dùng chung trong hệ thống ARENA.
 * Thừa kế bởi LeagueOwner, Player, và Advertiser.
 * 
 *
 * 
 */
public abstract class User {
	/** Tên của người dùng. */
    private String name;
    /** Thông tin liên hệ của người dùng (ví dụ: địa chỉ Email, số điện thoại). */
    private String contact;

    /**
     * Khởi tạo một đối tượng User mới.
     * 
     * @param name    Tên người dùng
     * @param contact Thông tin liên hệ (Email, SĐT)
     */
    public User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
    
    /**
     * Lấy tên của người dùng.
     *
     * @return Chuỗi chứa tên người dùng.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Lấy thông tin liên hệ của người dùng.
     *
     * @return Chuỗi chứa thông tin liên hệ.
     */
    public String getContact() {
        return contact;
    }
}
