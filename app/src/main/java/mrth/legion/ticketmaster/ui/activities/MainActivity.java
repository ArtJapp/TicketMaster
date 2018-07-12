package mrth.legion.ticketmaster.ui.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import mrth.legion.ticketmaster.R;
import mrth.legion.ticketmaster.app.Countries;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.presenters.TicketsPresenter;
import mrth.legion.ticketmaster.ui.adapters.TicketViewAdapter;
import mrth.legion.ticketmaster.ui.views.TicketsView;

public class MainActivity extends MvpAppCompatActivity implements TicketsView {

    @InjectPresenter
    TicketsPresenter presenter;

    private TicketViewAdapter adapter;

    RecyclerView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventList = findViewById(R.id.listEvents);
        adapter = new TicketViewAdapter(this);
        eventList.setAdapter(adapter);
        eventList.setLayoutManager(new LinearLayoutManager(this));

        presenter.loadResults();

        Toolbar t = findViewById(R.id.tool_bar);
        setSupportActionBar(t);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        menu.getItem(0).setTitle(TicketMasterApp.getCountryCode());
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_pick_country) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose the country");

            // add a list
            String[] countryList = new String[Countries.getListCountries().size()];
            int i = 0;
            for (String country : Countries.getListCountries()) {
                countryList[i] = country;
                i++;
            }


            builder.setItems(countryList, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String newCode = presenter.pickCountry(countryList[which]);
                    item.setTitle(newCode);
                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        return true;
    }

    @Override
    public void showEvents(List<Event> events) {
        adapter.setEvents(events);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "Nothing", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addEvents(List<Event> events) {
        adapter.setEvents(events);
    }

    @Override
    public void onStartLoading() {
    //Nothing to do
        //Должен появиться крутящийся кружок
    }

    @Override
    public void onFinishLoading() {
        //Nothing to do
    }
}
