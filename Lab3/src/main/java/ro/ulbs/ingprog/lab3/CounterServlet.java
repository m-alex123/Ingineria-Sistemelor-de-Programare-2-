package ro.ulbs.ingprog.lab3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", value = "/CounterServlet")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer counterGet = (Integer) session.getAttribute("CounterGetName");
        if (counterGet == null) {
            counterGet = 0;
        }

        String incParam = request.getParameter("inc");
        String decParam = request.getParameter("dec");

        if (incParam != null && !incParam.isEmpty()) {
            try {
                counterGet += Integer.parseInt(incParam);
            } catch (NumberFormatException ignored) {}
        }

        if (decParam != null && !decParam.isEmpty()) {
            try {
                counterGet -= Integer.parseInt(decParam);
            } catch (NumberFormatException ignored) {}
        }

        session.setAttribute("CounterGetName", counterGet);

        if (counterGet == 0) {
            session.setAttribute("WarningGet", true);
        } else {
            session.removeAttribute("WarningGet");
        }

        status(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer counterPost = (Integer) session.getAttribute("CounterPostName");
        if (counterPost == null) {
            counterPost = 0;
        }

        String incParam = request.getParameter("inc");
        String decParam = request.getParameter("dec");

        if (incParam != null && !incParam.isEmpty()) {
            try {
                counterPost += Integer.parseInt(incParam);
            } catch (NumberFormatException ignored) {}
        }

        if (decParam != null && !decParam.isEmpty()) {
            try {
                counterPost -= Integer.parseInt(decParam);
            } catch (NumberFormatException ignored) {}
        }

        session.setAttribute("CounterPostName", counterPost);

        if (counterPost == 0) {
            session.setAttribute("WarningPost", true);
        } else {
            session.removeAttribute("WarningPost");
        }

        status(request, response);
    }

    private void status(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession();

        printWriter.println("<h2>Welcome to Counter Servlet</h2>");

        Integer counterGet = (Integer) session.getAttribute("CounterGetName");
        printWriter.println("<br> Counter for GET: " + counterGet);

        Boolean warningGet = (Boolean) session.getAttribute("WarningGet");
        if (Boolean.TRUE.equals(warningGet)) {
            printWriter.println(" <strong style='color:red;'>WARNING GET</strong>");
        }

        Integer counterPost = (Integer) session.getAttribute("CounterPostName");
        printWriter.println("<br> Counter for POST: " + counterPost);

        Boolean warningPost = (Boolean) session.getAttribute("WarningPost");
        if (Boolean.TRUE.equals(warningPost)) {
            printWriter.println(" <strong style='color:red;'>WARNING POST</strong>");
        }

        printWriter.println("<br><br><a href='index.jsp'>Inapoi la index</a>");
    }
}