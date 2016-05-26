package hr.unipu.polyling.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hr.unipu.polyling.R;

// custom array adapter za podatke tipa kategorija
public class KategorijaArrayAdapter extends ArrayAdapter<Kategorija> {

    Context context;
    List<Kategorija> kategorije;

    public KategorijaArrayAdapter(Context context, int resource, List<Kategorija> kategorije) {
        super(context, resource, kategorije);

        this.context = context;
        this.kategorije = kategorije;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Kategorija kategorija = kategorije.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.kategorija_item, null);//bira custom izgled list itema


        ImageView slika = (ImageView) view.findViewById(R.id.slikaKategorije);
        //pronalazak slike po imenu u folderu drawable
        int res = context.getResources().getIdentifier(kategorija.getSlika(), "drawable", context.getPackageName());
        slika.setImageResource(res);

        //postavljanje teksta koji će se prikazati ispod slike kategorije
        TextView nazivEn = (TextView) view.findViewById(R.id.nazivKategorije);
        nazivEn.setText(kategorija.getNaziv_en());

        TextView nazivHr = (TextView) view.findViewById(R.id.nazivKategorijeHr);
        nazivHr.setText(kategorija.getNaziv_hr());


        return view;
    }
}
