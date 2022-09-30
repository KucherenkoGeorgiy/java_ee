package com.hillel.webapp.utils;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/findwords")
public class FindWords extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usersInput = req.getParameter("usersinput");
        InputStream is = getClass().getClassLoader().getResourceAsStream("input.txt");
        int result;

        if (is != null) {
            String sourceText = new String(is.readAllBytes());
            is.close();
            result = countHowManyTimesSubstringMatches(sourceText, usersInput);
            resp.getOutputStream().println("The word \"" + usersInput + "\" is found " + result + " time(s)");
            resp.getOutputStream().println("below is the text:\n");
            resp.getOutputStream().println(sourceText);
        } else {
            resp.getOutputStream().println("Error: failed to load the file");
        }
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
}