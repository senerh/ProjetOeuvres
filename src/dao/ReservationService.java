package dao;

import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Reservation;
import persistance.DialogueBd;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationService {

    public Reservation consulterReservation(int idOeuvrevente, int idAdherent) throws MonException {
        String mysql = "select * from reservation where id_oeuvrevente=" + idOeuvrevente + " and id_adherent=" + idAdherent + ";";
        List<Reservation> uneReservation = consulterReservations(mysql);
        if (uneReservation.isEmpty())
            return null;
        else {
            return uneReservation.get(0);
        }
    }


    public List<Reservation> consulterListeReservations() throws MonException {
        String mysql = "select * from reservation";
        return consulterReservations(mysql);
    }

    private List<Reservation> consulterReservations(String mysql) throws MonException {
        List<Object> rs;
        List<Reservation> reservations = new ArrayList<Reservation>();
        int index = 0;
        try {
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            rs = DialogueBd.lecture(mysql);

            AdherentService adherentService = new AdherentService();
            OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();

            while (index < rs.size()) {
                Reservation reservation = new Reservation();

                int idOeuvreVente = Integer.parseInt(rs.get(index).toString());
                Oeuvrevente oeuvrevente = oeuvreVenteService.consulterOeuvreVente(idOeuvreVente);
                reservation.setOeuvrevente(oeuvrevente);

                int idAdherent = Integer.parseInt(rs.get(index + 1).toString());
                Adherent adherent = adherentService.consulterAdherent(idAdherent);
                reservation.setAdherent(adherent);

                String date = rs.get(index + 2).toString();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
                Date realDate = null;
                try {
                    realDate = formatter.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                reservation.setDate(realDate);

                index = index + 4;
                reservations.add(reservation);
            }

            return reservations;

        } catch (Exception exc) {
            throw new MonException(exc.getMessage(), "systeme");
        }
    }


    public void insertReservation(Reservation reservation) throws MonException {

        String mysql;
        String mysql1 = "select id_adherent from adherent where id_adherent="
                + reservation.getAdherent().getIdAdherent();
        String mysql2 = "select id_oeuvrevente from oeuvrevente where id_oeuvrevente="
                + reservation.getOeuvrevente().getIdOeuvrevente();

        DialogueBd unDialogueBd = DialogueBd.getInstance();

        java.sql.Date sqlDate = new java.sql.Date(reservation.getDate().getTime());

        try {
            mysql = "insert into reservation  (date_reservation, statut, id_adherent, id_oeuvrevente)  " + "values " +
                    "('" + sqlDate + "'"
                    + ",'confirmee'"
                    + ",(" + mysql1 + ")"
                    + ",(" + mysql2 + "))";

            unDialogueBd.insertionBD(mysql);
            OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
            oeuvreVenteService.editEtatOeuvreVente("R", reservation.getOeuvrevente().getIdOeuvrevente());
        } catch (MonException e) {
            throw e;
        }
    }
    
    public void updateReservation(Reservation reservation, int updatedIdAdherent, int updatedIdOeuvrevente) throws MonException {

        String mysql;
        
        int idOeuvrevente = reservation.getOeuvrevente().getIdOeuvrevente();
        int idAdherent = reservation.getAdherent().getIdAdherent();

        DialogueBd unDialogueBd = DialogueBd.getInstance();

        java.sql.Date sqlDate = new java.sql.Date(reservation.getDate().getTime());

        try {
            mysql = "update reservation set "
                    + "date_reservation = '" + sqlDate + "', "
                    + "id_adherent = " + idAdherent + ", "
                    + "id_oeuvrevente = " + idOeuvrevente + " "
                    + "where id_adherent = " + updatedIdAdherent + " and id_oeuvrevente = " + updatedIdOeuvrevente + ";";

            unDialogueBd.execute(mysql);
        } catch (MonException e) {
            throw e;
        }
    }


    public void supprimerReservation(int idAdherent, int idOeuvrevente) throws MonException {
        String mysql;
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        mysql = "DELETE FROM reservation WHERE id_adherent = " + idAdherent + " and id_oeuvrevente = "+idOeuvrevente;
        unDialogueBd.execute(mysql);
        OeuvreVenteService oeuvreVenteService = new OeuvreVenteService();
        oeuvreVenteService.editEtatOeuvreVente("L", idOeuvrevente);
    }

    public void supprimerReservation(int idOeuvrevente) throws MonException {
        String mysql;
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        mysql = "DELETE FROM reservation WHERE id_oeuvrevente = "+idOeuvrevente;
        unDialogueBd.execute(mysql);
    }

    public void supprimerReservationAdherent(int idAdherent) throws MonException {
        String mysql;
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        mysql = "DELETE FROM reservation WHERE id_adherent = "+idAdherent;
        unDialogueBd.execute(mysql);
    }
}
