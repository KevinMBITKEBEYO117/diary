package eu.epfc.j6077.contactapp;

import java.io.PrintStream;
import java.util.Scanner;

public class DiaryApplication {
    private final DiaryUC diaryUC;

    public DiaryApplication(DiaryUC diaryUC) {
        this.diaryUC = diaryUC;
    }

    public static void main(String[] args) {
        String connectionString;
        if (args.length >= 1) {
            connectionString = args[0];
        } else {
            connectionString = "jdbc:h2:./contact";
        }

        IDiaryDao diaryDao = new DiaryDao(connectionString);
        PrintStream printStream = System.out;
        DiaryUI diaryUI = new DiaryUI(new Scanner(System.in), printStream);
        DiaryUC diaryUC = new DiaryUC(diaryDao, diaryUI);
        DiaryApplication diaryApplication = new DiaryApplication(diaryUC);

        diaryApplication.run();
        printStream.close();
    }

    public void run() {
        String choice;
        do {
            choice = diaryUC.showMenu();
            switch (choice) {
                case "1" -> diaryUC.consult();
                case "2" -> diaryUC.add();
                case "3" -> diaryUC.update();
                case "4" -> diaryUC.delete();
            }
        } while (! choice.equals("Q"));
    }
}
