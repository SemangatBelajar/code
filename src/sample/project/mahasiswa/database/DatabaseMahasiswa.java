/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project.mahasiswa.database;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseMahasiswa {

    private static Connection koneksi;
    
    public static Connection getConnection() {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            String url = "jdbc:mysql://localhost:3306/mahasiswa";
            String user = "root";
            String password = "rudyruh";

            koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi berhasil");
        } catch (SQLException ex) {
            System.out.println("Koneksi gagal");
        }

        return koneksi;
    }
}
