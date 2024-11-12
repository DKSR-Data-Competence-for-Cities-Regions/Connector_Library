![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# OpenWeather Connector API

This connector consumes data from OpenWeather HTTPS API which provides the details about the weather for given lat and lon.

please refer  to https://openweathermap.org/api/one-call-3 for further details 


# Schema that is used in the connector

```
{
      "description": {
            "countrycode": "Two letter country code",
            "zipcode": "zipcode of the city",
            "temp": "Current average temperature in the city in C",
            "temp_min": "Current minimum measured temperature in the city in C",
            "temp_max": "Current maximum measured temperature in the city in C",
            "pressure": "Pressure in hPa",
            "humidity": "Relative humidity in percentages (0-100)",
            "sunrise": "Time of next sunrise in UTC?",
            "sunset": "Time of next sunset in UTC?",
            "lat": "Latitude",
            "lon": "Longitude",
            "wind_speed": "Speed of the wind",
            "wind_deg": "The deg of the wind",
            "clouds": "Number of the clouds",
            "visibility": "Visibility",
            "weather_id": "Weather condition ID. See http://openweathermap.org/weather-conditions for the list of IDs",
            "weather_icon": "URL to icon that describes current weather condition",
            "city": "City Name"
      },
      "config": {
            "countrycode": "string",
            "zipcode": "double",
            "temp": "double",
            "temp_min": "double",
            "temp_max": "double",
            "pressure": "long",
            "humidity": "long",
            "sunrise": "string",
            "sunset": "string",
            "lat": "double",
            "lon": "double",
            "wind_speed": "double",
            "wind_deg": "long",
            "clouds": "long",
            "visibility": "long",
            "weather_id": "long",
            "weather_icon": "string",
            "city": "string"
      }
}
```

# Sample JSON data that is sent to OUP

```
 {
    "weather_id": 804,
    "temp": 3.8,
    "sunrise": "2024-01-01T07:07:46.000Z",
    "visibility": 10000,
    "city": "Augsburg",
    "countrycode": "DE",
    "lon": 10.8978,
    "clouds": 100,
    "pressure": 1010,
    "weather_icon": "04n",
    "feels_like": 0.31,
    "temp_max": 4.58,
    "SID": "e54f7f91-144a-454e-9dff-926c19d2cd5b",
    "zipcode": 8010,
    "wind_deg": 240,
    "temp_min": 2.04,
    "sunset": "2024-01-01T15:31:14.000Z",
    "humidity": 81,
    "wind_speed": 4.12,
    "lat": 48.3705,
    "timestamp": "2023-12-31T23:42:39.563Z"
}

```
