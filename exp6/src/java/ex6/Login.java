/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ex6;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Login extends HttpServlet {

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
            String username = request.getParameter("username");
            String pswd = request.getParameter("password");
            String password = "";

            try {
                Connection conn = DBConn.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("select * from ajt.person where name=?");
                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    password = rs.getString("password");
                    if (pswd.equals(password)) {
                        PersonBean st = new PersonBean();
                        st.setName(rs.getString("name"));
                        st.setAge(rs.getInt("age"));
                        st.setHight(rs.getInt("height"));

                        HttpSession hs = request.getSession();
                        hs.setAttribute("st", st);

                        RequestDispatcher rd = request.getRequestDispatcher("second.jsp");
                        rd.forward(request, response);
                    } else {
                        out.println("<h1 align='center' style='color:red;'>Incorrect Password!</h1>");
                    }
                } else {
                    out.println("<h1 align='center' style='color:red;'>User not Found! Try again.</h1>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

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

