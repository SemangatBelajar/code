/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project.mahasiswa;

import java.util.List;
import sample.project.mahasiswa.entity.Jurusan;
import sample.project.mahasiswa.entity.Mahasiswa;
import sample.project.mahasiswa.service.JurusanService;
import sample.project.mahasiswa.service.MahasiswaService;


public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MahasiswaService service = new MahasiswaService();
        
//        List<Mahasiswa> list = service.selectAll();
//        for(Mahasiswa m : list){
//            System.out.println(m.getNim());
//            System.out.println(m.getNama());
//        }
 
 
//        JurusanService jurusanService = new JurusanService();
//        Jurusan jurusan = jurusanService.selectByNim(111);
//        System.out.println("Nama Jurusan :" + jurusan.getJurusan());


//update 

//        JurusanService jurusanService = new JurusanService();
//        Jurusan jurusan = jurusanService.selectByNim(111);
//        jurusan.setJurusan("Antropologi");
//        jurusanService.update(jurusan);
//        System.out.println("Update berhasil" + jurusan.getJurusan());


//delete

//    JurusanService jurusanService = new JurusanService();
//    jurusanService.delete(111);
    }
}
