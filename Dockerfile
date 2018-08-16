FROM tomcat:8.0-jre8-alpine
RUN rm -rf ./webapps/ROOT.war ./webapps/examples.war ./webapps/ROOT 
COPY ./docker/tomcat-users.xml ./conf/
COPY ./target/peea.war ./webapps/ROOT.war