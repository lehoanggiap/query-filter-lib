@echo off

:: Test the connection to sonarqube local
call:check_connection
if not %ERRORLEVEL% == 0 (
    echo Starting sonarqube....
    START StartSonar.bat
    echo Go go http://localhost:9000
    :: Pause to wait user to check if sonarqube is up and running
    echo "Pausing...., you can press any key to exit if sonarqube is up"
    pause
    call:check_connection
    if not %ERRORLEVEL% == 0 call:end
)

goto:SonarScan

:: Escape here, not allow to run the below label.
goto:eof

:end
    echo Could not start sonarqube
goto:eof

:SonarScan
     echo "Run sonar scanner"
    sonar-scanner ^
    -Dsonar.projectKey=query-filer ^
    -Dsonar.projectBaseDir=%cd% ^
    -Dsonar.host.url=http://localhost:9000 ^
    -Dsonar.sources=src/main/java/ ^
    -Dsonar.java.binaries=target/classes ^
    -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
    -Dsonar.token=%sonar_token%
goto:eof

:check_connection
    echo Testing connection to sonarqube...
    echo %windir%
    :: findstr => always return 0 even if not found the term in the command output
    :: find => return 0 if matched, else 1
    powershell Test-NetConnection 127.0.0.1 -p 9000 | find "TcpTestSucceeded : True"
    echo %ERRORLEVEL%
goto:eof




