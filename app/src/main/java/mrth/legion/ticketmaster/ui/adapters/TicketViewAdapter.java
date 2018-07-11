package mrth.legion.ticketmaster.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.ticketmaster.R;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import mrth.legion.ticketmaster.models.Event;
import mrth.legion.ticketmaster.ui.activities.DetailsActivity;

public class TicketViewAdapter extends RecyclerView.Adapter<TicketViewAdapter.TicketViewHolder> {
    private List<Event> mEvents;
    private Context context;

    public TicketViewAdapter(Context context) {
        this.context = context;
        mEvents = new ArrayList<>();
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        TicketViewHolder ticketViewHolder = new TicketViewHolder(view);
        return ticketViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        holder.bindEvent(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public void setEvents(List<Event> events) {
        this.mEvents.clear();
        this.mEvents.addAll(events);
        notifyDataSetChanged();
    }



    public class TicketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.eventName)
        TextView eventName;
        @BindView(R.id.eventPlace)
        TextView eventPlace;
        @BindView(R.id.eventCity)
        TextView eventCity;
        @BindView(R.id.eventTime)
        TextView eventTime;
        @BindView(R.id.eventCategory)
        TextView eventCategory;

        @BindView(R.id.myImageView)
        ImageView imageView;

        private String id;

        @Nullable
        @BindView(R.id.card)
        RelativeLayout card;

        public TicketViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindEvent(Event event) {
            id = event.getId();
            eventName.setText(event.getName());
            String city = event.getEmbedded().getVenues().get(0).getCity().getName();
            String statecode = event.getEmbedded().getVenues().get(0).getState().getStateCode();
            eventCity.setText(city + ", " + statecode);
            String place = event.getEmbedded().getVenues().get(0).getName();
            eventPlace.setText(place);
            eventTime.setText(event.getDates().getStart().getDateTime());
           // eventCategory.setText(event.getClassifications().get(0).);\
            Log.d("Lol what is it", event.getClassifications().get(0).getSegment().getName());//shows Music for music event
            TicketMasterApp.getPicasso().load(event.getImages().get(0).getUrl()).into(imageView);
            try {
                card.setOnClickListener(this);
            } catch (NullPointerException e) {
                e.printStackTrace();
                Log.d("Bletb", "null pointer");
            }
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), DetailsActivity.class);
            intent.putExtra("id", id);
            view.getContext().startActivity(intent);
        }
    }
}
