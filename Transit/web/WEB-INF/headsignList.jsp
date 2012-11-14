<%-- 
    Document   : newjspheadsignList
    Created on : 9 nov. 2012, 10:13:14
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
        <h1>Choose the correct HeadSign for the route <s:property value="routeLongName"/></h1>

        <table border="1">
            <thead>
                <tr>
                    <th>headsign</th>
                    <th>further information</th>
                </tr>
            </thead>
            <tbody>

                <s:iterator value="headsigns" var="headsign">
                    <tr>
                        <td><s:property/></td>
                        <s:url action="displayTrips" id="url">
                            <s:param name="currentHeadsign" value="headsign"/>
                        </s:url>
                        <td><s:a href="%{url}">view</s:a></td>
                        </tr>

                </s:iterator>
            </tbody>
        </table>
    </body>
</html>
