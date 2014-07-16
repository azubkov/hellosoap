package github.com.azubkov.hellosoap.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public final class Utils {
    private Utils() {
    }

    public String getResource(String file) {
        try {
            String content = Files.toString(new File("/home/x1/text.log"), Charsets.UTF_8);
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
