package eu.epfc.j6077.contactapp;

import java.util.List;

public class ContactUC {
    private ContactUI contactUI = new ContactUI();
    private ContactDao contactDao;

    public ContactUC(String connectionString) {
        contactDao = new ContactDao(connectionString);
    }

    public String showMenu() {
        return contactUI.showMenu();
    }

    public void addContact() {
        Contact contact = contactUI.showAddForm();
        contactDao.add(contact);
    }

    public void deleteContact() {
        int id = contactUI.showDeleteForm();
        contactDao.delete(id);
    }

    public void updateContact() {
        Contact contact = contactUI.showUpdateForm();
        contactDao.update(contact);
    }

    public void consultContacts() {
        List<Contact> contacts = contactDao.fetch();
        contactUI.showList(contacts);
    }
}