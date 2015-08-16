package br.com.gazin.smartfood.config;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoConfig {
	private static final String HOST_NAME = "localhost";
	private static final Integer HOST_PORT = 5432;
	private static final String DB_NAME = "comanda_online";

	public static MongoClient getConnection() throws UnknownHostException {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient(HOST_NAME, HOST_PORT);
		} catch (Exception e) {
			throw new UnknownHostException("Host not found.");
		}
		return mongoClient;
	}

	public static DB getDB() throws UnknownHostException {
		return getConnection().getDB(DB_NAME);
	}
}
