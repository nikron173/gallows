package com.nikron.gallows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Helper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void startGame(){
        System.out.print("1) Начать игру\n0) Выход\nВыберите действие: ");
    }

    public static void successGame(){
        System.out.println("Победа!");
    }

    public static void lossGame(){
        System.out.println("Проиграл.");
    }

    public static void errorParameter(){
        System.out.println("Не правильный параметр. Пожалуйста повторите действие...");
    }

    public static char inputChar() throws IOException {
        String word = reader.readLine();
        if (word.length() > 1) {
            errorParameter();
            return inputChar();
        }
        return word.charAt(0);
    }

    public static int inputInt() {
        int move;
        try {
            move = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            errorParameter();
            return inputInt();
        }
        if (move == 0 || move == 1) return move;
        errorParameter();
        return inputInt();
    }

    public static void printMessage(char[] messsage){
        StringBuilder str = new StringBuilder();
        for (char ch : messsage){
            str.append(ch);
        }
        System.out.println(str);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
