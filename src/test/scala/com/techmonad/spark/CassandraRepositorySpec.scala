package com.techmonad.spark

import com.datastax.spark.connector.cql.CassandraConnector
import com.datastax.spark.connector.embedded.{EmbeddedCassandra, SparkTemplate, _}
import org.scalatest.{FlatSpec, Matchers}

class CassandraRepositorySpec extends FlatSpec with EmbeddedCassandra with SparkTemplate with Matchers {
  override def clearCache(): Unit = CassandraConnector.evictCache()

  //Sets up CassandraConfig and SparkContext
  useCassandraConfig(Seq(YamlTransformations.Default))
  useSparkConf(defaultConf)

  val connector = CassandraConnector(defaultConf)

  val keySpace = "company"
  val tableName = "employee"
  "We" should "be able to access our Embedded Cassandra Node" in {
    connector
      .withSessionDo(session => session.execute("SELECT * FROM system_schema.tables"))
      .all() should not be empty
  }

  it should "be able to do some work with Spark" in {
    sc.parallelize(1 to 10).count should be (10)
  }

}


//https://github.com/datastax/SparkBuildExamples/blob/master/scala/sbt/dse/src/test/scala/com/datastax/spark/example/WriteReadSpec.scala