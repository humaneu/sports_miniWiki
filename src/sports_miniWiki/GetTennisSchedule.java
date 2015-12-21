package sports_miniWiki;

/**
 * This class call the API for 2015 ATP and WTA schedule
 */

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class GetTennisSchedule {
	
	/**
	 * instance variables: ATP & WTA schedule
	 */
	private HashMap<String, ArrayList<TennisLeagueSchedule>> ATP_schedule = new HashMap<String, ArrayList<TennisLeagueSchedule>> ();
	private HashMap<String, ArrayList<TennisLeagueSchedule>> WTA_schedule = new HashMap<String, ArrayList<TennisLeagueSchedule>> ();
	
	/**
	 * 2015 ATP & WTA schedule's id on sportradar
	 */
	private static final String ATP_ID = "" ;
	private static final String WTA_ID = "" ;
	
	/**
	 * constructor
	 * get the schedule for each month of ATP and WTA and store in a HashMap
	 * @throws Exception
	 */
	public GetTennisSchedule() throws Exception {
		ATP_schedule = getSchedule(ATP_ID);
		TimeUnit.SECONDS.sleep(1);
		WTA_schedule= getSchedule(WTA_ID);
		TimeUnit.SECONDS.sleep(1);
	}
	
	/**
	 * @return a HashMap with 2015 ATP schedule information
	 */
	public HashMap<String, ArrayList<TennisLeagueSchedule>> getATPschedule() {
		return ATP_schedule;
	}
	
	/**
	 * @return a HashMap with 2015 WTA schedule information
	 */
	public HashMap<String, ArrayList<TennisLeagueSchedule>> getWTAschedule() {
		return WTA_schedule;
	}
	
	/**
	 * get the schedule information by calling the API
	 * @param id league id
	 * @return	a HashMap with each month's schedule
	 * @throws Exception
	 */
	private HashMap<String, ArrayList<TennisLeagueSchedule>> getSchedule(String id) throws Exception {
		
		HashMap<String, ArrayList<TennisLeagueSchedule>> schedule = new HashMap<String, ArrayList<TennisLeagueSchedule>> ();
		
		String link = "http://api.sportradar.us/tennis-t1/:season/" + id + "/schedule.xml?api_key=";
		
		URL url = new URL(link);
		URLConnection connection = url.openConnection();
	
		Document doc = parseXML(connection.getInputStream());
	
		NodeList month = doc.getElementsByTagName("month");
			
		for (int i = 0; i < month.getLength(); i++) {
			String month_name = "unknown";
			ArrayList<TennisLeagueSchedule> month_schedule = new ArrayList<TennisLeagueSchedule> ();
				
			month_name = month.item(i).getAttributes().getNamedItem("name").getTextContent();
				
			Element month_node = (Element) month.item(i);
			NodeList tournament  = month_node.getElementsByTagName("tournament");
				
			for (int j = 0; j < tournament.getLength(); j++) {
				String tournament_name = "unknown";
				String start = "0000-00-00";
				String end = "0000-00-00";
				String type = "unknown";
				String ground = "unknown";
				String prize = "unknown";
				String currency = "unknown";
					
				try {
					tournament_name = tournament.item(j).getAttributes().getNamedItem("name").getTextContent();
					start = tournament.item(j).getAttributes().getNamedItem("start").getTextContent();
					end = tournament.item(j).getAttributes().getNamedItem("end").getTextContent();
					type = tournament.item(j).getAttributes().getNamedItem("type").getTextContent();
					ground = tournament.item(j).getAttributes().getNamedItem("ground").getTextContent();
					prize = tournament.item(j).getAttributes().getNamedItem("prize_amount").getTextContent();
					currency = tournament.item(j).getAttributes().getNamedItem("prize_currency").getTextContent();
				} catch(Exception e) {}
				
				TennisLeagueSchedule oneTournament = new TennisLeagueSchedule(tournament_name, start, end, type, ground, prize, currency);
				month_schedule.add(oneTournament);
			}
			
			schedule.put(month_name, month_schedule);
		}
		
		return schedule;
		
	}
	
	/**
	 * parse XML file
	 * @param stream
	 * @return
	 * @throws Exception
	 */
	private Document parseXML(InputStream stream) throws Exception {
		DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       

        return doc;
		
	}
	
}
