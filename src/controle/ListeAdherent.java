package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import dao.AdherentService;
import form.AdherentForm;
import meserreurs.*;

@WebServlet("/adherent/" )
public class ListeAdherent extends HttpServlet {

    public ListeAdherent() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdherentService adherentService = new AdherentService();
        try {
            req.setAttribute("adherents", adherentService.consulterListeAdherents());
        } catch (MonException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/listeAdherent.jsp");
        dispatcher.forward(req, resp);
    }

}
