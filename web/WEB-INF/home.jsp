<%-- 
    Document   : home.jsp
    Created on : Oct 17, 2017, 1:15:22 PM
    Author     : 734972
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <div>Hello ${username}</div>
        <a href="login?action=logout">Log out</a>
    </body>
    <br/>
    <sait:debug>
        Remote Host: ${pageContext.request.remoteHost}<br />
        Session ID: ${pageContext.session.id}
    </sait:debug>
</html>
