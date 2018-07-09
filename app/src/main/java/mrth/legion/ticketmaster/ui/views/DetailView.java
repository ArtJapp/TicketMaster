package mrth.legion.ticketmaster.ui.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import mrth.legion.ticketmaster.models.Event;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface DetailView extends MvpView{
    @StateStrategyType(AddToEndStrategy.class)
    void showEvent(Event event);
    void showError();

    void onStartLoading();
    void onFinishLoading();
}
