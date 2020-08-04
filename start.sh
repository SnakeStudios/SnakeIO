mvn deploy:deploy-file -Dfile=./target/SnakeIO-1.0.jar
    -DpomFile=./pom.xml
    -DrepositoryId=github
    -Durl=https://maven.pkg.github.com/SnakeStudios/SnakeIO 
    -Dtoken=4be10fdcdee4dd82e6874fc9c476369672d9af9c