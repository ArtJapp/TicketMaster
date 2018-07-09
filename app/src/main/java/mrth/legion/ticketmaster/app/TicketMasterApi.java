package mrth.legion.ticketmaster.app;

import io.reactivex.Observable;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.models.Result;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TicketMasterApi {
    @GET("discovery/v2/events.json")
    Observable<Result> getEvents(@Query("apikey") String apiKey , @Query("countryCode") String countryCode );

    @GET("discovery/v2/events/{eventId}.json")
    Observable<Event> getEvent(@Query("apikey") String apiKey , @Path("id") String eventId );
}
