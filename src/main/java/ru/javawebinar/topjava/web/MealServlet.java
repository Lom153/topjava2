package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MealServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MealTo> meals = MealsUtil.testMealsTo();
        String forward = "/meals.jsp";
        String action = "read";
        int id = -1;


            if (request.getParameterMap().keySet().contains("action")){
                action = request.getParameter("action");
            }
        if (request.getParameterMap().keySet().contains("id")){
            id = Integer.parseInt(request.getParameter("id"));
        }



        switch (action){
            case "delete":{
                MealsUtil.delete(id);
                meals = MealsUtil.testMealsTo();
                break;
            }
            case "edit":{
                forward = "/editmeal.jsp";
                request.setAttribute("meal", MealsUtil.get(id));
                break;
            }
        }
        request.setAttribute("meals", meals);
        request.getRequestDispatcher(forward).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String description = request.getParameter("description");
        //String description = request.getParameter("datetime");
        int id = Integer.parseInt(request.getParameter("id"));
        int calories = Integer.parseInt(request.getParameter("calories"));
        //LocalDateTime dateTime = LocalDateTime.now();

        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("datetime"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        //LocalDateTime dateTime = LocalDateTime.parse("2020-10-01 10:00", DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"))
        MealsUtil.edit(id, description, dateTime, calories);
        request.setAttribute("meals", MealsUtil.testMealsTo());
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
