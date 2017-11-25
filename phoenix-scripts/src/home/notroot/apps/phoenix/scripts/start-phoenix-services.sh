export PHOENIX_COMMON_VERSION=1.0
export PHOENIX_SERVICES_VERSION=1.0

export CLASSPATH="/home/notroot/apps/phoenix/lib/phoenix-common-${PHOENIX_COMMON_VERSION}.jar;/home/notroot/lab/software/hbase-1.1.2/lib"
/home/notroot/lab/software/jdk1.8.0_151/bin/java -cp $CLASSPATH -Dexternal.properties.dir=/home/notroot/apps/phoenix/config -jar /home/notroot/apps/phoenix/lib/phoenix-services-${PHOENIX_SERVICES_VERSION}.jar > /home/notroot/apps/phoenix/logs/phoenix-services.log