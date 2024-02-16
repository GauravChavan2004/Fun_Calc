<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Final Page</title>
    </head>
    <style>
        body {
            background: linear-gradient(to right, rgb(0, 0, 204), rgb(0, 0, 0));
            text-align: center;
            color: aliceblue;
        }


        img {
            height: 15%;
            width: 15%;
            filter: drop-shadow(10px 10px 10px white);
        }

        input,
        button {
            border: 2px solid white;
            background-color: black;
            color: aliceblue;
            font-size: 19px;
        }
    </style>

    <body>
        <img src="images/smiley.gif" alt="">
        <h1 style="color:yellow; font-size:45px;">Joke of the Day !!!</h1>

        <h3><%=request.getParameter("joke") %>
        </h3>
        <form action="MyServlet" method="post">
            <input name="firstNo" placeholder="First Number">
            <input name="secondNo" placeholder="Second Number">
            <button name="btn" value="1"> + </button>
            <button name="btn" value="2"> - </button>
            <button name="btn" value="3"> * </button>
            <button name="btn" value="4"> / </button>
            <button name="btn" value="5"> % </button><br>
           <h1>Ans: <%=request.getParameter("ans") %></h1>
           <button action="History">History</button>
        </form>
        
     
    </body>

    </html>