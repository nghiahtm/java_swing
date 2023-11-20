package org.example.presentations.AuthorScreen;

import com.toedter.calendar.JDateChooser;
import org.example.common.constants.DateFormatConstant;
import org.example.common.constants.StringConstants;
import org.example.models.AuthorModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AuthorFrame{
    private JTextField idAuthor;
    private JTextField nameField;
    private JTextArea titleField;
    private JTable tableAuthors;
    public JPanel panelAuthor;
    private JPanel fieldCalendar;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnRemove;
    private JButton btnRefresh;
    private JDateChooser dateChooser;
    private AuthorController authorController;

    private List<AuthorModel> authors;

    private Integer indexSelected ;
    public AuthorFrame(){
       initState();
        tableAuthors.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionGetRow();
                setStateField();
                super.mouseClicked(e);
            }
        });
        tableAuthors.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //System.out.println(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 38 || e.getKeyCode() == 40){
                    actionGetRow();
                    setStateField();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAuthor();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearText();
            }
        });
    }

    private void initState () {
        authorController = new AuthorController();
        panelAuthor.setBorder(new EmptyBorder(10, 10, 10, 10));
        titleField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        idAuthor.setEditable(false);
        //Set date calendar
        Date maxDate = new Date(120, Calendar.DECEMBER,31);
        Date minDate = new Date(0, Calendar.DECEMBER,31);
        dateChooser = new JDateChooser();
        dateChooser.setLocale(new Locale("vi"));
        dateChooser.setDateFormatString(DateFormatConstant.dateVi);
        fieldCalendar.add(dateChooser);
        setTableAuthors();
    }

    private void addAuthor() {
        String name = nameField.getText();
        String title = titleField.getText();
        SimpleDateFormat dateDB = new SimpleDateFormat(DateFormatConstant.dateDB);
        String dob = dateDB.format(dateChooser.getDate());
        System.out.println(dob);
        AuthorModel authorModel = new AuthorModel(null,name,dob,title);
        if(idAuthor.getText().isEmpty()){
            authorController.isSuccessAdd(authorModel);
            setTableAuthors();
            clearText();
        }else {
            JOptionPane.showMessageDialog(panelAuthor, StringConstants.idAuthorAlive);
        }
    }

    private void setTableAuthors(){
        DefaultTableModel model = new DefaultTableModel() {
            final String[] headerAuthor = {"ID","Tên tác giả","Ngày sinh","Tiểu sử"};

            @Override
            public int getColumnCount() {
                return headerAuthor.length;
            }

            @Override
            public String getColumnName(int index) {
                return headerAuthor[index];
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // or a condition at your choice with row and column
            }
        };
        authors = authorController.getAuthors();
        for (final AuthorModel bookModel : authors) {
            model.addRow(new Object[]{
                    bookModel.getId(),
                    bookModel.getName(),
                    bookModel.getDob(),
                    bookModel.getTitle(),
            });
        }
        //controller.books = books;
        tableAuthors.setModel(model);
    }

    private void setStateField() {
        Date dateSelected;
        AuthorModel authorSelected = authors.get(indexSelected);
        idAuthor.setText(authorSelected.getId().toString());
        nameField.setText(authorSelected.getName());
            try {
                dateSelected = new SimpleDateFormat("dd/MM/yyyy").parse(authorSelected.getDob());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        dateChooser.setDate(dateSelected);
            titleField.setText(authorSelected.getTitle());
    }

    private void actionGetRow() {
        indexSelected = tableAuthors.getSelectedRow();
    }

    private void clearText() {
        idAuthor.setText("");
        nameField.setText("");
        titleField.setText("");
        dateChooser.setDate(null);
    }
}
