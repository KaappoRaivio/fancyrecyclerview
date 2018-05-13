package kaappo.monilista;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Entry {
    private static List<Entry> entryList = new ArrayList<>();

    public static String ROW_NORMAL = "normal";
    public static String ROW_NORMAL_WITH_BUTTON = "button";

    private String type;
    private String content;
    private String buttonText;


    Entry (String type, String content) {
        this.content = content;
        this.type = type;
        this.buttonText = String.valueOf(Entry.entryList.size());

        entryList.add(this);
    }

    public static List<Entry> getAll () {
        populate();
        return Entry.entryList;
    }

    private static void populate () {
        new Entry(Entry.ROW_NORMAL, "no button here");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL, "no button here");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL, "no button here");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL, "no button here");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
        new Entry(Entry.ROW_NORMAL_WITH_BUTTON, "the magic button!");
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    @Nullable
    public String getButtonText () {
        String temp;
        if (getType().equals(Entry.ROW_NORMAL_WITH_BUTTON)) {
            temp = buttonText;
        } else {
            temp = null;
        }

        return temp;
    }
}
