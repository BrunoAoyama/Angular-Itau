package br.com.itau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="colaborador")
@Entity

public class ColaboradorModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private Integer codigo;
 
	@Column(name="nome")
	private String  nome;
 
	@Column(name="funcional")
	private Integer funcional;
 
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getFuncional() {
		return funcional;
	}
	public void setFuncional(Integer funcional) {
		this.funcional = funcional;
	}	

}
