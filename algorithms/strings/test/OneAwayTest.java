import org.junit.Test;

import static algorithms.strings.OneAway.isOneAway;
import static org.junit.Assert.assertEquals;

public class OneAwayTest {
    @Test
    public void test1() {
        String str1 = "pale";
        String str2 = "ple";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test2() {
        String str1 = "pale";
        String str2 = "pales";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test3(){
        String str1 = "pale";
        String str2 = "bale";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test4() {
        String str1 = "pale";
        String str2 = "bake";
        assertEquals(false, isOneAway(str1, str2));
    }

    @Test
    public void test5() {
        String str1 = "palessss";
        String str2 = "pale";
        assertEquals(false, isOneAway(str1, str2));
    }

    @Test
    public void test6() {
        String str1 = "";
        String str2 = "p";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test7() {
        String str1 = "a";
        String str2 = "b";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test8() {
        String str1 = "a";
        String str2 = "";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test9() {
        String str1 = "ab";
        String str2 = "";
        assertEquals(false, isOneAway(str1, str2));
    }

    @Test
    public void test10() {
        String str1 = "";
        String str2 = "ab";
        assertEquals(false, isOneAway(str1, str2));
    }

    @Test
    public void test11() {
        String str1 = "cat";
        String str2 = "dog";
        assertEquals(false, isOneAway(str1, str2));
    }

    @Test
    public void test12() {
        String str1 = "cat";
        String str2 = "cats";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test13() {
        String str1 = "cat";
        String str2 = "cut";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test14() {
        String str1 = "cat";
        String str2 = "cast";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test15() {
        String str1 = "cat";
        String str2 = "at";
        assertEquals(true, isOneAway(str1, str2));
    }

    @Test
    public void test16() {
        String str1 = "cat";
        String str2 = "act";
        assertEquals(false, isOneAway(str1, str2));
    }
}
