package br.bernardoSeijasCavalcante.webServiceJPAHibernate.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.User;
import br.bernardoSeijasCavalcante.webServiceJPAHibernate.repositories.UserRepository;

@Configuration	
@Profile("test")
public class TestConfig implements CommandLineRunner { //CommandLineRunner para executar o método run assim que o programa começar

	@Autowired //Instancia o objeto userRepository automaticamente
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
}
