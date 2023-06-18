package com.nikron.gallows;

public class Main {
    public static void main(String[] args) {
        Helper.startGame();
        Gallows game = new Gallows();
        int i = Helper.inputInt();
        while (i != 0) {
            game.game();
            while (game.isGame()) {
                game.game();
            }
            Helper.startGame();
            i = Helper.inputInt();
            if (i == 1) game = new Gallows();
        }
    }
}
