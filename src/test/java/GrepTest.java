import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrepTest {

    @Test
    public void Finder1() {  //  Тесты для поиска слова
        List<String> list = new ArrayList<String>();
        list.add("'Cause we are the champions of the world");
        list.add("'Cause we are the champions of the world");
        list.add("'Cause we are the champions");
        try {
            Assert.assertEquals(list, Grep.finder(false, false, false, "'Cause", "WeAreTheChampions.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Finder2() {
        List<String> list = new ArrayList<String>();
        list.add("You brought me fame and fortune and everything that goes with it");
        try {
            Assert.assertEquals(list, Grep.finder(false, false, false, "brought", "WeAreTheChampions.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FlagR1() {  //  Тесты для флага -r
        List<String> list = new ArrayList<String>();
        list.add("I've taken my bows");
        try {
            Assert.assertEquals(list, Grep.finder(true, false, false, ".*\\s(taken)\\s.*", "WeAreTheChampions.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FlagR2() {
        List<String> list = new ArrayList<String>();
        list.add("No time for losers");
        list.add("No time for losers");
        list.add("No time for losers");
        try {
            Assert.assertEquals(list, Grep.finder(true, false, false, "(No)\\s(time)\\s(for)\\s(losers)", "WeAreTheChampions.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FlagV1() {  //  Тесты для флага -v
        List<String> list = new ArrayList<String>();
        list.add("ZenitChampion ...");
        list.add("ZeNiTcHaMpIoN");
        try {
            Assert.assertEquals(list, Grep.finder(false, true, false, "zenit", "ZenitChampion.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FlagV2() {
        List<String> list = new ArrayList<String>();
        list.add("zenit champion");
        list.add("ZeNiTcHaMpIoN");
        try {
            Assert.assertEquals(list, Grep.finder(false, true, false, "Champion", "ZenitChampion.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FlagI1() {  //  Тесты для флага -i
        List<String> list = new ArrayList<String>();
        list.add("But committed no crime");
        list.add("But I've come through");
        list.add("But it's been no bed of roses");
        try {
            Assert.assertEquals(list, Grep.finder(false, false, true, "BUT", "WeAreTheChampions.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FlagI2() {
        List<String> list = new ArrayList<String>();
        list.add("ZenitChampion ...");
        list.add("zenitChampion");
        list.add("zenit champion");
        list.add("ZeNiTcHaMpIoN");
        try {
            Assert.assertEquals(list, Grep.finder(false, false, true, "ZeNiT", "ZenitChampion.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AllFlags1() {  //  Тесты для всех флагов сразу
        List<String> list = new ArrayList<String>();
        list.add("zenitChampion");
        list.add("ZeNiTcHaMpIoN");
        try {
            Assert.assertEquals(list, Grep.finder(true, true, false, ".*\\s.*", "ZenitChampion.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AllFlags2() {
        List<String> list = new ArrayList<String>();
        list.add("ZenitChampion ...");
        list.add("zenitChampion");
        list.add("zenit champion");
        list.add("ZeNiTcHaMpIoN");
        try {
            Assert.assertEquals(list, Grep.finder(true, true, false, ".*(java).*", "ZenitChampion.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}