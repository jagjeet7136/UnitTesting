package mockito;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import forMockito.TodoBusinessImpl;
import forMockito.TodoService;

public class TodoBusinessImplStubTest {

	@Test
	public void test() {
		TodoService to = new TodoServiceStub();
		TodoBusinessImpl t = new TodoBusinessImpl(to);
		List<String> filteredTodos = t.retrieveTodoRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
		
	}
}
