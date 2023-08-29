package com.goit.Spring.Boot;

import com.goit.Spring.Boot.services.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher {

	public static void main(String[] args) {
		SpringApplication.run(Launcher.class, args);
	}
}
