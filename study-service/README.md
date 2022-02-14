A study service is an application to enable users to create studies via an API using Spring Boot and H2.

Study Service

Author
Method	Path	Description
GET	/api/Author	To get list of Authors
POST	/api/Author	To save author
PUT	/api/Author/{id}	To update Author
DELETE	/api/Author/{id}	To delete Author


Study
Method	Path	Description
GET	/api/Study	To get list of Studies
POST	/api/Study	To save Study
PUT	/api/Study/{id}	To update Study
DELETE	/api/Study/{id}	To delete Study

Note: Study can only be created for a pre existing author.

FileUpload
Method	Path	Description
POST	/api/fileUpload	To upload files
GET	/api/StudyFiles	To get list of files

Note: Files can only be uploaded for a pre existing study.


How to run?
Run as java application in IDE.

Using command prompt:

To build JAR: mvn clean install

To run Application: java -jar study-service-1.0.0.jar

To launch application swagger (in browser): http://localhost:8080/swagger-ui/


