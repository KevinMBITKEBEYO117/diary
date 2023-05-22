package eu.epfc.j6077.contactapp;

import java.util.List;

public interface IContactUI {
    String showMenu();

    int showDeleteForm();

    Contact showUpdateForm();

    Contact showAddForm();

    void showList(List<Contact> contacts);
}
