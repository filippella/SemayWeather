package org.dalol.semayweather.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.dalol.semayweather.R;
import org.dalol.semayweather.model.ListItem;
import org.dalol.semayweather.ui.activity.MainActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 4/24/2016
 */
public class PopupAdapter extends ArrayAdapter<ListItem> implements Filterable {

    private final ArrayList<ListItem> itemList;
    LayoutInflater inflater;
    ArrayList<ListItem> objects;
    ViewHolder holder = null;

    public PopupAdapter(Context context, int textViewResourceId, ArrayList<ListItem> objects) {
        super(context, textViewResourceId, objects);
        inflater = ((Activity) context).getLayoutInflater();
        this.itemList = objects;
        this.objects = objects;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        ListItem listItem = objects.get(position);
        View row = convertView;

        if (null == row) {
            holder = new ViewHolder();
            row = inflater.inflate(R.layout.row, parent, false);
            holder.name = (TextView) row.findViewById(R.id.name);
            holder.place = (TextView) row.findViewById(R.id.place);
            holder.imgThumb = (ImageView) row.findViewById(R.id.imgThumb);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.name.setText(listItem.name);
        holder.place.setText(listItem.place);
        holder.imgThumb.setBackgroundResource(listItem.logo);

        return row;
    }

    static class ViewHolder {
        TextView name, place;
        ImageView imgThumb;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final List<ListItem> results = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    oReturn.values = itemList;
                    oReturn.count = itemList.size();
                }

                else {
                    objects = itemList;

                    for (ListItem item : objects) {
                        if (item.name.toString().toLowerCase().contains(constraint.toString())) {
                            results.add(item);
                        }
                    }
                    oReturn.values = results;
                    oReturn.count = results.size();
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                objects = (ArrayList<ListItem>) results.values;
                if (results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
    }

    @Override
    public int getCount() {
        return objects.size();
    }
}