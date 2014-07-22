package github.com.azubkov.hellosoap.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
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
                String target = string.substring(firstIndex, lastIndex);
                list.add(target);
            }
        }
        list = trim(list);
        return list;
    }

    private static List<String> trim(Iterable<String> iterable) {
        List<String> result = new ArrayList<String>();
        for (String s : iterable) {
            s = s.trim();
            if (s.isEmpty()) {
                continue;
            }
            result.add(s);
        }
        return result;
    }

    public static List<String> toWords(String string) {
        BreakIterator bi = BreakIterator.getWordInstance(Locale.US);
        bi.setText(string);
        List<String> list = new ArrayList<String>();
        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(string.charAt(firstIndex))) {
                String target = string.substring(firstIndex, lastIndex);
                list.add(target);
            }
        }
        return list;
    }

    public static List<String> toLines(String string) {
        String lines[] = string.split("\\r?\\n");
        List<String> list = trim(Arrays.asList(lines));
        return list;
    }

    public static String toParagraph(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return StringUtils.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append('\n');
        }
        return sb.toString();
    }
}
