package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by User2 on 12.07.2017.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow{
    private int totalDuration;
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }
}
