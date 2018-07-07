package mrth.legion.ticketmaster.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.ticketmaster.R;
import mrth.legion.ticketmaster.app.Countries;
import mrth.legion.ticketmaster.app.TicketMasterApi;
import mrth.legion.ticketmaster.app.TicketMasterApp;

public class CountriesActivity extends AppCompatActivity {

    @BindView(R.id.country_list)
    ListView country_list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_activity);
        ButterKnife.bind(this);
        String[] v = (String[]) Countries.getListCountries().toArray();
      //  ArrayAdapter ss = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Countries.getListCountries());
        country_list.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, Countries.getListCountries()));

        country_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TicketMasterApp.setCodeCountry(((TextView)view).getText().toString());
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
