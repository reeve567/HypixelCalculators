package dev.reeve.api.influx

import com.influxdb.client.InfluxDBClient
import com.influxdb.client.InfluxDBClientFactory

object InfluxAPI: AutoCloseable {
	private lateinit var client: InfluxDBClient
	fun setupConnection(apiKey: String, baseUrl: String, bucket: String, org: String) {
		client = InfluxDBClientFactory.create(baseUrl, apiKey.toCharArray(), org, bucket)
	}

	fun test() {
		client.queryApi
	}

	override fun close() {
		client.close()
	}
}