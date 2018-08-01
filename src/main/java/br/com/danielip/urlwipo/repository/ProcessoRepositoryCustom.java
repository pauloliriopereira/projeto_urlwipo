package br.com.danielip.urlwipo.repository;

import java.util.List;

import br.com.danielip.urlwipo.models.Processo;

public interface ProcessoRepositoryCustom {
	public List<Processo> buscar(String numPub, String requerentes);
}
