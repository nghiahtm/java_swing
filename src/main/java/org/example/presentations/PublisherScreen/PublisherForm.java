package org.example.presentations.PublisherScreen;
import org.example.common.constants.StringConstants;
import org.example.models.PublisherModel;
import org.example.presentations.WarningDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PublisherForm {
    public JPanel publisherPanel;
    private JTextField fieldID;
    private JTextField fieldPublisher;
    private JButton reloadButton;
    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JTable tblPublishers;
    private JTextField fieldSearch;
    private JButton searchButton;

    private String keyword = "";
    private DefaultTableModel model;

    private List<PublisherModel> publishers;
    private PublisherModel publisherSelected;

    private PublisherController controller;
    public PublisherForm(){
        initState();
        reloadButton.addActionListener(e -> reloadPublisher());
        addButton.addActionListener(e -> addPublisher ());
        editButton.addActionListener(e -> editPublisher());
        removeButton.addActionListener(e -> removePublisher());
        searchButton.addActionListener(e -> searchPublisher());
        fieldID.setEditable(false);
    }

    private void removePublisher() {
        String id = fieldID.getText();
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(publisherPanel, StringConstants.idPublisherNotEmpty);
            return;
        }
        int ok = WarningDialog.warningDialog(StringConstants.questionDelete);
        if(ok == 0){
            int idPublisher = Integer.parseInt(id);
            String showMessage = controller.removePublisher(idPublisher);
            if(showMessage.equals(StringConstants.idPublisherExistInBook)){
                JOptionPane.showMessageDialog(publisherPanel, StringConstants.idPublisherExistInBook);
                return;
            }
            if(showMessage.equals(StringConstants.connectError)){
                JOptionPane.showMessageDialog(publisherPanel, StringConstants.connectError);
                return;
            }
                reloadPublisher();

        }
    }

    private void editPublisher() {
        String id = fieldID.getText();
        if(id.isEmpty()){
            JOptionPane.showMessageDialog(publisherPanel, StringConstants.idPublisherNotEmpty);
            return;
        }
        if(fieldPublisher.getText().isEmpty()){
            JOptionPane.showMessageDialog(publisherPanel, StringConstants.publisherNameEmpty);
            return;
        }

        PublisherModel addPublisher = new PublisherModel(
                Integer.parseInt(id), fieldPublisher.getText()
        );
        boolean isSuccess = controller.isEditPublisher(addPublisher);
        if(!isSuccess){
            JOptionPane.showMessageDialog(publisherPanel, StringConstants.connectError);
        }
        reloadPublisher();
    }

    private void addPublisher() {
        if(!fieldID.getText().isEmpty()){
            JOptionPane.showMessageDialog(publisherPanel, StringConstants.idPublisherEmpty);
            return;
        }
        if(fieldPublisher.getText().isEmpty()){
            JOptionPane.showMessageDialog(publisherPanel, StringConstants.publisherNameEmpty);
            return;
        }
        PublisherModel addPublisher = new PublisherModel(
                null, fieldPublisher.getText()
        );
        boolean isSuccess = controller.isAddPublisher(addPublisher);
        if(!isSuccess){
            JOptionPane.showMessageDialog(publisherPanel, StringConstants.connectError);
        }
        reloadPublisher();
    }

    private void reloadPublisher() {
        clearField();
        setTableData("");
    }

    private void initState(){
        publisherSelected = new PublisherModel(
                null,null
        );
        publisherPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        tblPublishers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setStateField();
                super.mouseClicked(e);
            }
        });
        controller = new PublisherController();
        setTableData(keyword);
    }

    private void setStateField() {
        publisherSelected = publishers.get(tblPublishers.getSelectedRow());
        fieldID.setText(""+publisherSelected.id);
        fieldPublisher.setText(publisherSelected.name);
    }

    private void clearField() {
       fieldSearch.setText("");
        fieldPublisher.setText("");
        fieldID.setText("");
    }

    private void setTableData(String keyword) {
        model = new DefaultTableModel() {
            final String[] headerBook =
                    {"ID","Publisher"};

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
                return false;
            }
        };
        publishers = controller.getPublishers(keyword);
        for (final PublisherModel publisher : publishers) {
            model.addRow(new Object[]{
                    publisher.id,
                    publisher.name
            });
        }
        tblPublishers.setModel(model);
    }

    void searchPublisher(){
        keyword = fieldSearch.getText();
        setTableData(keyword);
    }
}
