package mrth.legion.ticketmaster.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import mrth.legion.ticketmaster.common.Utils;
import mrth.legion.ticketmaster.di.TicketMasterComponent;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.ui.views.DetailView;

@InjectViewState
public class DetailPresenter extends BasePresenter<DetailView> {

    public static final String TAG = "DetailPresenter";

    @Inject
    TMService mService;

    public DetailPresenter() {
        TicketMasterComponent g =  TicketMasterApp.getTicketMasterComponent();
        mService = TicketMasterApp.getService();
    }

    public void loadData(String id) {
        final Observable<Event> observable = mService.getDetails(id);
        Disposable subscription = observable
                .compose(Utils.applySchedulers())
                .subscribe(this::onLoadingSuccess, error -> {
                    error.printStackTrace();
                    onLoadingFailed(error);
                });


        unsubscribeOnDestroy(subscription);
    }

    private void onLoadingSuccess(Event item) {
        getViewState().showEvent(item);
    }

    private void onLoadingFailed(Throwable t) {
        t.printStackTrace();
        getViewState().showError();
    }
}
