# UrlShortener
Shorten long URLs from Java code using latest Google web service.

Prerequisite : Generate Google API key(https://developers.google.com/maps/documentation/javascript/get-api-key) to be used in the code (Line 22).

Don't forget to check pom.xml or add following Maven Dependencies: 
  <dependency>
      <groupId>com.google.apis</groupId>
      <artifactId>google-api-services-oauth2</artifactId>
      <version>v1-rev117-1.22.0</version>
  </dependency>
  <dependency>
      <groupId>com.github.scribejava</groupId>
      <artifactId>scribejava-apis</artifactId>
      <version>2.8.1</version>
  </dependency>

  <dependency>
      <groupId>org.codehaus.jettison</groupId>
      <artifactId>jettison</artifactId>
      <version>1.3.7</version>
  </dependency>

  <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.3.1</version>
  </dependency>
