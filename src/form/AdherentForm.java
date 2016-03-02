package form;

import dao.AdherentService;
import meserreurs.MonException;
import metier.Adherent;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AdherentForm {

    private static final String CHAMP_NOM  = "nom";
    private static final String CHAMP_PRENOM   = "prenom";
    private static final String CHAMP_VILLE   = "ville";
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Adherent ajouterAdherent(HttpServletRequest request ) {
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String ville = getValeurChamp( request, CHAMP_VILLE );

        Adherent adherent = new Adherent();

        try {
            validationNom(nom);
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage());
        }
        adherent.setNomAdherent( nom );

        try {
            validationPrenom(prenom);
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage());
        }
        adherent.setPrenomAdherent(prenom);

        try {
            validationVille(ville);
        } catch ( Exception e ) {
            setErreur(CHAMP_VILLE, e.getMessage());
        }
        adherent.setVilleAdherent(ville);

        if ( erreurs.isEmpty() ) {
            AdherentService adherentService = new AdherentService();

            try {
                adherentService.insertAdherent(adherent);
            } catch (MonException e) {
                e.printStackTrace();
            }

            resultat = "Succès de l'ajout de l'adherent.";
        } else {
            resultat = "Échec de l'ajout.";
        }

        return adherent;
    }


    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 3 ) {
            throw new Exception( "Le prenom doit contenir au moins 3 caractères." );
        }
    }

    private void validationVille( String ville) throws Exception {
        if ( ville != null && ville.length() < 3 ) {
            throw new Exception( "la ville doit contenir au moins 3 caractères." );
        }
    }


    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom doit contenir au moins 3 caractères." );
        }
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
