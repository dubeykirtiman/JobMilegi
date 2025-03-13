package com.jobmilegi.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/jobmilegi";
        String user = "springuser";
        String password = "springpassword";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Connection established successfully!");
            } else {
                System.out.println("❌ Failed to establish connection!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
