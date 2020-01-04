<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 4/1/20
  Time: 8:43 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

    <title>Students Requests</title>
</head>
<body>

<a href="/students">Back</a>

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">INCOME</th>
        <th scope="col">BROTHERS STUDYING</th>
        <th scope="col">IS FROM ANOTHER CITY</th>
        <th scope="col">SEMESTER</th>
        <th scope="col">HOUSING YEARS</th>
        <th scope="col">DEPARTMENT</th>
        <th scope="col">ACCEPT THE REQUEST</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="request" items="${requests}" varStatus="status" >
        <tr>
            <td>${request.id}</td>
            <td>${request.income}</td>
            <td>${request.brothers}</td>
            <td>${request.fromAnotherCity}</td>
            <td>${request.semester}</td>
            <td>${request.housingYears}</td>
            <td>${request.department}</td>

            <c:set var="enabled" scope="session" value="${helper.isAccepted(scores ,request.id)}"/>
            <c:if test="${enabled}">
                <td>Already accepted</td>
            </c:if>
            <c:if test="${ not enabled}" >
                <td><a href="/students/students-requests/accept/${request.id}" >Accept</a> </td>
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