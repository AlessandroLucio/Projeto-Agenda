package model.dao;

import java.util.ArrayList;

import model.entities.Contato;

public interface ContatoDao {

	ArrayList<Contato> listarContatos();
	void inserirContato(Contato contato);
	void selecionarContato(Contato contato);
	void alterarContato(Contato contato);
	void deletarContato(Contato contato);
}
