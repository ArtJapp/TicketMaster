
package mrth.legion.ticketmaster.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Onsale {

    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("value")
    @Expose
    private String value;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
