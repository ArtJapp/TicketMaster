package mrth.legion.ticketmaster.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import mrth.legion.ticketmaster.common.Utils;
import mrth.legion.ticketmaster.di.TicketMasterComponent;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.models.Result;
import mrth.legion.ticketmaster.ui.views.TicketsView;


@InjectViewState
public class TicketsPresenter extends BasePresenter<TicketsView> {

    public static final String TAG = "ResultsPresenter";

    @Inject
    TMService mService;

    public TicketsPresenter() {
        TicketMasterComponent g =  TicketMasterApp.getTicketMasterComponent();
        mService = TicketMasterApp.getService();
    //    mService = g.getTicketMasterService();
        //g.inject(this);
    }

    public String pickCountry(String country) {
        TicketMasterApp.setCountry(country);
        loadResults();
        return TicketMasterApp.getCountryCode();
    }

    public void loadResults() {
        loadData(false);
    }

    private void loadData(boolean isPageLoading) {
        Log.d("Loggy", "start getting data");
        Log.d("Pis", "user request is " );

        Log.d("Pis", "Start subscription");

        /*Subscription subscription = observable
                .compose(Utils.applySchedulers())
                .subscribe(repositories -> {
                    Log.d("Pis", "Success loading");
                    onLoadingSuccess(isPageLoading, repositories.getItems());
                }, error -> {
                    Log.d("Pis", "Failed loading");
                    error.printStackTrace();
                    onLoagingFailed(isPageLoading, error);
                });
*/
        final Observable<Result> observable = mService.getQuery();
        Disposable subscription = observable
                .compose(Utils.applySchedulers())
                .subscribe(items -> {
                    Log.d("Pis", "Success loading");
                    onLoadingSuccess(isPageLoading, items.getEmbedded().getEvents());
                }, error -> {
                    Log.d("Pis", "Failed loading");
                    error.printStackTrace();
                    onLoagingFailed(isPageLoading, error);
                });


        unsubscribeOnDestroy(subscription);

    }

    private void onLoadingSuccess( boolean isPageLoading, List<Event> items) {
        if (isPageLoading) {
            getViewState().addEvents(items);

            System.out.println("Easy Beasy");
            for (Event x : items) {
                System.out.println("New item " + x.getName());
            }
        } else {
            getViewState().showEvents(items);
            System.out.println("Easy Beasy");
            for (Event x : items) {
                System.out.println("New item " + x.getName());
            }
        }
    }
    private void onLoagingFailed( boolean isPageLoading, Throwable error) {
        getViewState().showEmpty();
    }



}