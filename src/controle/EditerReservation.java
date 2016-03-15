package controle;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdherentService;
import dao.OeuvreVenteService;
import dao.ProprietaireService;
import dao.ReservationService;
import form.ProprietaireForm;
import form.ReservationForm;
import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Proprietaire;
import metier.Reservation;

@WebServlet("/reservation/editer" )
public class EditerReservation extends HttpServlet {

    public static final String ATT_RESERVATION = "reservation";
    public static final String SESSION_ADHERENTS = "adherents";
    public static final String SESSION_OEUVREVENTES = "oeuvreventes";
    public static final String ATT_FORM = "form";

    public EditerReservation() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idOeuvrevente = Integer.parseInt(req.getParameter("id-oeuvrevente"));
        int idAdherent = Integer.parseInt(req.getParameter("id-adherent"));
        HttpSession session = req.getSession();

        ReservationService reservationService= new ReservationService();
        AdherentService adherentService = new AdherentService();
        OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
        
        Reservation reservation = null;
        try {
            List<Adherent> listAdherents = adherentService.consulterListeAdherents();
            HashMap<String, Adherent> adherents = new HashMap<String, Adherent>();
            for (final Adherent a:listAdherents) {
                adherents.put( Integer.toString(a.getIdAdherent()), a );
            }
            session.setAttribute( SESSION_ADHERENTS, adherents );

            List<Oeuvrevente> listOeuvreVentes = oeuvreVenteService.consulterListeOeuvreVente();
            HashMap<String, Oeuvrevente> oeuvreventes = new HashMap<String, Oeuvrevente>();
            for (final Oeuvrevente o:listOeuvreVentes) {
                oeuvreventes.put( Integer.toString(o.getIdOeuvrevente()), o );
            }
            session.setAttribute( SESSION_OEUVREVENTES, oeuvreventes );

        } catch (MonException e) {
            e.printStackTrace();
        }

        try {
            reservation = reservationService.consulterReservation(idOeuvrevente, idAdherent);
        } catch (MonException e) {
            e.printStackTrace();
        }

        req.setAttribute(ATT_RESERVATION, reservation);

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
