package servlets;

import beans.EntryBean;
import beans.EntryBeansContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class AreaCheckServlet extends HttpServlet {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
    private final Locale timeFormatLocale = new Locale("en", "En");
    private final ArrayList<Double> rVals = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        rVals.add(1.0);
        rVals.add(2.0);
        rVals.add(3.0);
        rVals.add(4.0);
        rVals.add(5.0);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Lol kek cheburek");

        //LocalDateTime start = LocalDateTime.now();
        long start = System.nanoTime();

        try {

            double x = Double.parseDouble(req.getParameter("x").replace(",", "."));
            double y = Double.parseDouble(req.getParameter("y").replace(",", "."));
            double r = Double.parseDouble(req.getParameter("r").replace(",", "."));
            if (validateValues(x, y, r)) {
                boolean isHit = checkData(x, y, r);
                String currTime = LocalDateTime.now().format(formatter);
                //String execTime = String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC));
                String execTime = String.format(timeFormatLocale, "%.7f", (System.nanoTime() - start) * Math.pow(10, -9));
                System.out.println(execTime);

                EntryBean entry = new EntryBean(x, y, r, currTime, execTime, isHit);
                EntryBeansContainer tableRows = (EntryBeansContainer) req.getSession().getAttribute("tableRows");
                if (tableRows == null) {
                    tableRows = new EntryBeansContainer();
                    req.getSession().setAttribute("tableRows", tableRows);
                }
                tableRows.getEntryBeansContainer().add(entry);

                System.out.println("Size: " + tableRows.getEntryBeansContainer().size());
                for (EntryBean e :
                        tableRows.getEntryBeansContainer()) {
                    System.out.println(e);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Inappropriate num");
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private boolean checkData(double x, double y, double r) {
        return checkRectangle(x, y, r) || checkTriangle(x, y, r) || checkCircle(x, y, r);
    }

    private boolean checkRectangle(double x, double y, double r) {
        return x >= 0 && y >= 0 && y <= r && x <= r / 2;
    }

    private boolean checkTriangle(double x, double y, double r) {
        return x <= 0 && y <= 0 && y >= -x - 1;
    }

    private boolean checkCircle(double x, double y, double r) {
        return x <= 0 && y >= 0 && x * x + y * y <= r * r;
    }

    private boolean validateValues(double x, double y, double r) {
        boolean areNumbers = !Double.isNaN(x) && !Double.isNaN(y) && !Double.isNaN(r);
        boolean inLimits = areNumbers && x<=5 && x>=-3 && y<=5 && y>=-3 && rVals.contains(r);
        return inLimits;
    }
}
