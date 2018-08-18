package com.lp.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.cursomc.domain.Categoria;
import com.lp.cursomc.repositories.CategoriaRepository;
import com.lp.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	public Categoria buscar(Integer id) {
		
		Categoria obj = repository.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! "+id
					+ ", Tipo: "+Categoria.class.getName());
		}
		return obj;
	}
}
