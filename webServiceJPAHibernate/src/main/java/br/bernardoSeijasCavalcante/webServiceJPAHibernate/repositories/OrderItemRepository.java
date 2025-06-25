package br.bernardoSeijasCavalcante.webServiceJPAHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.OrderItem;
import br.bernardoSeijasCavalcante.webServiceJPAHibernate.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
