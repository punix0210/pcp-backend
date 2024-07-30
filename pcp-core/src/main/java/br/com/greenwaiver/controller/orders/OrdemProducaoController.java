package br.com.greenwaiver.controller.orders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.greenwaiver.dto.OrderFilterDTO;
import br.com.greenwaiver.services.OrdemProducaoService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "orders")
public class OrdemProducaoController {

	private final OrdemProducaoService service;

	public OrdemProducaoController(OrdemProducaoService service) {
		this.service = service;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(path = "find-by-range-product")
	public ResponseEntity<?> search_product(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "1") int size,			
			@RequestBody OrderFilterDTO filter) {	 
		return new ResponseEntity<>(service.search_product(page, size,filter), HttpStatus.OK);
	}	
	
	@PostMapping(path = "find-by-range-material")
	public ResponseEntity<?> searchMaterial(@RequestBody OrderFilterDTO filter) {	 
		return new ResponseEntity<>(service.search_material(filter), HttpStatus.OK);
	}	
}
