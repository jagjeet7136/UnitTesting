package mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.Test;

public class ListTest {

	@Test
	public void test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);

		assertEquals(2, listMock.size());
	}

	@Test
	public void test2() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	public void test3() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("Hello");

		assertEquals("Hello", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	public void test4() {
		//Given
		List<String> listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("Hello");

		//When
		String firstElement = listMock.get(0);

		//Then
		assertEquals("Hello", listMock.get(0));
		assertEquals("Hello", listMock.get(10));
		assertEquals("Hello", listMock.get(100));

	}

	@Test(expected=RuntimeException.class)
	public void test5() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something wrong"));

		listMock.get(0);

	}

}
