package server.teste;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import server.entities.Autor;
import server.entities.Livro;

public class TesteConsultaDinamicas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bancoz");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery(" select a from Autor a");
		List<Autor> autores = query.getResultList();
		for (Autor autor : autores) {
			System.out.println(" Autor : " + autor.getNome());
			Collection<Livro> livros = autor.getLivros();
			for (Livro livro : livros) {
				System.out.println(" Livro : " + livro.getNome());
				System.out.println(" Pre�o : " + livro.getPreco());
				System.out.println();
			}
			System.out.println();
		}
		manager.close();
		factory.close();
	}
}