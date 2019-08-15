<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Book List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Book List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Book Id</th>
            <th>Book Name</th>
            <th>Author</th>
            <th>Publish Date</th>
            <th>Book Price</th>
        </tr>
        <c:forEach  items="${bookList}" var ="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.publishDate}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>