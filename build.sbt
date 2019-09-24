name := "akka-grapc-scala"

version := "1.0"

scalaVersion := "2.12.6"

lazy val akkaVersion = "2.5.25"
lazy val akkaGrpcVersion = "0.7.1"

enablePlugins(AkkaGrpcPlugin)

// ALPN agent
enablePlugins(JavaAgent)
javaAgents += "org.mortbay.jetty.alpn" % "jetty-alpn-agent" % "2.0.7" % "runtime;test"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "net.codingwell" %% "scala-guice" % "4.2.6",
)
