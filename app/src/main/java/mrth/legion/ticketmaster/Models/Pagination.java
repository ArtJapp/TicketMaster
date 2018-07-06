
package mrth.legion.ticketmaster.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("rows")
    @Expose
    private Integer rows;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
