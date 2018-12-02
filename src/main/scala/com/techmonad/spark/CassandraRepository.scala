package com.techmonad.spark

import com.datastax.spark.connector._
import com.datastax.spark.connector.rdd.CassandraTableScanRDD
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD


object CassandraRepository {

  def read1(keyspace: String, tableName: String)(implicit sc: SparkContext): CassandraTableScanRDD[CassandraRow] = {
    sc.cassandraTable(keyspace, tableName)
  }


  def read2(keyspace: String, tableName: String)(implicit sc: SparkContext): CassandraTableScanRDD[Employee] = {
    sc.cassandraTable[Employee](keyspace, tableName)
  }


  def write1(rdd: RDD[(Int, String, String, Long)], keyspace: String, tableName: String): Unit = {
    rdd.saveToCassandra(keyspace, tableName, SomeColumns("id", "name", "email", "dob"))
  }


  def write2(rdd: RDD[Employee], keyspace: String, tableName: String): Unit = {
    rdd.saveToCassandra(keyspace, tableName)
  }


}

case class Employee(id: Int, name: String, email: String, dob: Long)
