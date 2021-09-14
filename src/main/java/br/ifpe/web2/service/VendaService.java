package br.ifpe.web2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.ifpe.web2.model.Produto;
import br.ifpe.web2.model.ProdutoDAO;

@Service
public class VendaService {

	@Autowired
	private ProdutoDAO produtoDAO;

	public Produto receberPorId(Integer codigo) {
		return this.produtoDAO.getOne(codigo);
	}

}
