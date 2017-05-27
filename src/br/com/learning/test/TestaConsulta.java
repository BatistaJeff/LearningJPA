package br.com.learning.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.learning.modelo.Conta;
import br.com.learning.modelo.Movimentacao;
import br.com.learning.modelo.TipoMovimentacao;
import br.com.learning.util.JPAUtil;

public class TestaConsulta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(6);
		
		Query query = manager.createQuery("select m from Movimentacao m where m.conta = :pConta" 
				+ " and m.tipoMovimentacao = :pTipo "
				+ " order by m.valor desc");
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("\n Descricao :" +movimentacao.getDescricao());
			System.out.println("Valor : " +movimentacao.getValor());
			
		}
		
	}
}
