package tests;

import main.ChangeString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeStringTest {

    @Test
    void countAmountOfLatin() {
        String str = "zxfg123vh";
        ChangeString cs = new ChangeString();
        assertEquals(6, cs.countAmountOfLatin(str));
    }

}