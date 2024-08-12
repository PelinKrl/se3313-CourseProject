/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313project;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author psk
 */
public class TimerManager {
    private Timer brewingTimer;
    private TimerTask brewingTask;

    TimerManager() {
        brewingTimer = new Timer();
    }

    void scheduleBrewingTimer(TimerTask task, int delay) {
        cancelBrewingTimer();
        brewingTask = task;
        brewingTimer.schedule(brewingTask, delay);
    }

    void cancelBrewingTimer() {
        if (brewingTask != null) {
            brewingTask.cancel();
        }
        brewingTask = null;
    }
}
