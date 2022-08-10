package model.dao;

import db.DB;
import model.dao.imple.ContatoDaoJDBC;

public class DaoFactory {
	public static ContatoDao createContatoDao(){
		return new ContatoDaoJDBC(DB.getConnection());
	}
}
