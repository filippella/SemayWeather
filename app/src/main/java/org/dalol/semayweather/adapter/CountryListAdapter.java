package org.dalol.semayweather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.dalol.semayweather.R;
import org.dalol.semayweather.model.Country;

import java.util.List;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 4/24/2016
 */
public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.Holder> {

    private final LayoutInflater mInflater;
    private List<Country> mCountries;

    public CountryListAdapter(LayoutInflater inflater, List<Country> countries) {
        mInflater = inflater;
        mCountries = countries;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.country_item, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {
            super(itemView);
        }
    }
}
