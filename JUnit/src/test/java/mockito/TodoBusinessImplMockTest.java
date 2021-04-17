package mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import forMockito.TodoBusinessImpl;
import forMockito.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void test() {

		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl t = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = t.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());

	}

	@Test
	public void test2() {

		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl t = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos = t.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());

	}

	@Test
	public void test3() {

		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl t = new TodoBusinessImpl(todoServiceMock);

		//When                                                                             this is actual method call
		List<String> filteredTodos = t.retrieveTodoRelatedToSpring("Dummy");

		assertEquals(2, filteredTodos.size());
		//Then
		assertThat(filteredTodos.size(), is(2));

	}

	@Test
	public void test4() {

		//Given  
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl t = new TodoBusinessImpl(todoServiceMock);

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
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl t = new TodoBusinessImpl(todoServiceMock);

		//When                                                                             this is actual method call
		t.deleteTodosNotRelatedToSpring("Dummy");

		//Then
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");



	}

	@Test
	public void test6() {

		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		//Given  
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl t = new TodoBusinessImpl(todoServiceMock);

		//When                                                                             this is actual method call
		t.deleteTodosNotRelatedToSpring("Dummy");

		//Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getValue(),is("Learn to Dance"));
		assertEquals("Learn to Dance", stringArgumentCaptor.getValue());


	}

	@Test
	public void test7() {

		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		//Given  
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn to Rock and Roll","Learn Spring", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl t = new TodoBusinessImpl(todoServiceMock);

		//When                                                                             this is actual method call
		t.deleteTodosNotRelatedToSpring("Dummy");

		//Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));


	}


}
