package com.nikron.gallows;

public class GallowsASCII {

    public static void printASCIIGallows(int countErrors){
        switch (countErrors){
            case 0 -> stepOne(0);
            case 1 -> stepTwo(1);
            case 2 -> stepThree(2);
            case 3 -> stepFouth(3);
            case 4 -> stepFive(4);
            case 5 -> stepSix(5);
            case 6 -> stepSeven(6);
        }
    }


    private static void stepOne(int countError){
        System.out.println(String.format("""
Количество ошибок: %d
          ______
          |    |
               |
               |
               |
        _______|_______""", countError));
    }

    private static void stepTwo(int countError){
        System.out.println(String.format("""
Количество ошибок: %d
          ______
          |    |
          0    |
               |
               |
        _______|_______""", countError));
    }

    private static void stepThree(int countError){
        System.out.println(String.format("""
Количество ошибок: %d
          ______
          |    |
          0    |
          |    |
          |    |
               |
        _______|_______""", countError));
    }

    private static void stepFouth(int countError){
        System.out.println(String.format("""
Количество ошибок: %d
          ______
          |    |
          0    |
         \\|    |
          |    |
               |
        _______|_______""", countError));
    }

    private static void stepFive(int countError){
        System.out.println(String.format("""
Количество ошибок: %d
          ______
          |    |
          0    |
         \\|/   |
          |    |
               |
        _______|_______""", countError));
    }

    private static void stepSix(int countError){
        System.out.println(String.format("""
Количество ошибок: %d
          ______
          |    |
          0    |
         \\|/   |
          |    |
         /     |
        _______|_______""", countError));
    }

    private static void stepSeven(int countError){
        System.out.println(String.format("""
Количество ошибок: %d
          ______
          |    |
          0    |
         \\|/   |
          |    |
         / \\   |
        _______|_______""", countError));
    }
}

