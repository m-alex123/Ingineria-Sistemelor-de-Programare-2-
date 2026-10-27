<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab 3 - Servlets</title>
</head>
<body>
    <h2>Counter Servlet Links & Forms</h2>

    <h3>GET Requests</h3>
    <a href="CounterServlet?inc=1">CounterServlet GET (inc=1)</a><br>
    <a href="CounterServlet?dec=1">CounterServlet GET (dec=1)</a><br>
    <a href="CounterServlet?inc=3">CounterServlet GET (inc=3)</a><br>
    <a href="CounterServlet?dec=3">CounterServlet GET (dec=3)</a><br>

    <br><hr><br>

    <h3>POST Request</h3>
    <form action="CounterServlet" method="POST">
        inc: <input type="text" name="inc" value="1"><br><br>
        dec: <input type="text" name="dec" value="1"><br><br>
        <input type="submit" value="CounterServlet POST">
    </form>
</body>
</html>