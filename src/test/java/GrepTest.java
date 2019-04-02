import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrepTest {

    @Test
    public void Finder1() throws IOException {  //  Тесты для поиска слова
        List<String> list = new ArrayList<String>();
        list.add("'Cause we are the champions of the world");
        list.add("'Cause we are the champions of the world");
        list.add("'Cause we are the champions");
        Assert.assertEquals(list, Grep.finder(false, false, false, "'Cause", "WeAreTheChampions.txt"));
    }

    @Test
    public void Finder2() throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("You brought me fame and fortune and everything that goes with it");
        Assert.assertEquals(list, Grep.finder(false, false, false, "brought", "WeAreTheChampions.txt"));
    }

    @Test
    public void FlagR1() throws IOException {  //  Тесты для флага -r
        List<String> list = new ArrayList<String>();
        list.add("I've taken my bows");
        Assert.assertEquals(list, Grep.finder(true, false, false, ".*\\s(taken)\\s.*", "WeAreTheChampions.txt"));
    }

    @Test
    public void FlagR2() throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("No time for losers");
        list.add("No time for losers");
        list.add("No time for losers");
        Assert.assertEquals(list, Grep.finder(true, false, false, "(No)\\s(time)\\s(for)\\s(losers)", "WeAreTheChampions.txt"));
    }

    @Test
    public void FlagV1() throws IOException {  //  Тесты для флага -v
        List<String> list = new ArrayList<String>();
        list.add("ZenitChampion ...");
        list.add("ZeNiTcHaMpIoN");
        Assert.assertEquals(list, Grep.finder(false, true, false, "zenit", "ZenitChampion.txt"));
    }

    @Test
    public void FlagV2() throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("zenit champion");
        list.add("ZeNiTcHaMpIoN");
        Assert.assertEquals(list, Grep.finder(false, true, false, "Champion", "ZenitChampion.txt"));
    }

    @Test
    public void FlagI1() throws IOException {  //  Тесты для флага -i
        List<String> list = new ArrayList<String>();
        list.add("But committed no crime");
        list.add("But I've come through");
        list.add("But it's been no bed of roses");
        Assert.assertEquals(list, Grep.finder(false, false, true, "BUT", "WeAreTheChampions.txt"));
    }

    @Test
    public void FlagI2() throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("ZenitChampion ...");
        list.add("zenitChampion");
        list.add("zenit champion");
        list.add("ZeNiTcHaMpIoN");
        Assert.assertEquals(list, Grep.finder(false, false, true, "ZeNiT", "ZenitChampion.txt"));
    }

    @Test
    public void AllFlags1() throws IOException {  //  Тесты для всех флагов сразу
        List<String> list = new ArrayList<String>();
        list.add("zenitChampion");
        list.add("ZeNiTcHaMpIoN");
        Assert.assertEquals(list, Grep.finder(true, true, false, ".*\\s.*", "ZenitChampion.txt"));
    }

    @Test
    public void AllFlags2() throws IOException {
        List<String> list = new ArrayList<String>();
        list.add("ZenitChampion ...");
        list.add("zenitChampion");
        list.add("zenit champion");
        list.add("ZeNiTcHaMpIoN");
        Assert.assertEquals(list, Grep.finder(true, true, false, ".*(java).*", "ZenitChampion.txt"));
    }
}