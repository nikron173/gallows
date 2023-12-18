package com.nikron.gallows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void welcome(){
        System.out.println("Добро пожаловать в игру `Виселица`");
    }

    public static void startMoves(){
        System.out.println("1) Начать игру\n0) Выход");
    }

    public static void moves(){
        System.out.println("1) Начать игру заново\n0) Выход");
    }

    public static void inCorrectInput(){
        System.out.println("Введите число 0 или 1");
    }

    public static void finishWin(String word){
        System.out.println("Вы победили. Загаданное слово: " + word);
    }

    public static void finishLose(String word){
        System.out.println("Вы проиграли. Загаданное слово: " + word);
    }

    public static void right(){
        System.out.println("Правильно.");
    }

    public static void notRight(){
        System.out.println("Не правильно.");
    }

    public static void notRightChar(){
        System.out.println("Такая буква уже открыта.");
    }

    public static void errorParameter(){
        System.out.println("Не правильный параметр. Пожалуйста повторите действие...");
    }

    public static char inputChar() {
        String word;
        try {
            word = reader.readLine();
            if (word.length() > 1) {
                throw new IOException();
            }
        } catch (IOException ex){
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

}
