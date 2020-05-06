/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project.mahasiswa.combobox.render;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import sample.project.mahasiswa.entity.Jurusan;


public class JurusanRender extends DefaultListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if(value instanceof Jurusan){
            Jurusan j = (Jurusan) value;
            String text = j.getJurusan();
            label.setText(text);
        }
        return label;
    }
    
}
