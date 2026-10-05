package boundary;

import model.InterestGroup;
import model.User;

/**
 * Màn hình/Thông báo gửi tới các Nhóm quan tâm về giải đấu mới được khởi tạo.
 */
public class InterestGroupNotice {

    public void notifyGroup(InterestGroup group, String tournamentName) {
        System.out.println("\n[Notice -> InterestGroup: " + group.getGroupName() + "]:");
        for (User user : group.getMembers()) {
            System.out.println("  - Gửi email tới " + user.getName() + " (" + user.getContact() + "): "
                    + "Giải đấu mới '" + tournamentName + "' đã được tạo! Xem chi tiết tại trang chủ Arena.");
        }
    }
}
