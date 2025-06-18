package br.bernardoSeijasCavalcante.webServiceJPAHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
