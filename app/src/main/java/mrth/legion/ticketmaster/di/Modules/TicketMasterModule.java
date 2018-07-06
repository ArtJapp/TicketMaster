package mrth.legion.ticketmaster.di.Modules;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mrth.legion.ticketmaster.app.TicketMasterApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
public class TicketMasterModule {

    @Provides
    @Singleton
    public TicketMasterApi ticketMasterApi(Retrofit retrofit) {
        return retrofit.create(TicketMasterApi.class);
    }

    @Provides
    @Singleton
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://app.ticketmaster.com")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public Gson gson() {
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory gsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}
