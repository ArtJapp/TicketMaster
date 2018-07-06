
package mrth.legion.ticketmaster.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("domain_id")
    @Expose
    private String domainId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("externalUrl")
    @Expose
    private Boolean externalUrl;
    @SerializedName("eventdate")
    @Expose
    private Eventdate eventdate;
    @SerializedName("day_of_week")
    @Expose
    private String dayOfWeek;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("localeventdate")
    @Expose
    private String localeventdate;
    @SerializedName("onsale")
    @Expose
    private Onsale onsale;
    @SerializedName("offsale")
    @Expose
    private Offsale offsale;
    @SerializedName("dooropening")
    @Expose
    private Dooropening dooropening;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("attractions")
    @Expose
    private List<Attraction> attractions = null;
    @SerializedName("price_ranges")
    @Expose
    private PriceRanges priceRanges;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(Boolean externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Eventdate getEventdate() {
        return eventdate;
    }

    public void setEventdate(Eventdate eventdate) {
        this.eventdate = eventdate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLocaleventdate() {
        return localeventdate;
    }

    public void setLocaleventdate(String localeventdate) {
        this.localeventdate = localeventdate;
    }

    public Onsale getOnsale() {
        return onsale;
    }

    public void setOnsale(Onsale onsale) {
        this.onsale = onsale;
    }

    public Offsale getOffsale() {
        return offsale;
    }

    public void setOffsale(Offsale offsale) {
        this.offsale = offsale;
    }

    public Dooropening getDooropening() {
        return dooropening;
    }

    public void setDooropening(Dooropening dooropening) {
        this.dooropening = dooropening;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public PriceRanges getPriceRanges() {
        return priceRanges;
    }

    public void setPriceRanges(PriceRanges priceRanges) {
        this.priceRanges = priceRanges;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
