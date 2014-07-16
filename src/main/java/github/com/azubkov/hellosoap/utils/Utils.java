package github.com.azubkov.hellosoap.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class Utils {
    private Utils() {
    }

    public static String getResource(String path) {
        try {
            URL url = Resources.getResource(path);
            String content = Resources.toString(url, Charsets.UTF_8);
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> toSentences(String string) {
        BreakIterator bi = BreakIterator.getSentenceInstance(Locale.US);
        bi.setText(string);
        List<String> list = new ArrayList<String>();
        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();
            if (lastIndex != BreakIterator.DONE) {
                String sentence = string.substring(firstIndex, lastIndex);
                list.add(sentence);
            }
        }
        List<String> filtered = new ArrayList<String>();
        for (String s : list) {
            filtered.add(s.trim());
        }
        return filtered;
    }

}
