package sports_miniWiki;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for the NBALeaders_Individual class.
 *
 */
public class NBALeaders_Individual_Test {
	
	private NBALeaders_Individual leader;

	@Before
	public void setUp() {
		int rank = 1;
		String name = "Aaa";
		String market = "Bbb";
		String team = "Ccc";
		double stats = 2.5;
		String category = "Ddd";
		
		leader = new NBALeaders_Individual(rank, name, market, team, stats, category);
	}
	
	@Test
	public void testNBALeaders_Individual_NotNull() {	
		assertNotNull("The NBALeaders_Individual should not be null", leader);
		
	}
	
	@Test
	public void testNBALeaders_Individual_toString() {
		
		String output = leader.toString();
		String expected = "1: Aaa -- 2.5 Ddd ( Bbb Ccc ) ";
		assertEquals("The toString method in the NBALeaders_Individual class should be equal to expected", output, expected);
	}

}
