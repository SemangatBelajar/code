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
import sample.project.mahasiswa.entity.Jurusan;


public class JurusanService {
    private Connection koneksi;
    
    public JurusanService(){
        koneksi = DatabaseMahasiswa.getConnection();
    }
    
    public void insert(Jurusan jurusan){
        PreparedStatement prepare = null;
        try{
            String sql = "INSERT INTO MAHASISWA_JURUSAN(nim, jurusan) VALUES(?, ?)";
            prepare = koneksi.prepareStatement(sql);
            prepare.setInt(1, jurusan.getNim());
            prepare.setString(2, jurusan.getJurusan());
            prepare.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("prepare gagal");
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("prepapre gagal diclose");
            }
        }
    }
    
    public void update(Jurusan jurusan){
        PreparedStatement prepare = null;
        try{
            String sql = "UPDATE MAHASISWA_JURUSAN SET jurusan = ? WHERE nim =?";
            prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, jurusan.getJurusan());
            prepare.setInt(2, jurusan.getNim());
            prepare.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("prepare gagal");
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("prepapre gagal diclose");
            }
        }
    }
    
    public void delete(int nim){
        PreparedStatement prepare = null;
        try{
            String sql = "DELETE FROM MAHASISWA_JURUSAN WHERE nim =?";
            prepare = koneksi.prepareStatement(sql);
            prepare.setInt(1, nim);
            
            prepare.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("prepare gagal");
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("prepapre gagal diclose");
            }
        }
    }
    
    public Jurusan selectByNim(int nim){
        PreparedStatement prepare = null;
        ResultSet result = null;
        Jurusan jurusan = null;
        try{
            String sql = "SELECT * FROM MAHASISWA_JURUSAN WHERE nim =?";
            prepare = koneksi.prepareStatement(sql);
            prepare.setInt(1, nim);
            result = prepare.executeQuery();
            if(result.next()){
                jurusan = new Jurusan();
                jurusan.setNim(result.getInt("nim"));
                jurusan.setJurusan(result.getString("jurusan"));
            }
            
            return jurusan;
        }catch(SQLException ex){
            System.out.println("prepare gagal" + ex.getMessage());
            return jurusan;
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("prepapre gagal diclose");
            }
             try{
                result.close();
            }catch(SQLException ex){
                System.out.println("prepapre gagal diclose");
            }
        }
    }
    
    public List<Jurusan> selectAll(){
        PreparedStatement prepare = null;
        ResultSet result = null;
        List<Jurusan> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM MAHASISWA_JURUSAN";
            prepare = koneksi.prepareStatement(sql);
            
            result = prepare.executeQuery();
            while(result.next()){
                Jurusan jurusan = new Jurusan();
                jurusan.setNim(result.getInt("nim"));
                jurusan.setJurusan(result.getString("jurusan"));
                list.add(jurusan);
            }
            
            return list;
        }catch(SQLException ex){
            System.out.println("prepare gagal" + ex.getMessage());
            return list;
        }finally{
            try{
                prepare.close();
            }catch(SQLException ex){
                System.out.println("prepapre gagal diclose");
            }
             try{
                result.close();
            }catch(SQLException ex){
                System.out.println("prepapre gagal diclose");
            }
        }
    }
}
