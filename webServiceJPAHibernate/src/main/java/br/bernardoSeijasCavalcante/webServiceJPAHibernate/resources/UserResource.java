package br.bernardoSeijasCavalcante.webServiceJPAHibernate.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.User;

@RestController //Falar que essa classe é um recurso Web implementado por um controlador rest
@RequestMapping(value = "/users")//Indica que todos os métodos no interior desta classe responderão a url /users
public class UserResource {
	@GetMapping//Indica que o método abaixo responde a requisições GET em /users
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria", "maria", "maria");
		return ResponseEntity.ok().body(u);//Retorna um HTTP 200 ok com um objeto java u em um corpo JSON.
	}
	
	/*ResponseEntity é o encapsulamento de uma resposta HTTP,
	 * ela encapsula o corpo da resposta, o status da resposta,
	 * os cabeçalhos e etc.
	 */
}
