package github.com.azubkov.hellosoap.utils;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

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

    @Test
    public void testToSentences() {
        List<String> list = Utils.toSentences("Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.\n" +
                "\n" +
                " Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.\n" +
                "\n" +
                " A small river named Duden flows by their place and supplies it with the necessary regelialia.");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0), "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.");
        Assert.assertEquals(list.get(1), "Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.");
        Assert.assertEquals(list.get(2), "A small river named Duden flows by their place and supplies it with the necessary regelialia.");
    }

    @Test
    public void testToWords() {
        List<String> list = Utils.toWords("Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.\n" +
                "\n" +
                " Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.\n" +
                "\n" +
                " A small river named Duden flows by their place and supplies it with the necessary regelialia.");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0), "Far");
        Assert.assertEquals(list.get(1), "far");
        Assert.assertEquals(list.get(2), "away");
        Assert.assertEquals(list.get(3), "behind");
        Assert.assertEquals(list.get(4), "the");
    }
}
