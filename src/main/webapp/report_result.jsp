<%@ page import="java.util.*,com.model.Reservation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Report Results</title></head>
<body>
<h2>Report Results</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<%
    List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
    Double revenue = (Double) request.getAttribute("revenue");

    if (reservations != null) {
%>
    <table border="1">
        <tr><th>ID</th><th>Customer</th><th>Room</th><th>Check-In</th><th>Check-Out</th><th>Total Amount</th></tr>
        <%
            for (Reservation r : reservations) {
        %>
        <tr>
            <td><%= r.getReservationID() %></td>
            <td><%= r.getCustomerName() %></td>
            <td><%= r.getRoomNumber() %></td>
            <td><%= r.getCheckIn() %></td>
            <td><%= r.getCheckOut() %></td>
            <td><%= r.getTotalAmount() %></td>
        </tr>
        <%
            }
        %>
    </table>
<%
    } else if (revenue != null) {
%>
    <h3>Total Revenue: $<%= String.format("%.2f", revenue) %></h3>
<%
    }
%>

<a href="reports.jsp">Back to Reports</a>
</body>
</html>
