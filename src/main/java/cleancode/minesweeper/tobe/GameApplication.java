package cleancode.minesweeper.tobe;


import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.gamelevel.Middle;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class GameApplication {
    public static void main(String[] args) {
        GameLevel gameLevel = new Middle();
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Minesweeper mineSweeper = new Minesweeper(gameLevel, inputHandler, outputHandler);
        mineSweeper.initialize();
        mineSweeper.run();
    }
}