package com.javarush.task.task36.task3601;

/**
 * Created by User2 on 07.09.2017.
 */
public class View {
    private Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());

    }
}
