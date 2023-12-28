package com.nikron.gallows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class RandomWord {
    private Path filePath = Paths.get(new File("src\\com\\nikron\\gallows\\words.txt").getPath());
    private List<String> words;
    private final Random random = new Random();

    public RandomWord(Path fileWordsPath) {
        this.filePath = fileWordsPath;
        loadWords();
    }
    public RandomWord() {
        loadWords();
    }

    private void loadWords(){
        try {
            words = Files.readAllLines(filePath);
        } catch (IOException e){
            throw new RuntimeException("Не удалось считать слова со словаря.(" + filePath + ")");
        }
    }
    public String getRandomWord(){
        return words.get(random.nextInt(words.size()-1)).toUpperCase();
    }

}
