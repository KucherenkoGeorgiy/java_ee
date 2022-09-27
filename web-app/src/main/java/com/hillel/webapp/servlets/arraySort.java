package com.hillel.webapp.servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class arraySort extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usersInput = req.getParameter("inputarray");
        int[] resultArray = getArrayOfIntFromInput(usersInput);
        resp.getOutputStream().println(Arrays.toString(resultArray));
    }

    private int[] getArrayOfIntFromInput(String usersInput) {
        int[] numArr = Arrays.stream(usersInput.split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numArr);
        return numArr;
    }
}
