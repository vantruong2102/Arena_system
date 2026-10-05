package model;

	/**
	 * Lớp trừu tượng đại diện cho trò chơi phần mềm trong ARENA.
	 */
	public abstract class Game {
	    private String name;

	    public Game(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
}

