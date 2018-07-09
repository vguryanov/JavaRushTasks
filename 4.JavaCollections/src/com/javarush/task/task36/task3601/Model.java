package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User2 on 07.09.2017.
 */
public class Model {
    private Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}
