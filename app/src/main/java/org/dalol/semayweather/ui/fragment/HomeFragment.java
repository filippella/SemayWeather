package org.dalol.semayweather.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dalol.semayweather.R;
import org.dalol.semayweather.adapter.CountryListAdapter;
import org.dalol.semayweather.model.Country;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 4/17/2016
 */
public class HomeFragment extends Fragment {

    @Bind(R.id.wordEntries)
    RecyclerView mRecyclerView;
    private CountryListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(HomeFragment.this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new CountryListAdapter(getLayoutInflater(savedInstanceState), getCountryList());
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<Country> getCountryList() {
        List<Country> countryList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            countryList.add(new Country());
        return countryList;
    }
}
