package control;

import boundary.InterestGroupNotice;
import boundary.SponsorNotice;
import model.Advertiser;
import model.Arena;
import model.InterestGroup;
import model.League;
import model.LeagueOwner;
import model.Tournament;

import java.util.ArrayList;
import java.util.List;

/**
 * Đối tượng điều khiển (Control Object) phối hợp toàn bộ luồng nghiệp vụ cho Use Case AnnounceTournament.
 */
public class AnnounceTournamentControl {

    private Arena arena;
    private League league;
    private LeagueOwner leagueOwner;
    private SponsorNotice sponsorNotice;
    private InterestGroupNotice interestGroupNotice;

    public AnnounceTournamentControl(Arena arena, League league, LeagueOwner leagueOwner) {
        this.arena = arena;
        this.league = league;
        this.leagueOwner = leagueOwner;
        this.sponsorNotice = new SponsorNotice();
        this.interestGroupNotice = new InterestGroupNotice();
    }

    /**
     * Thực thi luồng chính của Use Case AnnounceTournament.
     */
    public void processAnnounceTournament(String name, String appStart, String appEnd, 
                                           String playStart, String playEnd, int maxPlayers, 
                                           boolean seekExclusiveSponsor) {
        
        System.out.println("\n=== BẮT ĐẦU LUỒNG XỬ LÝ: ANNOUNCE TOURNAMENT ===");

        // Step 1: Kiểm tra điều kiện hạn mức giải đấu trong League
        if (!league.canCreateTournament()) {
            System.out.println("[Error]: Liên đoàn " + league.getName() + " đã đạt số lượng giải đấu tối đa.");
            return;
        }

        // Step 2: Khởi tạo Entity Tournament
        Tournament tournament = new Tournament(name, appStart, appEnd, playStart, playEnd, maxPlayers);
        System.out.println("[Control]: Tạo thành công đối tượng giải đấu: " + name);

        // Step 3: Xử lý tìm kiếm Nhà tài trợ độc quyền (nếu được yêu cầu)
        if (seekExclusiveSponsor) {
            handleSponsorship(tournament);
        } else {
            System.out.println("[Control]: LeagueOwner không chọn tìm kiếm nhà tài trợ độc quyền.");
        }

        // Step 4: Thêm giải đấu vào League
        league.addTournament(tournament);

        // Step 5: Thông báo tới các nhóm quan tâm (Interest Groups)
        notifyInterestGroups(tournament);

        System.out.println("=== HOÀN TẤT USE CASE ANNOUNCE TOURNAMENT ===\n");
    }

    private void handleSponsorship(Tournament tournament) {
        List<Advertiser> candidates = arena.getAdvertisers();
        double flatFee = arena.getFlatFeeForSponsorship();

        System.out.println("\n--- Xử lý tài trợ độc quyền ---");
        // Gửi lời mời tới tất cả nhà quảng cáo
        for (Advertiser adv : candidates) {
            sponsorNotice.sendSponsorshipInvitation(adv, tournament.getName(), flatFee);
        }

        // Giả lập: Lấy danh sách phản hồi đồng ý (Giả định Nhà quảng cáo đầu tiên đồng ý)
        List<Advertiser> interestedAdvertisers = new ArrayList<>();
        if (!candidates.isEmpty()) {
            interestedAdvertisers.add(candidates.get(0)); // Giả lập Advertiser 1 đồng ý
        }

        if (!interestedAdvertisers.isEmpty()) {
            // LeagueOwner lựa chọn 1 sponsor
            Advertiser selectedSponsor = interestedAdvertisers.get(0);
            
            // Trừ phí tài trợ
            boolean charged = selectedSponsor.getAccount().charge(flatFee);
            if (charged) {
                tournament.setExclusiveSponsor(selectedSponsor);
                System.out.println("[Control]: Đã chọn " + selectedSponsor.getName() 
                        + " làm Nhà tài trợ độc quyền. Đã trừ thành công $" + flatFee);
            }

            // Gửi thông báo kết quả cho các bên
            for (Advertiser adv : candidates) {
                boolean isSelected = adv.equals(selectedSponsor);
                sponsorNotice.sendSponsorshipResult(adv, tournament.getName(), isSelected);
            }
        } else {
            System.out.println("[Control]: Không có nhà quảng cáo nào phản hồi đồng ý tài trợ.");
        }
    }

    private void notifyInterestGroups(Tournament tournament) {
        System.out.println("\n--- Gửi thông báo tới Nhóm người dùng quan tâm ---");
        for (InterestGroup group : arena.getInterestGroups()) {
            interestGroupNotice.notifyGroup(group, tournament.getName());
        }
    }
}