<%-- 
    Document   : tripResult
    Created on : 9 nov. 2012, 11:48:40
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
        <h1>Here the list of trips corresponding to your selection</h1>


        <table border="0" style="width:100%">
	     
            <s:iterator value="stopTimes" var="st">
         
                <tbody>
                    <tr><td><s:property value="trip.tripHeadsign"/> </td>
                        <s:iterator value="st">
                            <td style="white-space:nowrap;">
                                <s:property value="stop.stopName"/>
                                <strong><s:date name="departureTime" format="hh:mm"/></strong>
                            </td>
                        </s:iterator>
                    </tr>
                </tbody>
            </s:iterator>
        </table>
    </body>
</html>
