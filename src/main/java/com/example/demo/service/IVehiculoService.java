package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

public interface IVehiculoService {
	
	public List<VehiculoTO> buscarTodos(); 
	public Vehiculo buscarPlaca(String placa); 

}
