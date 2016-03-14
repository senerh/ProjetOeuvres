package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProprietaireService;
import dao.ReservationService;
import form.ProprietaireForm;
import form.ReservationForm;
import meserreurs.MonException;
import metier.Proprietaire;
import metier.Reservation;

@WebServlet("/reservation/editer" )
public class EditerReservation extends HttpServlet {

    public static final String ATT_RESERVATION = "reservation";
    public static final String ATT_FORM = "form";

    public EditerReservation() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idOeuvrevente = Integer.parseInt(req.getParameter("id-oeuvrevente"));
        int idAdherent = Integer.parseInt(req.getParameter("id-adherent"));
        ReservationService reservationService= new ReservationService();
        
        Reservation reservation = null;
        try {
            reservation = reservationService.consulterReservation(idOeuvrevente, idAdherent);
        } catch (MonException e) {
            e.printStackTrace();
        }

        req.setAttribute(ATT_RESERVATION, reservation);
        try {
            req.setAttribute("reservations", reservationService.consulterListeReservations());
        } catch (MonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/editerReservation.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReservationForm form = new ReservationForm();
        Reservation reservation = form.updateReservation(req);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_RESERVATION, reservation);

        this.getServletContext().getRequestDispatcher("/WEB-INF/editerReservation.jsp").forward(req, resp);
    }
}
