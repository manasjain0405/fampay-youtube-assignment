#!/bin/sh

java $JAVA_OPTS -jar onboarding-data-server.jar $GROW_OPTS -Xms$JAVA_PROCESS_MIN_HEAP -Xmx$JAVA_PROCESS_MAX_HEAP --spring.profiles.active=$SPRING_ACTIVE_PROFILE