package org.example.presentations.GenreScreen;

import org.example.common.constants.StringConstants;
import org.example.models.DetailBookModel;
import org.example.models.GenreModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GenreForm {
    private JTextField idField;
    private JTextField genreField;
    public JPanel genrePanel;
    private JButton reloadButton;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JTable tableGenres;

    private GenreController controller = new GenreController();
    private List<GenreModel> genres;

    private GenreModel genreSelected;
    public GenreForm(){
        initState();
        reloadButton.addActionListener(e -> reloadGenre());
        addButton.addActionListener(e -> addGenre());
        editButton.addActionListener(e -> editGenre());
        removeButton.addActionListener(e -> removeGenre());
        idField.setEditable(false);
    }

    private void initState(){
        genrePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        tableGenres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setStateField();
                super.mouseClicked(e);
            }
        });
        setTableData();
    }

    ///TODO: Set up Table
    private void setTableData(){
        DefaultTableModel model = new DefaultTableModel() {
            final String[] headerBook =
                    {"ID","Genre"};

            @Override
            public int getColumnCount() {
                return headerBook.length;
            }

            @Override
            public String getColumnName(int index) {
                return headerBook[index];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // or a condition at your choice with row and column
            }
        };
        genres = controller.getGenres();
        for (final GenreModel genre : genres) {
            model.addRow(new Object[]{
                   genre.id,
                   genre.name
            });
        }
        tableGenres.setModel(model);
    }

    private void setStateField(){
         genreSelected = genres.get(tableGenres.getSelectedRow());
         idField.setText(""+genreSelected.id);
         genreField.setText(genreSelected.name);
    }

    private void clearField(){
        idField.setText("");
        genreField.setText("");
    }
    private void removeGenre(){
        if(genreSelected == null){
            JOptionPane.showMessageDialog(genrePanel, StringConstants.idGenreNotEmpty);
            return;
        }
        boolean isSuccess = controller.isSuccessRemove(genreSelected.id);
        if(!isSuccess){
            JOptionPane.showMessageDialog(genrePanel, StringConstants.idGenreExistInBook);
            return;
        }
        reloadGenre();
    }

    private void editGenre(){
        String name = genreField.getText();
        if(idField.getText().isEmpty()){
            JOptionPane.showMessageDialog(genrePanel, StringConstants.idGenreNotEmpty);
            return;
        }
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(genrePanel, StringConstants.genreNameEmpty);
            return;
        }
        int id = Integer.parseInt(idField.getText());
        GenreModel genreEdit = new GenreModel(
                id,
                name
        );
        boolean isSuccess = controller.isSuccessEdit(
                genreEdit
        );
        if(!isSuccess){
                JOptionPane.showMessageDialog(genrePanel, StringConstants.connectError);
                return;
        }
        reloadGenre();
    }

    private void addGenre(){
        String name = genreField.getText();
        if(!idField.getText().isEmpty()){
            JOptionPane.showMessageDialog(genrePanel, StringConstants.idGenreExistInBook);
            return;
        }
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(genrePanel, StringConstants.genreNameEmpty);
            return;
        }
        GenreModel genreEdit = new GenreModel(
                null,
                name
        );
        boolean isSuccess = controller.isSuccessAdd(
                genreEdit
        );
        if(!isSuccess){
            JOptionPane.showMessageDialog(genrePanel, StringConstants.connectError);
            return;
        }
        reloadGenre();
    }

    private void reloadGenre(){
        clearField();
        setTableData();
    }
}
