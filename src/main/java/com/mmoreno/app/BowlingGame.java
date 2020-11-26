package com.mmoreno.app;

public class BowlingGame {
    private int[] rolls;
    private int currentRoll;

    public BowlingGame() {
        this.currentRoll = 0;
        this.rolls = new int[21];
    }

    public void roll(int points) {
        this.rolls[this.currentRoll++] = points;
    }

    public int[] getRolls() {
        return rolls;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(frameIndex)) {
                score += 10 + getSpareBonus(frameIndex);
                frameIndex += 2;
            } else if (isStrike(frameIndex)) {
                score += 10 + getStrikeBonus(frameIndex);
                frameIndex++;
            } else {
                score += getSumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private int getSumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int getSpareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int getStrikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return getSumOfBallsInFrame(frameIndex) == 10;
    }
}
