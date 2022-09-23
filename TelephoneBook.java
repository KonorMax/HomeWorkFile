package com.konor.HomeWorkFile;

import java.io.*;
import java.util.Properties;

public class TelephoneBook {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        String number;

        FileInputStream fin = null;
        boolean changed = false;

        try {
            fin = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (fin != null) {
            try {
                ht.load(fin);
                fin.close();
            } catch (IOException e) {
                System.out.println("Error of file reading");
            }

        }

        do {
            System.out.println("Input name (or 'stop' for exit) : ");
            name = br.readLine();
            if (name.equals("stop")) continue;
            System.out.println("Input number: ");
            number = br.readLine();
            ht.put(name, number);
            changed = true;
        } while (!name.equals("stop"));


        if (changed) {
            FileOutputStream fouts = new FileOutputStream("phonebook.dat");
            ht.store(fouts, "Phone book");
            fouts.close();
        }

        do {
            System.out.println("Input name for search: (or 'stop' for exit): ");
            name = br.readLine();
            if (name.equals("stop")) continue;
            number = (String) ht.get(name);
            System.out.println(number);
        } while (!name.equals("stop"));
    }
}


