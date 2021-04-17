package mockito;

import java.util.Arrays;
import java.util.List;

import forMockito.TodoService;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		
		return Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
	}

	public void deleteTodo(String todo) {
//		System.out.println("deleteTodo called");
	}
	
	
}
