package com.hillel.webapp.utils;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/arraysort")
public class ArraySort extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usersInput = req.getParameter("inputarray");
        int[] resultArray = Arrays.stream(usersInput.split(",")).mapToInt(Integer::parseInt).sorted().toArray();
        resp.getOutputStream().println(Arrays.toString(resultArray));
    }
}
