package br.com.danielip.urlwipo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.danielip.urlwipo.models.Processo;

public interface ProcessoRepository extends CrudRepository<Processo, Long>, ProcessoRepositoryCustom {}
