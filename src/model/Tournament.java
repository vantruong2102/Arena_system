package model;

/**
 * Đại diện cho một Giải đấu được công bố và vận hành trong ARENA.
 */
public class Tournament {
    private String name;
    private String appStartDate;
    private String appEndDate;
    private String playStartDate;
    private String playEndDate;
    private int maxPlayers;
    private Advertiser exclusiveSponsor;

    public Tournament(String name, String appStartDate, String appEndDate, String playStartDate, String playEndDate, int maxPlayers) {
        this.name = name;
        this.appStartDate = appStartDate;
        this.appEndDate = appEndDate;
        this.playStartDate = playStartDate;
        this.playEndDate = playEndDate;
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public Advertiser getExclusiveSponsor() {
        return exclusiveSponsor;
    }

    public void setExclusiveSponsor(Advertiser exclusiveSponsor) {
        this.exclusiveSponsor = exclusiveSponsor;
    }
}
