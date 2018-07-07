package mrth.legion.ticketmaster.app;

import android.app.Application;

import com.squareup.picasso.Picasso;

import mrth.legion.ticketmaster.di.DaggerTicketMasterComponent;
import mrth.legion.ticketmaster.di.Modules.ContextModule;
import mrth.legion.ticketmaster.di.TicketMasterComponent;

public class TicketMasterApp extends Application {
    private static TicketMasterApi ticketMasterApi;
    private static Picasso picassoDownloader;

    private static String codeCountry;

    public void onCreate() {
        super.onCreate();

        TicketMasterComponent daggerTicketMasterComponent = DaggerTicketMasterComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        ticketMasterApi = daggerTicketMasterComponent.getTicketMasterService();
        picassoDownloader = daggerTicketMasterComponent.getPicasso();

        codeCountry = "US";
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
        switch (country) {
            case "Canada" : codeCountry = "CA"; break;
            case "Mexico" : codeCountry = "MX"; break;
            case "Australia" : codeCountry = "AU"; break;
            case "New Zealand" : codeCountry = "NZ"; break;
            case "UAE" : codeCountry = "AE"; break;
            case "Belgium" : codeCountry = "BE"; break;
            case "Denmark" : codeCountry = "DK"; break;
            case "Germany" : codeCountry = "DE"; break;
            case "Spain" : codeCountry = "ES"; break;
            case "Ireland" : codeCountry = "IE"; break;
            case "Netherlands" : codeCountry = "NL"; break;
            case "Norway" : codeCountry = "NO"; break;
            case "Austria" : codeCountry = "AT"; break;
            case "Poland" : codeCountry = "PL"; break;
            case "Finland" : codeCountry = "FI"; break;
            case "Sweden" : codeCountry = "SE"; break;
            case "Switzerland" : codeCountry = "CH"; break;
            case "UK" : codeCountry = "UK"; break;

            default: codeCountry = "US";
        }
    }
}
