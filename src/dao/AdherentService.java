package dao;

import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;

public class AdherentService {


    public void supprimerAdherent(int idAdherent) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "DELETE FROM adherent WHERE id_adherent = " + idAdherent;
            unDialogueBd.execute(mysql);
        } catch (MonException e) {
            throw e;
        }
    }


    public Adherent consulterAdherent(int numero) throws MonException {
        String mysql = "select * from adherent where numero_adherent=" + numero;
        List<Adherent> mesAdh = consulterListeAdherents(mysql);
        if (mesAdh.isEmpty())
            return null;
        else {
            return mesAdh.get(0);
        }
    }


    public List<Adherent> consulterListeAdherents() throws MonException {
        String mysql = "select * from adherent";
        return consulterListeAdherents(mysql);
    }


    private List<Adherent> consulterListeAdherents(String mysql) throws MonException {
        List<Object> rs;
        List<Adherent> mesAdherents = new ArrayList<Adherent>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);

            while (index < rs.size()) {
                Adherent unA = new Adherent();

                unA.setIdAdherent(Integer.parseInt(rs.get(index + 0).toString()));
                unA.setNomAdherent(rs.get(index + 1).toString());
                unA.setPrenomAdherent(rs.get(index + 2).toString());
                unA.setVilleAdherent(rs.get(index + 3).toString());

                index = index + 4;
                mesAdherents.add(unA);
            }

            return mesAdherents;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }

    public void insertAdherent(Adherent unAdherent) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
                    + unAdherent.getNomAdherent();
            mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }
}
