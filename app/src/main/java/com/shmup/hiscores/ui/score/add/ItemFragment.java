package com.shmup.hiscores.ui.score.add;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shmup.hiscores.R;
import com.shmup.hiscores.scores.model.ScoreCardItem;

import static com.shmup.hiscores.ui.score.add.NextItemFragmentFactory.nextFragmentOf;

public abstract class ItemFragment extends Fragment {

    public static final String ITEM_KEY = "item";
    private ScoreCardItem item;
    private int layout;

    public ItemFragment(int layout) {
        this.layout = layout;
    }

    public static Fragment newInstance(ScoreCardItem item, Class<? extends Fragment> clazz) {
        try {
            Bundle args = new Bundle();
            args.putParcelable(ITEM_KEY, item);
            Fragment fragment = clazz.newInstance();
            fragment.setArguments(args);
            return fragment;
        } catch (java.lang.InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        item = getArguments().getParcelable(ITEM_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(layout, container, false);
    }

    public ScoreCardItem getItem() {
        return item;
    }

    protected void goToNextFragmentFrom(Class<? extends ItemFragment> selectShipFragmentClass) {
        getActivity().
                getSupportFragmentManager().
                beginTransaction().
                addToBackStack(selectShipFragmentClass.getSimpleName()).
                replace(R.id.container_view, nextFragmentOf(this)).
                commit();
    }


}
