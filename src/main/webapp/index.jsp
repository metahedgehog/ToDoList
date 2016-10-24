<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page</title>
</head>
<body>
<h2>What should i do?</h2>
<c:set var="taskList" value="${sessionScope.get(\"taskList\")}" scope="page"/>
<c:choose>
    <c:when test="${fn:length(taskList) == 0}">
        <h3>There are no tasks.</h3>
    </c:when>
    <c:otherwise>
        <table class="center">
            <tr>
                <th>Name</th>
                <th class="smaller">Category</th>
                <th class="smaller">Completed</th>
            </tr>
                <form action="todo" method="get">
                <c:forEach var="task" items="${taskList}">
                <tr>
                    <td><c:out value="${task.taskName}"/></td>
                    <td><c:out value="${task.taskCategory}"/></td>
                    <td><input type="checkbox" name="completed" value="${task.taskName}"></td>
                </tr>
                </c:forEach>
        </table>
        <td align="right" colspan="3"><input type="submit" class="button" value="Update Tasks"/></td>
        </form>
    </c:otherwise>
</c:choose>
<form action="todo" method="POST">
    <table class="center">
        <tr bgcolor="#949494">
            <th>Task</th>
            <td><input type="text" name="taskName"></td>
        </tr>
        <tr bgcolor="#99999">
            <th>Category</th>
            <td><input type="text" name="taskCategory"></td>
        </tr>
        <input type="submit" class="button" id="2" value="Add Task"/>
    </table>
</form>

</body>
</html>