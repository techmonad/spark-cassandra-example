package com.techmonad.spark

import com.datastax.spark.connector.rdd.CassandraTableScanRDD

object Main extends SparkContextProvider {

  def main(args: Array[String]): Unit = {
    /*
        val empRDD1: CassandraTableScanRDD[CassandraRow] = CassandraRepository.read1("company", "employee")
        empRDD1.collect().foreach(println)


        val dataRDD1: RDD[(Int, String, String, Long)] =
          sc.parallelize(List((4, "jack", "jack@gmail.com", System.currentTimeMillis())))
        CassandraRepository.write1(dataRDD1, "company", "employee")

        */


    val empRDD2: CassandraTableScanRDD[Employee] = CassandraRepository.read2("company", "employee")
    empRDD2.collect().foreach(println)

    val dataRDD2 =
      sc.parallelize(List(Employee(5, "jack2", "jack2@gmail.com", System.currentTimeMillis())))
    CassandraRepository.write2(dataRDD2, "company", "employee")


    sc.stop()
  }


}

