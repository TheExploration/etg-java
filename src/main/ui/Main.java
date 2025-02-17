package ui;

import model.Game;

public class Main implements Runnable {

    private Game game;
    private Thread mainThread;  
    private boolean running = false;
    public static final long SLEEP_TIME = 1000000000L / 30L;
    public static int GAME_WIDTH = 15;
    public static int GAME_HEIGHT = 15;



    public Main() {
        
        game = new Game();
        
    }

    public void startGame() {
        if (!running) {
            running = true;
            mainThread = new Thread(this, "MainThread");
            mainThread.start();
        }
    }

    public void stopGame() {
        if (running) {
            running = false;
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (running) {
            game.update();

            render();

            long sleepMillis = SLEEP_TIME / 1_000_000L;
            int sleepNanos = (int)(SLEEP_TIME % 1_000_000L);

            try {
                Thread.sleep(sleepMillis, sleepNanos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void render() {

        
    }


    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.startGame();
    }
}
