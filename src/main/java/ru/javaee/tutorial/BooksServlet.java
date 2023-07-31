package ru.javaee.tutorial;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "BooksServlet", value = "/books")
public class BooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/javaee_db",
                            "postgres", "postgres");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select title from books");

            while(rs.next())
                pw.println(rs.getString("title"));

            st.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }

    public void init() {
    }
}
