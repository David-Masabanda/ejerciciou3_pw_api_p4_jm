package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public List<VehiculoTO> buscarTodos() {
		List<Vehiculo> lista= this.iVehiculoRepository.buscarTodos();
		List<VehiculoTO> newLista= lista.stream().map(vehi->this.convertir(vehi)).collect(Collectors.toList());
		return newLista;
	}


	@Override
	public Vehiculo buscarPlaca(String placa) {
		return this.iVehiculoRepository.buscarPlaca(placa);
	}
	
	public VehiculoTO convertir(Vehiculo vehiculo) {
		VehiculoTO vehi=new VehiculoTO();
		vehi.setId(vehiculo.getId());
		vehi.setPlaca(vehiculo.getPlaca());
		vehi.setMarca(vehiculo.getMarca());
		vehi.setModelo(vehiculo.getModelo());
		vehi.setPais(vehiculo.getPais());
		return vehi;
	
	}

}
