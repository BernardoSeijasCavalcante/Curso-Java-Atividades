package br.bernardoSeijasCavalcante.webServiceJPAHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
