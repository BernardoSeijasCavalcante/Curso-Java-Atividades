package br.bernardoSeijasCavalcante.webServiceJPAHibernate.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.User;

@RestController //Falar que essa classe é um recurso Web implementado por um controlador rest
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria", "maria", "maria");
		return ResponseEntity.ok().body(u);
	}
}
