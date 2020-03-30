package br.com.rpolnx.game;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Game {
    protected final String name;
    protected final String author;
    protected final LocalDate releaseDate;
    protected final Game.Type[] type;

    enum Type {
        RPG, ACTION, STRATEGY
    }

    public Game(String name, String author, LocalDate releaseDate, Type[] type) {
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Type[] getType() {
        return type;
    }

    void init() {
        System.out.println("Turns the video game on");
        System.out.println("Explore the world");
    }

    public abstract void play();

    protected abstract void advanceLevel();

    protected abstract void finish();

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", type=" + Arrays.toString(type) +
                '}';
    }
}
