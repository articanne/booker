# Use the official Tomcat image with the latest version
FROM tomcat:10-jdk17-openjdk

# Remove the default webapps to avoid conflicts with your app
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file to the Tomcat webapps directory
COPY target/booker.war /usr/local/tomcat/webapps/ROOT.war

# Expose the Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
