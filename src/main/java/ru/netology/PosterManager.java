package ru.netology;

public class PosterManager {
    private PosterItem[] posters = new PosterItem[0];
    private int limit;

    public PosterManager() {
        this.limit = 5;
    }

    public PosterManager(int limit) {
        this.limit = limit;
    }

    public void add(PosterItem item) {
        PosterItem[] tmp = new PosterItem[posters.length + 1];

        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }

        tmp[tmp.length - 1] = item;

        posters = tmp;
    }

    public PosterItem[] findAll() {
        return posters;
    }

    public PosterItem[] findLast() {
        int resultLength;

        if (posters.length < limit) {
            resultLength = posters.length;
        } else {
            resultLength = limit;
        }

        PosterItem[] result = new PosterItem[resultLength];

        for (int i = 0; i < resultLength; i++) {
            int index = posters.length - 1 - i;
            result[i] = posters[index];
        }
        return result;
    }
}