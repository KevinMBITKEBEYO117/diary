package eu.epfc.j6077.contactapp;

import java.util.ArrayList;
import java.util.List;

public class MemoryDao implements IDiaryDao {
    private final List<Diary> diarys = new ArrayList<>();

    @Override
    public void add(Diary diary) {
        diarys.add(diary);
    }

    @Override
    public void delete(int id) {
        for (Diary diary : diarys) {
            if (diary.getId() == id) {
                diarys.remove(diary);
                return;
            }
        }
    }

    @Override
    public List<Diary> fetch() {
        return diarys;
    }

    @Override
    public void update(Diary diary) {
        for (Diary c: diarys) {
            if (c.getId() == diary.getId()) {
                diarys.remove(c);
                diarys.add(diary);
            }
        }
    }
}
