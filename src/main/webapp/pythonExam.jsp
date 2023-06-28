<%@ page import="com.example.text.PythonEntity" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Python Exam</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .question {
            margin-bottom: 20px;
        }

        .question p {
            font-weight: bold;
        }

        .question ul {
            list-style-type: none;
            padding: 0;
        }

        .question ul li {
            margin-bottom: 10px;
        }

        .timer {
            text-align: right;
            margin-bottom: 20px;
        }

        .timer-box {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border-radius: 5px;
        }

        .timer-label {
            font-size: 14px;
            font-weight: bold;
            color: #fff;
        }

        .timer-value {
            font-size: 24px;
            font-weight: bold;
            color: #fff;
            margin-top: 5px;
        }

        button[type="submit"] {
            display: block;
            margin: 0 auto;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        var remainingTime = ${remainingTime}; // Get the remaining time from the server

        function startTimer() {
            var timerElement = document.getElementById("timer");

            // Update the timer every second
            var timerInterval = setInterval(function() {
                var minutes = Math.floor(remainingTime / 60000);
                var seconds = Math.floor((remainingTime % 60000) / 1000);

                // Display the remaining time
                timerElement.innerHTML = ("0" + minutes).slice(-2) + ":" + ("0" + seconds).slice(-2);

                // Decrease the remaining time by 1 second
                remainingTime -= 1000;

                // Check if the timer has expired
                if (remainingTime <= 0) {
                    clearInterval(timerInterval);

                    // Perform necessary actions (e.g., submit the exam)
                    document.getElementById("examForm").submit();
                }
            }, 1000);
        }

        window.onload = function() {
            startTimer(); // Start the timer
        };
    </script>
</head>
<body>
<div class="container">
    <h2>Python Exam</h2>
    <div class="timer">
        <div class="timer-box">
            <span class="timer-label">Remaining Time:</span>
            <div id="timer" class="timer-value"></div>
        </div>
    </div>
    <form id="examForm" action="submitExamPython" method="post" enctype="application/x-www-form-urlencoded">
        <% for (PythonEntity question : (List<PythonEntity>) request.getAttribute("pythonQuestions")) { %>
        <div class="question">
            <pre><%= question.getQuestion() %></pre>
            <ul>
                <li><input type="radio" name="<%= question.getId() %>" value="A"> <%= question.getOption1() %></li>
                <li><input type="radio" name="<%= question.getId() %>" value="B"> <%= question.getOption2() %></li>
                <li><input type="radio" name="<%= question.getId() %>" value="C"> <%= question.getOption3() %></li>
                <li><input type="radio" name="<%= question.getId() %>" value="D"> <%= question.getOption4() %></li>
            </ul>
        </div>
        <% } %>
        <input type="hidden" name="examTopic" value="${examTopic}">
        <input type="hidden" name="username" value="${username}">
        <button class="submit-button" type="submit">Submit Exam</button>
    </form>
</div>
</body>
</html>
