package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.services.Iservices;
import com.infotel.services.ServicesImpl;

/**
 * Servlet implementation class SupprimerPers
 */
@WebServlet("/SupprimerPers")
public class SupprimerPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservices service = new ServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 - Récupération des données
		
				int id = Integer.parseInt(request.getParameter("id"));
				
		//2 - Envoyer à la couche service
				
				Personne p = new Personne();
				p = service.getPersonne(id);
				service.supprimerPersonne(p);
				
		//3 - Préparation à l'envoi
				
				request.setAttribute("personne", service.findAllPersonne());
				request.setAttribute("adresse", service.findAllAdresse());
				
		//4 - Envoi à la JSP
				
				request.getRequestDispatcher("personne.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
