package mrth.legion.ticketmaster.presenters;

import io.reactivex.Observable;
import mrth.legion.ticketmaster.app.TicketMasterApi;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.models.Result;

public class TMService {
    private TicketMasterApi mApi;
    private static final String KEY = "HkgpTs1icsAAqywPmEXoKMullfP8W7he";

    public TMService(TicketMasterApi api) {
        mApi = api;
    }

    public Observable<Result> getQuery() {
        return mApi.getEvents(KEY, TicketMasterApp.getCountryCode());
    }
    public Observable<Event> getDetails(String id) {
        return mApi.getEvent(id, KEY);
    }
}
