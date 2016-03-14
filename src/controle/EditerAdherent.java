package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.AdherentService;
import form.AdherentForm;
import meserreurs.MonException;
import metier.Adherent;

@WebServlet("/adherent/editer" )
public class EditerAdherent extends HttpServlet {

    public static final String ATT_ADHERENT = "adherent";
    public static final String ATT_FORM = "form";

    public EditerAdherent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idAdherent = Integer.parseInt(req.getParameter("id"));
        AdherentService adherentService= new AdherentService();

        Adherent adherent = null;
        try {
            adherent = adherentService.consulterAdherent(idAdherent);
        } catch (MonException e) {
            e.printStackTrace();
        }

        req.setAttribute(ATT_ADHERENT, adherent);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/editerAdherent.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idAdherent = Integer.parseInt(req.getParameter("id"));
        AdherentForm form = new AdherentForm();

        Adherent adherent = form.ajouterAdherent(req, idAdherent);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_ADHERENT, adherent);

        resp.sendRedirect("/adherent/");
    }
}
