package quesado.prado.saramaria.miwok.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import quesado.prado.saramaria.miwok.ColorFragment;
import quesado.prado.saramaria.miwok.FamilyFragment;
import quesado.prado.saramaria.miwok.NumbersFragment;
import quesado.prado.saramaria.miwok.PhraseFragment;

public class MiwokViewPagerAdapter extends FragmentPagerAdapter {
    public MiwokViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new NumbersFragment();
            case 1: return new ColorFragment();
            case 2: return new FamilyFragment();
            case 3: return new PhraseFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Numbers";
            case 1: return "Colors";
            case 2: return "Family";
            case 3: return "Phrases";
        }
        return "Miwok";
    }
}