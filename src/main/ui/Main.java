package ui;

import model.Game;

// Represents the Main ui in the game. (In PHASE 1 so far it is the console UI)
public class Main implements Runnable {
    // The Game
    private Game game;
    // The main thread for the game loop
    private Thread mainThread;  
    // Game running status
    private boolean running = false;
    // Game constants: Frames per second, width of game, and height of game
    public static final long SLEEP_TIME = 1000000000L / 30L;
    public static final int GAME_WIDTH = 15;
    public static final int GAME_HEIGHT = 15;


    // Constructs a Main ui object
    // Effects: Instantiates a new Game object
    public Main() {
        game = new Game();
        
    }

    // Starts the game
    // Modifies: this
    // Effects: If game is not running, make running true and start the mainThread by making a new thread (create new thread and call run())
    public void startGame() {
        if (!running) {
            running = true;
            mainThread = new Thread(this, "MainThread");
            mainThread.start();
        }
    }

    // Stops the game
    // Modifies: this
    // Effects: If game is running, make running false to stop the mainThread
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

    // Creates the game loop using Thread.sleep
    // Modifies: this, game
    // Effects: While running is true, repeatedly call game.update() and render() every SLEEP_TIME
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

    // Render the console UI
    // Effects: Prints the UI out into console with System.out.println
    public void render() {

        
    }


    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.startGame();
    }
}
