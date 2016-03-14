package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import form.ProprietaireForm;
import metier.Proprietaire;

@WebServlet("/proprietaire/ajouter" )
public class AjouterProprietaire extends HttpServlet {

    public static final String ATT_PROPRIETAIRE = "proprietaire";
    public static final String ATT_FORM = "form";

    public AjouterProprietaire() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ajouterProprietaire.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProprietaireForm form = new ProprietaireForm();

        Proprietaire proprietaire = form.ajouterProprietaire(req);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_PROPRIETAIRE, proprietaire);

        if(form.getErreurs().isEmpty()) {
            resp.sendRedirect("/proprietaire/");
        }
        else
            this.getServletContext().getRequestDispatcher( "/WEB-INF/ajouterProprietaire.jsp" ).forward(req, resp);
    }
}
