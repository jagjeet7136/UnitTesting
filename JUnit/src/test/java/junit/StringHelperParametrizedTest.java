package junit;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametrizedTest {

	StringHelper h = new StringHelper();
	String input;
	String expectedOutput;

	public StringHelperParametrizedTest(String input, String expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static List<String[]> testConditions() {
		String array[][] = { 
				{"AACD", "CD"},
				{"ACD", "CD"} };

		return Arrays.asList(array);
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		assertEquals(expectedOutput, h.truncateAInFirst2Positions(input));
	}

}
