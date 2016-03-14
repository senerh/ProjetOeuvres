package dao;

import meserreurs.MonException;
import metier.Proprietaire;
import persistance.DialogueBd;

import java.util.ArrayList;
import java.util.List;


public class ProprietaireService {

    public void supprimerProprietaire(int idProprietaire) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "DELETE FROM proprietaire WHERE id_proprietaire = " + idProprietaire;
            unDialogueBd.execute(mysql);
        } catch (MonException e) {
            throw e;
        }
    }


    public Proprietaire consulterProprietaire(int id) throws MonException {
        String mysql = "select * from proprietaire where id_proprietaire=" + id;
        List<Proprietaire> unProprietaire = consulterListeProprietaire(mysql);
        if (unProprietaire.isEmpty())
            return null;
        else {
            return unProprietaire.get(0);
        }
    }


    public List<Proprietaire> consulterListeProprietaire() throws MonException {
        String mysql = "select * from proprietaire";
        return consulterListeProprietaire(mysql);
    }


    private List<Proprietaire> consulterListeProprietaire(String mysql) throws MonException {
        List<Object> rs;
        List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
        int index = 0;
        try {
            rs = DialogueBd.lecture(mysql);

            while (index < rs.size()) {
                Proprietaire proprietaire = new Proprietaire();

                proprietaire.setIdProprietaire(Integer.parseInt(rs.get(index).toString()));
                proprietaire.setNomProprietaire(rs.get(index + 1).toString());
                proprietaire.setPrenomProprietaire(rs.get(index + 2).toString());

                index = index + 3;
                proprietaires.add(proprietaire);
            }

            return proprietaires;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }


    public void insertProprietaire(Proprietaire proprietaire) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into proprietaire  (nom_proprietaire, prenom_proprietaire)  " + "values ('"
                    + proprietaire.getNomProprietaire();
            mysql += "'" + ",'" + proprietaire.getPrenomProprietaire() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }
}
