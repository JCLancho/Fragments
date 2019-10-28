package com.example.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentListado extends Fragment {

    private Carrera[] datos = new Carrera[] {
            new Carrera("1º Edicion", R.drawable.cartel5),
            new Carrera("2º Edicion", R.drawable.cartel5),
            new Carrera("3º Edicion", R.drawable.cartel5),
            new Carrera("4º Edicion", R.drawable.cartel5),
            new Carrera("5º Edicion", R.drawable.cartel5)
    };

    private ListView lstListado;
    private CarreraListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView) getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorCorreos(this));

        //Asignamos el evento onItemClick() a la lista de los correos
        lstListado.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                if (listener != null)
                    listener.onCarreraSeleccionado(
                            (Carrera)lstListado.getAdapter().getItem(position));
            }
        });
    }

    class AdaptadorCorreos extends ArrayAdapter<Carrera> {
        Activity context;
        AdaptadorCorreos(Fragment context) {
            super(context.getActivity(), R.layout.listitem_carrera, datos);
            this.context = context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_carrera, null);
            TextView lblEdicion = (TextView) item.findViewById(R.id.lblEdicion);
            lblEdicion.setText(datos[position].getEdicion());


            return (item);
        }
    }


    public void setCorreoListener (CarreraListener listener){
        this.listener = listener;
    }
}

