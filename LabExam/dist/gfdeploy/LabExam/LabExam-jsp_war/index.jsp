<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Page</title>
    </head>
    <body>
        <h1>This is Final Lab</h1>
        <p>You can input Parameter and it's Value </p>
        <form method="post" >
            <label>Parameter:
                <input type="parameter" name="userParameter">
                <label>Value:
                    <input type="value" name="userValue">
                </label>
                <br />
            </label>
            <button type="submit" name="submitButton">Submit</button>

            <%if (request.getAttribute("message") != null) {
                    out.println("<p>This Parameter: " + request.getAttribute("message") + "</p>");
                }
                if (request.getAttribute("error") != null) {
                    out.println("<p>" + request.getAttribute("error") + "</p>");
                }
            %>
        </form>
    </body>
</html>

