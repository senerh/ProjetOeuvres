package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.AdherentService;
import meserreurs.*;

@WebServlet("/adherent/supprimer" )
public class SupprimerAdherent extends HttpServlet {

    public SupprimerAdherent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idAdherent = Integer.parseInt(req.getParameter("id"));
        AdherentService adherentService = new AdherentService();

        try {
            adherentService.supprimerAdherent(idAdherent);
        } catch (MonException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("../adherent/");
    }
}
