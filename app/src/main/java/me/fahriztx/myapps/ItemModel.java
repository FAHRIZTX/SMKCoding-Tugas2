package me.fahriztx.myapps;

public class ItemModel {

    String title,lyric;
    int image;

    public ItemModel(String title, String lyric, int image) {
        this.title = title;
        this.lyric = lyric;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric.replace("\\\n", System.getProperty("line.separator"));
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
