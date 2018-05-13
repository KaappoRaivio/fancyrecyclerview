package kaappo.monilista;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Entry {
    private static List<Entry> entries = new ArrayList<>();

    public static Entry PLACEHOLDER = new Entry(true);

    private String title;
    private String content;
    private boolean placeholder;
    private int ID;


    Entry (String title, String content) {
        this.title = title;
        this.content = content;
        this.placeholder = false;
        this.ID = getFreeID();

        entries.add(this);
    }
    Entry (boolean placeholder) {
        placeholder = true;
    }

    private static void populate () {
        new Entry("Kauppalista", "Maitoa\nLeipää\nKinkkua\nJuustoa");
        new Entry("Läksyt", "Matikka: s.8–9, teht. 3–5");

    }

    public static List<Entry> get () {
        populate();

        List<Entry> temp = entries;
        temp.add(PLACEHOLDER);
        return temp;
    }

    private static int getFreeID () {
        int biggest = -1;

        for (Entry i : entries) {
            if (i.getID() > biggest) {
                biggest = i.getID();
            }
        }

        return biggest + 1;
    }

    @Nullable
    public static Entry findEntryByID (int ID) {
        for (Entry entry : entries) {
            if (entry.getID() == ID) {
                return entry;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean isPlaceholder() {
        return placeholder;
    }

    public static List<Entry> getEntries() {
        return entries;
    }

    public int getID() {
        return ID;
    }
}