
package mrth.legion.ticketmaster.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceRanges {

    @SerializedName("excluding_ticket_fees")
    @Expose
    private ExcludingTicketFees excludingTicketFees;
    @SerializedName("including_ticket_fees")
    @Expose
    private IncludingTicketFees includingTicketFees;

    public ExcludingTicketFees getExcludingTicketFees() {
        return excludingTicketFees;
    }

    public void setExcludingTicketFees(ExcludingTicketFees excludingTicketFees) {
        this.excludingTicketFees = excludingTicketFees;
    }

    public IncludingTicketFees getIncludingTicketFees() {
        return includingTicketFees;
    }

    public void setIncludingTicketFees(IncludingTicketFees includingTicketFees) {
        this.includingTicketFees = includingTicketFees;
    }

}
