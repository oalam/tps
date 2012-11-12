<%-- 
    Document   : import
    Created on : 8 nov. 2012, 10:26:32
    Author     : adminl
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>import</h1>

	<s:form action="doUpload" method="post" enctype="multipart/form-data">
	    <s:file name="upload" label="File"/>
	    <s:submit/>
	</s:form>


    </body>
</html>
