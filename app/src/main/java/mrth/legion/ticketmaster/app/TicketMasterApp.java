package mrth.legion.ticketmaster.app;

import android.app.Application;

import com.squareup.picasso.Picasso;

import mrth.legion.ticketmaster.di.DaggerTicketMasterComponent;
import mrth.legion.ticketmaster.di.Modules.ContextModule;
import mrth.legion.ticketmaster.di.TicketMasterComponent;

public class TicketMasterApp extends Application {
    private static TicketMasterApi ticketMasterApi;
    private static Picasso picassoDownloader;

    public void onCreate() {
        super.onCreate();

        TicketMasterComponent daggerTicketMasterComponent = DaggerTicketMasterComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        ticketMasterApi = daggerTicketMasterComponent.getTicketMasterService();
        picassoDownloader = daggerTicketMasterComponent.getPicasso();
    }
    public static Picasso getPicasso() {
        return picassoDownloader;
    }
    public static TicketMasterApi getApi() {
        return ticketMasterApi;
    }
}
