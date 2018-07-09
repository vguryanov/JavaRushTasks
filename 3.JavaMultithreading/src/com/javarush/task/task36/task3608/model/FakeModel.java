package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User2 on 16.02.2017.
 */
public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUsers() {
        List<User> list = new ArrayList<>();

        list.add(new User("Champloo", 1, 1));
        list.add(new User("BeBop", 2, 2));

        modelData.setUsers(list);
    }
}
