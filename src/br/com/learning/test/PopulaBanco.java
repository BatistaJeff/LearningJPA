package br.com.learning.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.learning.modelo.Conta;
import br.com.learning.modelo.Movimentacao;
import br.com.learning.modelo.TipoMovimentacao;
import br.com.learning.util.JPAUtil;

public class PopulaBanco {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta1 = new Conta();
		conta1.setAgencia("ITAU");
		conta1.setBanco("123");
		conta1.setNumero("3434");
		conta1.setTitular("JOAO NUNES");

		Conta conta2 = new Conta();
		conta2.setAgencia("BRADESCO");
		conta2.setBanco("444");
		conta2.setNumero("43422");
		conta2.setTitular("MARIA JOSE");

		Conta conta3 = new Conta();
		conta3.setAgencia("CAIXA BRASIL");
		conta3.setBanco("098");
		conta3.setNumero("2323");
		conta3.setTitular("JOAQUINA BRANDAO");

//		manager.getTransaction().begin();
//		
//		manager.persist(conta1);
//		manager.persist(conta2);
//		manager.persist(conta3);
//		
//		manager.getTransaction().commit();
//		manager.close();
//	
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Pagamento de conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("22.22"));
		movimentacao.setConta(conta1);
	
		manager.getTransaction().begin();
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		manager.close();
	
	}
	
}
