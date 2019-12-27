<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 27/12/19
  Time: 5:53 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

<head>
    <title>Create a new user </title>
</head>
<body>
<form:form action="#" form:action="/create-user/create" method="post" >
    <modelAttribute>userProfile</modelAttribute>
    <label class="form-label">Username</label>
    <input type="text" name="username"/><br/>

    <label class="form-label">Password</label>
    <input type="password" name="password"/><br/>

    <label class="form-label">Role</label>
    <input type="text" name="authority"/><br/>


    <button class="btn" type="submit">Create user</button>
</form:form>

</body>

