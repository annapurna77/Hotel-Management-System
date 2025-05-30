<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Reservation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f7f7f7;
        }
        h2 {
            color: #333;
        }
        form {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            width: 400px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        input[type="text"], input[type="date"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Update Reservation</h2>
    <form action="UpdateReservationServlet" method="post">
        <label for="reservationID">Reservation ID:</label>
        <input type="number" name="reservationID" id="reservationID" required>

        <label for="customerName">Customer Name:</label>
        <input type="text" name="customerName" id="customerName" required>

        <label for="roomNumber">Room Number:</label>
        <input type="text" name="roomNumber" id="roomNumber" required>

        <label for="checkIn">Check-In Date:</label>
        <input type="date" name="checkIn" id="checkIn" required>

        <label for="checkOut">Check-Out Date:</label>
        <input type="date" name="checkOut" id="checkOut" required>

        <label for="totalAmount">Total Amount:</label>
        <input type="number" step="0.01" name="totalAmount" id="totalAmount" required>

        <input type="submit" value="Update Reservation">
    </form>
</body>
</html>
