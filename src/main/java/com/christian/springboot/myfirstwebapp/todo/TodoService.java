package com.christian.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
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
