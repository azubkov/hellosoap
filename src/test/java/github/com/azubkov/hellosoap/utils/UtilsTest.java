package github.com.azubkov.hellosoap.utils;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UtilsTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetResourceNotExist() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("resource lox not found.");
        String string = Utils.getResource("lox");
    }

    @Test
    public void testGetResourceExist() {
        String string = Utils.getResource("github/com/azubkov/hellosoap/document/FarFarAway.txt");
        Assert.assertNotNull(string);
        Assert.assertTrue(org.apache.commons.lang3.StringUtils.containsIgnoreCase(string, "far far away"));
    }
}
