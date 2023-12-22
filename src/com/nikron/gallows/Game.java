package com.nikron.gallows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game {
    private int error = 0;
    private boolean isFinish = false;
    Random random = new Random();
    private String word;
    private char[] hiddenWord;
    private static Map<Integer, String> gameDrawing = new HashMap<>();

    static {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        Game.class.getResource("").getPath().toString().substring(1)
                                .replaceAll("/", "\\\\")+"gallowsAscii.txt"))){
            StringBuilder builder = new StringBuilder();
            int i = 0;
            while (reader.ready()){
                String tmp;
                tmp = reader.readLine();
                if (!tmp.matches("^;")){
                    builder.append(tmp).append('\n');
                } else {
                    builder.delete(builder.length()-1, builder.length());
                    gameDrawing.put(i, builder.toString());
                    i++;
                    builder = new StringBuilder();
                }
            }
        } catch (FileNotFoundException ex){
            throw new RuntimeException("Файл " + System.getProperty("user.dir") + " не найден.");
        } catch (IOException ex){
            throw new RuntimeException("Ошибка чтения файла " + System.getProperty("user.dir"));
        }
    }

    public Game(String word){
        this.word = word;
        this.hiddenWord = generatedHiddenWord(word);
    }

    public void start(){
        while (!isFinish){
            System.out.println(Arrays.toString(hiddenWord));
            if (error == 6){
                isFinish = true;
                gameDrawing.get(6);
                Helper.finishLose(word);
            } else {
                System.out.println(gameDrawing.get(error));
                char ch = Character.toUpperCase(Helper.inputChar());
                if (word.indexOf(ch) == -1){
                    Helper.notRight();
                    error++;
                } else if (checker(ch) && word.indexOf(ch) != -1) {
                    error++;
                    Helper.notRightChar();
                } else {
                    openCharHiddenWord(ch);
                }
            }
            if (!checkHiddenWord()){
                isFinish = true;
                Helper.finishWin(word);
            }
        }
    }

    private char[] generatedHiddenWord(String word){
        char[] hidden = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            hidden[i] = '_';
        }
        for (int i = 0; i < 2; i++) {
            int tmp = random.nextInt(word.length()-1);
            openCharHiddenWord(word.charAt(tmp), hidden);
        }
        return hidden;
    }

    private boolean checker(char ch){
        for (char h : hiddenWord){
            if (h == ch) return true;
        }
        return false;
    }

    private boolean checkHiddenWord(){
        for (char h : hiddenWord){
            if (h == '_') return true;
        }
        return false;
    }

    private void openCharHiddenWord(char ch){
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch){
                hiddenWord[i] = ch;
            }
        }
    }

    private void openCharHiddenWord(char ch, char[] hiddenWord){
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch){
                hiddenWord[i] = ch;
            }
        }
    }
}
