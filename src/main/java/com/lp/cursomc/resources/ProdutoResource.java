package com.lp.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lp.cursomc.domain.Produto;
import com.lp.cursomc.dto.ProdutoDTO;
import com.lp.cursomc.resources.utils.URL;
import com.lp.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto obj = produtoService.find(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> findAll() {		
		List<Produto> lista = produtoService.findAll();	
		List<ProdutoDTO> listaDTO = lista.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());		
		return ResponseEntity.ok().body(listaDTO);
	}

	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> lista = produtoService.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDTO> listaDTO = lista.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listaDTO);
	}

}
