package eu.epfc.j6077.contactapp;

import java.util.List;

public interface IDiaryUI {
    Diary showAddForm();
    int showDeleteForm();
    void showList(List<Diary> diary);
    String showMenu();


    Diary showUpdateForm();


}
