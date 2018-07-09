package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;

/**
 * Created by User2 on 10.02.2018.
 */
public class Model {
    View view;
    Provider[] providers;

    public Model(View view, Provider... providers) {
        if (view == null || providers == null || providers.length < 1) throw new IllegalArgumentException();

        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city) {
        ArrayList<Vacancy> result = new ArrayList<>();
        for (Provider provider : providers) result.addAll(provider.getJavaVacancies(city));
        view.update(result);
    }
}
