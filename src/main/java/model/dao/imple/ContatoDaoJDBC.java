package model.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import model.dao.ContatoDao;
import model.entities.Contato;

public class ContatoDaoJDBC implements ContatoDao{
	
	private Connection conn;

	public ContatoDaoJDBC() {}
	
	public ContatoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Contato> listarContatos() {
		ArrayList<Contato> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {		
			conn = DB.getConnection();
			pst = conn.prepareStatement(read);			
			rs = pst.executeQuery(); 

			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				contatos.add(new Contato(idcon, nome, fone, email));
			}
			return contatos;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);	
			DB.closeConnection();
		}
	}

	public void inserirContato(Contato contato) {
		String create = "insert into contatos (nome, fone, email) values(?,?,?)";
		PreparedStatement pst = null;

		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(create);

			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}	

	public void selecionarContato(Contato contato) {
		String read2 = "select * from contatos where idcon = ?";
		PreparedStatement pst = null;
		
		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}

	public void alterarContato(Contato contato) {
		String update = "update contatos set nome=?, fone=?, email=? where idcon=?";
		PreparedStatement pst = null;
		
		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(update);
			
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}

	public void deletarContato(Contato contato) {
		String delete = "delete from contatos where idcon=?";
		PreparedStatement pst = null;
		
		try {
			conn = DB.getConnection();
			pst = conn.prepareStatement(delete);
			pst.setString(1, contato.getIdcon());
			pst.executeUpdate();
		

		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			DB.closeStatement(pst);
			DB.closeConnection();
		}
	}
}
