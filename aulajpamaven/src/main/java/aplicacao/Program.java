package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {
	public static void main(String[] args) {
		
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Inserindo objetos no banco de dados
		
		Pessoa pessoa = new Pessoa(null, "Azul", "azul@gmail.com");
		
		em.getTransaction().begin();
		
		em.persist(pessoa);
		
		em.getTransaction().commit();
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		
		em.remove(p);
		
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
