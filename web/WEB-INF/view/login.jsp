<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 25/12/19
  Time: 4:31 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

    <title>Login</title>
</head>
<body>


<h3>Login Page</h3>

<div class="form-group">

    <form:form action="${pageContext.request.contextPath}/authUser" method="POST">
    <c:if test="${param.error != null}">
        <i>Sorry! Invalid username/password!</i>
    </c:if><br/>
    <label class="form-label">Username</label>
    <input type="text" name="username"/><br/>
    <label class="form-label">Password</label>
    <input type="password" name="password"/><br/>
    <button class="btn btn-success" type="submit">Login</button>
</div>
</form:form>

</div>

</body>

<style>
    h3{
        text-align: center;
        color: blueviolet;
        font-size: 100px;
    }
    div{
        height:auto;
        margin:0 auto;
    }

    form{
        width:50%;
        margin:0 auto;
    }
    i{
        color: red;
    }
    footer{
        color : coral;

    }

</style>