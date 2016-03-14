package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import form.AdherentForm;
import metier.Adherent;

@WebServlet("/adherent/ajouter" )
public class AjouterAdherent extends HttpServlet {

    public static final String ATT_ADHERENT = "adherent";
    public static final String ATT_FORM = "form";

    public AjouterAdherent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ajouterAdherent.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdherentForm form = new AdherentForm();

        Adherent adherent = form.ajouterAdherent(req, -1);

        req.setAttribute(ATT_FORM, form);
        req.setAttribute(ATT_ADHERENT, adherent);

        if(form.getErreurs().isEmpty()) {
            resp.sendRedirect("/adherent/");
        }
        else
            this.getServletContext().getRequestDispatcher( "/WEB-INF/ajouterAdherent.jsp" ).forward(req, resp);
    }
}
