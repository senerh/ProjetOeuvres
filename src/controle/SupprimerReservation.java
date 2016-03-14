package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.ProprietaireService;
import meserreurs.*;

@WebServlet("/reservation/supprimer" )
public class SupprimerReservation extends HttpServlet {

    public SupprimerReservation() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        ProprietaireService proprietaireService = new ProprietaireService();

        resp.sendRedirect("../proprietaire/");
    }
}
