<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 27/12/19
  Time: 5:53 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

    <title>Create a new user </title>
</head>
<body>
<h1>
    <a href="/users-manager">Users Manager</a>
    <a href="/create-user">Create User</a>
    <a href="/login">Logout</a>
</h1>
<br/>
<br/>
<h1>Create a new user </h1><br/>
<h2>Fill the form </h2><br/>

<form:form action="#" form:action="/create-user/create" method="post" >
    <modelAttribute hidden>userProfile</modelAttribute>
    <label class="form-label">Username</label>
    <input type="text" name="username"/><br/>

    <label class="form-label">Password</label>
    <input type="password" name="password"/><br/>

    <label class="form-label">Role</label>
    <input type="text" name="authority"/><br/>


    <button class="btn btn-success" type="submit">Create user</button>
</form:form>

</body>
<style>
    a{
        color:rebeccapurple;
        font-size: 50px;
        margin-left: 20px;
    }
</style>

