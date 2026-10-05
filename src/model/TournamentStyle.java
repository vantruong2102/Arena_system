package model;

/**
 * Lớp trừu tượng định nghĩa thể thức thi đấu giải đấu.
 */
public abstract class TournamentStyle {
    private String styleName;

    public TournamentStyle(String styleName) {
        this.styleName = styleName;
    }

    public String getStyleName() {
        return styleName;
    }
}
