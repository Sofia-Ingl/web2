package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IncFilter implements Filter {

    private Lock locker;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        locker = new ReentrantLock();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fChain) throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) req;
        Enumeration<String> headers = httpReq.getHeaderNames();

        while (headers.hasMoreElements()) {

            String header = headers.nextElement();
            if (header.equals("X-Inc-Counter")) {

                ServletContext context = httpReq.getServletContext();
                locker.lock();
                double counter = (context.getAttribute("counter") == null) ? 0 : (double) context.getAttribute("counter");
                double valToAdd = Double.parseDouble(httpReq.getHeader(header));
                counter += valToAdd;
                context.setAttribute("counter", counter);
                System.out.println(String.valueOf(context.getAttribute("counter")));
                locker.unlock();
                break;

            }


        }

        fChain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}
