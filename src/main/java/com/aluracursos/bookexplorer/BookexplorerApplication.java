package com.aluracursos.bookexplorer;

import com.aluracursos.bookexplorer.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookexplorerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookexplorerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
