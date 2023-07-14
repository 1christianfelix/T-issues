package com.christian.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
	private static List<Todo> todos;
	static {
		todos.add(new Todo(1, "christian", "Learn Spring", 
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "christian", "Learn Spring Boot", 
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(3, "christian", "Build app", 
				LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
}
