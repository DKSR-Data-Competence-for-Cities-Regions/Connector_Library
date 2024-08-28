![DKSR-logo](https://user-images.githubusercontent.com/102658834/171163305-cdd99910-1b93-4d74-be88-7c1d23fdcf0d.png)

# DKSR Connector Library

# Licence Information
This code is published by DKSR Gmbh under the German Free Software License. Please refer to the document in the link for usage, change and distribution information:
https://www.hbz-nrw.de/produkte/open-access/lizenzen/dfsl/german-free-software-license

# Building the connectors

Add the pom.xml for each connector in this repository and setup the connector project with the steps provided in the below link.

https://github.com/DKSR-Data-Competence-for-Cities-Regions/DKSR-Connector-SDK/wiki/Setting-up-the-project

After setting up and creating a fat jar for the connector, add the platform and API details on config.json and run the connector as mentioned in the below link,

https://github.com/DKSR-Data-Competence-for-Cities-Regions/DKSR-Connector-SDK/wiki/Creating-a-connector

# Sample JSON data tha will be sent to OUP,

{
"is_reserved" : 0,
"is_disabled" : 0,
"vehicle_type" : "scooter",
"lon" : 61.8354,
"bike_id" : "xxxxx-xxx-xxx-xx-xxxxxxx",
"lat" : 15.5106,
"timestamp" : "2023-07-03T09:51:52.624Z",
"SID" : "xxxxx-xxx-xxx-xx-xxxxxxx"
},
