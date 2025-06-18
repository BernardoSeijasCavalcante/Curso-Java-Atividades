package br.bernardoSeijasCavalcante.webServiceJPAHibernate.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.User;
import br.bernardoSeijasCavalcante.webServiceJPAHibernate.services.UserService;

@RestController //Falar que essa classe é um recurso Web implementado por um controlador rest
@RequestMapping(value = "/users")//Indica que todos os métodos no interior desta classe responderão a url /users
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping//Indica que o método abaixo responde a requisições GET em /users
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);//Retorna um HTTP 200 ok com um objeto java u em um corpo JSON.
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*ResponseEntity é o encapsulamento de uma resposta HTTP,
	 * ela encapsula o corpo da resposta, o status da resposta,
	 * os cabeçalhos e etc.
	 */
}
