
package mrth.legion.ticketmaster.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExcludingTicketFees {

    @SerializedName("min")
    @Expose
    private Double min;
    @SerializedName("max")
    @Expose
    private Double max;

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

}
