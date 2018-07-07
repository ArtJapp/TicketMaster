package mrth.legion.ticketmaster;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mrth.legion.ticketmaster.Models.Event;
import mrth.legion.ticketmaster.Models.Result;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnSearch);
        final TextView textView = findViewById(R.id.results);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicketMasterApp.setCodeCountry("Poland");
                TicketMasterApp.getApi().getEvents("HkgpTs1icsAAqywPmEXoKMullfP8W7he", TicketMasterApp.getCodeCountry()).enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        try {
                            textView.setText(response.message());
                            if (response.body() != null) {
                                Log.d("Loggy", "wow body is not empty");
                                if(response.body().getEmbedded().getEvents() != null) {
                                    Log.d("Loggy", "Wow events are not empty!");
                                    for (Event x : response.body().getEmbedded().getEvents()) {
                                        textView.setText(textView.getText() + "\n" + x.getName() + "  ->  " +x.getDates().getStart().getLocalDate());
                                    }
                                }
                            }
                        } catch (NullPointerException e) {
                            textView.setText(e.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        textView.setText("Something wrong ((");
                    }
                });
            }
        });
    }
}
