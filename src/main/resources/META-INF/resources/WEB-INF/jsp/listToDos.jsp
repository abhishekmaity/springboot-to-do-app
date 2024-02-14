<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

        <title>List ToDos Page</title>
    </head>
    <body>
        <div class="container">
            <div>       
                Welcome to home !
            </div>
            <h1>List of ToDos</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done ?</th>
                        <th></th>
                    </tr>
                </thead>
            <tbody>
                <c:forEach items="${todos}" var="todos">
                    <tr>
                        <td>${todos.id}</td>
                        <td>${todos.description}</td>
                        <td>${todos.targetDate}</td>
                        <td>${todos.done}</td>
                        <td><a href="delete-todo?id=${todos.id}" class="btn btn-warning">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todos" class="btn btn-success">Add ToDo</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>

    </body>
</html>