package com.github.wolfie.columntext.client.ui;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class SplitUtilTest {
  
  @Test
  public void testSplitHTML() {
    assertArrayEquals(new String[] { "a", "b" }, SplitUtil.splitHTML("a b"));
    assertArrayEquals(Arrays.asList(SplitUtil.splitHTML("<a>")).toString(),
        new String[] { "<a>" }, SplitUtil.splitHTML("<a>"));
    assertArrayEquals(new String[] { "<a href='foo'>" }, SplitUtil
        .splitHTML("<a href='foo'>"));
    assertArrayEquals(Arrays.asList(
        SplitUtil.splitHTML("<a href='foo'> bar </a>")).toString(),
        new String[] { "<a href='foo'>", "bar", "</a>" }, SplitUtil
            .splitHTML("<a href='foo'> bar </a>"));
    assertArrayEquals(new String[] { "<a href='f<o>o'>", "bar", "</a>" },
        SplitUtil.splitHTML("<a href='f<o>o'> bar </a>"));
    assertArrayEquals(new String[] { "<a property='\"'>", "bar", "</a>" },
        SplitUtil.splitHTML("<a property='\"'> bar </a>"));
    assertArrayEquals(new String[] { "<a property='\">'>" }, SplitUtil
        .splitHTML("<a property='\">'>"));
    assertArrayEquals(new String[] { "<a property=\"'>\">" }, SplitUtil
        .splitHTML("<a property=\"'>\">"));
    assertArrayEquals(new String[] { "a", "'b", "c'", "d" }, SplitUtil
        .splitHTML("a 'b c' d"));
    assertArrayEquals(
        new String[] { "text", "<tag>", "text", "</tag>", "text" }, SplitUtil
            .splitHTML("text<tag>text</tag>text"));
    assertArrayEquals(new String[] { "<h1>", "Lorem", "ipsum", "</h1>" },
        SplitUtil.splitHTML("<h1>Lorem ipsum</h1>"));
  }
}
