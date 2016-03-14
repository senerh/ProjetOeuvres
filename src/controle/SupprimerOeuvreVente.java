package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.OeuvreVenteService;
import meserreurs.*;

@WebServlet("/oeuvre/vente/supprimer" )
public class SupprimerOeuvreVente extends HttpServlet {

    public SupprimerOeuvreVente() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idOeuvreVente = Integer.parseInt(req.getParameter("id"));
        OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();

        try {
            oeuvreVenteService.supprimerOeuvreVente(idOeuvreVente);
        } catch (MonException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("../../adherent/");
    }
}
