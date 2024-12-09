![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# Next Bike Connector API

This connector consumes data from Next Bike HTTPS API which provides the details about the bikes provided by Next bike 

please refer  to https://api.nextbike.net/maps/nextbike-live.json for further details 


# Schema that is used in the connector

```
{
      "description": {
            "uid": "id of the bike",
            "lat": "lattitude of the bike",
            "lon": "longitude of the bike",
            "number": "number of the location",
            "name": "name of the location",
            "bookedBikes": "number of bikes booked",
            "bikes": "number of bikes",
            "bikesAvailable": "available bikes",
            "bikeNumber": "number of the bike",
            "bikeType": "type of the bike",
            "lockTypes": "type of the lock for the bike",
            "active": "active status of the bike",
            "state": "status of the bike",
            "electricLock": "electric lock status of the bike",
            "boardComputer": "boardComputer of the bike ",
            "pedelecBattery": "Battery details",
            "batteryPack": "Battery details"
          },
          "config": {
            "uid": "double",
            "lat": "double",
            "lon": "double",
            "number": "double",
            "name": "string",
            "bookedBikes": "double",
            "bikes": "double",
            "bikesAvailable": "double",
            "bikeNumber": "string",
            "bikeType": "double",
            "lockTypes": "string",
            "active": "boolean",
            "state": "string",
            "electricLock": "boolean",
            "boardComputer": "double",
            "pedelecBattery": "double",
            "batteryPack": "double"
          }
        }
```

# Sample JSON data that is sent to OUP

```
{		
  "bikes" : 21.0,
  "bikesAvailable" : 21.0,
  "active" : true,
  "lon" : 7.204667,
  "boardComputer" : 7.551111532E9,
  "SID" : "xxxx",
  "uid" : xxxx,
  "number" : 53750.0,
  "bookedBikes" : 0.0,
  "batteryPack" : null,
  "bikeType" : 196.0,
  "bikeNumber" : "530188",
  "lockTypes" : "frame_lock",
  "name" : "xxxxx",
  "pedelecBattery" : null,
  "state" : "ok",
  "electricLock" : true,
  "lat" : xx.xx,
  "timestamp" : "2024-12-03T22:02:09.947Z",
}
```
