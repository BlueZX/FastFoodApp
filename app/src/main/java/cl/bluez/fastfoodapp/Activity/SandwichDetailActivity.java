package cl.bluez.fastfoodapp.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import cl.bluez.fastfoodapp.R;
import cl.bluez.fastfoodapp.model.Sandwich;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SandwichDetailActivity extends AppCompatActivity {

    private Sandwich sandwich;
    private ImageView iv_sandwich;
    private TextView tv_name_detail;
    private TextView tv_cost_detail;
    private TextView tv_description_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();

        setContentView(R.layout.activity_sandwich_detail);

        sandwich = (Sandwich) getIntent().getSerializableExtra("sandwich");

        actionBar.setTitle(sandwich.getName());

        iv_sandwich = (ImageView) findViewById(R.id.iv_detail_sandwich);
        tv_name_detail = (TextView) findViewById(R.id.tv_name_detail);
        tv_cost_detail = (TextView) findViewById(R.id.tv_cost_detail);
        tv_description_detail = (TextView) findViewById(R.id.tv_description_detail);

        iv_sandwich.setImageResource(sandwich.getImage());
        tv_name_detail.setText(sandwich.getName());
        tv_description_detail.setText(sandwich.getDescription());
        tv_cost_detail.setText(sandwich.getCost()+"$");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if( itemId == R.id.btn_close){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.quiet, R.anim.slide_out_down);
    }
}
