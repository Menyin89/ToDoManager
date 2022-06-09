package com.example.tdm;

import com.example.tdm.helper.ToDoItemsFromFile;
import com.example.tdm.model.ToDoItem;
import com.example.tdm.repository.ToDoRepository;
import com.example.tdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TodomanagerApplication implements CommandLineRunner {

	@Value("${tdm.importfile}")
	private String importFile;
	@Autowired
	private UserService userService;

	@Autowired
	private ToDoRepository toDoRepository;

	@Autowired
	private ToDoItemsFromFile toDoItemsFromFile;

	public static void main(String[] args) {
		SpringApplication.run(TodomanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createUsers();
		createToDoItems(importFile);
	}

	private void createUsers() {
		userService.createUser(001, "User1");
		userService.createUser(002, "User2");
		userService.createUser(003, "User3");
		userService.createUser(004, "User4");
	}

	private void createToDoItems(String fileToImport) throws IOException {
		toDoItemsFromFile.read(fileToImport).forEach(importedToDoItem ->
				toDoRepository.save(new ToDoItem(importedToDoItem.getName(),
						userService.findById(importedToDoItem.getUserId()))));
	}

}
