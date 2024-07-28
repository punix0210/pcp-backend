package br.com.greenwaiver.controller.products;

import javax.validation.Valid;

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

import br.com.greenwaiver.entities.Produto;
import br.com.greenwaiver.services.ProductsService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "products")
public class ProductsController {
	private final ProductsService service;

	public ProductsController(ProductsService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<?> search(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "1") int size,
			@RequestParam(name = "value", defaultValue = "") String value) {
		return new ResponseEntity<>(service.findAll(page, size, value), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Produto produto) {
		Produto p = this.service.save(produto);
		return new ResponseEntity<>("Gravação do produto {" + p.getIdProduto() + "} realizada com sucesso!",
				HttpStatus.CREATED);

	}

}
