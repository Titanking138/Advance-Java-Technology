/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author arjun
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String dbDriver = "org.postgresql.Driver";
            String dbURL = "jdbc:postgresql://localhost:5432/postgres";
            // Database name to access

            String dbUsername = "postgres";
            String dbPassword = "shree9592";

            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            PreparedStatement ps = con.prepareStatement("select * from ajt.students where userid=?");
            ps.setInt(1, Integer.parseInt(request.getParameter("userId")));
            ResultSet rs = ps.executeQuery();
            System.out.println("Result set");

            if (rs.next()) {
//                System.out.println("NewServlet.processRequest()");
                out.println("<h2>Data Found!</h2>");
            } else {

                String pass = request.getParameter("password");
                String email = request.getParameter("email");

                if (pass.equals(request.getParameter("password2"))) {

                    if (email.equals(request.getParameter("email2"))) {

                        PreparedStatement st = con.prepareStatement("insert into ajt.students values(?,?,?,?,?,?,?,?,?,?) ");
                        st.setInt(1, Integer.parseInt(request.getParameter("userId")));
                        st.setString(2, request.getParameter("username"));
                        st.setString(3, pass);
                        st.setString(4, request.getParameter("firstName") + " " + request.getParameter("lastName"));
                        st.setString(5, request.getParameter("addr"));
                        st.setInt(6, Integer.parseInt(request.getParameter("rollNo")));
                        st.setInt(7, Integer.parseInt(request.getParameter("sem")));
                        st.setString(8, email);
                        st.setLong(9, Long.parseLong(request.getParameter("contact")));
                        st.setInt(10, Integer.parseInt(request.getParameter("age")));

                        st.executeUpdate();
                        st.close();
                        con.close();

                        out.println("Successfully Inserted");
                        System.out.println("inserted");
                    } else {
                        out.print("Confirm email not match");
                    }

                } else {
                    out.print("Confirm Password Does not Match");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
