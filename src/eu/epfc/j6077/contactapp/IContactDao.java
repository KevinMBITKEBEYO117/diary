package eu.epfc.j6077.contactapp;

import java.util.List;

public interface IContactDao {
    void add(Contact contact);
    void delete(int id);
    List<Contact> fetch();
    void update(Contact contact);
}
