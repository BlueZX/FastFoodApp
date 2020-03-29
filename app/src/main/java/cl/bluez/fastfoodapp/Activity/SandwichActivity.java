package cl.bluez.fastfoodapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cl.bluez.fastfoodapp.R;
import cl.bluez.fastfoodapp.adapter.SandwichAdapter;
import cl.bluez.fastfoodapp.model.Sandwich;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class SandwichActivity extends AppCompatActivity {

    private RecyclerView rv_sandwich;
    private SandwichAdapter adapter;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle(R.string.we_sandwich);

        setContentView(R.layout.activity_sandwich);

        rv_sandwich = (RecyclerView) findViewById(R.id.rv_sandwich);

        llm = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        rv_sandwich.setLayoutManager(llm);

        Sandwich italiano = new Sandwich("Churrasco Italiano","Contiene Filetes delgados de carne lomo de vacuno, 4 Paltas, 4 Tomates, 4 Panes para Sándwich, 2 Dientes de ajo 1/2 Limón, Aceite de Oliva, Pimienta, Sal a gusto, Mayonesa, ketchup, mostaza a elección",3500,R.drawable.italiano);
        Sandwich chacarero = new Sandwich("Churrasco Chacarero", "CONTIENE 400 GRAMOS DE BISTEC DE POSTA ROSADA, POROTOS VERDES, TOMATE GRANDE, SAL, PIMIENTA  Y MANTEQUILLA QUE REPOSAN SOBRE DOS PANES FRICA",3700,R.drawable.chacarero);
        Sandwich barrosluco = new Sandwich("Lomo italiano","400 gramos de bistec de posta rosada a temperatura ambiente\n" +
                "2 paltas grandecitas\n" +
                "1 tomate grande y maduro\n" +
                "1 pan frica\n" +
                "mayonesa\n" +
                "ají verde para servir", 3000,R.drawable.lomo);
        Sandwich churrasco = new Sandwich("Churrasco chacarero"," 1 pan frica, \n" +
                "1 bistec de posta, asiento\n" +
                "porotos verdes (1 taza más o menos)\n" +
                "1 tomate grande y bien maduro\n" +
                "mantequilla", 2900,R.drawable.churrasco);
        Sandwich pollo = new Sandwich("Pollo con Albondigas","Contiene Pan, Albondigas de pollo, queso cheddar, cebolla, pimienta roja y pesto", 2500,R.drawable.pollo_albonigas);

        ArrayList<Sandwich> data = new ArrayList<Sandwich>();

        data.add(italiano);
        data.add(chacarero);
        data.add(barrosluco);
        data.add(churrasco);
        data.add(pollo);

        adapter = new SandwichAdapter(data, this);

        rv_sandwich.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
