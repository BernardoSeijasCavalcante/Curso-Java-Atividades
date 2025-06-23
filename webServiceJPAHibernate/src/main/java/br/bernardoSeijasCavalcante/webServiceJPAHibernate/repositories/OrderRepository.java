package br.bernardoSeijasCavalcante.webServiceJPAHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
