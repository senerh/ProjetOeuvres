package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import dao.OeuvreVenteService;
import dao.ProprietaireService;
import form.OeuvreVenteForm;
import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Proprietaire;

@WebServlet("/oeuvre/vente/editer" )
public class EditerOeuvreVente extends HttpServlet {

    public static final String ATT_OEUVREVENTE = "oeuvrevente";
    public static final String ATT_FORM = "form";
    public static final String SESSION_PROPRIETAIRES = "proprietaires";

    public EditerOeuvreVente() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ProprietaireService proprietaireService = new ProprietaireService();

        int idOeuvreVente = Integer.parseInt(req.getParameter("id"));
        OeuvreVenteService oeuvreVenteService= new OeuvreVenteService();

        Oeuvrevente oeuvrevente = null;
        try {
            List<Proprietaire> listProprietaires = proprietaireService.consulterListeProprietaire();
            HashMap<String, Proprietaire> proprietaires = new HashMap<String, Proprietaire>();
            for (final Proprietaire p:listProprietaires) {
                proprietaires.put( Integer.toString(p.getIdProprietaire()), p );
            }
            session.setAttribute( SESSION_PROPRIETAIRES, proprietaires );
            oeuvrevente = oeuvreVenteService.consulterOeuvreVente(idOeuvreVente);
        } catch (MonException e) {
            e.printStackTrace();
        }

        req.setAttribute(ATT_OEUVREVENTE, oeuvrevente);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/editerOeuvreVente.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idOeuvreVente = Integer.parseInt(req.getParameter("id"));
        OeuvreVenteForm form = new OeuvreVenteForm();

        Oeuvrevente oeuvrevente = form.ajouterOeuvreVente(req, idOeuvreVente);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_OEUVREVENTE, oeuvrevente);

        resp.sendRedirect("/oeuvre/vente");
    }
}
