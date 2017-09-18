package br.com.learning.test;

import javax.persistence.EntityManager;

import br.com.learning.modelo.Conta;
import br.com.learning.util.JPAUtil;

public class TestaMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = manager.find(Conta.class, 6);
		
//		Movimentacao movimentacao = manager.find(Movimentacao.class, 1);
		
		System.out.println(conta);
		
	}
	
	
}
