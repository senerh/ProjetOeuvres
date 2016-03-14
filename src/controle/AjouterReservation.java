package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AdherentService;
import dao.OeuvreVenteService;
import dao.ProprietaireService;
import form.OeuvreVenteForm;
import form.ReservationForm;
import meserreurs.*;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Proprietaire;
import metier.Reservation;

@WebServlet("/reservation/ajouter" )
public class AjouterReservation extends HttpServlet {

    public static final String ATT_RESERVATION = "reservation";
    public static final String ATT_FORM = "form";
    public static final String SESSION_ADHERENT = "adherents";
    public static final String SESSION_OEUVREVENTE = "oeuvreventes";

    public AjouterReservation() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        AdherentService adherentService = new AdherentService();
        OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
        try {
            List<Oeuvrevente> listeOeuvreVentes = oeuvreVenteService.consulterListeOeuvreVente();
            HashMap<String, Oeuvrevente> oeuvreventeHashMap = new HashMap<String, Oeuvrevente>();

            List<Adherent> listeAdherent = adherentService.consulterListeAdherents();
            HashMap<String, Adherent> adherentHashMap = new HashMap<String, Adherent>();

            for (final Oeuvrevente o:listeOeuvreVentes) {
                oeuvreventeHashMap.put( Integer.toString(o.getIdOeuvrevente()), o);
            }

            for (final Adherent a:listeAdherent) {
                adherentHashMap.put( Integer.toString(a.getIdAdherent()), a);
            }

            session.setAttribute( SESSION_OEUVREVENTE, oeuvreventeHashMap );
            session.setAttribute( SESSION_ADHERENT, adherentHashMap );

        } catch (MonException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ajouterReservation.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ReservationForm form = new ReservationForm();
        Reservation reservation = form.ajouterReservation(req);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_RESERVATION, reservation);

        this.getServletContext().getRequestDispatcher( "/WEB-INF/ajouterOeuvreVente.jsp" ).forward(req, resp);
    }
}
