package com.servlet;

import com.dao.ReservationDAO;
import com.model.Reservation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportType = request.getParameter("reportType");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        if (reportType == null || startDateStr == null || endDateStr == null) {
            request.setAttribute("error", "Please select report type and provide start & end dates.");
            request.getRequestDispatcher("report_result.jsp").forward(request, response);
            return;
        }

        try {
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);
            ReservationDAO dao = new ReservationDAO();

            if ("dateRange".equals(reportType)) {
                List<Reservation> reservations = dao.getReservationsBetweenDates(startDate, endDate);
                request.setAttribute("reservations", reservations);
            } else if ("revenue".equals(reportType)) {
                double revenue = dao.getTotalRevenue(startDate, endDate);
                request.setAttribute("revenue", revenue);
            } else {
                request.setAttribute("error", "Invalid report type selected.");
            }
            request.getRequestDispatcher("report_result.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error generating report.");
            request.getRequestDispatcher("report_result.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
