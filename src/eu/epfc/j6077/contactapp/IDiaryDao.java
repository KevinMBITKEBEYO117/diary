package eu.epfc.j6077.contactapp;

import java.util.List;

public interface IDiaryDao {
    void add(Diary diary);
    void delete(int id);
    List<Diary> fetch();
    void update(Diary diary);
}
