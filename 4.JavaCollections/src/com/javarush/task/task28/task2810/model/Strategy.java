package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Created by User2 on 03.02.2018.
 */
public interface Strategy {
    public List<Vacancy> getVacancies(String searchString);
}
