package com.solimar.dataaccess.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;
import org.junit.Ignore;

import com.solimar.dataaccess.PostgreSQLConnection;

public class PostgresSQLConnectionTest {

	@Test
    public void checkConnection() {
		PostgreSQLConnection postgresprovider = new PostgreSQLConnection();
		Connection connection = postgresprovider.getConnection();
		assertNotNull(connection);
    }
}
