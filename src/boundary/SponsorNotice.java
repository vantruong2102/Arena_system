package boundary;

import model.Advertiser;

/**
 * Màn hình/Thông báo gửi tới Nhà quảng cáo để mời và thông báo kết quả tài trợ.
 */
public class SponsorNotice {

    public void sendSponsorshipInvitation(Advertiser advertiser, String tournamentName, double flatFee) {
        System.out.println("[Notice -> Advertiser " + advertiser.getName() + " (" + advertiser.getContact() + ")]: "
                + "Lời mời tài trợ độc quyền cho giải " + tournamentName + " với mức phí: $" + flatFee);
    }

    public void sendSponsorshipResult(Advertiser advertiser, String tournamentName, boolean isSelected) {
        String status = isSelected ? "ĐƯỢC CHỌN" : "KHÔNG ĐƯỢC CHỌN";
        System.out.println("[Notice -> Advertiser " + advertiser.getName() + "]: Quyết định tài trợ cho giải " 
                + tournamentName + " - Kết quả: " + status);
    }
}
