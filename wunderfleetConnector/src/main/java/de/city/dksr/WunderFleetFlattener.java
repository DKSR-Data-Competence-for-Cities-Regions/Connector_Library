package de.city.dksr;

import de.urbanpulse.connector.sdk.core.runtime.preprocessing.Command;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WunderFleetFlattener extends Command {

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
        HashMap<Double, String> vehicleType = new HashMap();
        vehicleType.put(3.0,"54i:conic");
        vehicleType.put(5.0,"Renault Zoe");    
        


        try {
            List<JsonObject> flatItems = new LinkedList<>();


            for(int i=0;i<nestedJsonItems.size();i++)
            {

                JsonObject obj = nestedJsonItems.getJsonObject(i);
                obj.put("vehicleType",vehicleType.get(obj.getDouble("vehicleTypeId")));


                flatItems.add(obj);
                System.out.println("FLAT ITEM  : " + obj);

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
