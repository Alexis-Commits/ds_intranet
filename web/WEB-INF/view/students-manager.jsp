<%@ page import="hua.objects.StudentHousing" %><%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 30/12/19
  Time: 7:46 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

    <title>Students manager</title>
</head>
<body>
<a href="/students">Back</a>

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">FIRST NAME</th>
        <th scope="col">LAST NAME</th>
        <th scope="col">EMAIL</th>
        <th scope="col">DATE STARTED</th>
        <th scope="col">DEPARTMENT</th>
        <th scope="col">ADDRESS</th>
        <th scope="col">PHONE NUMBER</th>
        <th scope="col">Enable student's housing request</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}" varStatus="status" >
        <tr>
            <td>${student.id}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.dateStarted}</td>
            <td>${student.department}</td>
            <td>${student.address}</td>
            <td>${student.phoneNumber}</td>

            <c:set var="enabled" scope="session" value="${helper.isEnabled(studentsEnabled , student.id)}"/>
            <c:if test="${enabled}">
                <td>Already enabled</td>
            </c:if>
            <c:if test="${ not enabled}" >
                <td><a href="/students/students-manager/enable/${student.id}" >Enable</a> </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>


</table>



</body>

<style>
    a{
        text-align: center;
        font-size: x-large;
        color: black;
    }
</style>