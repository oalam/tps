<%-- 
    Document   : searchResult
    Created on : 8 nov. 2012, 11:43:03
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
        <h1>The result of your research</h1>

        <s:if test="%{agencies.size !=0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>agency_id</th>
                        <th>agency_name</th>
                    </tr>
                </thead>
                <tbody>

                    <s:iterator value="agencies">
                        <tr>
                            <td><s:property value="agencyId"/></td>
                            <td><s:property value="agencyName"/></td>
                        </tr>

                    </s:iterator>
                </tbody>
            </table>
        </s:if>

        <s:if test="%{routes.size !=0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>routeId</th>
                        <th>routeShortName</th>
                    </tr>
                </thead>
                <tbody>

                    <s:iterator value="routes">
                        <tr>
                            <td><s:property value="routeId"/></td>
                            <td><s:property value="routeShortName"/></td>
                        </tr>

                    </s:iterator>
                </tbody>
            </table>
        </s:if>

    </body>
</html>
