package mrth.legion.ticketmaster.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.ticketmaster.R;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.presenters.DetailPresenter;
import mrth.legion.ticketmaster.ui.views.DetailView;

public class DetailsActivity extends MvpAppCompatActivity implements DetailView{

    @InjectPresenter
    DetailPresenter presenter;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager pager;

    protected void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        setContentView(R.layout.details_activity);
        ButterKnife.bind(this);
    }

    @Override
    public void showEvent(Event event) {

    }

    @Override
    public void showError() {
        Log.d("DetailActivity", "Lol kek, there is an error");
        finish();
    }

    @Override
    public void onStartLoading() {

    }

    @Override
    public void onFinishLoading() {

    }
}
