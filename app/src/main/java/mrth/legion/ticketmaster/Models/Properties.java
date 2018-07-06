
package mrth.legion.ticketmaster.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("rescheduled")
    @Expose
    private Boolean rescheduled;
    @SerializedName("seats_avail")
    @Expose
    private Boolean seatsAvail;
    @SerializedName("sold_out")
    @Expose
    private Boolean soldOut;
    @SerializedName("package")
    @Expose
    private Boolean _package;

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Boolean getRescheduled() {
        return rescheduled;
    }

    public void setRescheduled(Boolean rescheduled) {
        this.rescheduled = rescheduled;
    }

    public Boolean getSeatsAvail() {
        return seatsAvail;
    }

    public void setSeatsAvail(Boolean seatsAvail) {
        this.seatsAvail = seatsAvail;
    }

    public Boolean getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(Boolean soldOut) {
        this.soldOut = soldOut;
    }

    public Boolean getPackage() {
        return _package;
    }

    public void setPackage(Boolean _package) {
        this._package = _package;
    }

}
