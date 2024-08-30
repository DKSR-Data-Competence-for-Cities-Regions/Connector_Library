![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# Eco-Counter Connector API

This connector consumes data from Eco-counter HTTPS API which provides the details about the traffic.

please refer  to https://developers.eco-counter.com/ for further details 


# Sample schema that is used in the connector

`"description": {
"timestamp_ecocounter" : "timestamp of data retrieval",
"count" : "Count of vehicles",
"stand" : "Stand Value",
"placementLocation" : "Where the sensor is placed",
"channel_name" : "Description of Channel",
"channel_id" : "ID of Channel",
"counter_site_location" : "Counter Site location",
"counter_site_id" : "ID of Counter Site",
"domain_name" : "Domain name",
"domain_id" : "Domain ID",
"lon" : "longitude",
"lat": "latitude",
"timezone" : "timezone",
"interval" : "interval time in minutes",
"counter_serial" : "counter serial number"
},
"config": {
"timestamp_ecocounter" : "string",
"count" : "double",
"stand" : "double",
"placementLocation" : "string",
"channel_name" : "string",
"channel_id" : "double",
"counter_site_location" : "string",
"counter_site_id" : "double",
"domain_name" : "string",
"domain_id" : "double",
"lon" : "double",
"lat": "double",
"timezone" : "string",
"interval" : "double",
"counter_serial" : "string"
}
`

# Sample JSON data tha will be sent to OUP,

`{
"channel_name" : "XXXXXXXXXXX",
"timezone" : "XXXXXXXXXXXT",
"count" : 77.0,
"lon" : 17.83717,
"SID" : "XXXXXXXXXXX",
"domain_id" : xxx,
"domain_name" : "Test ABC",
"timestamp_ecocounter" : "2022-10-24T21:00:00+0000",
"placementLocation" : "XXXXXXXXXXX",
"counter_site_id" : XXXXXXXXXXX,
"interval" : 15,
"counter_site_location" : "ABC Test",
"stand" : 0,
"channel_id" : XXXXXXXXXXX,
"counter_serial" : "XXXXXXXXXXX",
"lat" : 14.99984,
"timestamp" : "2022-10-25T09:52:12.874Z"
}`
