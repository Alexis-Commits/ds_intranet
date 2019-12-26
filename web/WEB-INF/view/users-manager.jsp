<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 25/12/19
  Time: 4:36 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

<head>
    <title>Users Manager</title>
</head>
<body>
<div>
<table class="table ">
    <thead>
    <tr>
        <th scope="col">USERNAME</th>
        <th scope="col">ENABLED</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.enabled}</td>
        </tr>
    </c:forEach>
    </tbody>


</table>
</div>

</body>

<style>

div{
    width: 100%;
}
.table{
    width: inherit;
}
td{
    text-align: center;
}

</style>
