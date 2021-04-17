package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class SpyTest {

	@Test
	public void test() {
		
		List arrayListMock = spy(ArrayList.class);
//		stub(arrayListMock.size()).toReturn(0);
		assertEquals(0, arrayListMock.size());
		arrayListMock.add("123");
		assertEquals(0, arrayListMock.size());
		
		stub(arrayListMock.size()).toReturn(5);
		assertEquals(5, arrayListMock.size());
		
		
	}

}
