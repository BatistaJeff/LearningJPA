package br.com.learning.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.learning.modelo.Conta;
import br.com.learning.modelo.Movimentacao;
import br.com.learning.modelo.TipoMovimentacao;
import br.com.learning.util.JPAUtil;

public class TestJPARelacionamento {

	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("Osasco");
		conta.setBanco("Itau");
		conta.setNumero("230-1");
		conta.setTitular("Animal de teta");
		
		Movimentacao movimentacao = new Movimentacao(); 
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("saque");
		movimentacao.setValor(new BigDecimal("100"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		movimentacao.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
//		manager.persist(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		
		manager.close();
		
	}
	
}
