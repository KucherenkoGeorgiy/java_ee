package com.hillel.webapp.utils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class findWords extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usersInput = req.getParameter("usersinput");
        String sourceText = processRequest(resp);
        int result = countHowManyTimesSubstringMatches(sourceText, usersInput);

        resp.getOutputStream().println("The word \"" + usersInput + "\" is found " + result + " time(s)");
        resp.getOutputStream().println("below is the text:\n");
        resp.getOutputStream().println(sourceText);
    }

    private int countHowManyTimesSubstringMatches(String sourceText, String usersInput) {
        Pattern p = Pattern.compile(usersInput.toLowerCase());
        Matcher m = p.matcher(sourceText.toLowerCase());
        int counter = 0;

        while (m.find()) {
            counter++;
        }
        return counter;
    }

    protected String processRequest(HttpServletResponse response) {
        String result = "";
        response.setContentType("text/plain");
        ServletContext cntxt = this.getServletContext();
        String fName = "/WEB-INF/classes/input.txt";

        try (InputStream ins = cntxt.getResourceAsStream(fName);
             InputStreamReader isr = new InputStreamReader(ins);
             BufferedReader reader = new BufferedReader(isr)) {

            String word;
            while ((word = reader.readLine()) != null) {
                result += word;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
