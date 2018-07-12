package mrth.legion.ticketmaster.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.ticketmaster.R;
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

    TextView promoter;

    @BindView(R.id.findTickets)
    Button findTickets;

    @Override
    protected void onCreate(@Nullable Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.activity_findtickets);
        ButterKnife.bind(this);
        onStartLoading();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        presenter.loadData(id);

    }

    @Override
    public void showEvent(Event event) {
        name.setText(event.getName());
        time.setText(event.getDates().getStart().getLocalDate() +" "+ event.getDates().getStart().getLocalTime());
//        place.setText(event.getPromoter().getName());
        prices.setText(event.getPriceRanges().get(0).getMin() +" - " + event.getPriceRanges().get(0).getMax());
        genre.setText(event.getClassifications().get(0).getGenre().getName());
//        promoter.setText(event.getPromoters().get(0).getName());
        TicketMasterApp.getPicasso().load(event.getImages().get(0).getUrl()).into(photo);
        onFinishLoading();
    }

    @Override
    public void showError() {
        Log.d("DetailActivity", "Lol kek, there is an error");
    //    finish();
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
