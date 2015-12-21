package sports_miniWiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NBATeamProfile {
	
	private ArrayList<NBATeam> teams;
	private TreeMap<String, String> team;
	
	public NBATeamProfile() throws IOException, JSONException, InterruptedException {
		
		teams = new ArrayList<NBATeam>();
		team = new TreeMap<String, String>();
		team.put("Golden State Warriors", "583ec825-fb46-11e1-82cb-f4ce4684ea4c");
		team.put("San Antonio Spurs", "583ecd4f-fb46-11e1-82cb-f4ce4684ea4c");
		team.put("Cleveland Cavaliers", "583ec773-fb46-11e1-82cb-f4ce4684ea4c");
		team.put("Toronto Raptors", "583ecda6-fb46-11e1-82cb-f4ce4684ea4c");
		team.put("Oklahoma City Thunder", "583ecfff-fb46-11e1-82cb-f4ce4684ea4c");
		team.put("Los Angeles Clippers", "583ecdfb-fb46-11e1-82cb-f4ce4684ea4c");
		team.put("Indiana Pacers", "583ec7cd-fb46-11e1-82cb-f4ce4684ea4c");
		team.put("Chicago Bulls", "583ec5fd-fb46-11e1-82cb-f4ce4684ea4c");
		
		getTeams();
	}
	
	private void getTeams() throws IOException, JSONException, InterruptedException {
		
		JSONObject js;
        String results;

		for (String nbaTeam: team.keySet()) {
			
			switch (nbaTeam) {
				case "Golden State Warriors":
					NBATeam t = null;
					String url = "http://api.sportradar.us/nba-t3/teams/" + team.get("Golden State Warriors") + "/profile.json?api_key=";
					URL myUrl = new URL(url);
			        URLConnection myConnection = myUrl.openConnection();
			        BufferedReader in = new BufferedReader(
                        	new InputStreamReader(
                            myConnection.getInputStream()));
			        
			        while ((results = in.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t.members.add(p);
			        	}
			        	
			        }
			        teams.add(t);
			        break;
			        
				case "San Antonio Spurs":
					NBATeam t1 = null;
					String url1 = "http://api.sportradar.us/nba-t3/teams/" + team.get("San Antonio Spurs") + "/profile.json?api_key=";
					URL myUrl1 = new URL(url1);
			        URLConnection myConnection1 = myUrl1.openConnection();
			        BufferedReader in1 = new BufferedReader(
                        	new InputStreamReader(
                            myConnection1.getInputStream()));
			        
			        while ((results = in1.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t1 = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t1.members.add(p);
			        	}
			        	
			        }
			        teams.add(t1);
			        break;
			        
				case "Cleveland Cavaliers":
					NBATeam t2 = null;
					String url2 = "http://api.sportradar.us/nba-t3/teams/" + team.get("Cleveland Cavaliers") + "/profile.json?api_key=";
					URL myUrl2 = new URL(url2);
			        URLConnection myConnection2 = myUrl2.openConnection();
			        BufferedReader in2 = new BufferedReader(
                        	new InputStreamReader(
                            myConnection2.getInputStream()));
			        
			        while ((results = in2.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t2 = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t2.members.add(p);
			        	}
			        	
			        }
			        teams.add(t2);
			        break;
			        
				case "Toronto Raptors":
					NBATeam t3 = null;
					String url3 = "http://api.sportradar.us/nba-t3/teams/" + team.get("Toronto Raptors") + "/profile.json?api_key=";
					URL myUrl3 = new URL(url3);
			        URLConnection myConnection3 = myUrl3.openConnection();
			        BufferedReader in3 = new BufferedReader(
                        	new InputStreamReader(
                            myConnection3.getInputStream()));
			        
			        while ((results = in3.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t3 = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t3.members.add(p);
			        	}			        	
			        }
			        teams.add(t3);
			        break;
			        
				case "Oklahoma City Thunder":
					NBATeam t4 = null;
					String url4 = "http://api.sportradar.us/nba-t3/teams/" + team.get("Oklahoma City Thunder") + "/profile.json?api_key=";
					URL myUrl4 = new URL(url4);
			        URLConnection myConnection4 = myUrl4.openConnection();
			        BufferedReader in4 = new BufferedReader(
                        	new InputStreamReader(
                            myConnection4.getInputStream()));
			        
			        while ((results = in4.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t4 = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t4.members.add(p);
			        	}		        	
			        }
			        teams.add(t4);
			        break;
			        
				case "Los Angeles Clippers":
					NBATeam t5 = null;
					String url5 = "http://api.sportradar.us/nba-t3/teams/" + team.get("Los Angeles Clippers") + "/profile.json?api_key=";
					URL myUrl5 = new URL(url5);
			        URLConnection myConnection5 = myUrl5.openConnection();
			        BufferedReader in5 = new BufferedReader(
                        	new InputStreamReader(
                            myConnection5.getInputStream()));
			        
			        while ((results = in5.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t5 = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t5.members.add(p);
			        	}
			        	
			        }
			        teams.add(t5);
			        break;
			        
				case "Indiana Pacers":
					NBATeam t6 = null;
					String url6 = "http://api.sportradar.us/nba-t3/teams/" + team.get("Indiana Pacers") + "/profile.json?api_key=";
					URL myUrl6 = new URL(url6);
			        URLConnection myConnection6 = myUrl6.openConnection();
			        BufferedReader in6 = new BufferedReader(
                        	new InputStreamReader(
                            myConnection6.getInputStream()));
			        
			        while ((results = in6.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t6 = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t6.members.add(p);
			        	}
			        	
			        }
			        teams.add(t6);
			        break;
			        
				case "Chicago Bulls":
					NBATeam t7 = null;
					String url7 = "http://api.sportradar.us/nba-t3/teams/" + team.get("Chicago Bulls") + "/profile.json?api_key=";
					URL myUrl7 = new URL(url7);
			        URLConnection myConnection7 = myUrl7.openConnection();
			        BufferedReader in7 = new BufferedReader(
                        	new InputStreamReader(
                            myConnection7.getInputStream()));
			        
			        while ((results = in7.readLine()) != null) {       	
			        	js = new JSONObject(results);			        	
			        	String name = js.getString("name");
			        	String market = js.getString("market");
			        	t7 = new NBATeam(name, market);
			        	JSONArray players = js.getJSONArray("players");
			        	for (int i = 0; i < players.length(); i++) {
			        		String player = players.getJSONObject(i).getString("full_name");
			        		String position = players.getJSONObject(i).getString("position");
			        		String number = players.getJSONObject(i).getString("jersey_number");
			        		int height = players.getJSONObject(i).getInt("height");
			        		int weight = players.getJSONObject(i).getInt("weight");
			        		String experience = players.getJSONObject(i).getString("experience");
			        		
			        		NBAPlayer p = new NBAPlayer(player, position, number, height, weight, experience);
			        		t7.members.add(p);
			        	}
			        	
			        }
			        teams.add(t7);
			        break;
			       
			}
			TimeUnit.SECONDS.sleep(1);
		}
	}

	/**
	 * @return the team
	 */
	public TreeMap<String, String> getTeam() {
		return team;
	}
	
	/**
	 * @return the teams
	 */
	public ArrayList<NBATeam> getStoredTeams() {
		return teams;
	}
	
}

