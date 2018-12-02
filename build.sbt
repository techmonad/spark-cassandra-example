name := "spark-cassandra-example"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++=
  Seq(
    "org.apache.spark" %% "spark-core" % "2.3.2",
    "org.apache.spark" %% "spark-sql" % "2.3.2",
    "com.datastax.spark" %% "spark-cassandra-connector" % "2.3.2"
  )
