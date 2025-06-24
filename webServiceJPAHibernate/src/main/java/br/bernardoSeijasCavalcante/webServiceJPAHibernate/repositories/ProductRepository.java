package br.bernardoSeijasCavalcante.webServiceJPAHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
