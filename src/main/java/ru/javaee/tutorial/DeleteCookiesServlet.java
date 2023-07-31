package ru.javaee.tutorial;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "DeleteCookiesServlet", value = "/delete-cookies")
public class DeleteCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("some_id", "");

        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public void destroy() {
    }

    public void init() {
    }
}
