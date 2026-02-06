package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterItem item1 = new PosterItem(1, "url1", "Бладшот", "боевик");
    PosterItem item2 = new PosterItem(2, "url2", "Вперёд", "мультфильм");
    PosterItem item3 = new PosterItem(3, "url3", "Отель «Белград»", "комедия");
    PosterItem item4 = new PosterItem(4, "url4", "Джентльмены", "боевик");
    PosterItem item5 = new PosterItem(5, "url5", "Человек-невидимка", "ужасы");
    PosterItem item6 = new PosterItem(6, "url6", "Тролли", "мультфильм");
    PosterItem item7 = new PosterItem(7, "url7", "Номер один", "комедия");

    @Test
    public void shouldAddPostersAndFindAll() {
        PosterManager manager = new PosterManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        PosterItem[] expected = {item1, item2, item3};
        PosterItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastBelowLimit() {

        PosterManager manager = new PosterManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        PosterItem[] expected = {item3, item2, item1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastExactlyLimit() {

        PosterManager manager = new PosterManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        PosterItem[] expected = {item5, item4, item3, item2, item1};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastOverLimitDefault() {

        PosterManager manager = new PosterManager();
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);

        PosterItem[] expected = {item7, item6, item5, item4, item3};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimit() {

        PosterManager manager = new PosterManager(3);
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        PosterItem[] expected = {item5, item4, item3};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldWorkWithEmptyManager() {
        PosterManager manager = new PosterManager();

        PosterItem[] expected = {};
        PosterItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}