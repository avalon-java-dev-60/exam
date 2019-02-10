<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrator page</title>
    </head>
    <body>
        <h1>This is Final Lab</h1>
        <p>You can input Parameter and it's Value </p>

        <form method="post" action="/labExam/registrator">
            <label>Parameter:
                <input type="text" name="userParameter" value="${userParameter}" maxlength="255">
                <label>Value:
                    <input type="number" name="userValue" value="${userValue}" pattern="\d">
                </label>
                <br />
            </label> <button type="submit" name="submitButton">Submit</button> <button type="submit" name="deleteButton">Delete</button>         
        </form>
        <form method="post" action="/labExam/viewlist">
            <button type="submit" name="viewListButton">View List</button>
        </form>        


        <%if (request.getAttribute("message") != null) {
                out.println("<p>This Parameter: " + request.getAttribute("message") + "</p>");
            }
            if (request.getAttribute("error") != null) {
                out.println("<p>" + request.getAttribute("error") + "</p>");
            }
        %>

        <style>
            input[type='number'] {
                -moz-appearance:textfield;
            }

            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button {
                -webkit-appearance: none;
            }
        </style>
    </body>
</html>

