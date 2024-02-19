<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

        <div class="container">
            <div>       
                Welcome to home !
            </div>
            <h1>List of ToDos</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done ?</th>
                        <th></th>
                        <th></th>

                    </tr>
                </thead>
            <tbody>
                <c:forEach items="${todos}" var="todos">
                    <tr>
                        <td>${todos.description}</td>
                        <td>${todos.targetDate}</td>
                        <td>${todos.done}</td>
                        <td><a href="update-todo?id=${todos.id}" class="btn btn-warning">Update</a></td>
                        <td><a href="delete-todo?id=${todos.id}" class="btn btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todos" class="btn btn-success">Add ToDo</a>
    </div>
<%@ include file="common/footer.jspf" %>