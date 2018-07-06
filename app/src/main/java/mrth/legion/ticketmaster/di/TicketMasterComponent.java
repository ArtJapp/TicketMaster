package mrth.legion.ticketmaster.di;


import com.squareup.picasso.Picasso;

import dagger.Component;
import mrth.legion.ticketmaster.app.TicketMasterApi;
import mrth.legion.ticketmaster.di.Modules.PicassoModule;
import mrth.legion.ticketmaster.di.Modules.TicketMasterModule;

@Component(modules = {TicketMasterModule.class, PicassoModule.class})
public interface TicketMasterComponent {
    TicketMasterApi getTicketMasterService();
    Picasso getPicasso();

}
