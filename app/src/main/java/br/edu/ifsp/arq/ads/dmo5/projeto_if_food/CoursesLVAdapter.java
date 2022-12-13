package br.edu.ifsp.arq.ads.dmo5.projeto_if_food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.edu.ifsp.arq.ads.dmo5.projeto_if_food.Model.MenuModal;

public class CoursesLVAdapter extends ArrayAdapter<MenuModal> {

    // constructor for our list view adapter.
    public CoursesLVAdapter(@NonNull Context context, ArrayList<MenuModal> dataModalArrayList) {
        super(context, 0, dataModalArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.lv_item, parent, false);
        }

        MenuModal menuModal = getItem(position);

        TextView nameTV = listitemView.findViewById(R.id.idTVtext);
        TextView valorTV = listitemView.findViewById(R.id.idTVvalor);

        nameTV.setText(menuModal.getNome());
        valorTV.setText(menuModal.getValor());

        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Voce Selecionou : " + menuModal.getNome(), Toast.LENGTH_SHORT).show();
            }
        });
        return listitemView;
    }
}
