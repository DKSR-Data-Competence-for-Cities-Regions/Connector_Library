![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# Lime Connector API

This connector consumes data from Lime HTTPS API which provides the details about the LIME ebikes.

please refer  to https://lime.openfl.org/api/ for further details 


# Schema that is used in the connector

```"description": {
"bike_id": "Id of the bike",
"lat": "latitude of the station",
"lon": "longitude of the station",
"is_reserved": "Status of the bike if reserved",
"is_disabled": "Status of the bike if disabled",
"vehicle_type": "Type of the bike"
},
"config": {
"bike_id": "string",
"lat": "double",
"lon": "double",
"is_reserved": "double",
"is_disabled": "double",
"vehicle_type": "string"
}```

# Sample JSON data that is sent to OUP

```{
"is_reserved" : 0,
"is_disabled" : 0,
"vehicle_type" : "scooter",
"lon" : 61.8354,
"bike_id" : "xxxxx-xxx-xxx-xx-xxxxxxx",
"lat" : 15.5106,
"timestamp" : "2023-07-03T09:51:52.624Z",
"SID" : "xxxxx-xxx-xxx-xx-xxxxxxx"
},```
