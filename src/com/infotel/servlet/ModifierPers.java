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
 * Servlet implementation class ModifierPers
 */
@WebServlet("/ModifierPers")
public class ModifierPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservices service = new ServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 - Récupération des données
				
				
		//2 - Envoyer à la couche service
			

				
		//3 - Préparation à l'envoi
				
		Personne p = service.affichagePersonne(Integer.parseInt(request.getParameter("id")));

				request.setAttribute("id", p.getId());
				request.setAttribute("nom", p.getNom());
				request.setAttribute("prenom", p.getPrenom());
				request.setAttribute("age", p.getAge());
				
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
