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

//        App.getApi().getData(requestUser, CX, KEY, "image", "medium").enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                if (model != null) {
//                    model.clear();
//                    updateView();
//                }
//                if (response.body() != null)
//                {
//                    Log.d("Loggy","подгрузка начата");
//                    model = new ArrayList<>();
//                    Log.d("Loggy", response.body().toString());
//                    if (Long.parseLong(response.body().getSearchInformation().getTotalResults()) > 0) {
//                        Log.d("Loggy","Inputing elements");
//                        model.addAll(response.body().getItems());
//                    } else {
//                        Log.d("Loggy","nothing to input");
//                        view().showEmpty();
//                    }
//
//                    setModel(model);
//                    Log.d("Loggy","подгрузка закончена");
//                //    updateView();
//                    Log.d("Loggy","обновление view закончено");
//                    updateView();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//            }
//        });
//        Log.d("Loggy", "finish getting component");

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