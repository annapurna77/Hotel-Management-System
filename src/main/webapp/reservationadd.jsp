<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Add Reservation</title></head>
<body>
<h2>Add Reservation</h2>
<form action="AddReservationServlet" method="post">
    Reservation ID: <input type="number" name="reservationID" required><br>
    Customer Name: <input type="text" name="customerName" required><br>
    Room Number: <input type="text" name="roomNumber" required><br>
    Check-In Date: <input type="date" name="checkIn" required><br>
    Check-Out Date: <input type="date" name="checkOut" required><br>
    Total Amount: <input type="number" step="0.01" name="totalAmount" required><br>
    <input type="submit" value="Add Reservation">
</form>
<c:if test="${not empty param.error}">
    <p style="color:red">${param.error}</p>
</c:if>
<a href="reservationdisplay.jsp">View All Reservations</a>
</body>
</html>
