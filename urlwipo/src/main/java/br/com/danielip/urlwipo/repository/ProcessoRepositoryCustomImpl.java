package br.com.danielip.urlwipo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import br.com.danielip.urlwipo.models.Processo;

@Service
public class ProcessoRepositoryCustomImpl implements ProcessoRepositoryCustom {
	@PersistenceContext
    private EntityManager manager;
	
	public List<Processo> buscar(String numPub, String requerentes) {
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Processo> criteria = builder.createQuery(Processo.class);
		Root<Processo> processoRoot = criteria.from(Processo.class);
		criteria.select(processoRoot);
		criteria.where(builder.or(builder.equal(processoRoot.get("numPub"), numPub),
				                   builder.like(processoRoot.get("requerentes"), "%"+requerentes+"%")));
		List<Processo> listaProcessos = (List<Processo>) this.manager.createQuery(criteria).getResultList();
		return listaProcessos;
	}
}