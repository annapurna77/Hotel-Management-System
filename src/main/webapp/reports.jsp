<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Generate Reports</title></head>
<body>
<h2>Reports</h2>
<form action="ReportServlet" method="post">
    Report Type:
    <select name="reportType" required>
        <option value="">--Select--</option>
        <option value="dateRange">Reservations in Date Range</option>
        <option value="revenue">Total Revenue</option>
    </select><br><br>

    Start Date: <input type="date" name="startDate" required><br><br>
    End Date: <input type="date" name="endDate" required><br><br>

    <input type="submit" value="Generate Report">
</form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
