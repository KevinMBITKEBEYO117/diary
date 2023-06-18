package eu.epfc.j6077.contactapp;

import java.util.List;

public class DiaryUC {
    private final DiaryUI diaryUI;
    private final IDiaryDao diaryDao;

    public DiaryUC(IDiaryDao diaryDao, DiaryUI diaryUI) {
        this.diaryDao = diaryDao;
        this.diaryUI = diaryUI;
    }
    public String showMenu() {
        return diaryUI.showMenu();
    }

    public void add() {
        Diary diary = diaryUI.showAddForm();
        diaryDao.add(diary);
    }

    public void delete() {
        int id = diaryUI.showDeleteForm();
        diaryDao.delete(id);
    }

    public void update() {
        Diary diary = diaryUI.showUpdateForm();
        diaryDao.update(diary);
    }

    public void consult() {
        List<Diary> diarys = diaryDao.fetch();
        diaryUI.showList(diarys);
    }
}