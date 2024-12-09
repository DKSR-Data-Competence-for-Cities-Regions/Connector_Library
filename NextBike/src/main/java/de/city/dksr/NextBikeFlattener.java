package de.city.dksr;

import de.urbanpulse.connector.sdk.core.runtime.preprocessing.Command;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

public class NextBikeFlattener extends Command {

    /**
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
     * This functions flattens the raw JSON object received from the OWM API and
     * include only the data required, in desired format.
     *
     * @param nestedJsonItems raw JSON object received by the Connector
     * @return List&lt;JsonObject&gt; with flat JSON of each supported
     * application of each node in the original nested JSON containing only the
     * supported info points
     */
    private List<JsonObject> flatten(JsonObject nestedJsonItems) {
        try {
            List<JsonObject> flatItems = new LinkedList<>();


            JsonArray countries = nestedJsonItems.getJsonArray("countries");
            JsonObject country = countries.getJsonObject(0);
            JsonArray cities = country.getJsonArray("cities");
            JsonObject city = cities.getJsonObject(0);
            JsonArray data = city.getJsonArray("places");

            for(int i=0;i<data.size();i++)
            {
                //JsonObject flatItem = new JsonObject();
                JsonObject obj = data.getJsonObject(i);
                Double uid = obj.getDouble("uid");
                Double lat = obj.getDouble("lat");
                Double lon = obj.getDouble("lng");
                String name = obj.getString("name");
                Double number = obj.getDouble("number");
                Double bookedBikes = obj.getDouble("booked_bikes");
                Double bikes = obj.getDouble("bikes");
                Double bikesAvailable = obj.getDouble("bikes_available_to_rent");

                /*flatItem.put("uid",uid);
                flatItem.put("lat",lat);
                flatItem.put("lon",lon);
                flatItem.put("number",number);
                flatItem.put("name",name);
                flatItem.put("bookedBikes",bookedBikes);
                flatItem.put("bikes",bikes);*/

                JsonArray bikeArr = obj.getJsonArray("bike_list");

                if(!name.toLowerCase().contains("city_name"))
                    continue;


                for(int j=0;j < bikeArr.size(); j++)
                {
                    JsonObject flatItem = new JsonObject();
                    JsonObject bikeObj = bikeArr.getJsonObject(j);
                    String bikeNumber = bikeObj.getString("number");
                    Double bikeType = bikeObj.getDouble("bike_type");
                    Boolean active = bikeObj.getBoolean("active");
                    String state = bikeObj.getString("state");
                    Boolean electricLock = bikeObj.getBoolean("electric_lock");
                    Double boardComputer = bikeObj.getDouble("boardcomputer");
                    Double pedelecBattery = bikeObj.getDouble("pedelec_battery");
                    JsonObject batteryPack = bikeObj.getJsonObject("battery_pack");
                    Double percent = null;
                    if(batteryPack != null)
                        percent = batteryPack.getDouble("percentage");
                    JsonArray lockArr = bikeObj.getJsonArray("lock_types");
                    StringBuffer buffer = new StringBuffer();

                    for(int k=0; k < lockArr.size(); k++)
                    {
                        buffer.append(lockArr.getString(k));
                    }
                    flatItem.put("uid",uid);
                    flatItem.put("lat",lat);
                    flatItem.put("lon",lon);
                    flatItem.put("number",number);
                    flatItem.put("name",name);
                    flatItem.put("bookedBikes",bookedBikes);
                    flatItem.put("bikes",bikes);
                    flatItem.put("bikesAvailable",bikesAvailable);
                    flatItem.put("bikeNumber",bikeNumber);
                    flatItem.put("bikeType",bikeType);
                    flatItem.put("lockTypes",buffer.toString());
                    flatItem.put("active",active);
                    flatItem.put("state",state);
                    flatItem.put("electricLock",electricLock);
                    flatItem.put("boardComputer",boardComputer);
                    flatItem.put("pedelecBattery",pedelecBattery);
                    flatItem.put("batteryPack",percent);
                    flatItems.add(flatItem);
                    System.out.println("FLAT ITEM  : " + flatItem);
                }


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
