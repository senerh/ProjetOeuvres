package form;

import dao.OeuvreVenteService;
import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Proprietaire;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OeuvreVenteForm {

    private static final String CHAMP_TITRE = "titre";
    private static final String CHAMP_ETAT = "etat";
    private static final String CHAMP_PRIX = "prix";
    private static final String CHAMP_LISTE_PROPRIETAIRES = "listeProprietaires";
    private static final String SESSION_PROPRIETAIRE    = "proprietaires";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Oeuvrevente ajouterOeuvreVente(HttpServletRequest request, int idOeuvreVente) {

        String idProprietaire = getValeurChamp(request, CHAMP_LISTE_PROPRIETAIRES);
        String titre = getValeurChamp(request, CHAMP_TITRE);
        String etat = getValeurChamp(request, CHAMP_ETAT);
        String prix = getValeurChamp(request, CHAMP_PRIX);

        Oeuvrevente oeuvrevente = new Oeuvrevente();
        oeuvrevente.setIdOeuvrevente(idOeuvreVente);


        Proprietaire proprietaire;
        HttpSession session = request.getSession();

        proprietaire = ((Map<String, Proprietaire>) session.getAttribute( SESSION_PROPRIETAIRE )).get(idProprietaire);
        oeuvrevente.setProprietaire(proprietaire);

        try {
            validationTitre(titre);
        } catch ( Exception e ) {
            setErreur( CHAMP_TITRE, e.getMessage());
        }
        oeuvrevente.setTitreOeuvrevente(titre);

        try {
            validationEtat(etat);
        } catch ( Exception e ) {
            setErreur( CHAMP_ETAT, e.getMessage());
        }
        oeuvrevente.setEtatOeuvrevente(etat);

        float valeurPrix = -1;
        try {
            valeurPrix = validationPrix( prix );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRIX, e.getMessage() );
        }
        oeuvrevente.setPrixOeuvrevente( valeurPrix );

        if ( erreurs.isEmpty() ) {
            OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
            try {
                if(oeuvrevente.getIdOeuvrevente() > 0)
                    oeuvreVenteService.editOeuvreVente(oeuvrevente);
                else
                    oeuvreVenteService.insertOeuvreVente(oeuvrevente);
            } catch (MonException e) {
                e.printStackTrace();
            }

            resultat = "Succès de l'ajout de l'oeuvre.";
        } else {
            resultat = "Échec de l'ajout.";
        }

        return oeuvrevente;
    }


    private void validationTitre( String titre ) throws Exception {
        if ( titre != null && titre.length() < 3 ) {
            throw new Exception( "Le titre doit contenir au moins 3 caractères." );
        }
    }

    private void validationEtat( String etat) throws Exception {
        if ( etat != null && etat.length() < 0 ) {
            throw new Exception( "" );
        }
    }


    private float validationPrix( String prix ) throws Exception {
        float temp;
        if ( prix != null ) {
            try {
                temp = Float.parseFloat( prix );
                if ( temp < 0 ) {
                    throw new Exception( "Le montant doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le montant doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un montant." );
        }
        return temp;
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
