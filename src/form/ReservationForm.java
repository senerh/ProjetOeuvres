package form;

import dao.AdherentService;
import dao.OeuvreVenteService;
import dao.ReservationService;
import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Proprietaire;
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

    private static final String CHAMP_LISTE_ADHERENTS  = "adherent";
    private static final String CHAMP_LISTE_OEUVREVENTES   = "oeuvrevente";
    private static final String CHAMP_DATE   = "date";
    private static final String CHAMP_UPDATED_ADHERENT   = "id-adherent-origin";
    private static final String CHAMP_UPDATED_OEUVREVENTE = "id-oeuvrevente-origin";
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
        return insertOrUpdateReservation(request, -1, -1);
    }
    
    public Reservation updateReservation(HttpServletRequest request) {
        int updatedIdAdherent = Integer.parseInt(getValeurChamp(request, CHAMP_UPDATED_ADHERENT));
        int updatedIdOeuvrevente = Integer.parseInt(getValeurChamp(request, CHAMP_UPDATED_OEUVREVENTE));
        return insertOrUpdateReservation(request, updatedIdAdherent, updatedIdOeuvrevente);
    }
    
    private Reservation insertOrUpdateReservation(HttpServletRequest request, int updatedIdAdherent, int updatedIdOeuvrevente) {
        String idAdherent = getValeurChamp(request, CHAMP_LISTE_ADHERENTS);
        String idOeuvreVente = getValeurChamp(request, CHAMP_LISTE_OEUVREVENTES);
        String date = getValeurChamp(request, CHAMP_DATE);

        HttpSession session = request.getSession();

        Reservation reservation = new Reservation();

        System.out.print(idAdherent);

        Adherent adherent;
        adherent = ((Map<String, Adherent>) session.getAttribute( SESSION_ADHERENT )).get(idAdherent);
        reservation.setAdherent(adherent);


        Oeuvrevente oeuvreVente;
        oeuvreVente = ((Map<String, Oeuvrevente>) session.getAttribute( SESSION_OEUVREVENTE )).get(idOeuvreVente);
        reservation.setOeuvrevente(oeuvreVente);

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date realDate = null;
        try {
            realDate = formatter.parse(date);
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
                if (updatedIdAdherent < 0 || updatedIdOeuvrevente < 0) {
                    reservationService.insertReservation(reservation);
                } else {
                    reservationService.updateReservation(reservation, updatedIdAdherent, updatedIdOeuvrevente);
                }
            } catch (MonException e) {
                e.printStackTrace();
            }
            resultat = "Succès de l'ajout de la reservation.";
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
