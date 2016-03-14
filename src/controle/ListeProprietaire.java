package controle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.ProprietaireService;
import meserreurs.*;

@WebServlet("/proprietaire/" )
public class ListeProprietaire extends HttpServlet {

    public ListeProprietaire() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProprietaireService proprietaireService = new ProprietaireService();
        try {
            req.setAttribute("proprietaires", proprietaireService.consulterListeProprietaire());
        } catch (MonException e) {
            e.printStackTrace();
        }

        System.out.print(req.getAttribute("message"));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/listeProprietaire.jsp");
        dispatcher.forward(req, resp);
    }
}
