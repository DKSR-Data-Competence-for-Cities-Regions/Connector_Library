package de.dksr.city;

import de.urbanpulse.connector.sdk.core.runtime.preprocessing.Command;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CambioSiegburgFlattener extends Command {

    /**
     * @param buffer contains the nested JSON string
     * @return List&lt;JsonObject&gt; with flat JSON of each supported
     * application of each node in the original nested JSON containing only the
     * supported info points
     */
    @Override
    public List<JsonObject> apply(Object buffer) {


        String nestedJsonString = ((Buffer) buffer).toString();
        JsonArray arrayOfNestedJsonItems = new JsonArray(nestedJsonString);
        List<JsonObject> flatItems = flatten(arrayOfNestedJsonItems);
        return flatItems;
    }


    /**
     * This functions flattens the raw JSON object received from the OWM API and
     * include only the data required, in desired format.
     *
     * @param nestedJsonItems raw JSON object received by the Connector
     * @return List&lt;JsonObject&gt; with flat JSON of each supported
     * application of each node in the original nested JSON containing only the
     * supported info points
     */
    private List<JsonObject> flatten(JsonArray nestedJsonItems) {

        try {
            List<JsonObject> flatItems = new LinkedList<>();

            for(int i=0; i < nestedJsonItems.size();i++)
            {
                JsonObject flatItem = new JsonObject();
                JsonObject station = nestedJsonItems.getJsonObject(i);

                String id = station.getString("id");
                String displayName = station.getString("displayName");

                JsonObject address = station.getJsonObject("address");
                String streetAddress = address.getString("streetAddress");
                String streetNumber = address.getString("streetNumber");
                String addressLocation = address.getString("addressLocation");
                if(!addressLocation.toLowerCase().contains("siegburg"))
                    continue;
                String postalCode = address.getString("postalCode");
                String addressCountry = address.getString("addressCountry");
                JsonObject information = station.getJsonObject("information");
                String location = information.getString("location");
                JsonObject geoposition = station.getJsonObject("geoposition");
                Double lat = geoposition.getDouble("latitude");
                Double lon = geoposition.getDouble("longitude");
                JsonArray vehicleClasses = station.getJsonArray("vehicleClasses");
                flatItem.put("id",id);
                flatItem.put("displayName",displayName);
                flatItem.put("streetAddress",streetAddress);
                flatItem.put("streetNumber",streetNumber);
                flatItem.put("addressLocation",addressLocation);
                flatItem.put("postalCode",postalCode);
                flatItem.put("addressCountry",addressCountry);
                flatItem.put("location",location);
                flatItem.put("lat",lat);
                flatItem.put("lon",lon);

                ArrayList<String[]> vehicleClass = new ArrayList<>();
                for(int j = 0 ; j < vehicleClasses.size(); j++)
                {
                    JsonObject vehicle = vehicleClasses.getJsonObject(j);
                    String[] vehicleInfo = new String[2];
                    vehicleInfo[0] = vehicle.getString("id");
                    vehicleInfo[1] = vehicle.getString("displayName");
                    vehicleClass.add(vehicleInfo);
                    flatItem.put("vehicleClasses", vehicleClass);

                }

                flatItems.add(flatItem);
                System.out.println("FLAT ITEM  : " + flatItem);
            }
            return flatItems;
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return null;
    }

}
