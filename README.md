# appdirect-integrations

- Integrated Below APIS:
-         1. Subscription create
-         2. Subscription change
-         3. Subscription cancel
- 
- Additional Points done are:
-         1. Oauth Signature verification on the AppDirect issued API requests.
-         2. For reading the event details(by performing an HTTP GET after signing the eventUrl with         your OAuth credentials) when AppDirect notifies your application of a Subscription event.
- 
- Steps To Run the application:
-         1. Prerequisite : Install JAVA 8 , Maven, Git
-         2. Clone the repository
-         3. Run the 'mvn clean install' command in repository folder
-         4. Once done, Just run command 'java -jar target/appdirect-integration-0.0.1-SNAPSHOT.jar'            from repository folder
-         5. H2 DB is configured here. You can check it at path '/console'.

