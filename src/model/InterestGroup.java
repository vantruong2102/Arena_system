package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Đại diện cho Nhóm người dùng có chung quan tâm đến một Game/League để nhận thông báo.
 */
public class InterestGroup {
    private String groupName;
    private List<User> members;

    public InterestGroup(String groupName) {
        this.groupName = groupName;
        this.members = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getMembers() {
        return members;
    }
}
