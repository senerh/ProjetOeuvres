package form;

import dao.AdherentService;
import dao.OeuvreVenteService;
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
        return insertOrUpdateReservation(request, false);
    }
    
    public Reservation updateReservation(HttpServletRequest request ) {
        return insertOrUpdateReservation(request, true);
    }
    
    private Reservation insertOrUpdateReservation(HttpServletRequest request, boolean isUpdate) {
        String idAdherent = getValeurChamp(request, CHAMP_LISTE_ADHERENT);
        String idOeuvreVente = getValeurChamp(request, CHAMP_LISTE_OEUVREVENTE);
        String date = getValeurChamp(request, CHAMP_DATE);


        Reservation reservation = new Reservation();

        Adherent adherent = null;
        HttpSession session = request.getSession();
        AdherentService adherentService = new AdherentService();
        OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
        try {
            adherent = adherentService.consulterAdherent(Integer.parseInt(idAdherent));
        } catch (NumberFormatException | MonException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        reservation.setAdherent(adherent);

        Oeuvrevente oeuvreVente = null;
        try {
            oeuvreVente = oeuvreVenteService.consulterOeuvreVente(Integer.parseInt(idOeuvreVente));
        } catch (NumberFormatException | MonException e1) {
            e1.printStackTrace();
        }
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
                if (isUpdate) {
                    reservationService.updateReservation(reservation);
                } else {
                    reservationService.insertReservation(reservation);
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
