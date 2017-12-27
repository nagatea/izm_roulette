package main;

/**
 * Created by nagatea on 2017/12/27.
 */
public class RouletteTimer implements Runnable {
    private int minute;
    private int second;
    private String timer;
    RouletteTimer(int minute, int second){
        this.minute = minute;
        this.second = second;
        timer = "";
    }

    public void run(){
        while (true){
            if (second == 0) {
                second = 59;
                minute--;
            } else{
                second--;
            }
            String m = minute < 10 ? ("0" + minute) : Integer.toString(minute);
            String s = second < 10 ? ("0" + second) : Integer.toString(second);
            timer = m + ":" + s;

            if (minute == 0 && second == 0){
                break;
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public String getTimer(){
        return timer;
    }
}
