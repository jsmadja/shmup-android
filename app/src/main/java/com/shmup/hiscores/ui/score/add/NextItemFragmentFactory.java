package com.shmup.hiscores.ui.score.add;

import android.support.v4.app.Fragment;

import com.shmup.hiscores.scores.model.ScoreCardItem;
import com.shmup.hiscores.ui.score.add.options.SelectDifficultyFragment;
import com.shmup.hiscores.ui.score.add.options.SelectModeFragment;
import com.shmup.hiscores.ui.score.add.options.SelectPlatformFragment;
import com.shmup.hiscores.ui.score.add.options.SelectShipFragment;
import com.shmup.hiscores.ui.score.add.options.SelectStageFragment;

public class NextItemFragmentFactory {

    public static Fragment nextFragmentOf(ItemFragment from) {
        if (from instanceof SelectPlatformFragment) {
            return nextOfSelectPlatform(from.getItem());
        }
        if (from instanceof SelectModeFragment) {
            return nextOfSelectMode(from.getItem());
        }
        if (from instanceof SelectDifficultyFragment) {
            return nextOfSelectDifficulty(from.getItem());
        }
        if (from instanceof SelectShipFragment) {
            nextOfSelectShip(from.getItem());
        }
        return nextOfSelectStage(from.getItem());
    }

    private static Fragment nextOfSelectStage(ScoreCardItem item) {
        return ItemFragment.newInstance(item, TypeScoreFragment.class);
    }

    private static Fragment nextOfSelectShip(ScoreCardItem item) {
        if (item.getGame().hasStages()) {
            return ItemFragment.newInstance(item, SelectStageFragment.class);
        }
        return nextOfSelectStage(item);
    }

    private static Fragment nextOfSelectDifficulty(ScoreCardItem item) {
        if (item.getGame().hasShips()) {
            return ItemFragment.newInstance(item, SelectShipFragment.class);
        }
        return nextOfSelectShip(item);
    }

    private static Fragment nextOfSelectMode(ScoreCardItem item) {
        if (item.getGame().hasDifficulties()) {
            return ItemFragment.newInstance(item, SelectDifficultyFragment.class);
        }
        return nextOfSelectDifficulty(item);
    }

    private static Fragment nextOfSelectPlatform(ScoreCardItem item) {
        if (item.getGame().hasModes()) {
            return ItemFragment.newInstance(item, SelectModeFragment.class);
        }
        return nextOfSelectMode(item);
    }
}
