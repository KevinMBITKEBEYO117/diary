package eu.epfc.j6077.contactapp;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class DiaryUI implements IDiaryUI {
    private final Scanner input;
    private final PrintStream output;

    public DiaryUI(Scanner input, PrintStream output) {
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
    public Diary showUpdateForm() {
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
        return new Diary(id, firstName, lastName, email, phone);
    }

    @Override
    public Diary showAddForm() {
        output.println("\nFormulaire de contact");
        output.print("Prénom: ");
        String firstName = input.nextLine();
        output.print("Nom de famille: ");
        String lastName = input.nextLine();
        output.print("Email: ");
        String email = input.nextLine();
        output.print("Téléphone: ");
        String phone = input.nextLine();
        return new Diary(firstName, lastName, email, phone);
    }

    @Override
    public void showList(List<Diary> diarys) {
        output.println("\nListe des contacts:");
        for (Diary c : diarys) {
            output.println(String.join(" - ", String.valueOf(c.getId()), c.getFirstName(), c.getLastName(),
                    c.getEmail(), c.getPhone()));
        }
    }
}