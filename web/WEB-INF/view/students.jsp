<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: alexis
  Date: 30/12/19
  Time: 7:43 μ.μ.
  To change this template use File | Settings | File Templates.
--%>

    <title>Students index</title>
</head>
<a class ="btn-info" href="/logout">Logout</a><br/><br/><br/>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <a class ="btn-info" href="/admin">Admin tool</a><br/><br/><br/>

    <br/>
</security:authorize>


<body>
<security:authorize access="hasRole('ROLE_DIT')">
    <a class="btn-info" href="/students/students-manager/dit">(dit) Τμήμα Πληροφορικής & Τηλεματικής</a><br/>
    <br/>
</security:authorize><security:authorize access="hasRole('ROLE_DHEE')">
    <a class="btn-info" href="/students/students-manager/dhee">(dhee) Τμήμα Οικιακής Οικονομίας & Οικολογίας</a><br/>
    <br/>
</security:authorize><security:authorize access="hasRole('ROLE_DDNS')">
    <a class="btn-info" href="/students/students-manager/ddns">(ddns) Τμήμα Επιστήμης Διαιτολογίας-Διατροφής</a><br/>
    <br/>
</security:authorize><security:authorize access="hasRole('ROLE_ADMIN')">
    <a  class="btn-info" href="/students/students-manager">Ολοι οι φοιτητές</a><br/>
    <a class="btn-info" href="/students/students-manager/dit">(dit) Τμήμα Πληροφορικής & Τηλεματικής</a><br/>
    <a class="btn-info" href="/students/students-manager/dhee">(dhee) Τμήμα Οικιακής Οικονομίας & Οικολογίας</a><br/>
    <a class="btn-info" href="/students/students-manager/ddns">(ddns) Τμήμα Επιστήμης Διαιτολογίας-Διατροφής</a><br/>


    <br/>
</security:authorize><security:authorize access="hasRole('ROLE_USER')">
    <a  class="btn-info" href="/students/students-manager">Ολοι οι φοιτητές</a><br/>
    <a class="btn-info" href="/students/students-manager/dit">(dit) Τμήμα Πληροφορικής & Τηλεματικής</a><br/>
    <a class="btn-info" href="/students/students-manager/dhee">(dhee) Τμήμα Οικιακής Οικονομίας & Οικολογίας</a><br/>
    <a class="btn-info" href="/students/students-manager/ddns">(ddns) Τμήμα Επιστήμης Διαιτολογίας-Διατροφής</a><br/>    <br/>
</security:authorize>

<br/>
<br/>
<br/>

<security:authorize access="hasRole('ROLE_DIT')">
    <a class="btn-dark"  href="/students/students-requests/dit">Αιτήσεις φοιτητων για στέγαση(DIT)</a><br/>
    <br/>
</security:authorize><security:authorize access="hasRole('ROLE_DDNS')">
    <a class="btn-dark"  href="/students/students-requests/ddns">Αιτήσεις φοιτητων για στέγαση(DDNS)</a><br/>
    <br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_DHEE')">
    <a class="btn-dark"  href="/students/students-requests/dhee">Αιτήσεις φοιτητων για στέγαση(DHEE)</a><br/>
    <br/>
</security:authorize>

<security:authorize access="hasRole('ROLE_USER')">
<a class="btn-dark"  href="/students/students-requests">Αιτήσεις φοιτητων για στέγαση (ΟΛΟΙ)</a><br/>
<a class="btn-dark"  href="/students/students-requests/dit">Αιτήσεις φοιτητων για στέγαση(dit)</a><br/>
<a class="btn-dark" href="/students/students-requests/ddns">Αιτήσεις φοιτητων για στέγαση(ddns)</a><br/>
<a class="btn-dark" href="/students/students-requests/dhee">Αιτήσεις φοιτητων για στέγαση(dhee)</a><br/>
    <br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
<a class="btn-dark"  href="/students/students-requests">Αιτήσεις φοιτητων για στέγαση (ΟΛΟΙ)</a><br/>
<a class="btn-dark"  href="/students/students-requests/dit">Αιτήσεις φοιτητων για στέγαση(dit)</a><br/>
<a class="btn-dark" href="/students/students-requests/ddns">Αιτήσεις φοιτητων για στέγαση(ddns)</a><br/>
<a class="btn-dark" href="/students/students-requests/dhee">Αιτήσεις φοιτητων για στέγαση(dhee)</a><br/>
    <br/>
</security:authorize>






</body>

<style>
    a{
        text-align: center;
        color: black;
        font-size: larger;
    }
</style>