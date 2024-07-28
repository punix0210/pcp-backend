package br.com.greenwaiver.controller.engineering;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.greenwaiver.entities.ListaProduto;
import br.com.greenwaiver.services.ListaProdutoService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "product-engineering")
public class ListaProdutoController {

	private final ListaProdutoService service;

	public ListaProdutoController(ListaProdutoService service) {
		this.service = service;
	}

	@GetMapping(path = "{idproduct}")
	public ResponseEntity<?> findByIdProduct(@PathVariable("idproduct") String id) {
		return new ResponseEntity<>(this.service.findByIdProduto(id), HttpStatus.OK);
	}

	@GetMapping(path = "/{idproduct}/detail/{iddetail}")
	public ResponseEntity<?> findById(@PathVariable("idproduct") String idproduct,
			@PathVariable("iddetail") String id) {
		return new ResponseEntity<>(this.service.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody ListaProduto lista) {
		return new ResponseEntity<>(this.service.save(lista), HttpStatus.CREATED);
	}

}
