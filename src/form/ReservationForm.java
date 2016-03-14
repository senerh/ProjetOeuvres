package form;

import dao.ReservationService;
import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Reservation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ReservationForm {

    private static final String CHAMP_LISTE_ADHERENT  = "adherent";
    private static final String CHAMP_LISTE_OEUVREVENTE   = "oeuvrevente";
    private static final String CHAMP_DATE   = "date";
    private static final String SESSION_ADHERENT    = "adherents";
    private static final String SESSION_OEUVREVENTE    = "oeuvreventes";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Reservation ajouterReservation(HttpServletRequest request ) {
        String idAdherent = getValeurChamp(request, CHAMP_LISTE_ADHERENT);
        String idOeuvreVente = getValeurChamp(request, CHAMP_LISTE_OEUVREVENTE);
        String date = getValeurChamp(request, CHAMP_DATE);


        Reservation reservation = new Reservation();

        Adherent adherent;
        HttpSession session = request.getSession();
        adherent = ((Map<String, Adherent>) session.getAttribute( SESSION_ADHERENT )).get(idAdherent);
        reservation.setAdherent(adherent);

        Oeuvrevente oeuvreVente;
        oeuvreVente = ((Map<String, Oeuvrevente>) session.getAttribute( SESSION_OEUVREVENTE )).get(idOeuvreVente);
        reservation.setOeuvrevente(oeuvreVente);

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date realDate = null;
        try {
            realDate = formatter.parse(date);
            System.out.print(realDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            validationDate(date);
        } catch ( Exception e ) {
            setErreur( CHAMP_DATE, e.getMessage());
        }
        reservation.setDate(realDate);

        ReservationService reservationService = new ReservationService();
        if ( erreurs.isEmpty() ) {
            try {
                reservationService.insertReservation(reservation);
            } catch (MonException e) {
                e.printStackTrace();
            }
            resultat = "Succès de l'ajout de l'oeuvre.";
        } else {
            resultat = "Échec de l'ajout.";
        }

        return reservation;
    }


    private void validationDate(String date) {
    }


    private void setErreur( String champ, String message ) {
        erreurs.put(champ, message);
    }


    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
