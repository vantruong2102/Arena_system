package Demo;

import boundary.TournamentForm;
import control.AnnounceTournamentControl;
import model.Advertiser;
import model.Arena;
import model.Chess;
import model.InterestGroup;
import model.KnockOutStyle;
import model.League;
import model.LeagueOwner;
import model.Player;

/**
 * Lớp điều khiển chương trình chính để chạy giả lập Use Case AnnounceTournament.
 */
public class Main {

    public static void main(String[] args) {
        // 1. Khởi tạo môi trường Arena và dữ liệu mẫu (Entity Objects)
        Arena arena = new Arena(10, 500.0); // Tối đa 10 giải đấu, Phí tài trợ $500

        LeagueOwner owner = new LeagueOwner("Alice Nguyễn", "alice@arena.com");
        Advertiser adv1 = new Advertiser("RedBull", "contact@redbull.com", 2000.0);
        Advertiser adv2 = new Advertiser("Logitech", "contact@logitech.com", 1500.0);
        arena.addAdvertiser(adv1);
        arena.addAdvertiser(adv2);

        Player player1 = new Player("Bob", "bob@gmail.com");
        InterestGroup chessLovers = new InterestGroup("Hội Những Người Thích Cờ Vua");
        chessLovers.addMember(player1);
        chessLovers.addMember(owner);
        arena.addInterestGroup(chessLovers);

        League chessLeague = new League("VCS Chess League", 5, new Chess(), new KnockOutStyle());

        // 2. Tương tác từ Màn hình Boundary
        TournamentForm form = new TournamentForm();
        form.displayForm();

        // 3. Khởi tạo Control Object và Kích hoạt Use Case
        AnnounceTournamentControl control = new AnnounceTournamentControl(arena, chessLeague, owner);
        
        // Giả lập nhập liệu từ Form và khởi chạy
        control.processAnnounceTournament(
                "Giải Cờ Vua Mùa Xuân 2026", 
                "01/11/2026", 
                "10/11/2026", 
                "15/11/2026", 
                "20/11/2026", 
                64, 
                true // Tìm nhà tài trợ độc quyền
        );
    }
}
