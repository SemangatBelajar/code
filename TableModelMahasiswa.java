/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project.mahasiswa.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sample.project.mahasiswa.entity.Mahasiswa;


public class TableModelMahasiswa extends AbstractTableModel {

    private List<Mahasiswa> list;

    public TableModelMahasiswa(List<Mahasiswa> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNim();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getJurusan();
            case 3:
                return list.get(rowIndex).getAlamat();
            case 4:
                return list.get(rowIndex).getEmail();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nim";
            case 1:
                return "Nama";
            case 2:
                return "Jurusan";
            case 3:
                return "Alamat";
            case 4:
                return "Email";
            default:
                return null;
        }
    }
}
