package br.ifpe.web2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.model.Admin;

@Controller
public class AcessoController {

	@PostMapping("/login")
	public String loginGerente(Admin admin, RedirectAttributes ra, HttpSession session) {
		if (admin.getEmail().equals("admin") && admin.getChaveAcesso().equals("adm123")) {
			return "tela_home";
		} else {
			return "index";
		}
	}

	@GetMapping("/telaHome")
	public String telaHome() {
		return "tela_home";
	}

	@GetMapping("/telaPrincipal")
	public String telaPrincipal() {
		return "index";
	}

}
