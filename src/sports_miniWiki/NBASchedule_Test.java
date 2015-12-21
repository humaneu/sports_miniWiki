package sports_miniWiki;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class NBASchedule_Test {
	
	private NBA_Schedule newSchedule;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		newSchedule = new NBA_Schedule();
		TimeUnit.SECONDS.sleep(1);
	}

	@Test
	public void testNBA_Scheule_NotNull() throws InterruptedException {
		assertNotNull("NBA_Schedule should not be null", newSchedule);
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test 
	public void testNBA_Schedule_GetStoredSchedule() throws InterruptedException {
		assertNotNull("The ArrayList which stores the results of API call should not be null", newSchedule.getStoredSchedule());
		TimeUnit.SECONDS.sleep(1);
	}
	

}
