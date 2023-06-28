<!DOCTYPE html>
<html>
<head>
    <title>Exam Result</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .result {
            margin-bottom: 20px;
        }

        .result p {
            margin-bottom: 10px;
        }

        .result p:first-child {
            font-weight: bold;
            color: #333;
            font-size: 20px;
        }

        .result p:last-child {
            font-size: 18px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">Exam Result</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <h2>Exam Result</h2>
        <div class="result">
            <p class="lead">Total Marks: ${totalMarks}</p>
            <p class="lead">Total Questions: ${totalQuestions}</p>
            <p class="lead">Percentage: ${percentage}%</p>
            <p class="lead">Note on Pass or Fail: ${pass}</p>
        </div>
    </div>

    <footer class="bg-light text-center py-3">
        <p>&copy; 2023 Exam Systm. All Rights Reserved.</p>
    </footer>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
