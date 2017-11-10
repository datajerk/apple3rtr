@ECHO OFF
REM
REM ADTPro - OS/2 startup command file
REM
REM You can set two variables here:
REM   1. %JAVA_HOME% - to pick a particular java to run under
REM   2. %ADTPRO_HOME% - to say where you installed ADTPro
REM
REM e.g. uncomment (remove the "@REM" from in front) and customize
REM      the following two SET statements.  
REM Note: They must have a trailing backslash as in the examples!

REM SET ADTPRO_HOME=C:\src\workspace\311\adtpro\build\ADTPro-2.0.2.jar\
REM SET MY_JAVA_HOME=E:\Java142\jre\bin\

SETLOCAL

CD %ADTPRO_HOME%disks
%MY_JAVA_HOME%java -Xms128m -Xmx256m -cp %ADTPRO_HOME%lib\ADTPro-2.0.2.jar;%ADTPRO_HOME%lib\rxtx\rxtx-2.2pre2-local\RXTXcomm.jar org.adtpro.ADTPro %*

ENDLOCAL