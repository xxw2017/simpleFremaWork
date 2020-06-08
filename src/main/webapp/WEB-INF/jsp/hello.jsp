<%@ page pageEncoding="UTF-8" %>
<html>
    <head>
        <title>HelloTitle</title>
    </head>
    <body>
        <h1>Hello H1!</h1>
        <h2><%=request.getAttribute("name")%></h2>
    </body>
</html>