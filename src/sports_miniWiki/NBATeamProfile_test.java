/**
 * 
 */
package sports_miniWiki;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for the NBATeamProfile class.
 *
 */
public class NBATeamProfile_test {

	private NBATeamProfile newTeam;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		newTeam = new NBATeamProfile();
	}

	@Test
	public void testNBATeamProfile_NotNull() {
		assertNotNull("NBATeamProfile cannot be null", newTeam);
	}

}
