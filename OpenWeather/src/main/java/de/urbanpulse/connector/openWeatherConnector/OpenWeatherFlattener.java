package de.urbanpulse.connector.openWeatherConnector;


import de.urbanpulse.connector.sdk.core.runtime.preprocessing.Command;
import de.urbanpulse.connector.sdk.util.time.UPDateTimeFormat;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;

public class OpenWeatherFlattener extends Command {

    private static String countrycode = "countrycode";
    private static double temp;
    private static String sunrise = "sunrise";
    private static long weather_id;
    private static long visibility;
    private static String city = "city";
    private static double lon;
    private static long pressure;
    private static long clouds;
    private static double temp_max;
    private static String weather_icon = "weather_icon";
    private static double temp_min;
    private static long  wind_deg;
    private static String sunset = "sunset";
    private static long humidity;
    private static double wind_speed;
    private static double lat;
    private static double zipcode = 8010;

    /**
     * This method is responsible for parsing the API data to flat JSON structure.
     * @param buffer contains the nested JSON string
     * @return List&lt;JsonObject&gt; with flat JSON of each supported
     * application of each node in the original nested JSON containing only the
     * supported info points
     */
    @Override
    public List<JsonObject> apply(Object buffer) {
        String nestedJsonString = ((Buffer) buffer).toString();
        JsonObject arrayOfNestedJsonItems = new JsonObject(nestedJsonString);
        List<JsonObject> flatItems = flatten(arrayOfNestedJsonItems);
        return flatItems;
    }

    /**
     * This functions flattens the raw JSON object received from the Open weather API and
     * include only the data required, in desired format.
     * @param nestedJsonItems raw JSON object received by the Connector
     * @return List&lt;JsonObject&gt; with flat JSON of each supported
     * application of each node in the original nested JSON containing only the
     * supported info points
     */
    private List<JsonObject> flatten(JsonObject nestedJsonItems) {
        List<JsonObject> flatItems = new LinkedList<>();
        JsonObject flatItem = new JsonObject();

        JsonArray weatherConditions = nestedJsonItems.getJsonArray("weather");
        if (weatherConditions.size() > 0) {
            JsonObject weatherCondition = weatherConditions.getJsonObject(0);
            long weatherId = weatherCondition.getLong("id");
            flatItem.put("weather_id", weatherId);
            String weatherIcon = weatherCondition.getString("icon");
            flatItem.put("weather_icon", weatherIcon);
        }

        flatItem.put("zipcode", zipcode);
        flatItem.put("visibility", nestedJsonItems.getLong("visibility"));
        flatItem.put("city", nestedJsonItems.getString("name"));
        JsonObject weather = nestedJsonItems.getJsonObject("main");
        JsonObject coord = nestedJsonItems.getJsonObject("coord");

        JsonObject sys = nestedJsonItems.getJsonObject("sys");
        flatItem.put("countrycode", sys.getString("country"));

        JsonObject wind = nestedJsonItems.getJsonObject("wind");
        flatItem.put("wind_speed", wind.getDouble("speed"));
        flatItem.put("wind_deg", wind.getLong("deg"));

        JsonObject clouds = nestedJsonItems.getJsonObject("clouds");
        flatItem.put("clouds",clouds.getLong("all"));

        flatItem.mergeIn(weather);

        Instant instantSunrise = Instant.ofEpochMilli(sys.getLong("sunrise") * 1000);
        OffsetDateTime ofInstantSunrise = OffsetDateTime.ofInstant(instantSunrise, ZoneOffset.UTC);

        Instant instantSunset = Instant.ofEpochMilli(sys.getLong("sunset") * 1000);
        OffsetDateTime ofInstantSunset = OffsetDateTime.ofInstant(instantSunset, ZoneOffset.UTC);

        flatItem.put("sunrise", UPDateTimeFormat.getFormatterWithZoneZ().format(ofInstantSunrise));
        flatItem.put("sunset", UPDateTimeFormat.getFormatterWithZoneZ().format(ofInstantSunset));

        flatItem.put("lat",  coord.getDouble("lat"));
        flatItem.put("lon", coord.getDouble("lon"));

        flatItems.add(flatItem);
        return flatItems;

    }
}
