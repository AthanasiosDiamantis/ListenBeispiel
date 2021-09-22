package com.example.listenbeispiel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

// zuerst extends
// dann RecyclerView, damit die Klasse von RV erbt
// dann mit . wird etwas Statisches angesprochen in diesem Fall die statische Adapter-Klasse
// trotzdem alles Rot da methoden erst mit implementiert werden müssen --> rechter Mousklick
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainListViewHolder> {

    // Vorher hatte ich die Auto-Klasse angelegt, diese ArrayList wird nun in getItemCount genutzt
    ArrayList<Auto> carList;


    @NonNull
    @Override
    public MainListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // diese 2 Zeilen auswendig lernen
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_layout, parent);
        // ich hole mir die Class von unten hier rauf und fülle die mit dem v
        MainListViewHolder mainListViewHolder = new MainListViewHolder(v);
        return mainListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainListViewHolder holder, int position) {
        Auto a = carList.get(position);

        holder.MarkeFeld.setText(a.getMarke());
        holder.ModellFeld.setText(a.getModell());
        holder.BezeichnungFeld.setText("" + a.getCalendar().get(Calendar.YEAR));

    }
        // Diese Liste hier holt sich aus der ArrayList oben die Size und gibt diese Anzahl zurück
    @Override
    public int getItemCount() {
        return carList.size();
    }

    // diese Klasse haben wir so genannt, Sie soll Festlegen, dass die xml-Zeile des xml-Layouts mit java verknüoft wird
    public class MainListViewHolder extends RecyclerView.ViewHolder {

        TextView MarkeFeld, ModellFeld, BezeichnungFeld;
        ConstraintLayout constraintLayout;

        public MainListViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find View By ID kann nicht alleine stehen, daher muss das Objekt davor stehen
            // hier werden die UI-Elemente aus dem Layout der Listenzeile mit den Java Objekten verknüpfen

            // Ziel ist es im ConstraintLayout die einzelnen Zeilenfarben zu wechseln
            constraintLayout = itemView.findViewById(R.id.conLayID);

            MarkeFeld = itemView.findViewById(R.id.MarkeFeld);
            ModellFeld = itemView.findViewById(R.id.ModellFeld);
            BezeichnungFeld = itemView.findViewById(R.id.BezeichnungFeld);
        }
    }
}
