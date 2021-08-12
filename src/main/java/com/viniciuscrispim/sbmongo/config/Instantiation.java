package com.viniciuscrispim.sbmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciuscrispim.sbmongo.domain.User;
import com.viniciuscrispim.sbmongo.repositories.UserRepository;

//classe de configuração para teste
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userrepo;

	@Override
	public void run(String... args) throws Exception {
		
		userrepo.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userrepo.saveAll(Arrays.asList(maria, alex, bob));
	}

}
