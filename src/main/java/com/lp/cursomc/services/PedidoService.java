package com.lp.cursomc.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lp.cursomc.domain.Categoria;
import com.lp.cursomc.domain.ItemPedido;
import com.lp.cursomc.domain.PagamentoComBoleto;
import com.lp.cursomc.domain.Pedido;
import com.lp.cursomc.domain.enums.EstadoPagamento;
import com.lp.cursomc.repositories.ItemPedidoRepository;
import com.lp.cursomc.repositories.PagamentoRepository;
import com.lp.cursomc.repositories.PedidoRepository;
import com.lp.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	BoletoService boletoService;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	public Pedido find(Integer id) {
		
		Pedido obj = pedidoRepository.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! "+id
					+ ", Tipo: "+Categoria.class.getName());
		}
		return obj;
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		
		obj = pedidoRepository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());	
			ip.setPedido(obj);
			
		}

		itemPedidoRepository.save(obj.getItens());
		
		return obj;
	}
}
