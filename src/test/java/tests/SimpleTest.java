package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    @Tag("simple")
    void simpleTest () {
        String string = System.getProperty("browser", "opera");
        System.out.println(string);
    }
}
