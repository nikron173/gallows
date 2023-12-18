package com.nikron.gallows;

public class Main {
    public static void main(String[] args) {
        RandomWord random = new RandomWord();
        Helper.welcome();
        Helper.startMoves();
        int move = -1;
        while (move != 0){
            move = Helper.inputInt();
            if (move == 1) {
                Game game = new Game(random.getRandomWord());
                game.start();
            }
            if (move != 0) Helper.moves();
        }
    }
}
