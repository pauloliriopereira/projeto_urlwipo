package br.com.danielip.urlwipo.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class BuscarHttpClient {
	private int contador;
	private final String[] campos = {"detailPCTtableWO","detailPCTtableAN","detailPCTtablePubDate","PCTapplicants","PCTtitle"};
	private final String[] chaves = {"numPub","numInternacional","dataPublicacao","requerentes","titulo"};
	private final String USER_AGENT = "Mozilla/5.0";
	
	private Map<String,String> valores = new HashMap<String,String>();
	
	public Processo parseWipo(String num_proc) throws Exception {
		String url = "https://patentscope.wipo.int/search/pt/detail.jsf?docId=" + num_proc + "&redirectedID=true";
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);
		
		try (Scanner entrada = new Scanner(response.getEntity().getContent(), "UTF-8")) {
			while (entrada.hasNextLine()) {
				this.pegaValor(entrada.nextLine());
				if (this.contador >= 5) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return constroiProcesso();
	}

	private Processo constroiProcesso() throws ParseException {
		Processo processo = new Processo();
		processo.setNumPub(this.valores.get("numPub").replaceAll("/", ""));
		processo.setNumInternacional(this.valores.get("numInternacional").replaceAll("/", ""));
		SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yyyy");
		processo.setDataPublicacao((Date) formato.parse(this.valores.get("dataPublicacao").replaceAll("/", "")));
		processo.setRequerentes(this.valores.get("requerentes"));
		processo.setTitulo(this.valores.get("titulo"));
		return processo;
	}
	
	public void pegaValor(String valor) {
		List<String> listaCampos = Arrays.asList(this.campos);
		List<String> listaChaves = Arrays.asList(this.chaves);
		String regex = "<.*?/?>";
		
		if(valor.contains(listaCampos.get(this.contador))) {
			this.valores.put(listaChaves.get(contador), strArrayToString(valor.split(regex)));
			contador++;
		}
	}
	
	private static String strArrayToString(String[] strArr) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr) {
			sb.append(str.trim());
		}
		return sb.toString();
	}
}