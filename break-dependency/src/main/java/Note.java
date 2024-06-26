//import io.reactivex.rxjava3.core.Completable;
//import io.reactivex.rxjava3.core.Scheduler;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Note {
    private final String DEFAULT_FILE_NAME = "note.txt";
    private final TextFile textFile; // "textFile" is dependency of "Note"
    private BirthdayChecker birthdayChecker;

    public Note(TextFile textFile) {
        this.textFile = textFile;
        this.create();
    }

    public Note(TextFile textFile, BirthdayChecker birthdayChecker) {
        this.textFile = textFile;
        this.birthdayChecker = birthdayChecker;
    }

    private void create() {
        textFile.create(DEFAULT_FILE_NAME);
    }

    public void write(String content) {
        if (birthdayChecker != null && birthdayChecker.isBirthday()) {
            content += " 🎂";
        }
        textFile.write(DEFAULT_FILE_NAME, content);
    }

    public Completable writeAsync(String content, Scheduler scheduler) {
        return Completable.fromAction(() -> write(content)).subscribeOn(scheduler);
    }
//    public Completable writeAsync(String content) {
//        return Completable.fromAction(() -> write(content)).subscribeOn(Schedulers.io());
//    }

    public String read() {
        return textFile.read(DEFAULT_FILE_NAME);
    }
}
