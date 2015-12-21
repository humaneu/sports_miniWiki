package sports_miniWiki;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * This is a test class for the NBALeagueLeaders class.
 *
 */
public class NBALeagueLeaders_Test {

	private NBALeagueLeaders nbaLeaders;
	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		nbaLeaders = new NBALeagueLeaders();
		TimeUnit.SECONDS.sleep(1);
	}

	/**
	 * This test case tests if the constructor works properly 
	 * and the object of the NBALeagueLeaders class is not null.
	 * @throws InterruptedException 
	 */
	@Test
	public void testNBALeagueLeadersNotNull() throws InterruptedException {
		assertNotNull("NBALeagueLeaders should not be null", nbaLeaders);
		TimeUnit.SECONDS.sleep(1);
	}
	
	
	@Test 
	public void testNBALeagueLeadersGetPointLeaders() throws InterruptedException {
		assertNotNull("The ArrayList of pointsLeaders should not be null", nbaLeaders.getPointsLeaders());
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	public void testNBALeagueLeadersGetAssistLeaders() throws InterruptedException {
		assertNotNull("The ArrayList of assistsLeaders should not be null", nbaLeaders.getAssistsLeaders());
		TimeUnit.SECONDS.sleep(1);
	}
	

}
