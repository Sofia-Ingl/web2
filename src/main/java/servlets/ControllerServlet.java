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
        System.out.println("Wow I am here");
        Map<String, String[]> params = req.getParameterMap();
        for (String s:
             params.keySet()) {
            System.out.println(s + ": ");
            for (String val:
                    params.get(s)) {
                System.out.println(val);
            }
        }
        if (params.containsKey("clear") && params.get("clear")[0].equals("true")) {
            getServletContext().getNamedDispatcher("ClearSessionServlet").forward(req, resp);
        } else {
            if (req.getParameter("x") != null && req.getParameter("y") != null && req.getParameter("r") != null) {
                getServletContext().getNamedDispatcher("AreaCheckServlet").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }
}
