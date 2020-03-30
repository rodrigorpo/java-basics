package br.com.rpolnx.game;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class GtaSanAndreas extends Game {
    private Region currentRegion = GtaSanAndreas.Region.LOS_SANTOS;
    private int currentMission = 1;

    enum Region {
        LOS_SANTOS(37),
        SAN_FIERRO(40),
        LAS_VENTURAS(28);

        Region(int numberOfMissions) {
            this.numberOfMissions = numberOfMissions;
        }

        private int numberOfMissions;
    }

    public GtaSanAndreas() {
        super("GTA San Andreas", "Rockstar Games", LocalDate.of(2004, 10, 26),
                new Game.Type[]{Type.ACTION});
    }

    @Override
    public void play() {
        super.init();

        do {
            System.out.printf("\n=== Doing missions for %s Region ===\n", currentRegion);

            for (int missionNumber = 0; missionNumber < currentRegion.numberOfMissions; missionNumber++) {
                System.out.printf("--> Mission #%d passed", currentMission);
                currentMission++;
            }
            this.advanceLevel();
        } while (Objects.nonNull(currentRegion));

        this.finish();
    }

    @Override
    protected void advanceLevel() {
        this.currentRegion = getNextRegion();
    }

    @Override
    protected void finish() {
        System.out.println("\nYou finished all missions");
    }

    private Region getNextRegion() {
        try {
            return Region.values()[getCurrentArrayPosition() + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    private int getCurrentArrayPosition() {
        return Arrays.asList(Region.values()).indexOf(currentRegion);
    }

    @Override
    public String toString() {
        return "GtaSanAndreas{" +
                "currentRegion=" + currentRegion +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", type=" + Arrays.toString(type) +
                '}';
    }
}
