package com.konor.HomeWorkFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneBook {
    private static HashMap<String, String> pb = new HashMap<String, String>();

    private static void addPB(String phone, String name) {
        pb.put(phone, name);
    }

    private static void delPB(String phone) {
        pb.remove(phone);
    }

    private static void savePB() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.txt")));
        for (Map.Entry<String, String> k : pb.entrySet()) {
            writer.write(k.getKey() + " " + k.getValue() + System.lineSeparator());
        }
        writer.close();
    }

    public static void loadPB() throws IOException {
        File file = new File("phone.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act = reader.readLine()) != null) {
                String[] dat = act.split(" ");
                pb.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    public static void PrintPhonebook() {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, String> k : pb.entrySet()) {
            System.out.println(k.getValue() + ": " + k.getKey());
        }
    }

    public static String FindSurname(String number) {
        String result = pb.get(number);
        if (result == null) return "абонент с таким номером не найдей";
        return result;
    }

    public static String[] FindNumberPhone(String surname) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry entry : pb.entrySet()) {
            if (surname.equalsIgnoreCase((String) entry.getValue())) {
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0) result.add("абонент с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {

        String act;
        loadPB();
        PrintPhonebook();

        System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (num) найти номера по фамилии, (sur)найти фамилию, " +
                "(save)сохранить, (exit)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while (!act.equals("exit")) {

            if (act.equals("add")) {
                System.out.println("Введите фамилию:");
                String name = bf.readLine();
                System.out.println("Введите телефон:");
                String phone = bf.readLine();
                addPB(phone, name);
            } else {

                if (act.equals("del")) {
                    System.out.println("Введите телефон:");
                    String phone = bf.readLine();
                    delPB(phone);
                } else {

                    if (act.equals("num")) {
                        System.out.println("Введите фамилию:");
                        String surname = bf.readLine();
                        String[] numbers = FindNumberPhone(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    } else {

                        if (act.equals("sur")) {
                            System.out.println("Введите номер:");
                            String number = bf.readLine();
                            System.out.println(FindSurname(number));
                        } else {

                            if (act.equals("save")) {
                                savePB();
                            }
                        }
                    }
                }
            }

            System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (num) найти номера по фамилии, (sur)найти фамилию, (save)сохранить, (exit)выход");
            act = bf.readLine();
        }
    }
}
