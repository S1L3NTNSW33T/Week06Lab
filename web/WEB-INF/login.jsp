<%-- 
    Document   : login.jsp
    Created on : Oct 17, 2017, 1:11:50 PM
    Author     : 734972
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="login" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>

     
        <login:login/>
        <br>
        
         <sait:debug>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>

    </body>
</html>
