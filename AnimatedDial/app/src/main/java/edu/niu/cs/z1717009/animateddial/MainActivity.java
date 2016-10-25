package edu.niu.cs.z1717009.animateddial;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;

import java.util.logging.Handler;

public class MainActivity extends Activity {

    private Thread animationThread;
    private DialView dialView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialView = new DialView(this);

        setContentView(dialView);

        animationThread = new Thread(runningAnim);
        animationThread.start();
    }

    private Runnable runningAnim = new Runnable(){
        private static final int DELAY= 1000;
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(DELAY);
                    threadHandler.sendEmptyMessage(0);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }// end of while
        }// end of run
    };

    private android.os.Handler threadHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            dialView.update();
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        threadHandler.removeCallbacks(runningAnim);
    }
}
