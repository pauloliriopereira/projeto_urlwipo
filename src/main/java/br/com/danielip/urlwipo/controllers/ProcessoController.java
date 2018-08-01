package br.com.danielip.urlwipo.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.danielip.urlwipo.models.BuscarHttpClient;
import br.com.danielip.urlwipo.models.Processo;
import br.com.danielip.urlwipo.repository.ProcessoRepository;

@Controller
public class ProcessoController {
	@Autowired
	ProcessoRepository repository;
	
	@PostMapping("/processo/consultar")
	public String consultar(@RequestParam String numero, Model model) {
		try {
			BuscarHttpClient httpClient = new BuscarHttpClient();
			Processo processo = httpClient.parseWipo(numero);
			model.addAttribute("modelProcesso", processo );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "processo/salvar";
	}
	
	@PostMapping("/processo/salvar")
	public String salvar(@RequestParam String numPub,
			             @RequestParam String numInternacional,
			             @RequestParam String dataPublicacao,
			             @RequestParam String requerentes,
			             @RequestParam String titulo) {
		try {
			Processo processo = new Processo(numPub, numInternacional, dataPublicacao, requerentes, titulo);
			repository.save(processo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@GetMapping("/processo/buscar")
	public String buscar() {
		return "processo/buscar";
	}
	
	@PostMapping("/processo/listar")
	public String listar(@RequestParam String numPub, @RequestParam String requerentes, Model model) {
		List<Processo> processos = this.repository.buscar(numPub, requerentes);
		model.addAttribute("processos", processos);
		return "processo/listar";
	}
}