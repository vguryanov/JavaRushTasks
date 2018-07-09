package com.javarush.task.task36.task3608.model;

/**
 * Created by User2 on 16.02.2017.
 */
public interface Model {
    ModelData getModelData();

    void loadUsers();

    public void loadDeletedUsers();

    public void loadUserById(long userId);

    public void deleteUserById(long id);

    public void changeUserData(String name, long id, int level);

}
