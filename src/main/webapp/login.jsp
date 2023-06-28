<!DOCTYPE html>
<html>
<head>
    <title>Student Authentication Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
            margin-bottom: 20px;
            color: #333;
        }
        
        .form-group label {
            font-weight: bold;
        }
        
        .form-group input[type="text"],
        .form-group input[type="password"] {
            font-size: 16px;
            border-radius: 5px;
        }
        
        .form-group input[type="submit"] {
            font-size: 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Exam System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-4">
        <h2 class="text-center">Student Authentication Page</h2>
        <form action="home" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Login" class="btn btn-primary btn-block">
            </div>
        </form>
    </div>

    <footer class="mt-5 py-3 text-center bg-light">
        <p>All Rights Reserved &copy; 2023 Exam System</p>
    </footer>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
