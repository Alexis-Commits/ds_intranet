<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 29/12/19
  Time: 5:18 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

    <title>Edit user </title>
</head>
<body>
<modelAttribute hidden>userProfile</modelAttribute>

<h1>
    <a href="/admin/users-manager">Users Manager</a>
    <a href="/admin/create-user">Create User</a>
    <a href="/login">Logout</a>
</h1>


<%--filled form--%>
    <div class="formedit">
        <form:form action="#" form:action="/users-manager/edit" method="post" >
            <label class="form-label">Username</label><br/>
            <input type="text" name="username" value="<c:out value="${userProfile.username}" />" readonly /> <br/>

            <label class="form-label">Password<br/>(If you don't want to change password let it empty ) </label><br/>
            <input type="text" name="password"  value="<c:out value="${userProfile.password}" />"/><br/>

            <label class="form-label">Enabled ( 0 or 1 )</label><br/>
            <input type="text" name="enabled" value="<c:out value="${userProfile.enabled}" />"/><br/>

            <label class="form-label">Role</label><br/>
            <input type="text" name="authority" value="<c:out value="${userProfile.authority}" />"/><br/>


            <button class="btn btn-success" type="submit">Edit-User</button>
        </form:form>


    </div>
<br/>
<br/>
    <div class="deleteform">

        <form:form action="#" form:action="/users-manager/delete" method="post" >
            <input type="text" name="username" value="<c:out value="${userProfile.username}" />" readonly  hidden/>
            <input type="text" name="password"  value="<c:out value="${userProfile.password}" />" hidden />
            <input type="text" name="enabled" value="<c:out value="${userProfile.enabled}" />" hidden />
            <input type="text" name="authority" value="<c:out value="${userProfile.authority}" />" hidden />
            <div class="delete-section">Delete user : ${userProfile.username} </div>
            <button class="btn btn-danger" type="submit">Delete</button>
        </form:form>


    </div>

<br/>
<br/>   <br/>
<br/>   <br/>
<br/>
</body>

<style>
    body{
        text-align: center;
    }

   .formedit , .deleteform{
       display: inline;
   }
    .delete-section{
        font-size: large;
        color:red;
    }
    a{
        color:rebeccapurple;
        font-size: 50px;
        margin-left: 20px;
    }
</style>
