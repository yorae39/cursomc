package com.lp.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lp.cursomc.domain.Categoria;
import com.lp.cursomc.domain.Produto;
import com.lp.cursomc.repositories.CategoriaRepository;
import com.lp.cursomc.repositories.ProdutoRepository;
import com.lp.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Produto find(Integer id) {
		
		Produto obj = produtoRepository.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! "+id
					+ ", Tipo: "+Categoria.class.getName());
		}
		return obj;
	}
	
	
	public Page<Produto> search(String nome, List<Integer> ids,Integer page, Integer linesPerPage, 
			String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		List<Categoria> categorias = categoriaRepository.findAll(ids);
		
		return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}


	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
}
