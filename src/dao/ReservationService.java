package dao;

import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Proprietaire;
import metier.Reservation;
import persistance.DialogueBd;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nathan on 08/03/2016.
 */
public class ReservationService {

    public Reservation consulterReservation(int id) throws MonException {
        String mysql = "select * from reservation where id_reservation=" + id;
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

                int idAdherent = Integer.parseInt(rs.get(index).toString());
                Adherent adherent = adherentService.consulterAdherent(idAdherent);
                reservation.setAdherent(adherent);

                int idOeuvreVente = Integer.parseInt(rs.get(index + 1).toString());
                Oeuvrevente oeuvrevente = oeuvreVenteService.consulterOeuvreVente(idOeuvreVente);
                reservation.setOeuvrevente(oeuvrevente);

                String date = rs.get(index + 2).toString();
                DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
                Date realDate = null;
                try {
                    realDate = formatter.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                index = index + 3;
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
        } catch (MonException e) {
            throw e;
        }
    }


    public void supprimerReservation(int idReservation) throws MonException {
        String mysql;

        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "DELETE FROM reservation WHERE id_reservation = " + idReservation;
            unDialogueBd.execute(mysql);
        } catch (MonException e) {
            throw e;
        }
    }
}
