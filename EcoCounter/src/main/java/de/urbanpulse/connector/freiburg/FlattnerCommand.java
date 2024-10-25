package de.urbanpulse.connector.freiburg;

import de.urbanpulse.connector.sdk.core.runtime.preprocessing.Command;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FlattnerCommand extends Command {


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
        List<JsonObject> flatItems = flatten(nestedJsonString);
        return flatItems;
    }



    /**
     * This functions flattens the raw JSON object received from the EcoCounter API and
     * include only the data required, in desired format.
     * @param nestedJsonItems raw JSON object received by the Connector
     * @return List&lt;JsonObject&gt; with flat JSON of each supported
     * application of each node in the original nested JSON containing only the
     * supported info points
     */
    private List<JsonObject> flatten(String nestedJsonItems) {
        List<JsonObject> flatItems = new LinkedList<>();

        JsonArray tempArr = new JsonArray(nestedJsonItems);

            for (int i =0; i < tempArr.size(); i++)
            {
                JsonObject flatItem = tempArr.getJsonObject(i);
                if(validateData(flatItem.getString("timestamp"),flatItem.getString("counter_serial"))) {

                    flatItem.remove("iso_timestamp");
                    flatItem.put("lat", flatItem.getDouble("latitude"));
                    flatItem.remove("latitude");
                    flatItem.put("lon", flatItem.getDouble("longitude"));
                    flatItem.remove("longitude");
                    flatItem.put("count", flatItem.getDouble("zählstand"));
                    flatItem.remove("zählstand");
                    flatItem.put("placementLocation", flatItem.getString("standort"));
                    flatItem.remove("standort");
                    flatItem.put("counter_site_location", flatItem.getString("counter_site"));
                    flatItem.remove("counter_site");
                    flatItem.put("timestamp_ecocounter", flatItem.getString("timestamp"));
                    flatItem.remove("timestamp");

                    flatItems.add(flatItem);
                }

            }

        return flatItems;
    }

    /**
     * This method validates the data if this received for last 24 hours
     * @param date date returned by API
     * @param id id of the sensor
     * @return
     */

    private boolean validateData(String date, String id)
    {
        HashMap<String,String> ids = new HashMap<>();
        ids.put("Y2H21070299","Y2H21070299");
        ids.put("Y2H18076077","Y2H18076077");
        ids.put("Y2H22012076","Y2H22012076");

        boolean retVal = false;

        LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"));

        LocalDateTime dateTimeMinus = LocalDateTime.now();

        if(dateTime.isAfter(dateTimeMinus.minusHours(24)) && ids.containsKey(id))
        {
            retVal = true;
        }
        return retVal;
    }
}
