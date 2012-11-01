<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Haricot aimable</title>
        <s:head/>
        <link rel="stylesheet" href="../styles/styles.css" type="text/css" />
    </head>
    <body>
        <h1>La boutique du Haricot</h1>

        <div class="blue">
	    Browse the catalog.
            <s:form action="category">
                <s:select list="categories" 
			  name="currentCategory"
			  headerKey="-1"  headerValue="select a category" 
			  listKey="id" listValue="name"
			  onchange="this.form.submit()"/>
            </s:form>

        </div>

    </body>
</html>
