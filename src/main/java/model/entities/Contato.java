package model.entities;

import java.io.Serializable;

public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	private String idcon;
	 private String nome;
	 private String fone;
	 private String email;
	 
	 public Contato() {}

	public Contato(String idcon, String nome, String fone, String email) {
		this.idcon = idcon;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	public String getIdcon() {
		return idcon;
	}

	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [idcon=" + idcon + ", nome=" + nome + ", fone=" + fone + ", email=" + email + "]";
	} 
	
	
}
