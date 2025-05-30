package com.servlet;

import com.dao.ReservationDAO;
import com.model.Reservation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/AddReservationServlet")
public class AddReservationServlet extends HttpServlet {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("reservationID"));
            String customerName = request.getParameter("customerName");
            String roomNumber = request.getParameter("roomNumber");
            java.util.Date checkIn = sdf.parse(request.getParameter("checkIn"));
            java.util.Date checkOut = sdf.parse(request.getParameter("checkOut"));
            double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));

            Reservation res = new Reservation();
            res.setReservationID(id);
            res.setCustomerName(customerName);
            res.setRoomNumber(roomNumber);
            res.setCheckIn(checkIn);
            res.setCheckOut(checkOut);
            res.setTotalAmount(totalAmount);

            ReservationDAO dao = new ReservationDAO();
            dao.addReservation(res);

            response.sendRedirect("reservationdisplay.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("reservationadd.jsp?error=Invalid Input");
        }
    }
}
