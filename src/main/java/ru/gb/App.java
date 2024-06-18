package ru.gb;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int countWin = 0;
        int countLose = 0;

        Random rnd = new Random();
        Map<Integer, Boolean> results = new HashMap<>();

        for (int i = 1; i <= 1000; i++) {
            int selectDoor = rnd.nextInt(3);
            int winDoor = rnd.nextInt(3);

            int openDoor = (selectDoor + 1) % 3;
            while (openDoor == winDoor) {
                openDoor = (openDoor + 1) % 3;
            }

            int newSelectDoor = (selectDoor + 1) % 3;
            while (newSelectDoor == openDoor || newSelectDoor == selectDoor) {
                newSelectDoor = (newSelectDoor + 1) % 3;
            }

            if (newSelectDoor == winDoor) {
                countWin++;
                results.put(i, true);
            } else {
                countLose++;
                results.put(i, false);
            }
        }

        for (Map.Entry<Integer, Boolean> entry : results.entrySet()) {
            System.out.println("Игра №" + entry.getKey() + ": " + entry.getValue());
        }


        System.out.println("Количество побед: " + countWin);
        System.out.println("Количество проигрышей: " + countLose);
    }
}