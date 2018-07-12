package mrth.legion.ticketmaster.ui.activities;

import android.app.Activity;
import android.content.Intent;
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

        Button showEventsButton = findViewById(R.id.btnSearch);

        eventList = findViewById(R.id.listEvents);
        adapter = new TicketViewAdapter(this);
        eventList.setAdapter(adapter);
        eventList.setLayoutManager(new LinearLayoutManager(this));

        showEventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadResults();
            }
        });

        Button button = findViewById(R.id.btnCountry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication().getApplicationContext(), CountriesActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        Toolbar t = findViewById(R.id.tool_bar);
        setSupportActionBar(t);
        Button b = t.findViewById(R.id.action_pick_country);
        View customV = getLayoutInflater().inflate(R.layout.toolbar, null);
        b = customV.findViewById(R.id.action_pick_country);
        if (b != null) {

            b.setText(TicketMasterApp.getCountryCode());
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("blayd", "country change button");
                }
            });
        } else {
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        menu.getItem(0).setTitle(TicketMasterApp.getCountryCode());
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_pick_country) {
            Log.d("CYKE", "it works");

        }
        return true;
    }


        @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Log.d("Loggy", "It's oK");
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

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

    }

    @Override
    public void onFinishLoading() {

    }
}
