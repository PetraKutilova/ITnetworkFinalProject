/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.finalproject;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author petra
 */
public class Overview {

    private PersonManager personManager = new PersonManager();

    private Scanner sc = new Scanner(System.in, "Windows-1250");

    public void run() {
        String choose = "";

        writeIntro();
        while (!choose.equals("4")) {
            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat pojištěnce");
            System.out.println("2 - Vypsat všechny pojištěnce");
            System.out.println("3 - Vyhledat pojištěnce");
            System.out.println("4 - Konec");
            choose = sc.nextLine();

            switch (choose) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    writeAllPersons();
                    break;
                case "3":
                    findPersons();
                    break;
                case "4":
                    System.out.println("Ukončuji program.");
                    break;
                default:
                    System.out.println("Neplatná volba, stiskněne libovolnou klávesu.");
                    break;
            }

        }
    }

    private void writeIntro() {
        System.out.println("---------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("---------------------------------");
        System.out.println();
    }

    private void addPerson() {
        String name = getInputName("jméno");
        String surname = getInputName("příjmení");

        String phoneNumber = "";

        while (!PersonValidator.validatePhoneNumber(phoneNumber)) {
            System.out.println("Zadejte telefonní číslo ve formátu +(1 až 12 číslic):");
            phoneNumber = sc.nextLine();

            if (!PersonValidator.validatePhoneNumber(phoneNumber)) {
                System.out.println("Zadáno neplatné telefonní číslo. Zadejte ho znovu.");
            }
        }

        String age = "";

        while (!PersonValidator.validateAge(age)) {
            System.out.println("Zadejte věk v rozmezí 0 až 150:");
            age = sc.nextLine();

            if (!PersonValidator.validateAge(age)) {
                System.out.println("Zadán neplatný věk. Zadejte ho znovu.");
            }
        }

        personManager.addPerson(name, surname, phoneNumber, Integer.parseInt(age));
    }

    private void writeAllPersons() {
        writeOut("Výpis všech pojištěnců:", personManager.getAll());
    }

    private void findPersons() {
        String name = getInputName("jméno");
        String surname = getInputName("příjmení");

        writeOut("Výpis nalezených pojištěnců:", personManager.findByNameAndSurname(name, surname));
    }

    private void writeOut(String title, List<Person> persons) {
        System.out.println(title);

        if (persons.isEmpty()) {
            System.out.println();
            System.out.println("Nenalezen žádný záznam.");
        } else {
            for (Person person : persons) {
                System.out.println();
                System.out.println(person);
            }
        }
        System.out.println();
    }

    private String getInputName(String fieldName) {
        String name = "";
        while (!PersonValidator.validateName(name)) {
            System.out.println("Zadejte " + fieldName + ":");
            name = sc.nextLine();

            if (!PersonValidator.validateName(name)) {
                System.out.println("Zadáno neplatné " + fieldName + ". Zadejte ho znovu.");
            }
        }
        return name;
    }
}
