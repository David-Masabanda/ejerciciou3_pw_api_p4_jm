package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerRestFul {
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> consultarTodos(){
		List<VehiculoTO> lista=this.iVehiculoService.buscarTodos();
		for(VehiculoTO v : lista) {
			Link myLink=linkTo(methodOn(VehiculoControllerRestFul.class).consultarPorPlaca(v.getPlaca())).withSelfRel();
			v.add(myLink);
		}	
		return new ResponseEntity<>(lista,null,HttpStatus.OK);
	}
	
	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vehiculo consultarPorPlaca(@PathVariable String placa) {
		return this.iVehiculoService.buscarPlaca(placa);
	}
}
	
	

	
	
	
	
	
	
	
	