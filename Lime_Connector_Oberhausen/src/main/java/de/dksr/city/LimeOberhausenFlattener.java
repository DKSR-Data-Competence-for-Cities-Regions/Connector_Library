package de.dksr.city;

import de.urbanpulse.connector.sdk.core.runtime.preprocessing.Command;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

public class LimeOberhausenFlattener extends Command {

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
    private List<JsonObject> flatten(JsonObject nestedJsonItems) 
    {
        try {
            List<JsonObject> flatItems = new LinkedList<>();
            JsonObject data = nestedJsonItems.getJsonObject("data");
            JsonArray bikes = data.getJsonArray("bikes");

            for(int i=0; i < bikes.size();i++)
            {
                JsonObject bike = bikes.getJsonObject(i);
                flatItems.add(bike);
                System.out.println("FLAT ITEM  : " + bike);
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
