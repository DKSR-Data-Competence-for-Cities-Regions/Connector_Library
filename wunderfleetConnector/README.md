![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# Wunderfleet Connector API

This connector consumes data from Wunderfleet Sharing HTTPs API which provides the details about the cars provided by Wunderfleet 

please refer to https://www.wundermobility.com/software for further details 


# Schema that is used in the connector

```
{
      "description": {
           "carId": "Id of the car",
            "serviceType": "service type of the car",
            "title": "car title",
            "lat": "lattitude of the car",
            "lon": "longitude of the car",
            "licencePlate": "licenseplate of the car",
            "fuelLevel": "fuel level of the car",
            "vehicleStateId": "vehicle state id",
            "vehicleTypeId": "vehicletypeID",
            "pricingTime": "pricing time",
            "pricingParking": "parking price",
            "reservationState": "reservation state",
            "address": "address",
            "zipCode": "zipcode",
            "city": "city",
            "locationId": "location Id",
            "vehicleType": "vehicle type"
          },
          "config": {
            "carId": "double",
            "serviceType": "double",
            "title": "string",
            "lat": "double",
            "lon": "double",
            "licencePlate": "string",
            "fuelLevel": "double",
            "vehicleStateId": "double",
            "vehicleTypeId": "double",
            "pricingTime": "string",
            "pricingParking": "string",
            "reservationState": "double",
            "address": "string",
            "zipCode": "string",
            "city": "string",
            "locationId": "double",
            "vehicleType": "string"
          }
        }
```

# Sample JSON data that is sent to OUP

```
{  
  "carId": 200,
  "serviceType": 2,
  "title": "M & XL",
  "SID" : "894487rt-8474-4302-9az6-457283b81cde",
  "lat": "XX",
  "lon": "XX",
  "licencePlate": "XX",
  "fuelLevel": 40,
  "vehicleStateId": 12,
  "vehicleTypeId": 2,
  "pricingTime": "XX €/Min",
  "pricingParking": "XX €",
  "reservationState": 0,
  "address": "XX",
  "zipCode": "XX",
  "city": "XX",
  "locationId": 2,
  "vehicleType": "54i:conic",
  "timestamp" : "2024-12-08T00:42:43.754Z"
}
```
