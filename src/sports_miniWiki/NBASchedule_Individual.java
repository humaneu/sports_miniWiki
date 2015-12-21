package sports_miniWiki;

/**
 * This class constructs information about a single scheduled NBA game.
 *
 */
public class NBASchedule_Individual {
	
	private String date;
	private String time;
	private String away;
	private String home;
	
	/**
	 * The constructor
	 * @param date
	 * @param time
	 * @param away
	 * @param home
	 */
	public NBASchedule_Individual(String date, String time, String away, String home) {
		this.date = date;
		this.time = time;
		this.away = away;
		this.home = home;
	}

	@Override
	public String toString() {
		String res = date + " " + time + " " + away + " VS " + home;
		return res;
	}
	

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
}
