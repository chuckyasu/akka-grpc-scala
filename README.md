# Akka gRPC Scala
See https://doc.akka.io/docs/akka-grpc/current/server/walkthrough.html
## Getting Started
Compile
```
$ sbt compile
```
Run server
```
$ sbt -Dconfig.resource=dev.conf "runMain com.example.GreeterServer"
```
Run client
```
$ sbt -Dconfig.resource=dev.conf "runMain com.example.GreeterClient"
```

