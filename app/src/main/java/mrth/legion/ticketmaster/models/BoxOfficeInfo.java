
package mrth.legion.ticketmaster.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoxOfficeInfo {

    @SerializedName("openHoursDetail")
    @Expose
    private String openHoursDetail;
    @SerializedName("acceptedPaymentDetail")
    @Expose
    private String acceptedPaymentDetail;
    @SerializedName("willCallDetail")
    @Expose
    private String willCallDetail;

    public String getOpenHoursDetail() {
        return openHoursDetail;
    }

    public void setOpenHoursDetail(String openHoursDetail) {
        this.openHoursDetail = openHoursDetail;
    }

    public String getAcceptedPaymentDetail() {
        return acceptedPaymentDetail;
    }

    public void setAcceptedPaymentDetail(String acceptedPaymentDetail) {
        this.acceptedPaymentDetail = acceptedPaymentDetail;
    }

    public String getWillCallDetail() {
        return willCallDetail;
    }

    public void setWillCallDetail(String willCallDetail) {
        this.willCallDetail = willCallDetail;
    }

}
