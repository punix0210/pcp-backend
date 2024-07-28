package br.com.greenwaiver.controller.engineering;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.greenwaiver.services.ListaProdutoEstruturaService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "product-engineering")
public class ListaProdutoEstruturaController {

	private final ListaProdutoEstruturaService service;

	public ListaProdutoEstruturaController(ListaProdutoEstruturaService service) {
		this.service = service;
	}

	@GetMapping(path = "/structure/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

}
