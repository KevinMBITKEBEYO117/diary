package eu.epfc.j6077.contactapp;

import java.time.LocalDate;

public class Diary {
    private int id;
    private String title;
    private Boolean isPublic;
    private LocalDate begin;

    public Diary(String title, Boolean isPublic, LocalDate begin) {
        this.title = title;
        this.isPublic = isPublic;
        this.begin = begin;
    }

    public Diary(int id, String title, Boolean isPublic, LocalDate begin) {
        this.id = id;
        this.title = title;
        this.isPublic = isPublic;
        this.begin = begin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

}