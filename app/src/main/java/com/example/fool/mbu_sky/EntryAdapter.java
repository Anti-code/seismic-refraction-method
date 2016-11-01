package com.example.fool.mbu_sky;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fool on 10/31/16.
 */

class EntryAdapter extends ArrayAdapter<Entry> {

    public EntryAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public EntryAdapter(Context context, int resource, List<Entry> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.entry_item, null);
        }

        Entry p = getItem(position);

        if (p != null) {
            final TextView title = (TextView) v.findViewById(R.id.item);
            final TextView itemlat= (TextView) v.findViewById(R.id.itemlat);

            final TextView itemlng= (TextView) v.findViewById(R.id.itemlng);
            title.setText(p.getTitle());
            itemlat.setText(String.valueOf(p.getLat()));
            itemlng.setText(String.valueOf(p.getLng()));
            TextView itemdate = (TextView) v.findViewById(R.id.itemdate);
            Button map = (Button) v.findViewById(R.id.itemmap);
            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), MapsActivity.class);
                    i.putExtra("title", title.getText());
                    i.putExtra("lat", itemlat.getText());
                    i.putExtra("lng", itemlng.getText());
                    v.getContext().startActivity(i);
                }
            });
        }

        return v;
    }

}