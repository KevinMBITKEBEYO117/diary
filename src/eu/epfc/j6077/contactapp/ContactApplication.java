package eu.epfc.j6077.contactapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ContactApplication {
    private final ContactUC contactUC;

    public ContactApplication(ContactUC contactUC) {
        this.contactUC = contactUC;
    }

    public static void main(String[] args) {
        String connectionString;
        if (args.length >= 1) {
            connectionString = args[0];
        } else {
            connectionString = "jdbc:h2:./contact";
        }

        IContactDao contactDao = new ContactDao(connectionString);
        PrintStream printStream = System.out;
        ContactUI contactUI = new ContactUI(new Scanner(System.in), printStream);
        ContactUC contactUC = new ContactUC(contactDao, contactUI);
        ContactApplication contactApplication = new ContactApplication(contactUC);

        contactApplication.run();
        printStream.close();
    }

    public void run() {
        String choice;
        do {
            choice = contactUC.showMenu();
            switch (choice) {
                case "1" -> contactUC.consultContacts();
                case "2" -> contactUC.addContact();
                case "3" -> contactUC.updateContact();
                case "4" -> contactUC.deleteContact();
            }
        } while (! choice.equals("Q"));
    }
}
