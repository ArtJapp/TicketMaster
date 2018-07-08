package mrth.legion.ticketmaster.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrth.legion.ticketmaster.R;
import mrth.legion.ticketmaster.app.TicketMasterApp;
import mrth.legion.ticketmaster.models.Event;

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

    public class TicketViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.eventName)
        TextView eventName;
        @BindView(R.id.eventPlace)
        TextView eventPlace;
        @BindView(R.id.eventTime)
        TextView eventTime;
        @BindView(R.id.eventCategory)
        TextView eventCategory;

        @BindView(R.id.myImageView)
        ImageView imageView;

        public TicketViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindEvent(Event event) {
            eventName.setText(event.getName());
            //    java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String mrth.legion.ticketmaster.models.Promoter.getName()' on a null object reference
            eventPlace.setText(event.getPromoter().getName());
            eventTime.setText(event.getDates().getStart().getDateTime());
           // eventCategory.setText(event.getClassifications().get(0).);\
            Log.d("Lol what is it", event.getClassifications().get(0).getSegment().getName());//shows Music for music event
            TicketMasterApp.getPicasso().load(event.getImages().get(0).getUrl()).into(imageView);
        }
    }
}
