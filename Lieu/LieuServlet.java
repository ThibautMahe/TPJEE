package jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Entite.LieuEntite;
import Services.LieuServices;

@WebServlet(name = "Intentions_Criminelles", urlPatterns = { "/Intentions_Criminelles/Lieu" })

public class LieuServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Lieu Criminelles</title></head>");
		writer.println("<body><h1>Lieu Criminelles</h1>");
		writer.println("<form method='post'>");
		writer.println("<table>");
		writer.println("<tr>");
		writer.println("<td>Lieu:</td>");
		writer.println("<td><input Name='Name'/></td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td><input type='reset'/>" + "<input type='submit'/></td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("</form>");
		writer.println("</body>");
		writer.println("</html>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CriminelServices service = new CriminelServices();

		LieulEntite Lieu = new LieuEntite(request.getParameter("Lieu"));
				
		service.setCriminel(Criminel);

		request.setAttribute("Lieu", service.getAllLieu());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Lieux.jsp");
		rd.forward(request, response);
	}
}
