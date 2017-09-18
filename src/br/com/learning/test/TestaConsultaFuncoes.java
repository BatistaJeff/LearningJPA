package br.com.learning.test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.learning.modelo.Conta;
import br.com.learning.modelo.TipoMovimentacao;
import br.com.learning.util.JPAUtil;

public class TestaConsultaFuncoes {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(3);

		TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

		Double media = query.getSingleResult();

		System.out.println(media);
	}

}
