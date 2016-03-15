package controle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.OeuvreVenteService;
import dao.ReservationService;
import meserreurs.*;

@WebServlet("/reservation/supprimer" )
public class SupprimerReservation extends HttpServlet {

    public SupprimerReservation() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idAdherent = Integer.parseInt(req.getParameter("id-adherent"));
        int idOeuvrevente = Integer.parseInt(req.getParameter("id-oeuvrevente"));
        ReservationService reservationService = new ReservationService();

        try {
            reservationService.supprimerReservation(idAdherent, idOeuvrevente);
        } catch (MonException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("../../reservation/");
    }
}
