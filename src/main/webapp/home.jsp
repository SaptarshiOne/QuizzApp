<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group select {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .form-group .start-button {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-group .start-button:hover {
            background-color: #45a049;
        }

        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #999;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mt-3">Dashboard</h2>
        <p>WELCOME! ${username}</p>

        <!-- Display subject and respective marks -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Subject</th>
                    <th>Marks Obtained</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${results}">
                    <tr>
                        <td>${subject}</td>
                        <td>${marksObtained}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="startExam" method="post">
            <div class="form-group">
                <label for="examTopic">Exam Topic:</label>
                <select id="examTopic" name="examTopic" class="form-control">
                    <option value="JAVA">JAVA</option>
                    <option value="PYTHON">PYTHON</option>
                </select>
            </div>
            <input type="hidden" name="username" value="${username}">
            <div class="form-group">
                <button class="start-button btn btn-primary" type="submit">Start Test</button>
            </div>
        </form>
    </div>
    <footer class="footer">
        &copy; 2023 Exam System. All rights reserved. &trade;
    </footer>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
