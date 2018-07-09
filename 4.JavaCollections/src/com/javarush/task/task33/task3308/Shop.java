package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by User2 on 06.08.2017.
 */
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public static class Goods {
        public List<String> names;
    }
}
