package de.sigma3d.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
		System.out.println("DataBaseLoader");
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
		this.repository.save(new Employee("Frod", "Bains", "ring arer"));
		System.out.println(this.repository.count());
		System.out.println(this.repository.exists((long) 1));
		System.out.println(this.repository.findOne((long) 1).getName());
	}
}