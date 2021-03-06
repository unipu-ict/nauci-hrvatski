package hr.unipu.polyling.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import hr.unipu.polyling.R;

public class FrazeArrayAdapter extends ArrayAdapter<Fraza>{
    Context context;
    List<Fraza> fraze;

    public FrazeArrayAdapter(Context context, int resource, List<Fraza> fraze) {
        super(context, resource, fraze);

        this.context = context;
        this.fraze = fraze;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fraza fraza = fraze.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.fraza_item, null);

        TextView nazivEn = (TextView) view.findViewById(R.id.nazivFrazeItem);
        nazivEn.setText(fraza.getNaziv_en());

        TextView nazivHr = (TextView) view.findViewById(R.id.nazivFrazeHrItem);
        nazivHr.setText(fraza.getNaziv_hr());

//        if (position % 5 == 0)
//            view.setBackgroundColor(Color.parseColor("#d2e7ff"));
//        else if (position % 5 == 1)
//            view.setBackgroundColor(Color.parseColor("#f4f1e6"));
//        else if (position % 5 == 2)
//            view.setBackgroundColor(Color.parseColor("#ead4e1"));
//        else if (position % 5 == 3)
//            view.setBackgroundColor(Color.parseColor("#d6b6c3"));
//        else
//            view.setBackgroundColor(Color.parseColor("#d09db9"));

        //manje šarenila
        if(position % 2 ==0) {
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            nazivEn.setTextColor(Color.parseColor("#3333cc"));
            nazivHr.setTextColor(Color.parseColor("#3333cc"));

        }
        else {
            view.setBackgroundColor(Color.parseColor("#e6f7ff"));
            nazivEn.setTextColor(Color.parseColor("#3333cc"));
            nazivHr.setTextColor(Color.parseColor("#3333cc"));
        }

        return view;
    }
}
