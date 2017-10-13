name := "jackson-scala-map-bug"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.1"

libraryDependencies += "io.circe" %% "circe-core" % "0.8.0"
libraryDependencies += "io.circe" %% "circe-generic" % "0.8.0"
libraryDependencies += "io.circe" %% "circe-parser" % "0.8.0"