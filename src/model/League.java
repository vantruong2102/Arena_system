package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Đại diện cho Liên đoàn quản lý các giải đấu của một Game cụ thể.
 */
public class League {
    private String name;
    private int maxTournaments;
    private Game game;
    private TournamentStyle style;
    private List<Tournament> tournaments;

    public League(String name, int maxTournaments, Game game, TournamentStyle style) {
        this.name = name;
        this.maxTournaments = maxTournaments;
        this.game = game;
        this.style = style;
        this.tournaments = new ArrayList<>();
    }

    public boolean canCreateTournament() {
        return tournaments.size() < maxTournaments;
    }

    public void addTournament(Tournament tournament) {
        tournaments.add(tournament);
    }

    public String getName() {
        return name;
    }
}