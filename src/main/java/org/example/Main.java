package org.example;


import org.example.config.DefaultAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);
        ContactService contactService = context.getBean(ContactService.class);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду (list, add, remove, save, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "list":
                    contactService.printAllContacts();
                    break;
                case "add":
                    System.out.println("Введите контакт в формате FIO; номер телефона; адрес электронной почты:");
                    String newContact = scanner.nextLine();
                    contactService.addNewContact(newContact);
                    break;
                case "remove":
                    System.out.println("Введите email для удаления:");
                    String email = scanner.nextLine();
                    contactService.deleteContactByEmail(email);
                    break;
                case "save":
                    contactService.saveContactsToFile();
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }


}