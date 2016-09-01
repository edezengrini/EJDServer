package server.teste;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ClienteAdd {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("bancoz");

	private static EntityManager manager = factory.createEntityManager();
	
	static Scanner sc;
	
	public static void main(String[] args) {

		Cliente cliente = new Cliente();

		sc = new Scanner(System.in);
		System.out.println("digite o id do cliente?");
		Long id = sc.nextLong();

		System.out.println("digite o codigo?");
		Long codigo = sc.nextLong();

		System.out.println("digite o nome do cliente?");
		String nome = sc.next();

		System.out.println("digite o rg cliente?");
		String rg = sc.next();

		System.out.println("digite o cpf cliente?");
		String cpf = sc.next();

		System.out.println("digite o rg cliente?");
		String endereco = sc.next();

		System.out.println("digite o rg cliente?");
		String fone = sc.next();

		// manager.persist(prod);
		
		cliente.setIdcliente(id);
		cliente.setCodigo(codigo);
		cliente.setNome(nome);
		cliente.setRg(rg);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setFone(fone);

		try {
			inserir(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * Compra com = new Compra(); com.setQuantidade(1);
		 * com.setDataCompra(10-04-2014);
		 */
	}

	public static Cliente inserir(Cliente entity) throws Exception {
		try {
			manager.getTransaction().begin();

			manager.persist(entity);

			manager.getTransaction().commit();

		} catch (Exception e) {

			if (manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}

			throw e;
		}
		return entity;
	}

}
