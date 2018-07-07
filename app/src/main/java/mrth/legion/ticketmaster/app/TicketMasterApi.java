package mrth.legion.ticketmaster.app;

import android.database.Observable;

import mrth.legion.ticketmaster.Models.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TicketMasterApi {
    @GET("discovery/v2/events.json")
    Call<Result> getEvents(@Query("apikey") String apiKey , @Query("countryCode") String countryCode );
}
