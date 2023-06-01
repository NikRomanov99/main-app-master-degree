FROM gradle:jdk17 as builder
COPY --chown=gradle:gradle . /main-app-master-degree/gradle/src
WORKDIR /main-app-master-degree/gradle/src
COPY build.gradle.kts ./build.gradle.kts
RUN gradle clean build

FROM openjdk:17-alpine as backend
WORKDIR /root
COPY --from=builder /main-app-master-degree/gradle/src/service-app/build/libs/* ./app
ENTRYPOINT ["java", "-jar", "/root/app"]