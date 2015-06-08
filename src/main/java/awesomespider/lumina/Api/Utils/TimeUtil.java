package awesomespider.lumina.Api.Utils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

/**
 * This class was created to aid in timing of tasks along with TimerTask if you don't have a method that is called every tick,
 * or if you're just lazy. ;)
 *
 * Created by Awesome_Spider on 5/3/2015.
 */
public class TimeUtil {
    public static TimerTask[] tasks = {};

    /**
     * Adds a task to the timer.
     * @param task - The task to add.
     */
    public static void addTask(TimerTask task){
        int length = tasks.length;

        int current = length + 1;

        tasks[current] = task;
    }

    /**
     * Loops through all the tasks added and updates them; if the time is 0, it executes the task.
     */
    public void update(){
        for (int current = 0; current == tasks.length; current ++){
            TimerTask task = tasks[current];

            int time = task.getTime();

            if (time >= 0){
                task.decrementTime(1);
            } else {
                task.run();
                tasks[current] = null;
            }
        }
    }

    /**
     * This event is used to update the timer every tick.
     * @param event
     */
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event){
        update();
    }
}
