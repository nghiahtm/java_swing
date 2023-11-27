package org.example.presentations.PublisherScreen;
import org.example.models.PublisherModel;

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

    private List<PublisherModel> publishers;
    private PublisherModel publisherSelected;

    private PublisherController controller;
    public PublisherForm(){
        initState();
        reloadButton.addActionListener(e -> reloadPublisher());
        addButton.addActionListener(e -> addPublisher ());
        editButton.addActionListener(e -> editPublisher());
        removeButton.addActionListener(e -> removePublisher());
        fieldID.setEditable(false);
    }

    private void removePublisher() {
    }

    private void editPublisher() {

    }

    private void addPublisher() {
    }

    private void reloadPublisher() {
        clearField();
        setTableData();
    }

    private void initState(){
        publisherPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        tblPublishers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setStateField();
                super.mouseClicked(e);
            }
        });
        controller = new PublisherController();
        setTableData();
    }

    private void setStateField() {
        publisherSelected = publishers.get(tblPublishers.getSelectedRow());
        fieldID.setText(""+publisherSelected.id);
        fieldPublisher.setText(publisherSelected.name);
    }

    private void clearField() {
        fieldPublisher.setText("");
        fieldID.setText("");
    }

    private void setTableData() {
        DefaultTableModel model = new DefaultTableModel() {
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
        publishers = controller.getPublishers();
        for (final PublisherModel publisher : publishers) {
            model.addRow(new Object[]{
                    publisher.id,
                    publisher.name
            });
        }
        tblPublishers.setModel(model);
    }
}
