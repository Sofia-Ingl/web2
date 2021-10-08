package servlets;

import beans.EntryBeansContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Clear!!!");
        EntryBeansContainer tableRows = (EntryBeansContainer) req.getSession().getAttribute("tableRows");
        if (tableRows!=null) {
            tableRows.getEntryBeansContainer().clear();
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
