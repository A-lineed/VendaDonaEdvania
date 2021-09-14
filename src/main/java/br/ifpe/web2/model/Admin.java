package br.ifpe.web2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id_admin;

private String chaveAcesso;

@Column(length=50)
private String email;

@Column(length=11)
private String telefone;


public Integer getId_gerente() {
	return id_admin;
}
public void setId_gerente(Integer id_admin) {
	this.id_admin = id_admin;
}
public String getChaveAcesso() {
	return chaveAcesso;
}
public void setChaveAcesso(String chaveAcesso) {
	this.chaveAcesso = chaveAcesso;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}

}
