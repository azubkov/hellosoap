package github.com.azubkov.hellosoap.utils;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UtilsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetResource() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("java.io.FileNotFoundException: /home/x1/text.log (No such file or directory)");
        String string = Utils.getResource("lox");
    }

    @Test
    public void testGetResource2() {
        String string = Utils.getResource("github/com/azubkov/hellosoap/document/FarFarAway.txt");
        Assert.assertNotNull(string);
    }
}
