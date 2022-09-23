package com.konor.HomeWorkFile;

import java.util.ArrayList;
import java.util.Scanner;


public class listTask {
    public static void main(String[] args) {
        System.out.println("Список команд: \nLIST — выводит дела с их порядковыми номерами;" +
                "\nADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;" +
                "\nEDIT — заменяет дело с указанным номером; \nDELETE — удаляет; \nВызовите команду:");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<>() {{
            add(0, "Позавтракать");
            add(1, "Умыться");
            add(2, "Почитать книгу");
            add(3, "Поработать");
            add(4, "Пообедать");
        }};

        while (true) {
            String comanda = scanner.nextLine();
            String[] naSlova = comanda.split(" ");
            for (int i = 0; i < naSlova.length; i++) {
                if (naSlova[i].equals("LIST")) {
                    for (int j = 0; j < todoList.size(); j++) {
                        System.out.println(todoList.get(j));
                    }
                } else if (naSlova[0].equals("ADD") && naSlova.length == 2) {
                    todoList.add(naSlova[1]);
                    System.out.println("Вы добавили новое дело в конец списка:");
                    for (int j = 0; j < todoList.size(); j++) {
                        System.out.println(todoList.get(j));
                    }
                    break;
                } else if (naSlova[0].equals("ADD") && naSlova.length > 2) {
                    todoList.add(Integer.parseInt(naSlova[1]) - 1, naSlova[2]);
                    System.out.println("Вы добавили новое дело: " + naSlova[2] + ", в позицию номер: " + naSlova[1] + "\nИзмененный список дел:");
                    for (int j = 0; j < todoList.size(); j++) {
                        System.out.println(todoList.get(j));
                    }
                    break;
                } else if (naSlova[0].equals("EDIT") && naSlova.length == 3) {
                    todoList.set(Integer.parseInt(naSlova[1]) - 1, naSlova[2]);
                    System.out.println("Вы заменили дело в позиции номер: " + naSlova[1] + " на: " + naSlova[2] + "\nИзмененный список дел:");
                    for (int j = 0; j < todoList.size(); j++) {
                        System.out.println(todoList.get(j));
                    }
                    break;
                } else if (naSlova[0].equals("DELETE") && naSlova.length == 2) {
                    System.out.println("Вы удалили дело " + todoList.get(Integer.parseInt(naSlova[1]) - 1) + ", которое было в позиции номер: " + naSlova[1] + "\nИзмененный список дел:");
                    todoList.remove(Integer.parseInt(naSlova[1]) - 1);
                    for (int j = 0; j < todoList.size(); j++) {
                        System.out.println(todoList.get(j));
                    }
                    break;
                } else {
                    System.out.println("Не верная команда. Вызовите правильну команду:");
                }
                break;
            }
        }
    }
}

