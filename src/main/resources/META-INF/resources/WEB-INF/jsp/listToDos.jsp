<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>

        <title>List ToDos Page</title>
    </head>
    <body>
        <div>       
             Welcome to home !
        </div>
        <div>
            Hello ${name}.
        </div>
        <hr>
        <h1>List of ToDos</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done ?</th>
                </tr>
            </thead>
        <tbody>
            <c:forEach items="${todos}" var="todos">
                <tr>
                    <td>${todos.id}</td>
                    <td>${todos.description}</td>
                    <td>${todos.targetDate}</td>
                    <td>${todos.done}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>