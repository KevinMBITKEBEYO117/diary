package eu.epfc.j6077.contactapp;

import java.util.List;

public class ContactUC {
    private final ContactUI contactUI;
    private final IContactDao contactDao;

    public ContactUC(IContactDao contactDao, ContactUI contactUI) {
        this.contactDao = contactDao;
        this.contactUI = contactUI;
    }
    public String showMenu() {
        return contactUI.showMenu();
    }

    public void add() {
        Contact contact = contactUI.showAddForm();
        contactDao.add(contact);
    }

    public void delete() {
        int id = contactUI.showDeleteForm();
        contactDao.delete(id);
    }

    public void update() {
        Contact contact = contactUI.showUpdateForm();
        contactDao.update(contact);
    }

    public void consult() {
        List<Contact> contacts = contactDao.fetch();
        contactUI.showList(contacts);
    }
}