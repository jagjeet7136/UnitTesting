package mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import forMockito.TodoBusinessImpl;
import forMockito.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {
	
//	@Rule
//	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl t;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	public void test1() {

		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		List<String> filteredTodos = t.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void test2() {

		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		List<String> filteredTodos = t.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());

	}

	@Test
	public void test3() {

		//Given
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When                                                                             this is actual method call
		List<String> filteredTodos = t.retrieveTodoRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
		//Then
		assertThat(filteredTodos.size(), is(2));

	}

	@Test
	public void test4() {

		//Given  
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When                                                                             this is actual method call
		t.deleteTodosNotRelatedToSpring("Dummy");

		//Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		verify(todoServiceMock, never()).deleteTodo("Learn Spring");
//		verify(todoServiceMock, times(4)).deleteTodo("Learn to MVC");


	}

	@Test
	public void test5() {

		//Given  
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When                                                                             this is actual method call
		t.deleteTodosNotRelatedToSpring("Dummy");

		//Then
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");



	}

	@Test
	public void test6() {

		//Given  
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When                                                                             this is actual method call
		t.deleteTodosNotRelatedToSpring("Dummy");

		//Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getValue(),is("Learn to Dance"));
		assertEquals("Learn to Dance", stringArgumentCaptor.getValue());


	}

	@Test
	public void test7() {

		//Given  
		List<String> todos = Arrays.asList("Learn to Rock and Roll","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When                                                                             this is actual method call
		t.deleteTodosNotRelatedToSpring("Dummy");

		//Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));


	}
	
	
}
