package com.nikron.gallows;

import java.io.*;
import java.util.*;

public class Gallows {
    private String word;
    private char[] arrCharWord;
    private Set<Character> hiddenChar = new HashSet<>();
    private int count = 0;
    private boolean game = false;

    public boolean isGame() {
        return game;
    }

    public Gallows(){
        generatedWord();
        generatedArrCharWord();
    }

    private void generatedArrCharWord(){
        arrCharWord = new char[word.length()];
        int countHidden = word.length() > 7 ? 7 : word.length()%7 > 4 ? 3 : word.length()%7-1;
        int tmp = 0;
        int i = 0;
        while (tmp != countHidden && i < word.length()){
            if (Math.random() > 0.5){
                tmp++;
                hiddenChar.add(word.charAt(i));
            }
            i++;
        }
        for (int j = 0; j < arrCharWord.length; j++) {
            if (hiddenChar.contains(word.charAt(j))){
                arrCharWord[j] = '_';
            } else {
                arrCharWord[j] = word.charAt(j);
            }
        }
    }

    private void checkInputChar(char ch){
        if (hiddenChar.contains(ch)){
            int i = 0;
            while ((i = word.indexOf(ch, i)) != -1){
                arrCharWord[i] = ch;
                i++;
            }
            hiddenChar.remove(ch);
        } else {
            count++;
        }
    }

    public void game(){
        if (!game) {
            game = true;
            GallowsASCII.printASCIIGallows(count);
            Helper.printMessage(arrCharWord);
        } else if (count == 6){
            GallowsASCII.printASCIIGallows(count);
            Helper.printMessage(String.format("Правильное слово: %s", word));
            Helper.lossGame();
            game = false;
        } else if (hiddenChar.isEmpty()){
            Helper.successGame();
            game = false;
        } else {
            try {
                char ch = Helper.inputChar();
                checkInputChar(ch);
                GallowsASCII.printASCIIGallows(count);
                Helper.printMessage(arrCharWord);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void generatedWord(){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Gallows.class.getClassLoader().getResource("com/nikron/gallows/words.txt").getPath()))))
        {
            Random random = new Random();
            List<String> arr = new ArrayList<>();
            while (reader.ready()){
                arr.add(reader.readLine().trim());
            }
            word = arr.get(random.nextInt(0, arr.size()));
        } catch (IOException e){
            System.out.println("File not found.");
        }
    }
}
