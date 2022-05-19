package com.example.demo4;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/ducthuan")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int a= Integer.parseInt(request.getParameter("a"));
        int b= Integer.parseInt(request.getParameter("b"));
        int sum=a+b;
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>"+sum+"</html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user=request.getParameter("username");
        String pass=request.getParameter("pass");
        PrintWriter printWriter=response.getWriter();
        printWriter.println("<html>");
        if("admin".equals(user) && "abc".equals(pass)){
            printWriter.println("<h1> wellcome" +user+ "</h1>");
        }
        else {
            printWriter.println("<h1>ko đúng</h1>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        }
        printWriter.println("</html>");
    }

}
