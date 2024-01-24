package com.atguigu.gmall;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoClientConnectionExample {
    public static void main(String[] args) {
        String connectionString = "mongodb://sichengzhu:19880312@ac-wba8lie-shard-00-00.lj3el42.mongodb.net:27017,ac-wba8lie-shard-00-01.lj3el42.mongodb.net:27017,ac-wba8lie-shard-00-02.lj3el42.mongodb.net:27017/?ssl=true&replicaSet=atlas-io6425-shard-0&authSource=admin&retryWrites=true&w=majority";


        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}
