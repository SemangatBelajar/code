/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project.mahasiswa.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sample.project.mahasiswa.entity.Jurusan;


public class TableModelJurusan extends AbstractTableModel {

    private List<Jurusan> list;

    public TableModelJurusan(List<Jurusan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNim();
            case 1:
                return list.get(rowIndex).getJurusan();
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
                return "Jurusan";
            default:
                return null;
        }
    }
}
