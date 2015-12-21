package sports_miniWiki;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class calls NBA API and stores the schedule information.
 */
public class NBA_Schedule {
	
	private ArrayList<NBASchedule_Individual> schedule;
	private ArrayList<String> dates;
	
	/**
	 * The constructor
	 * @throws IOException
	 * @throws JSONException
	 */
	public NBA_Schedule() throws IOException, JSONException {
		schedule = new ArrayList<NBASchedule_Individual>();
		dates = new ArrayList<String>();
		getSchedule();

	}
	
	/**
	 * The method that makes the API call.
	 * @throws IOException
	 * @throws JSONException
	 */
	private void getSchedule() throws IOException, JSONException {
		
		URL myUrl = new URL("http://api.sportradar.us/nba-t3/games/2015/REG/schedule.json?api_key=");
        URLConnection myConnection = myUrl.openConnection();
        
        JSONObject js;
        
        String results;

        BufferedReader in = new BufferedReader(
                            	new InputStreamReader(
                                myConnection.getInputStream()));
        
        while ((results = in.readLine()) != null) {      	
        	String date = null;
        	String time = null;
        	js = new JSONObject(results);
        	JSONArray games = js.getJSONArray("games");
        	for (int i = 0; i < games.length(); i++) {
        		String RawDate = games.getJSONObject(i).getString("scheduled");
        		Pattern pattern1 = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})"); 
        		Matcher matcher1 = pattern1.matcher(RawDate);
        		if (matcher1.find()) {
        			date = matcher1.group();
        			if (!dates.contains(date)) {
        				dates.add(date);
        			}
        		}
        		Pattern pattern2 = Pattern.compile("(\\d{2}:\\d{2}:\\d{2})");
        		Matcher matcher2 = pattern2.matcher(RawDate);
        		if (matcher2.find()) {
        			time = matcher2.group();
        		}
        		time = time + "(UTC)";
        		
        		String home = games.getJSONObject(i).getJSONObject("home").getString("name");
        		String away = games.getJSONObject(i).getJSONObject("away").getString("name");
        		
        		NBASchedule_Individual NBAGameSchedule = new NBASchedule_Individual(date, time, away, home);
        		schedule.add(NBAGameSchedule);        		
        	}
        }
	}
	
	/**
	 * The getter for schedule.
	 * @return the schedule
	 */
	public ArrayList<NBASchedule_Individual> getStoredSchedule() {
		return schedule;
	}
	
	/**
	 * The getter for dates.
	 * @return the dates
	 */
	public ArrayList<String> getStoredDate() {
		return dates;
	}

}
