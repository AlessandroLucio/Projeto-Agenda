package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/controller", "/main", "/insert", "/select", "/update"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	
	public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/main")) {
			contatos(request, response);
		}else if(action.equals("/insert")) {
			adicionarContato(request, response);
		}else if(action.equals("/select")) {
			listarContatos(request, response);
		}else if(action.equals("/update")) {
			editarContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/agenda.jsp");
		rd.forward(request, response);		
	}
	
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.inserirContato(contato);
		response.sendRedirect("main");		
	}

	protected void listarContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		dao.selecionarContato(contato);
		
		request.setAttribute("idcon",contato.getIdcon());
		request.setAttribute("nome",contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		
		dao.alterarContato(contato);
		
		response.sendRedirect("main");
	}	
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		
		dao.alterarContato(contato);
		
		response.sendRedirect("main");
	}
}






















