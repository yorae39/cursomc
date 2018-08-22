package com.lp.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.cursomc.domain.Cliente;
import com.lp.cursomc.repositories.ClienteRepository;
import com.lp.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente find(Integer id) {

		Cliente obj = clienteRepository.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}

}
