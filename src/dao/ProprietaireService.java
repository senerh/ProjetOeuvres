package dao;

import meserreurs.MonException;
import metier.Adherent;
import metier.Proprietaire;
import persistance.DialogueBd;

import java.util.ArrayList;
import java.util.List;


public class ProprietaireService {

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

            System.out.println(rs);

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
}
