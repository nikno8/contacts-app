package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();



    @Value("${contacts.file.save}")
    private String saveFilePath;

    public void loadContactsFromFile(String loadFilePath) {
        System.out.println(loadFilePath);
        try (BufferedReader br = new BufferedReader(new FileReader(loadFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    contacts.put(parts[2], new Contact(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке контактов из файла: " + e.getMessage());
        }
    }

    public void printAllContacts(){
        if(contacts.isEmpty()){
            System.out.println("Список контактов пуст");
        }else{
            contacts.values().forEach(System.out::println);
        }
    }

    public void addNewContact(String contactString){
        String[] parts = contactString.split(";");
        if (parts.length == 3) {
            contacts.put(parts[2].trim(), new Contact(parts[0], parts[1], parts[2]));
            System.out.println("Контакт добавлен.");
        } else {
            System.out.println("Неверный формат ввода.");
        }
    }

    public void deleteContactByEmail(String email){
        Contact contact = contacts.remove(email);
        System.out.println("Контакт удален. Его email" + contact.getEmail());
    }

    public void saveContactsToFile(){
        try (PrintWriter pw = new PrintWriter(new FileWriter(saveFilePath))) {
            contacts.values().forEach(contact -> pw.println(contact.toFileFormat()));
            System.out.println("Контакты сохранены в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении контактов в файл: " + e.getMessage());
        }
    }
}
