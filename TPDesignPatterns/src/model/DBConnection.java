package model;

import java.sql.Connection;

public class DBConnection {

    private static Connection instance;

    private DBConnection() {

    }

    public synchronized static Connection getInstance() {
        if(instance == null) {
            instance =  new MyDBConnection();
        }
        return instance;
    }
}
