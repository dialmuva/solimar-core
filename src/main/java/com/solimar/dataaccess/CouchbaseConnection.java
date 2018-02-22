package com.solimar.dataaccess;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;

public class CouchbaseConnection {
	
	public Bucket getConnection(){
		System.out.println("Trying to connect to Couchbase");
		System.setProperty("com.couchbase.queryEnabled", "true");
		CouchbaseEnvironment env = DefaultCouchbaseEnvironment.create();
		Cluster cluster = CouchbaseCluster.create(env, "127.0.0.1:8091");
		Bucket bucket = cluster.openBucket("solimar", "password");
		System.out.println("Connected");
		return bucket;	
	}
	
	public boolean disconnect(Cluster cluster){
		return cluster.disconnect();
	}
	
	public boolean close(Bucket bucket){
		return bucket.close();
	}

}
