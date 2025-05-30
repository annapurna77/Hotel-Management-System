<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Reservation</title>
</head>
<body>
    <h2>Delete Reservation</h2>
    
    <form action="DeleteReservationServlet" method="post">
        <label for="reservationID">Reservation ID:</label>
        <input type="number" id="reservationID" name="reservationID" required />
        <br/><br/>
        <input type="submit" value="Delete Reservation" />
    </form>

    <br/>
    <% 
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p><b><%= message %></b></p>
    <% } %>

    <a href="index.jsp">Back to Home</a>
</body>
</html>
