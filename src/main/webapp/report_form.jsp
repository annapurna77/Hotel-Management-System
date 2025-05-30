<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Generate Report</title>
</head>
<body>
    <h2>Generate Report</h2>
    
    <form action="ReportServlet" method="post">
        <label for="reportType">Select Report Type:</label>
        <select id="reportType" name="reportType" required>
            <option value="">--Select--</option>
            <option value="dateRange">Reservations in Date Range</option>
            <option value="revenue">Total Revenue</option>
        </select>
        <br/><br/>
        
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required />
        <br/><br/>
        
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required />
        <br/><br/>
        
        <input type="submit" value="Generate Report" />
    </form>

    <br/>
    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
        <p style="color:red;"><b><%= error %></b></p>
    <% } %>

    <a href="index.jsp">Back to Home</a>
</body>
</html>
