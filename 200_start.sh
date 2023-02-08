#!/bin/sh
    #java -cp lib/slf4j-api-1.7.30.jar:lib/slf4j-simple-1.7.30.jar:out/classes/ io.takima.master3.HelloWorld

#

./100_compile.sh
./prepare.sh
mkdir -p out/war/WEB-INF
cp -R out/classes out/war/WEB-INF
cp -R src/main/webapp/* out/war/
jar -cvf out/war/helloworld.war  -C  out/war/ .

cp -R src/main/META-INF out/war/WEB-INF/classes

./110_configure.sh
./120_deploy.sh
sh wildfly-26.1.3.Final/bin/standalone.sh



