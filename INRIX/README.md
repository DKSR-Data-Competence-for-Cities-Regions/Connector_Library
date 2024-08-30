![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# Inrix Connector API

This connector consumes data from Eco Counter HTTPS API which provides the details.

please refer  to https://docs.inrix.com/traffic/segmentspeed/ for further details 


# Schema that used in the connector

```
"description": {
"createdDate": "date of creation of inrix data",
"statusId": "status id of inrix data",
"statusText": "statusText for inrix data",
"responseId": "response id for inrix data",
"coverage": "coverage for inrix data",
"average": "hourly partitioned average velocity value per segment",
"code": "unique id of segment",
"reference": "speed of the segment under optimal conditions",
"speed": "current travel speed in the segment",
"travelTimeMinutes": "current travel time required in the segment",
"type": "description of segment type",
"score": "rating of the actuality of the data from 10 being historical to 30 being real-time",
"c-value": "confidence interval of the segment",
"speedBucket": "Categorical evaluation of the segment by the current travel speed in relation to the reference speed"
},
"config": {
"createdDate": "string",
"statusId": "double",
"statusText": "string",
"responseId": "string",
"coverage": "double",
"average": "double",
"code": "string",
"reference": "double",
"speed": "double",
"travelTimeMinutes": "double",
"type": "string",
"score": "double",
"c-value": "double",
"speedBucket": "double"
}
```

# Sample JSON data sent to OUP,

```
{
"coverage" : 8.0,
"average" : 29.0,
"code" : "XXXXXXXXXXXXXXXXXXXX",
"type" : "XXX",
"speed" : 24.0,
"SID" : "XXXXXXXXXXXXXXXXXXXX",
"reference" : 31.0,
"score" : 30.0,
"createdDate" : "2022-08-25T13:38:01Z",
"speedBucket" : 2.0,
"statusId" : 0.0,
"statusText" : "OK",
"c-value" : XXXX,
"travelTimeMinutes" : 0.069,
"responseId" : "XXXXXXXXXXXXXXXXXXXX",
"timestamp" : "2022-08-25T13:38:53.165Z"
},
```
