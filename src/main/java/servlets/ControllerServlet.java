package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> params = req.getParameterMap();

        if (params.containsKey("clear") && params.get("clear")[0].equals("true")) {
            getServletContext().getNamedDispatcher("ClearSessionServlet").forward(req, resp);
        } else {
            if ((params.get("graph") != null && params.get("graph")[0].equals("true") && params.get("graphY") != null || params.get("y") != null) && params.get("x") != null && params.get("r") != null) {

                getServletContext().getNamedDispatcher("AreaCheckServlet").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }
}
