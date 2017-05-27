package br.com.learning.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.learning.modelo.Conta;
import br.com.learning.util.JPAUtil;

public class TestJPA {

	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("aa");
		conta.setBanco("dad");
		conta.setNumero("dadas");
		conta.setTitular("dadad");
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		
		manager.close();
		
	}
	
}
