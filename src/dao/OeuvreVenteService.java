package dao;

import meserreurs.MonException;
import metier.Adherent;
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
                oeuvrevente.setPrixOeuvrevente(Integer.parseInt(rs.get(index + 3).toString()));

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


}
