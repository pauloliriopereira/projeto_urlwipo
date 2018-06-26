package br.com.danielip.urlwipo.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "processo")
public class Processo {

	@Id
    @GeneratedValue
    private Long id;
	
	private String numPub;
	private String numInternacional;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataPublicacao;
	private String requerentes;
	private String titulo;
	
	public Processo() {}

	public Processo(String numPub, String numInternacional, String dataPublicacao, String requerentes, String titulo) throws ParseException {
		this.numPub = numPub;
		this.numInternacional = numInternacional;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		this.dataPublicacao = (Date) formato.parse(dataPublicacao);
		this.requerentes = requerentes;
		this.titulo = titulo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumPub() {
		return numPub;
	}

	public void setNumPub(String numPub) {
		this.numPub = numPub;
	}

	public String getNumInternacional() {
		return numInternacional;
	}

	public void setNumInternacional(String numInternacional) {
		this.numInternacional = numInternacional;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getRequerentes() {
		return requerentes;
	}

	public void setRequerentes(String requerentes) {
		this.requerentes = requerentes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void buscaValores(String numero) {
		
	}
}