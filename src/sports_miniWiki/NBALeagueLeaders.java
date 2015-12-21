package sports_miniWiki;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class calls NBA API and stores the information about league leaders.
 *
 */
public class NBALeagueLeaders {
	
	private ArrayList<NBALeaders_Individual> pointsLeaders;
	private ArrayList<NBALeaders_Individual> assistsLeaders;
	private ArrayList<NBALeaders_Individual> threePointsLeaders;
	private ArrayList<NBALeaders_Individual> reboundsLeaders;
	private ArrayList<NBALeaders_Individual> freeThrowLeaders;
	private ArrayList<NBALeaders_Individual> blocksLeaders;
	private ArrayList<NBALeaders_Individual> stealsLeaders;
	
	
	/**
	 * The constructor
	 * @throws Exception
	 */
	public NBALeagueLeaders() throws Exception {
		pointsLeaders = new ArrayList<NBALeaders_Individual>();
		assistsLeaders = new ArrayList<NBALeaders_Individual>();
		threePointsLeaders = new ArrayList<NBALeaders_Individual>();
		reboundsLeaders = new ArrayList<NBALeaders_Individual>();
		freeThrowLeaders = new ArrayList<NBALeaders_Individual>();
		blocksLeaders = new ArrayList<NBALeaders_Individual>();
		stealsLeaders = new ArrayList<NBALeaders_Individual>();
		
		getLeaders();
	}
	
	private void getLeaders() throws Exception {
        
		URL myUrl = new URL("http://api.sportradar.us/nba-t3/seasontd/2015/REG/leaders.json?api_key=");
        URLConnection myConnection = myUrl.openConnection();
        
        JSONObject js;
        
        String results;

        BufferedReader in = new BufferedReader(
                            	new InputStreamReader(
                                myConnection.getInputStream()));
        
        while ((results = in.readLine()) != null) {       	
        	js = new JSONObject(results);
        	JSONArray categories = js.getJSONArray("categories");
        	for (int i = 0; i < categories.length(); i++) {
        		String name = categories.getJSONObject(i).getString("name");
        		
        		switch (name) {
        		
        			case "points":
        				JSONArray pts_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < pts_leaders.length(); j++) {
        					int leader_rank = pts_leaders.getJSONObject(j).getInt("rank");
        					String leaders = pts_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = pts_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = pts_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					
        					NBALeaders_Individual ld = new NBALeaders_Individual(leader_rank, leaders, market, team, stats, name);
        					pointsLeaders.add(ld);
        					        					
        				}
        				
        				break;
        				
        			case "assists":        				
        				JSONArray assist_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < assist_leaders.length(); j++) {
        					int leader_rank = assist_leaders.getJSONObject(j).getInt("rank");
        					String leaders = assist_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = assist_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = assist_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					NBALeaders_Individual ld = new NBALeaders_Individual(leader_rank, leaders, market, team, stats, name);
        					assistsLeaders.add(ld);
        									
        				}
        				
        				break;       				
        			
        			case "three_points_made":        				
        				JSONArray three_pt_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < three_pt_leaders.length(); j++) {
        					int leader_rank = three_pt_leaders.getJSONObject(j).getInt("rank");
        					String leaders = three_pt_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = three_pt_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = three_pt_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					NBALeaders_Individual ld = new NBALeaders_Individual(leader_rank, leaders, market, team, stats, name);
        					threePointsLeaders.add(ld);       									    					
        				}
        				
        				break;
        			
        			case "rebounds":        				
        				JSONArray reb_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < reb_leaders.length(); j++) {
        					int leader_rank = reb_leaders.getJSONObject(j).getInt("rank");
        					String leaders = reb_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = reb_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = reb_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					NBALeaders_Individual ld = new NBALeaders_Individual(leader_rank, leaders, market, team, stats, name);
        					reboundsLeaders.add(ld);       					      					
        				}        				
        				break;
        				
        			case "free_throws_made":        				
        				JSONArray free_thr_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < free_thr_leaders.length(); j++) {
        					int leader_rank = free_thr_leaders.getJSONObject(j).getInt("rank");
        					String leaders = free_thr_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = free_thr_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = free_thr_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					NBALeaders_Individual ld = new NBALeaders_Individual(leader_rank, leaders, market, team, stats, name);
        					freeThrowLeaders.add(ld);
        				}        				
        				break;
        				
        			case "blocks":       				
        				JSONArray blocks_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < blocks_leaders.length(); j++) {
        					int leader_rank = blocks_leaders.getJSONObject(j).getInt("rank");
        					String leaders = blocks_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = blocks_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = blocks_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					NBALeaders_Individual ld = new NBALeaders_Individual(leader_rank, leaders, market, team, stats, name);
        					blocksLeaders.add(ld);       									
        				}       				
        				break;
        			
        			case "steals":       				
        				JSONArray steal_leaders = categories.getJSONObject(i).getJSONArray("ranks");
        				for (int j = 0; j < steal_leaders.length(); j++) {
        					int leader_rank = steal_leaders.getJSONObject(j).getInt("rank");
        					String leaders = steal_leaders.getJSONObject(j).getJSONObject("player").getString("full_name");
        					
        					JSONArray leader_team = steal_leaders.getJSONObject(j).getJSONArray("teams");
        					String market = leader_team.getJSONObject(0).getString("market");
        					String team = leader_team.getJSONObject(0).getString("name");
        					
        					double stats = steal_leaders.getJSONObject(j).getJSONObject("average").getDouble(name);
        					NBALeaders_Individual ld = new NBALeaders_Individual(leader_rank, leaders, market, team, stats, name);
        					stealsLeaders.add(ld);       					 					    					
        				}        				
        				break;
        		}
        	}
        } 
    }

	/**
	 * @return the pointsLeaders
	 */
	public ArrayList<NBALeaders_Individual> getPointsLeaders() {
		return pointsLeaders;
	}

	/**
	 * @return the assistsLeaders
	 */
	public ArrayList<NBALeaders_Individual> getAssistsLeaders() {
		return assistsLeaders;
	}

	/**
	 * @return the threePointsLeaders
	 */
	public ArrayList<NBALeaders_Individual> getThreePointsLeaders() {
		return threePointsLeaders;
	}

	/**
	 * @return the reboundsLeaders
	 */
	public ArrayList<NBALeaders_Individual> getReboundsLeaders() {
		return reboundsLeaders;
	}

	/**
	 * @return the freeThrowLeaders
	 */
	public ArrayList<NBALeaders_Individual> getFreeThrowLeaders() {
		return freeThrowLeaders;
	}

	/**
	 * @return the blocksLeaders
	 */
	public ArrayList<NBALeaders_Individual> getBlocksLeaders() {
		return blocksLeaders;
	}

	/**
	 * @return the stealsLeaders
	 */
	public ArrayList<NBALeaders_Individual> getStealsLeaders() {
		return stealsLeaders;
	}
}
