package mrth.legion.ticketmaster.ui.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import mrth.legion.ticketmaster.models.Event;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface TicketsView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showEvents(List<Event> events);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showEmpty();

    @StateStrategyType(AddToEndStrategy.class)
    void addEvents(List<Event> events);

    void onStartLoading();
    void onFinishLoading();
}