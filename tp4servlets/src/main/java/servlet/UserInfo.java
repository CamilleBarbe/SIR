package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ElectronicDevice;
import domain.Home;
import domain.Person;
import domain.Singleton;
import jpa.JpaTest;

@WebServlet(name = "userinfo", urlPatterns = {"/UserInfo"})
public class UserInfo extends HttpServlet {

	private Collection<Person> person;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		Singleton manager = Singleton.getInstance();

		EntityTransaction tx = manager.getManager().getTransaction();
		tx.begin();

		// ajoute une nouvelle personne en BD
		Person person = new Person(request.getParameter("name"), request.getParameter("firstname"),
				new Integer(request.getParameter("age")), request.getParameter("mail"));

		manager.getManager().persist(person);

		tx.commit();

		manager.getManager().close();

		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Mail: " + request.getParameter("mail") + "\n" + " <LI>Age: " + request.getParameter("age")
				+ "\n" + " <LI>Amis: " + request.getParameter("amis") + "\n" + " <LI>Maisons: "
				+ request.getParameter("homes") + "\n" + " <LI>Equipements : " + request.getParameter("equipements")
				+ "\n" + "</UL>\n" + "</BODY></HTML>");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Singleton manager = Singleton.getInstance();
		
		PrintWriter p = new PrintWriter(response.getOutputStream());
		
		person = new ArrayList<Person>();
		try {
	         p.println("<!DOCTYPE html>");
	         p.println("<html><head>");
	         p.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         p.println("<title>Liste des personnes</title></head>");
	         p.println("<body>");
	         p.println("<h1>Liste des personnes de la base de donnees</h1>"); 

	 		 Query query = (Query) manager.getManager().createQuery("From Person");
	 		 
	 		 person = query.getResultList();
	 		 
	 		 for(Person personne : person){
	 			 p.println(personne);
	 			 p.println("<br/>");
	 		 }
	 		 
	         p.println("</body>");
	         p.println("</html>");
	         
	         p.flush();
	      } finally {
	         p.close();  // Always close the output writer
	      }
    }
}
