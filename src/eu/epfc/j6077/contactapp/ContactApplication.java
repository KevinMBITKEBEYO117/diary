package eu.epfc.j6077.contactapp;

public class ContactApplication {
    private ContactUC contactUC;

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
        ContactDao contactDao = new ContactDao(connectionString);
        ContactUI contactUI = new ContactUI();
        ContactUC contactUC = new ContactUC(contactDao, contactUI);
        new ContactApplication(contactUC).run();
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
