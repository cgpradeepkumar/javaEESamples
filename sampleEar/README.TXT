REMEMBER to USE Java 1.6

1. RUN COMMAND TO COMPILE THE PROJECT

pkumar@01hw824061:~/workstation/projects/javaEESamples/sampleEar$ gradle clean build

2. DEPLOY EAR TO WAS FROM BELOW PATH

/sampleEar/build/libs/

3. CREATE STUBS USING FOLLOWING COMMAND

pkumar@01hw824061:~/eaf/software/WebSphere/bin$ ./createEJBStubs.sh ~/workstation/projects/javaEESamples/sampleEar/build/libs/sampleEar.ear -updatefile

4. COPY UPDATE EJB-CLIENT JAR TO ALL CLIENT PROJECTS.

