# spring-cloud-consul-poc
spring cloud integration with consul configuration 
1. download consul server - https://www.consul.io/downloads.html
2. extract into your local directory
3. run in local development mode 
         consul agent -dev
4. clone this project
5. run SpringCloudConsulPocApplication as spring boot application
6. goto browser and type the following url
    http://localhost:8500
7. click on Key/Value tab
8. click Create button
9. entery key as 
          config/spring-config-consul/openweather/rest/endpoint
   value as 
        https://samples.openweathermap.org/data/2.5/weather?zip={zip}&appid=b6907d289e10d714a6e88b30761fae22
        
 10. open the browser and type the following url
 http://localhost:8080/discoveryClient?zip=75068&country=us
        
