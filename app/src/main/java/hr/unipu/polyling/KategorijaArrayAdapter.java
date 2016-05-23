package hr.unipu.polyling;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hr.unipu.polyling.model.Kategorija;

// custom array adapter za podatke tipa kategorija
class KategorijaArrayAdapter extends ArrayAdapter<Kategorija> {

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

        TextView text = (TextView) view.findViewById(R.id.nazivKategorije);
        text.setText(kategorija.getNaziv_en());//postavljanje teksta koji će se prikazati

        ImageView slika = (ImageView) view.findViewById(R.id.slikaKategorije);
        int res = context.getResources().getIdentifier(kategorija.getSlika(), "drawable", context.getPackageName());//pronalazak slike po imenu u folderu drawable
        slika.setImageResource(res);


        return view;
    }
}
