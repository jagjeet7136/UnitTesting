package junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringHelperTest {

	StringHelper h = new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		
		//		String actual = h.truncateAInFirst2Positions("AACD");
		//		String expected = "CD";
		//		assertEquals(expected, actual);
		
		assertEquals("CD", h.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		assertEquals("CD", h.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		assertFalse(h.areFirstAndLastTwoCharactersTheSame("ABCD"));
		// this function also takes (String, boolean)
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue(h.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

}