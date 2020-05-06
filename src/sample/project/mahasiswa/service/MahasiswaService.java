/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project.mahasiswa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.project.mahasiswa.database.DatabaseMahasiswa;
import sample.project.mahasiswa.entity.Mahasiswa;


public class MahasiswaService {
    private Connection koneksi;
    
    public MahasiswaService(){
        koneksi = DatabaseMahasiswa.getConnection();
    }
    
    public void insert(Mahasiswa mahasiswa){
        PreparedStatement prepare = null;
        try{
            String sql = "INSERT INTO MAHASISWA(nim, nama, jurusan, alamat, email)"
                + "VALUES(?, ?, ?, ?, ?)";
        prepare = koneksi.prepareStatement(sql);
        prepare.setInt(1, mahasiswa.getNim());
        prepare.setString(2, mahasiswa.getNama());
        prepare.setString(3, mahasiswa.getJurusan());
        prepare.setString(4, mahasiswa.getAlamat());
        prepare.setString(5, mahasiswa.getEmail());
        
        prepare.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Prepare gagal" + ex.getMessage());
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("Prepare gagal diclose");
            }
        }
    }
    public void update(Mahasiswa mahasiswa){
        PreparedStatement prepare = null;
        try{
            String sql = "UPDATE MAHASISWA SET nama =?, jurusan =?, alamat =?, email = ? WHERE nim =?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, mahasiswa.getNama());
            prepare.setString(2, mahasiswa.getJurusan());
            prepare.setString(3, mahasiswa.getAlamat());
            prepare.setString(4, mahasiswa.getEmail());
            prepare.setInt(5, mahasiswa.getNim());
            
            prepare.executeUpdate();
            
            
        }catch(SQLException ex){
            System.out.println("Prepare gagal");
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("Prepare gagal diclose");
            }
        }
    }
    
    public void delete(int nim){
        PreparedStatement prepare = null;
        try{
            String sql = "DELETE FROM MAHASISWA WHERE nim =?";
        prepare = koneksi.prepareStatement(sql);
        prepare.setInt(1, nim);
       
        
        prepare.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Prepare gagal");
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("Prepare gagal diclose");
            }
        }
    }
    
    public Mahasiswa selectByNim(int nim){
        PreparedStatement prepare = null;
        ResultSet result = null;
        Mahasiswa mahasiswa = null;
        try{
            String sql = "SELECT * FROM MAHASISWA WHERE nim =?";
            
            prepare = koneksi.prepareStatement(sql);
            prepare.setInt(1, nim);
            result = prepare.executeQuery();
            while(result.next()){
                mahasiswa = new Mahasiswa();
                mahasiswa.setNim(result.getInt("nim"));
                mahasiswa.setNama(result.getString("nama"));
                mahasiswa.setJurusan(result.getString("jurusan"));
                mahasiswa.setAlamat(result.getString("alamat"));
                mahasiswa.setEmail(result.getString("email"));
            }
            
            return mahasiswa;
        }catch(SQLException ex){
            System.out.println("Prepare gagal");
            return mahasiswa;
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("Prepare gagal diclose");
            }finally{
                try{
                    result.close();
                }catch(SQLException ex){
                }
            }
        }
    }
    
    
    public List<Mahasiswa> selectAll(){
        PreparedStatement prepare = null;
        ResultSet result = null;
        List<Mahasiswa> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM MAHASISWA";
            
            prepare = koneksi.prepareStatement(sql);
            
            result = prepare.executeQuery();
            while(result.next()){
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNim(result.getInt("nim"));
                mahasiswa.setNama(result.getString("nama"));
                mahasiswa.setJurusan(result.getString("jurusan"));
                mahasiswa.setAlamat(result.getString("alamat"));
                mahasiswa.setEmail(result.getString("email"));
                list.add(mahasiswa);
            }
            
            return list;
        }catch(SQLException ex){
            System.out.println("Prepare gagal");
            return list;
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("Prepare gagal diclose");
            }finally{
                try{
                    result.close();
                }catch(SQLException ex){
                }
            }
        }
    }
}
