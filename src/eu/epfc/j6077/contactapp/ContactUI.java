package eu.epfc.j6077.contactapp;

import java.util.List;
import java.util.Scanner;

public class ContactUI {
    private Scanner input = new Scanner(System.in);

    public String showMenu() {
        System.out.println("\nChoisissez dans les options suivantes");
        System.out.println("(1) lister les contacts");
        System.out.println("(2) ajouter un contact");
        System.out.println("(3) modifier un contact");
        System.out.println("(4) supprimer un contact");
        System.out.println("(Q) quitter l'application");
        return input.nextLine();
    }
    public int showDeleteForm() {
        System.out.println("\nFormulaire de suppression d'un contact");
        System.out.print("Identifiant: ");
        return Integer.parseInt(input.nextLine());
    }

    public Contact showUpdateForm() {
        System.out.println("\nFormulaire de modification d'un contact");
        System.out.print("Identifiant: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Prénom: ");
        String firstName = input.nextLine();
        System.out.print("Nom de famille: ");
        String lastName = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Téléphone: ");
        String phone = input.nextLine();
        return new Contact(id, firstName, lastName, email, phone);
    }

    public Contact showAddForm() {
        System.out.println("\nFormulaire de contact");
        System.out.print("Prénom: ");
        String firstName = input.nextLine();
        System.out.print("Nom de famille: ");
        String lastName = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Téléphone: ");
        String phone = input.nextLine();
        return new Contact(firstName, lastName, email, phone);
    }

    public void showList(List<Contact> contacts) {
        System.out.println("\nListe des contacts:");
        for(Contact c : contacts) {
            System.out.println(String.join(" - ", String.valueOf(c.getId()), c.getFirstName(), c.getLastName(),
                    c.getEmail(), c.getPhone()));
        }
    }
}