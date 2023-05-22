package eu.epfc.j6077.contactapp;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ContactUI implements IContactUI {
    private final Scanner input;
    private final PrintStream output;

    public ContactUI(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String showMenu() {
        output.println("\nChoisissez dans les options suivantes");
        output.println("(1) lister les contacts");
        output.println("(2) ajouter un contact");
        output.println("(3) modifier un contact");
        output.println("(4) supprimer un contact");
        output.println("(Q) quitter l'application");
        return input.nextLine();
    }
    @Override
    public int showDeleteForm() {
        output.println("\nFormulaire de suppression d'un contact");
        output.print("Identifiant: ");
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public Contact showUpdateForm() {
        output.println("\nFormulaire de modification d'un contact");
        output.print("Identifiant: ");
        int id = Integer.parseInt(input.nextLine());
        output.print("Prénom: ");
        String firstName = input.nextLine();
        output.print("Nom de famille: ");
        String lastName = input.nextLine();
        output.print("Email: ");
        String email = input.nextLine();
        output.print("Téléphone: ");
        String phone = input.nextLine();
        return new Contact(id, firstName, lastName, email, phone);
    }

    @Override
    public Contact showAddForm() {
        output.println("\nFormulaire de contact");
        output.print("Prénom: ");
        String firstName = input.nextLine();
        output.print("Nom de famille: ");
        String lastName = input.nextLine();
        output.print("Email: ");
        String email = input.nextLine();
        output.print("Téléphone: ");
        String phone = input.nextLine();
        return new Contact(firstName, lastName, email, phone);
    }

    @Override
    public void showList(List<Contact> contacts) {
        output.println("\nListe des contacts:");
        for(Contact c : contacts) {
            output.println(String.join(" - ", String.valueOf(c.getId()), c.getFirstName(), c.getLastName(),
                    c.getEmail(), c.getPhone()));
        }
    }
}