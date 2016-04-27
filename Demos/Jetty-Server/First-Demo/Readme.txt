*************************************************************************************************************************************
                                          Installation guidelines for JettyServer Demo
*************************************************************************************************************************************

Required Programs
***********************
1: Eclipse IDE
2: MySql 


Installation Steps:
***********************
1: Using mysql workbench software -> import the sql file to build the database sample schema.

2: Check if database table ( Medicines ) contains data if not then add some test data.

3: Using eclipse open the server JettyHaaSServer Project , make sure that the jars are properly configured in the build path.

4: Jars exist in lib packages in each project.

5: run it  , The main class is -> com.haas.server.main.Main.java

6: After running the class -> a GUI window will apear , click start 

7: This is a test step to make sure that the server is running:
      open any browser and make sure that there is not proxy configured on your machine then write the following URL:
      http://localhost:8585/runJetty/service/medicine/getUserMedicines?userEmail=
      at the end of the above line enter the user email that you added some medicines with or enter one of the exisitings table

8: after checking that the server is running well , Import the client



*************************************************************************************************************************************
                                          Installation guidelines for JettyClient Demo
*************************************************************************************************************************************

1: Import the client named JettyHaaSClient

2: make sure of the jars consistency

3: Run the project from the class -> com.haas.client.main.Main.java

4: the output will be printed in the console

And that's it :)
