package de.urbanpulse.connector.inrix;

import de.urbanpulse.connector.sdk.core.runtime.preprocessing.Command;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

import io.vertx.core.json.JsonArray;


public class INRIXFreiburgFlattenerCommand extends Command {


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
        List<JsonObject> flatItems = new LinkedList<>();

        String createDate = nestedJsonItems.getString("createdDate");
        double status = nestedJsonItems.getDouble("statusId");
        String statusText =  nestedJsonItems.getString("statusText");
        String responseId = nestedJsonItems.getString("responseId");

        JsonObject resultObj = nestedJsonItems.getJsonObject("result");
        double coverage = resultObj.getDouble("coverage");
        JsonArray segmentSpeeds = resultObj.getJsonArray("segmentSpeeds");
        JsonObject segmentSpeedsObj = segmentSpeeds.getJsonObject(0);
        JsonArray segmentsArr = segmentSpeedsObj.getJsonArray("segments");

        if (segmentsArr != null && segmentsArr.size() > 0) {
            for (int i =0; i < segmentsArr.size(); i++)
            {
                JsonObject flatItem = new JsonObject();
                JsonObject segment = segmentsArr.getJsonObject(i);


                double average = 0.0;
                if(segment.containsKey("average"))
                    average = segment.getDouble("average");
                String code = segment.getString("code");
                double reference = 0.0;
                if(segment.containsKey("reference"))
                    reference = segment.getDouble("reference");
                double speed = 0.0;
                if(segment.containsKey("speed"))
                    speed = segment.getDouble("speed");
                double travelTimeMinutes = 0.0;
                if(segment.containsKey("travelTimeMinutes"))
                    travelTimeMinutes = segment.getDouble("travelTimeMinutes");
                String type = segment.getString("type");
                double score = 0.0;
                if(segment.containsKey("score"))
                    score = segment.getDouble("score");

                double cValue = 0.0;
                if(segment.containsKey("c-Value"))
                    cValue = segment.getDouble("c-Value");
                double speedBucket = 0.0;
                if(segment.containsKey("speedBucket"))
                    speedBucket = segment.getDouble("speedBucket");

                flatItem.put("createdDate", createDate);
                flatItem.put("statusId", status);
                flatItem.put("statusText", statusText);
                flatItem.put("responseId", responseId);
                flatItem.put("coverage", coverage);
                flatItem.put("average", average);
                flatItem.put("code", code);
                flatItem.put("reference",reference);
                flatItem.put("speed",speed);
                flatItem.put("travelTimeMinutes",travelTimeMinutes);
                flatItem.put("type",type);
                flatItem.put("score",score);
                flatItem.put("c-value",cValue);
                flatItem.put("speedBucket",speedBucket);



                System.out.println("flatItem : " + flatItem);
                flatItems.add(flatItem);

            }

        }

        return flatItems;
    }
}

