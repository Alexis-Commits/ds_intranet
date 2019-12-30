<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 25/12/19
  Time: 4:36 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

    <title>Users Manager</title>
</head>
<body>

<h1>
    <a class= "mena" href="/users-manager">Users Manager</a>
    <a class="mena" href="/create-user">Create User</a>
    <a class="mena" href="/login">Logout</a>
</h1>
<br/>
<br/>
<br/>


<div>
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">USERNAME</th>
        <th scope="col">ENABLED</th>
        <th scope="col">#</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.enabled}</td>
            <td><a href="/users-manager/${user.name}" >Edit</a> </td>
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

a{
    color:white;
}

.mena{
    color:rebeccapurple;
    font-size: 50px;
    margin-left: 20px;
}
</style>
