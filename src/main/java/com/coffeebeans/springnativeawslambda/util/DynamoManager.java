package com.coffeebeans.springnativeawslambda.util;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

public class DynamoManager {
//    private static final AmazonDynamoDB amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard().
//            withCredentials(new DefaultAWSCredentialsProviderChain()).
//            withRegion(Regions.AP_NORTHEAST_1).build();
//    private static final DynamoDB dynamo = new DynamoDB(amazonDynamoDBClient);
//
//    private static final Table table = dynamo.getTable(DynamoConstants.TABLE_NAME);
//
//    public static Table getTable() {
//        return table;
//    }
//
//    public static AmazonDynamoDB getDynamoDB() {
//        return amazonDynamoDBClient;
//    }
//
//    public static DynamoDB getDynamo() {
//        return dynamo;
//    }
}
