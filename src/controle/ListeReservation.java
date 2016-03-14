package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.ProprietaireService;
import dao.ReservationService;
import meserreurs.*;

@WebServlet("/reservation/" )
public class ListeReservation extends HttpServlet {

    public ListeReservation() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReservationService reservationService = new ReservationService();
        try {
            req.setAttribute("reservations", reservationService.consulterListeReservations());
        } catch (MonException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/listeReservation.jsp");
        dispatcher.forward(req, resp);
    }
}
