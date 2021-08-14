package com.viniciuscrispim.sbmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciuscrispim.sbmongo.domain.Post;
import com.viniciuscrispim.sbmongo.domain.User;
import com.viniciuscrispim.sbmongo.dto.AuthorDTO;
import com.viniciuscrispim.sbmongo.dto.CommentDTO;
import com.viniciuscrispim.sbmongo.dto.UserDTO;
import com.viniciuscrispim.sbmongo.repositories.PostRepository;
import com.viniciuscrispim.sbmongo.repositories.UserRepository;

//classe de configuração para teste
@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userrepo;
	@Autowired
	private PostRepository postrepo;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userrepo.deleteAll();
		postrepo.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bobg@gmail.com");
		// precisa salvar user antes de associar o userDTO pq senao o id fica null
		userrepo.saveAll(Arrays.asList(maria, alex, bob));

		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem!!", sdf.parse("21/03/2018"), new UserDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new UserDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um otimo dia", sdf.parse("23/03/2018"), new UserDTO(alex));

		p1.getComments().addAll(Arrays.asList(c1,c2));
		p2.getComments().add(c3);
		
		postrepo.saveAll(Arrays.asList(p1, p2));

		maria.getPosts().addAll(Arrays.asList(p1, p2));
		userrepo.save(maria);

	}

}
