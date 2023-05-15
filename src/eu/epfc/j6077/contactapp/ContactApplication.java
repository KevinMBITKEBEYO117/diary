package eu.epfc.j6077.contactapp;

public class ContactApplication {
    private ContactUC contactUC;

    public ContactApplication(String connectionString) {
        contactUC = new ContactUC(connectionString);
    }

    public static void main(String[] args) {
        String connectionString;
        if (args.length >= 1) {
            connectionString = args[0];
        } else {
            connectionString = "jdbc:h2:./contact";
        }
        new ContactApplication(connectionString).run();
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
