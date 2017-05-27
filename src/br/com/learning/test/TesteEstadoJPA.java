package br.com.learning.test;

import javax.persistence.EntityManager;

import br.com.learning.modelo.Conta;
import br.com.learning.util.JPAUtil;

public class TesteEstadoJPA {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 1);
		
		conta.setTitular("123");
		
		manager.merge(conta);
		
		manager.getTransaction().commit();
		
		
		manager.close();
	}
}
