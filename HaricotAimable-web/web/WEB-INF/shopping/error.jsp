<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="error.title"/></title>
	<s:head/>
        <link rel="stylesheet" href="../styles/styles.css" type="text/css" />
    </head>
    <body>
        <h1><s:text name="error.title"/></h1>
	<div class="blue">


	    <h2>An unexpected error has occurred</h2>
	    <p>
		Please report this error to your system administrator
		or appropriate technical support personnel.
		Thank you for your cooperation.
	    </p>
	    <hr/>
	    <h3>Error Message</h3>
	    <s:actionerror/>
	    <p>
		<s:property value="%{exception.message}"/>
	    </p>
	    <hr/>
	    <h3>Technical Details</h3>
	    <p>
		<s:property value="%{exceptionStack}"/>
	    </p>
	</div>
    </body>
</html>
