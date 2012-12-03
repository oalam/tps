<%--
    Document   : twit
    Created on : 15 nov. 2012, 14:17:18
    Author     : adminl
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <s:head/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>TWIT me</title>

        <link rel="stylesheet" href="styles/styles.css" type="text/css" />
    </head>
    <body class="ui-form">
        <h1>Twitter</h1>
        <div class="blue">
            <strong>actually <s:property value="sessionCount"/> users online.</strong>

            <s:form action="twit">
                <s:textfield name="hotMessage.author" label="from"/> 
                <s:textfield name="hotMessage.body" label="message" value=""/> 
                <s:submit label="post"/>
            </s:form>
            <table border="0">

                    <s:iterator value="newsList">
                        <tr>
                            <td><strong><s:property value="author"/> (<s:date name="postDate" format="hh:mm"/>)</strong></td>
                            <td><s:property value="body"/></td>
                        </tr>

                    </s:iterator>

            </table>



        </div>
    </body>
</html>
