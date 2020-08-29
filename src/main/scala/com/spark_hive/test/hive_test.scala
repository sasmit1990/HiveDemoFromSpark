package com.spark_hive.test

import org.apache.spark.sql.{Row, SQLContext, SaveMode, SparkSession}



object hive_test {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession

      .builder()

      .master("local")

      .appName("Spark SQL basic example")

      .config("spark.sql.warehouse.directory", "/user/hive/warehouse")

      .enableHiveSupport()

      .getOrCreate()



    spark.sql("Select * from video_analytics.Merged_data_all limit 10").show()



  }

}
