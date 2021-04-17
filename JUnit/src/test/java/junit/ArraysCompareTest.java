package junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class ArraysCompareTest {

	@Test
	public void testArraySort_RandomArray() {
		int array[] = {12,3,4,1};
		int expected[] = {1,3,4,12};
		Arrays.sort(array);

		assertArrayEquals(expected, array);
	}

	@Ignore
	@Test(expected=NullPointerException.class)            // to be successful test an exception must b occur
	public void testArraySort_NullArray() {
		int array[] = {};
		Arrays.sort(array);
	}
	
	@Test(timeout = 100)
	public void testSort_Performance() {
		int array[] = {12,23,4};
		for(int i=1; i<1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}
		
	}

}
