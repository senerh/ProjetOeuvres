package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.ProprietaireService;
import meserreurs.*;

@WebServlet("/proprietaire/supprimer" )
public class SupprimerProprietaire extends HttpServlet {

    public SupprimerProprietaire() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idProprietaire = Integer.parseInt(req.getParameter("id"));
        ProprietaireService proprietaireService = new ProprietaireService();

        try {
            proprietaireService.supprimerProprietaire(idProprietaire);
        } catch (MonException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/proprietaire/");
    }
}
