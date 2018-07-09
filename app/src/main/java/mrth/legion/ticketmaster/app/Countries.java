package mrth.legion.ticketmaster.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Countries {
    private static HashMap<String, String> countryCodes;
    private static String currentCountry;

    public Countries() {
        countryCodes = new HashMap<>();
        countryCodes.put("Canada", "CA");
        countryCodes.put("Mexico", "MX");
        countryCodes.put("Australia", "AU");
        countryCodes.put("New Zealand", "NZ");
        countryCodes.put("UAE", "AE");
        countryCodes.put("Belgium", "BE");
        countryCodes.put("Denmark", "DK");
        countryCodes.put("Germany", "DE");
        countryCodes.put("Spain", "ES");
        countryCodes.put("Ireland", "IE");
        countryCodes.put("Netherlands", "NL");
        countryCodes.put("Norway", "NO");
        countryCodes.put("Austria", "AT");
        countryCodes.put("Poland", "PL");
        countryCodes.put("Finland", "FI");
        countryCodes.put("Sweden", "SE");
        countryCodes.put("Switzerland", "CH");
        countryCodes.put("UK", "UK");
        countryCodes.put("USA", "US");

        currentCountry = "USA";
    }

    public static String getCode(String country) {
        if (countryCodes.containsKey(country)) {
            return countryCodes.get(country);
        } else {
            return "US";
        }
    }

    public static List<String> getListCountries() {
        List<String> answer = new ArrayList<>(countryCodes.keySet());
        Collections.sort(answer);
        return answer;
    }

    public static String getCurrentCode() {
        return countryCodes.get(currentCountry);
    }

    public static void setCountry(String country) {
        currentCountry = country;
    }

    public static String getCountry() {
        return currentCountry;
    }
}
