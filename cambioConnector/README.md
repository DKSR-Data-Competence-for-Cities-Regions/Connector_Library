![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# Cambio Connector API

This connector consumes data from Cambio Car Sharing HTTPs API which provides the details about the cars provided by Cambio 

please refer to https://github.com/ubahnverleih/WoBike/blob/master/Cambio.md and https://www.cambio-carsharing.de/en/ for further details 


# Schema that is used in the connector

```
{
      "description": {
           "id": "Id of the station",
            "displayName": "name of the station",
            "streetAddress": "street address of the station",
            "streetNumber": "Streetnumber of the station",
            "addressLocation": "adress location of the station",
            "postalCode": "postalcode of the station",
            "addressCountry": "country info of the station",
            "location": "location of the station",
            "lat": "latitude of the station",
            "lon": "longitude of the station",
            "vehicleClasses": "vehicle information details"
          },
          "config": {
            "id": "string",
            "displayName": "string",
            "streetAddress": "string",
            "streetNumber": "string",
            "addressLocation": "string",
            "postalCode": "string",
            "addressCountry": "string",
            "location": "string",
            "lat": "double",
            "lon": "double",
            "vehicleClasses": "java.util.List"
          }
        }
```

# Sample JSON data that is sent to OUP

```
{		
  "streetNumber" : "25",
  "displayName" : "xx",
  "postalCode" : "xx",
  "lon" : xx,
  "SID" : "693411dc-8474-4302-97ee-366363b81cde",
  "streetAddress" : "StreetName",
  "addressLocation" : "CityName",
  "location" : "Hausnr 25",
  "id" : "12-4600",
  "lat" : xx,
  "timestamp" : "2024-12-08T00:42:43.754Z"
}
```
