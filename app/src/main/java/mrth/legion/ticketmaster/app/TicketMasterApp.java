package mrth.legion.ticketmaster.app;

import android.app.Application;

import com.squareup.picasso.Picasso;

import mrth.legion.ticketmaster.di.DaggerTicketMasterComponent;
import mrth.legion.ticketmaster.di.Modules.ContextModule;
import mrth.legion.ticketmaster.di.TicketMasterComponent;
import mrth.legion.ticketmaster.presenters.TMService;

public class TicketMasterApp extends Application {
    private static TicketMasterApi ticketMasterApi;
    private static Picasso picassoDownloader;
    private static Countries countries;
    private static TMService service;

    static TicketMasterComponent daggerTicketMasterComponent;

    public void onCreate() {
        super.onCreate();

        daggerTicketMasterComponent = DaggerTicketMasterComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        ticketMasterApi = daggerTicketMasterComponent.getTicketMasterService();
        picassoDownloader = daggerTicketMasterComponent.getPicasso();
        countries = new Countries();
        service = new TMService(ticketMasterApi);
    }
    public static Picasso getPicasso() {
        return picassoDownloader;
    }
    public static TicketMasterApi getApi() {
        return ticketMasterApi;
    }

    public static TMService getService() {
        return service;
    }


    public static void setCountry(String country) {
        countries.setCountry(country);
    }

    public static String getCountry() {
        return countries.getCountry();
    }

    public static String getCountryCode() {
        return countries.getCode(countries.getCountry());
    }

    public static TicketMasterComponent getTicketMasterComponent() {
        return daggerTicketMasterComponent;
    }
}
