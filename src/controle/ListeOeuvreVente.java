package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import dao.AdherentService;
import dao.OeuvreVenteService;
import meserreurs.*;

@WebServlet("/oeuvre/vente" )
public class ListeOeuvreVente extends HttpServlet {

    public ListeOeuvreVente() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
        try {
            req.setAttribute("oeuvreVentes", oeuvreVenteService.consulterListeOeuvreVente());
        } catch (MonException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/listeOeuvreVente.jsp");
        dispatcher.forward(req, resp);
    }
}
