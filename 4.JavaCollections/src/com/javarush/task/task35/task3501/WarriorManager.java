package com.javarush.task.task35.task3501;

import java.util.List;

/**
 * Created by User2 on 27.08.2017.
 */
class WarriorManager {
    public static <T extends MagicWarrior> boolean fight(List<T> w1, List<? super ArcherEnforcerWarrior> w2) {
        return true;
    }
}
