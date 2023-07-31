package ru.javaee.tutorial;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCookiesServlet", value = "/get-cookies")
public class GetCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");

        for (Cookie cookie : cookies)
            pw.println("<h3>" + cookie.getName() +
                    " : " + cookie.getValue() + "</h3>");

        pw.println("</body></html>");
    }

    public void destroy() {
    }

    public void init() {
    }
}
