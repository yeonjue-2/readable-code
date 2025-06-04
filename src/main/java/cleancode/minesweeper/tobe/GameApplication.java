package cleancode.minesweeper.tobe;


import cleancode.minesweeper.tobe.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.gamelevel.Middle;
import cleancode.minesweeper.tobe.gamelevel.VeryBeginner;

public class GameApplication {
    public static void main(String[] args) {
        GameLevel gameLevel = new Middle();
        Minesweeper mineSweeper = new Minesweeper(gameLevel);

        mineSweeper.run();
    }
}