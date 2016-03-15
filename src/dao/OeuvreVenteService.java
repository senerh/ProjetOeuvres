package dao;

import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Proprietaire;
import persistance.DialogueBd;
import java.util.ArrayList;
import java.util.List;

public class OeuvreVenteService {

    public Oeuvrevente consulterOeuvreVente(int id) throws MonException {
        String mysql = "select * from oeuvrevente where id_oeuvrevente=" + id;
        List<Oeuvrevente> uneOeuvreVente = consulterListeOeuvreVente(mysql);
        if (uneOeuvreVente.isEmpty())
            return null;
        else {
            return uneOeuvreVente.get(0);
        }
    }


    public List<Oeuvrevente> consulterListeOeuvreVente() throws MonException {
        String mysql = "select * from oeuvrevente";
        return consulterListeOeuvreVente(mysql);
    }

    private List<Oeuvrevente> consulterListeOeuvreVente(String mysql) throws MonException {
        List<Object> rs;
        List<Oeuvrevente> oeuvreVentes = new ArrayList<Oeuvrevente>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);

            ProprietaireService proprietaireService = new ProprietaireService();

            while (index < rs.size()) {
                Oeuvrevente oeuvrevente = new Oeuvrevente();

                oeuvrevente.setIdOeuvrevente(Integer.parseInt(rs.get(index).toString()));
                oeuvrevente.setTitreOeuvrevente(rs.get(index + 1).toString());
                oeuvrevente.setEtatOeuvrevente(rs.get(index + 2).toString());
                oeuvrevente.setPrixOeuvrevente(Float.parseFloat(rs.get(index + 3).toString()));

                int idProprietaire = Integer.parseInt(rs.get(index + 4).toString());
                Proprietaire proprietaire = proprietaireService.consulterProprietaire(idProprietaire);
                oeuvrevente.setProprietaire(proprietaire);

                index = index + 5;
                oeuvreVentes.add(oeuvrevente);
            }

            return oeuvreVentes;
        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }


    public void insertOeuvreVente(Oeuvrevente oeuvrevente) throws MonException {
        String mysql;

        String mysql1 = "select id_proprietaire from proprietaire where id_proprietaire="
                + oeuvrevente.getProprietaire().getIdProprietaire();

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into oeuvrevente  (titre_oeuvrevente, etat_oeuvrevente, prix_oeuvrevente, id_proprietaire)  " + "values " +
                    "('" + oeuvrevente.getTitreOeuvrevente() + "'"
                    + ",'" + oeuvrevente.getEtatOeuvrevente() + "'"
                    + ",'" + oeuvrevente.getPrixOeuvrevente() + "'"
                    + ",(" + mysql1 + "))";

            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

    public void editOeuvreVente(Oeuvrevente oeuvrevente) throws MonException {
        String mysql;

        String mysql1 = "select id_proprietaire from proprietaire where id_proprietaire="
                + oeuvrevente.getProprietaire().getIdProprietaire();

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "UPDATE oeuvrevente SET " +
                    "titre_oeuvrevente ='" + oeuvrevente.getTitreOeuvrevente()+"', " +
                    "etat_oeuvrevente ='" + oeuvrevente.getEtatOeuvrevente()+"', " +
                    "prix_oeuvrevente ='" + oeuvrevente.getPrixOeuvrevente()+"', " +
                    "id_proprietaire = (" + mysql1+") WHERE id_oeuvrevente =" + oeuvrevente.getIdOeuvrevente();

                    unDialogueBd.execute(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

    public void editEtatOeuvreVente(String etat, int idOeuvrevrente) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "UPDATE oeuvrevente SET " +
                    "etat_oeuvrevente ='" + etat+"' " +
                    "WHERE id_oeuvrevente =" + idOeuvrevrente;

            unDialogueBd.execute(mysql);
        } catch (MonException e) {
            throw e;
        }
    }


    public void supprimerOeuvreVente(int idOeuvreVente) throws MonException {
        String mysql;
        mysql = "DELETE FROM oeuvrevente WHERE id_oeuvrevente = " + idOeuvreVente;
        DialogueBd unDialogueBd = DialogueBd.getInstance();

        ReservationService reservationService = new ReservationService();
        reservationService.supprimerReservation(idOeuvreVente);

        unDialogueBd.execute(mysql);
    }
}
