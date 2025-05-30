package com.servlet;

import com.dao.ReservationDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/DeleteReservationServlet")
public class DeleteReservationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("reservationID"));
            ReservationDAO dao = new ReservationDAO();
            dao.deleteReservation(id);
            response.sendRedirect("reservationdisplay.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("reservationdelete.jsp?error=Error deleting reservation");
        }
    }
}
