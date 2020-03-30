package br.com.rpolnx.game;

import java.time.LocalDate;
import java.util.Arrays;

public class FinalFantasyXII extends Game {
    @SuppressWarnings("FieldCanBeLocal")
    private int MAX_LEVEL = 99;
    private int partyAverageLevel = 0;

    public FinalFantasyXII() {
        super("Final Fantasy XII", "Square Enix", LocalDate.of(2006, 3, 16),
                new Game.Type[]{Type.RPG, Type.STRATEGY});
    }

    @Override
    public void play() {
        super.init();

        for (int i = 0; i < MAX_LEVEL; i++) {
            this.getExperience();
            if (i % 8 == 0) {
                System.out.print("You passed some main history at party avg level: ");
                this.advanceLevel();
            }
        }
        this.finish();
    }

    @Override
    protected void advanceLevel() {
        System.out.println(partyAverageLevel);
    }

    @Override
    protected void finish() {
        System.out.println("You killed Vayne and saved Dalmasca");
    }

    private void getExperience() {
        partyAverageLevel++;
    }

    @Override
    public String toString() {
        return "FinalFantasyXII{" +
                "MAX_LEVEL=" + MAX_LEVEL +
                ", partyAverageLevel=" + partyAverageLevel +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", type=" + Arrays.toString(type) +
                '}';
    }
}
