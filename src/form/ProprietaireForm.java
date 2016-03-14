package form;

import dao.ProprietaireService;
import meserreurs.MonException;
import metier.Proprietaire;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class ProprietaireForm {

    private static final String CHAMP_NOM  = "nom";
    private static final String CHAMP_PRENOM   = "prenom";
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Proprietaire ajouterProprietaire(HttpServletRequest request ) {
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );

        Proprietaire proprietaire = new Proprietaire();

        try {
            validationNom(nom);
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage());
        }
        proprietaire.setNomProprietaire(nom);

        try {
            validationPrenom(prenom);
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage());
        }
        proprietaire.setPrenomProprietaire(prenom);

        if ( erreurs.isEmpty() ) {
            ProprietaireService proprietaireService = new ProprietaireService();

            try {
                proprietaireService.insertProprietaire(proprietaire);
            } catch (MonException e) {
                e.printStackTrace();
            }

            resultat = "Succès de l'ajout du proprietaire.";
        } else {
            resultat = "Échec de l'ajout.";
        }

        return proprietaire;
    }


    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 3 ) {
            throw new Exception( "Le prenom doit contenir au moins 3 caractères." );
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
