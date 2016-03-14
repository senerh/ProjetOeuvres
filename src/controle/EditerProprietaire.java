package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProprietaireService;
import form.ProprietaireForm;
import meserreurs.MonException;
import metier.Proprietaire;

@WebServlet("/proprietaire/editer" )
public class EditerProprietaire extends HttpServlet {

    public static final String ATT_PROPRIETAIRE = "proprietaire";
    public static final String ATT_FORM = "form";

    public EditerProprietaire() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProprietaire = Integer.parseInt(req.getParameter("id"));
        ProprietaireService proprietaireService= new ProprietaireService();

        Proprietaire proprietaire = null;
        try {
            proprietaire = proprietaireService.consulterProprietaire(idProprietaire);
        } catch (MonException e) {
            e.printStackTrace();
        }

        req.setAttribute(ATT_PROPRIETAIRE, proprietaire);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/editerProprietaire.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idProprietaire = Integer.parseInt(req.getParameter("id"));
        ProprietaireForm form = new ProprietaireForm();

        Proprietaire proprietaire = form.editerProprietaire(req, idProprietaire);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_PROPRIETAIRE, proprietaire);

        resp.sendRedirect("../proprietaire/");
    }
}
