<%@ page import="java.util.*,com.model.Reservation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
%>
<html>
<head><title>All Reservations</title></head>
<body>
<h2>All Reservations</h2>
<a href="reservationadd.jsp">Add New Reservation</a><br><br>
<table border="1">
    <tr>
        <th>ID</th><th>Customer Name</th><th>Room Number</th><th>Check-In</th><th>Check-Out</th><th>Total Amount</th><th>Actions</th>
    </tr>
    <%
        if (reservations != null) {
            for (Reservation r : reservations) {
    %>
    <tr>
        <td><%= r.getReservationID() %></td>
        <td><%= r.getCustomerName() %></td>
        <td><%= r.getRoomNumber() %></td>
        <td><%= r.getCheckIn() %></td>
        <td><%= r.getCheckOut() %></td>
        <td><%= r.getTotalAmount() %></td>
        <td>
            <a href="reservationupdate.jsp?reservationID=<%=r.getReservationID()%>">Edit</a> |
            <a href="DeleteReservationServlet?reservationID=<%=r.getReservationID()%>" onclick="return confirm('Are you sure?')">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
