package parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void replaceLoop() {
        assertEquals("Loop", StringUtil.replaceLoop("LOOP"));
        assertEquals("Loop", StringUtil.replaceLoop("LooP"));
        assertEquals("Loop", StringUtil.replaceLoop("loop"));
        assertEquals("Loop", StringUtil.replaceLoop("Loop"));
    }

    @Test
    void replaceWhile() {
        assertEquals("While", StringUtil.replaceWhile("while"));
        assertEquals("While", StringUtil.replaceWhile("WHILE"));
        assertEquals("While", StringUtil.replaceWhile("While"));
        assertEquals("While", StringUtil.replaceWhile("WhIle"));
    }

    @Test
    void replaceDo() {
        assertEquals("Do", StringUtil.replaceDo("DO"));
        assertEquals("Do", StringUtil.replaceDo("Do"));
        assertEquals("Do", StringUtil.replaceDo("dO"));
        assertEquals("Do", StringUtil.replaceDo("do"));
    }

    @Test
    void replaceEnd() {
        assertEquals("End", StringUtil.replaceEnd("End"));
        assertEquals("End", StringUtil.replaceEnd("END"));
        assertEquals("End", StringUtil.replaceEnd("end"));
        assertEquals("End", StringUtil.replaceEnd("EnD"));
    }

    @Test
    void removeSemicolon() {
        assertEquals("End", StringUtil.removeSemicolon("End;"));
        assertEquals("End", StringUtil.removeSemicolon("End;;"));
        assertEquals("abcd", StringUtil.removeSemicolon(";ab;cd;"));
        assertEquals("Do", StringUtil.removeSemicolon("Do"));
    }

    @Test
    void appendSemicolon() {
        assertEquals("abc;", StringUtil.appendSemicolon("abc"));
        assertEquals("End;;", StringUtil.appendSemicolon("End;"));
        assertEquals(";", StringUtil.appendSemicolon(""));
    }

    @Test
    void isCommented() {
        assertEquals(true, StringUtil.isCommented("//abc"));
        assertEquals(false, StringUtil.isCommented("End;//"));
        assertEquals(false, StringUtil.isCommented("End"));
    }

    @Test
    void isBlockStart() {
        assertEquals(true, StringUtil.isBlockStart("Loop"));
        assertEquals(true, StringUtil.isBlockStart("While"));
        assertEquals(true, StringUtil.isBlockStart("  Loop"));
        assertEquals(true, StringUtil.isBlockStart("  While"));
        assertEquals(true, StringUtil.isBlockStart("  Loop..."));
        assertEquals(true, StringUtil.isBlockStart("  While..."));
        assertEquals(false, StringUtil.isBlockStart("Whille"));
        assertEquals(false, StringUtil.isBlockStart("End"));
        assertEquals(false, StringUtil.isBlockStart("x1 = x0 + 0"));
    }

    @Test
    void isBlockEnd() {
        assertEquals(true, StringUtil.isBlockEnd("End"));
        assertEquals(true, StringUtil.isBlockEnd("  End"));
        assertEquals(true, StringUtil.isBlockEnd("  End..."));
        assertEquals(false, StringUtil.isBlockEnd("While"));
        assertEquals(false, StringUtil.isBlockEnd("Loop"));
        assertEquals(false, StringUtil.isBlockEnd("Ennd"));
        assertEquals(false, StringUtil.isBlockEnd("x1 = x0 + 0"));
    }

    @Test
    void xToLowerCase() {
        assertEquals("x", StringUtil.xToLowerCase("X"));
        assertEquals("x", StringUtil.xToLowerCase("x"));
        assertEquals("x1", StringUtil.xToLowerCase("X1"));
    }
}