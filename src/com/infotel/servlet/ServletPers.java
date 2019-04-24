package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.services.Iservices;
import com.infotel.services.ServicesImpl;

/**
 * Servlet implementation class ServletPers
 */
@WebServlet("/ServletPers")
public class ServletPers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Iservices service = new ServicesImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 - Récupération des données
		
		String nom = null;
		String prenom = null;
		int age = 0;
		int id = 0;
		int idadresse = 0;
		String login = null;
		String mdp = null;
		
		if(request.getParameter("nom")!=null){  
			age = Integer.parseInt(request.getParameter("age"));            
			nom = request.getParameter("nom");            
			prenom = request.getParameter("prenom");
			
			login = request.getParameter("login");
			mdp = request.getParameter("mdp");
			
			idadresse = Integer.parseInt(request.getParameter("adresse"));
		}
		
		
//2 - Envoyer à la couche service
		
		Personne p = new Personne();
		p.setAge(age);
		p.setNom(nom);
		p.setPrenom(prenom);
		
		Connexion c = new Connexion();
		c.setLogin(login);
		c.setMdp(mdp);
		
		p.setConnexion(c);
		
		if (idadresse != 0) {
			p.setAdresse(service.affichageAdresse(idadresse));
		
		
		if(request.getParameter("ajouter")!=null) {
			service.ajouterPersonne(p);
		}
		
		if(request.getParameter("modifier")!=null){
			id = Integer.parseInt(request.getParameter("id"));
			p.setId(id);
			
			service.modifierPersonne(p);
		}
		}
		//3 - Préparation à l'envoi
		
		request.setAttribute("personne", service.findAllPersonne());
		request.setAttribute("adresse", service.findAllAdresse());
		request.setAttribute("connexion", service.findAllConnexion());
		
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
