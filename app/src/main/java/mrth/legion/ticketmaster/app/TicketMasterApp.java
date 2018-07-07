package mrth.legion.ticketmaster.app;

import android.app.Application;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import mrth.legion.ticketmaster.di.DaggerTicketMasterComponent;
import mrth.legion.ticketmaster.di.Modules.ContextModule;
import mrth.legion.ticketmaster.di.TicketMasterComponent;

public class TicketMasterApp extends Application {
    private static TicketMasterApi ticketMasterApi;
    private static Picasso picassoDownloader;
    private static Countries countries;
    private static String codeCountry;

    public void onCreate() {
        super.onCreate();

        TicketMasterComponent daggerTicketMasterComponent = DaggerTicketMasterComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        ticketMasterApi = daggerTicketMasterComponent.getTicketMasterService();
        picassoDownloader = daggerTicketMasterComponent.getPicasso();
        codeCountry = "US";
        countries = new Countries();
    }
    public static Picasso getPicasso() {
        return picassoDownloader;
    }
    public static TicketMasterApi getApi() {
        return ticketMasterApi;
    }

    public static String getCodeCountry() {
        return codeCountry;
    }

    public static void setCodeCountry(String country) {
        codeCountry = countries.getCode(country);
    }
}
