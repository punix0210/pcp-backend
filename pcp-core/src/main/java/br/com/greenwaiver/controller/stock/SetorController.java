package br.com.greenwaiver.controller.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.greenwaiver.services.SetorService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "sectors")
public class SetorController {
	
	@Autowired
	private SetorService service;
	
	
	@GetMapping(path="")
	public ResponseEntity<?> findByCdEmpresa(@RequestParam(name = "company_code") String cdEmpresa){
		return new ResponseEntity<>(service.findByCdEmpresa(cdEmpresa), HttpStatus.OK);
	}
	

}
