<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>List ToDos Page</title>
    </head>
    <body>
        <div>       
             Welcome to home !
        </div>
        <div>
            Hello ${name}. Your todos are 
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