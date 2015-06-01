package awesomespider.lumina.Api.Utils;

/**
 * Created by Awesome_Spider on 5/3/2015.
 */
public interface TimerTask {
    void run();
    int timeInTicks = 0;
    int getTime();
    void decrementTime(int amt);
}
