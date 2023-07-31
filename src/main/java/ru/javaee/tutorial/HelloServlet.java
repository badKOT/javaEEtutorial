package ru.javaee.tutorial;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-world")
public class HelloServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        if (cart == null) {
            cart = new Cart();
            cart.setName(name);
            cart.setQuantity(quantity);
        }
        session.setAttribute("cart", cart);

        try {
            getServletContext().getRequestDispatcher("showCart.jsp")
                            .forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello!</h1>");
        out.println("</body></html>");

//        Redirect
//        response.sendRedirect("https://www.google.com");

//        Forward
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void destroy() {
    }
}