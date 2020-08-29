# HiveDemoFromSpark

In this example we will see how we can connect and read a hive table from Spark.

# Hive

Run the below code in hive

hive> create DATABASE video_analytics;
hive> CREATE TABLE IF NOT EXISTS Merged_data_all
    > (
    > liked STRING,user_id STRING,video_end_type INT,minutes_played INT,video_id STRING,geo_cd STRING,channel_id STRING,creator_id STRING ,tim
estamp STRING ,disliked STRING) PARTITIONED BY (batchid STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

Get data from the table:

hive> Select * from video_analytics.Merged_data_all limit 10;

# Spark

Reading from the above hive table

# code

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

# execution

We need to create jar file to submit

spark-submit --master yarn --class com.spark_hive.test.hive_test --num-executors 2 /home/sasmitsb4081/hive_table_test_
2.11-0.1.jar

Check the [link](https://dataengineeringtech.blogspot.com/2020/08/reading-hive-table-from-spark.html) for more.

##end
