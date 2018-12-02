package com.techmonad.spark

import org.apache.spark.{SparkConf, SparkContext}

trait SparkContextProvider {

  val sparkConf = new SparkConf()

  sparkConf.set("spark.cassandra.connection.host", "127.0.0.1")

  sparkConf.setMaster("local[*]")
  sparkConf.setAppName("SparkCassandraApp")

  implicit val sc = new SparkContext(sparkConf)

}
