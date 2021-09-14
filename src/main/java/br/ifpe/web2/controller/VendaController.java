package br.ifpe.web2.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.model.Categoria;
import br.ifpe.web2.model.Cliente;
import br.ifpe.web2.model.ClienteDAO;
import br.ifpe.web2.model.Produto;
import br.ifpe.web2.model.ProdutoDAO;
import br.ifpe.web2.model.Venda;
import br.ifpe.web2.service.ClienteService;
import br.ifpe.web2.service.VendaService;

@Controller
public class VendaController {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private VendaService vendaService;
	@Autowired
	private ProdutoDAO produtoDAO;

	@GetMapping("/exibirProdutosVenda")
	public String exibirProdutos(Model model) {
		PageRequest page = PageRequest.of(0, 15);
		model.addAttribute("listaProdutos", this.produtoDAO.findAll(page));
//		model.addAttribute("listaProdutos", this.produtoDAO.findByPrecoBetween(1, 3));
		return "vendas/produto-search";
	}

	@PostMapping("/pesquisarProdutos")
	public String pesquisarProdutos(String nomeProduto, Model model) {

		List<Produto> resultado = this.produtoDAO.findByNomeContainingIgnoreCase(nomeProduto, Sort.by("nome"));
		model.addAttribute("listaProdutos", resultado);
		return "vendas/produto-search";
	}

	@GetMapping("/realizarVenda")
	public String realizarVenda(Integer codigo, Model model) {

		model.addAttribute("venda", new Venda());
		model.addAttribute("clientes", this.clienteDAO.findAll());
		model.addAttribute("produtoEscolhido", this.vendaService.receberPorId(codigo));
		return "vendas/vender_produto";
	}

	@GetMapping("/registrarVenda")
	public String registrarVenda() {
		
			return "vendas/registrar_venda";
		}
	
}

