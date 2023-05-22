package eu.epfc.j6077.contactapp;

import java.util.ArrayList;
import java.util.List;

public class MemoryDao implements IContactDao {
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public void add(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void delete(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                contacts.remove(contact);
                return;
            }
        }
    }

    @Override
    public List<Contact> fetch() {
        return contacts;
    }

    @Override
    public void update(Contact contact) {
        for (Contact c: contacts) {
            if (c.getId() == contact.getId()) {
                contacts.remove(c);
                contacts.add(contact);
            }
        }
    }
}
