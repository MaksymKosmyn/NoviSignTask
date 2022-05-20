#!/bin/bash

echo Discovery Service: BUILDING
cd DiscoveryService
mvn clean install -U
cd ..
clear


echo Discovery Service: BUILD DONE
echo API Gateway: BUILDING
cd APIGateway
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo API Service: BUILDING
cd APIService
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo API Service: BUILD DONE
echo Admin Service: BUILDING
cd AdminService
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo API Service: BUILD DONE
echo Admin Service: BUILD DONE
echo ---
echo Starting Application...
docker-compose up --build
