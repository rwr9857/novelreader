FROM tomcat:9.0

# WAR 파일 복사
COPY /target/*.war /usr/local/tomcat/webapps/ROOT.war