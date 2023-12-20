package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    private final Logger log  = LoggerFactory.getLogger(getClass());

    private MealService service;

    @Autowired
    public MealRestController(MealService service) {
        this.service = service;
    }

    //get all
    public List<MealTo> getAll(int userId){
        log.info("get all");
        return service.getAll(userId);
    }
    //get
    public Meal get(int mealId, int userId){
        log.info("get meal id {} by user id {}", mealId, userId);
        return service.get(mealId, userId);
    }
    //create
    public Meal create(Meal meal, int userId){
        log.info("create {}", meal);
        checkNew(meal);
        return service.create(meal, userId);
    }
    //update
    //delete
    //filtered by date
    //filtered by time
    //filtered by date and time
}