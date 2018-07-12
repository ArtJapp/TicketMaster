package mrth.legion.ticketmaster.ui.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.ticketmaster.R;
import mrth.legion.ticketmaster.app.Countries;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.presenters.DetailPresenter;
import mrth.legion.ticketmaster.ui.views.DetailView;

public class DetailsActivity extends MvpAppCompatActivity implements DetailView{

    @InjectPresenter
    DetailPresenter presenter;

    @BindView(R.id.imageView)
    ImageView photo;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.prices)
    TextView prices;

    @BindView(R.id.genre)
    TextView genre;

    @BindView(R.id.place)
    TextView place;

    @BindView(R.id.time)
    TextView time;

    @BindView(R.id.date)
    TextView date;

    TextView promoter;

    @BindView(R.id.findTickets)
    Button findTickets;

    @BindView(R.id.tools_bar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_findtickets);
        ButterKnife.bind(this);
        onStartLoading();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        presenter.loadData(id);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_activity_menu, menu);
        menu.getItem(0).setTitle(TicketMasterApp.getCountryCode());
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_micro: {
                Toast.makeText(this, "Adding to your calendar", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_item_share: {
                Toast.makeText(this, "Sharing event with your friends", Toast.LENGTH_SHORT).show();
                break;
            }
            case android.R.id.home:
                finish();
        }
        return true;
    }

    @Override
    public void showEvent(Event event) {
        name.setText(event.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat output = new SimpleDateFormat("dd.MM.yyyy");
        Date d;
        try {
            d = sdf.parse(event.getDates().getStart().getLocalDate());
            String formattedTime = output.format(d);
            date.setText(formattedTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

         sdf = new SimpleDateFormat("HH:mm:ss");
         output = new SimpleDateFormat("HH:mm");

        try {
            d = sdf.parse(event.getDates().getStart().getLocalTime());
            String formattedTime = output.format(d);
            time.setText(formattedTime);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            time.setText("");
        }
        if (event.getPromoter() == null) {
            place.setText("");
        } else {
            place.setText(event.getPromoter().getName());
        }
        if (event.getPriceRanges() == null) {
            prices.setText("Check promoter's site for prices");
        } else {
            prices.setText("$" + event.getPriceRanges().get(0).getMin() +" - $" + event.getPriceRanges().get(0).getMax());
        }
        genre.setText(event.getClassifications().get(0).getGenre().getName());
//        promoter.setText(event.getPromoters().get(0).getName());
        TicketMasterApp.getPicasso().load(event.getImages().get(0).getUrl()).into(photo);

        findTickets.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(event.getUrl()));
            startActivity(intent);
        });

        onFinishLoading();
    }

    @Override
    public void showError() {
        Log.d("DetailActivity", "Lol kek, there is an error");
        Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartLoading() {
        name.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);
        place.setVisibility(View.INVISIBLE);
        prices.setVisibility(View.INVISIBLE);
        genre.setVisibility(View.INVISIBLE);
    //    promoter.setVisibility(View.INVISIBLE);
        findTickets.setVisibility(View.INVISIBLE);
        photo.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onFinishLoading() {

        name.setVisibility(View.VISIBLE);
        time.setVisibility(View.VISIBLE);
        place.setVisibility(View.VISIBLE);
        prices.setVisibility(View.VISIBLE);
        genre.setVisibility(View.VISIBLE);
  //      promoter.setVisibility(View.VISIBLE);
        findTickets.setVisibility(View.VISIBLE);
        photo.setVisibility(View.VISIBLE);
    }
}
