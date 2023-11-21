package org.example.presentations.BookScreen;

import org.example.common.constants.StringConstants;
import org.example.models.*;
import org.example.presentations.AuthorScreen.AuthorScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

public class BookFrame {
    private JButton removeButton;
    private JButton editButton;
    private JTextField nameField;
     private JTable tableBook;
    public JPanel bookPanel;
    private JScrollPane scrollBook;
    private JComboBox<String> cbGenre;
    private JButton button1;
    private JButton btnAuthor;
    private JTextArea jTextTitle;
    private JButton btnAdd;
    private JLabel yearPublishLabel;
    private JFormattedTextField priceField;
    private JSpinner spinnerYearPublisher;
    private JButton btnRefresh;
    private JButton btnDeleteAll;
    private JComboBox<String> cbAuthors;
    private JButton scanINSBButton;
    private JLabel insbCode;
    private JLabel idBook;
    private JTextField insbField;
    private JComboBox <String>cbPublisher;
    //TODO: Create State
    final private BookController controller;
    private List<DetailBookModel> books;
    private List<AuthorModel> authors;
    private List<PublisherModel> publishers;
    private PublisherModel publisherSelected = new PublisherModel(0,"");
    private GenreModel genreSelected = new GenreModel(0,"");
    private AuthorModel authorSelected = new AuthorModel(0,"","","");
    private Integer indexSelected;
    public BookFrame() {
        controller = new BookController();
        initState();
        btnDeleteAll.addActionListener(e -> removeAll());
        btnAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AuthorScreen().setVisible(true);
            }
        });
        scanINSBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void initState(){
        Calendar cal=Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        SpinnerModel modelSpinner =
                new SpinnerNumberModel(currentYear, //initial value
                        currentYear - 100,
                        currentYear + 100,
                        1);
        spinnerYearPublisher.setModel(modelSpinner);
        spinnerYearPublisher.setEditor(new JSpinner.NumberEditor(spinnerYearPublisher, "0000"));
        //TODO:set format money number
        priceField.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        jTextTitle.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jTextTitle.setLineWrap(true);
        bookPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setTableData();
        //TODO:SET COMBOBOX
        authors = controller.getAuthors();
        for (AuthorModel itemAuthor:authors) {
            cbAuthors.addItem(itemAuthor.getName());
        }
        cbAuthors.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                int indexAuthor = cbAuthors.getSelectedIndex();
               authorSelected = authors.get(indexAuthor);
            }
        }
        );
        publishers = controller.getPublishers();
        for (PublisherModel publisherModel:publishers) {
            cbPublisher.addItem(publisherModel.name);
        }
        cbPublisher.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                int indexPublisher = cbPublisher.getSelectedIndex();
                publisherSelected = publishers.get(indexPublisher);
            }
        }
        );

        for (GenreModel genre:controller.getGenres()) {
            cbGenre.addItem(genre.name);
        }
        cbGenre.addItemListener(event -> {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        int indexGenre = cbGenre.getSelectedIndex();
                        genreSelected = controller.getGenres().get(indexGenre);
                    }
                }
        );
        //TODO: SET table
        tableBook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionGetRow();
                setStateField();
                super.mouseClicked(e);
            }
        });
        tableBook.addKeyListener(new KeyListener() {
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
        btnAdd.addActionListener(e -> addBook());

        removeButton.addActionListener(e -> {
            if(idBook.getText().isEmpty()){
                JOptionPane.showMessageDialog(bookPanel, StringConstants.idEmpty);
            } else{
                removeBook();
            }
        });

        btnRefresh.addActionListener(e -> clearText());

        editButton.addActionListener(e -> editBook());
    }

    private void actionGetRow() {
        int index = tableBook.getSelectedRow();
        controller.getSelectedBook(index);
        indexSelected = index;
    }

    ///TODO: RESET DATA
    private void setTableData(){
        DefaultTableModel model = new DefaultTableModel() {
            final String[] headerBook = {"INSB Code","Book Name", "Author Name","Publisher","Title","Selling Price","Publisher Year"};

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
        books = controller.getBooks();
        for (final DetailBookModel detailBookModel : books) {
            model.addRow(new Object[]{
                    detailBookModel.getInsbCode(),
                    detailBookModel.getName(),
                    detailBookModel.getAuthorModel().getName(),
                    detailBookModel.getPublisher(),
                    detailBookModel.getBookTitle(),
                    detailBookModel.getSellPricing(),
                    detailBookModel.getYearPublish(),
            });
        }
        controller.books = books;
        tableBook.setModel(model);
    }

    private void setStateField (){
        DetailBookModel detailBookModel = controller.bookSelected;
        nameField.setText(detailBookModel.getName());
        idBook.setText(String.valueOf(detailBookModel.getIDBook()));
        jTextTitle.setText(detailBookModel.getBookTitle());
        priceField.setText(String.valueOf(detailBookModel.getSellPricing()));
        insbField.setText(detailBookModel.getInsbCode());
        spinnerYearPublisher.setValue(detailBookModel.getYearPublish());
    }

    ///TODO: CLEAR
    private void clearText(){
        nameField.setText(null);
        idBook.setText(null);
        cbAuthors.updateUI();
        cbAuthors.setSelectedIndex(0);
        cbGenre.updateUI();
        cbGenre.setSelectedIndex(0);
        cbPublisher.updateUI();
        cbPublisher.setSelectedIndex(0);
        jTextTitle.setText(null);
        priceField.setText(null);
//        publisherField.setText(null);
        spinnerYearPublisher.setValue(2023);
        insbField.setText(null);
    }

    ///TODO: REMOVE
    private void removeBook(){
        if(indexSelected == null){
            JOptionPane.showMessageDialog(bookPanel, StringConstants.idEmpty);
        }else{
            int ok = warningDialog(StringConstants.questionDelete);
            if(ok == 0){
                int id = books.get(indexSelected).getIDBook();
                boolean isSuccess = controller.removeBook(id);
                if(isSuccess){
                    clearText();
                    setTableData();
                }else{
                    JOptionPane.showMessageDialog(bookPanel, StringConstants.connectError);
                }
            }
        }
    }

    private int warningDialog(String message) {
        int confirm;
        Object[] options = { "Xác nhận", "Huỷ" };
        int answer = JOptionPane.showOptionDialog(null, message, "Cảnh báo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        System.out.println(answer);
        switch (answer) {
            case 0:
                confirm = 0;
                break;
            case 1:
            default:
                confirm = 1;
                break;
        }
        return confirm;
    }

    ///TODO: ADD
    private void addBook(){
        String insb = insbField.getText();
        String year = String.valueOf(spinnerYearPublisher.getValue());
        if(!idBook.getText().isEmpty()){
            JOptionPane.showMessageDialog(bookPanel, StringConstants.idAlive);
            return;
        }
        if (nameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(bookPanel, StringConstants.nameBookEmpty);
            return;
        }
        if (insb.length()!=13) {
            JOptionPane.showMessageDialog(bookPanel, StringConstants.insbEmpty);
            return;
        }
        if(controller.isINSBExist(insb)){
            JOptionPane.showMessageDialog(bookPanel, StringConstants.insbExist);
            return;
        }
            String title = jTextTitle.getText();
            String price = priceField.getText().isEmpty()? "0": priceField.getText().replace(",","");

            BookModel newBook = new BookModel(
                    nameField.getText(), insb,
                    title,
                    Integer.parseInt(year),
                    publisherSelected.id,
                    genreSelected.id,
                    authorSelected.getId(),null,
                    Integer.parseInt(price)
            );
            boolean isSuccess = controller.addBook(newBook);
          if(isSuccess){
              setTableData();
              clearText();
            }else{
              JOptionPane.showMessageDialog(bookPanel, StringConstants.connectError);
          }

    }
    ///TODO:EDIT
    private void editBook(){
//        if(indexSelected == null){
//            JOptionPane.showMessageDialog(bookPanel, StringConstants.idEmpty);
//        }else{
//            String title = jTextTitle.getText();
//            String price = priceField.getText().isEmpty()? "0": priceField.getText().replace(",","");
//            String publisher = publisherField.getText().replace(",","");
//            BookModel editBook = new BookModel(
//                    controller.bookSelected.getId(),nameField.getText(), title,null,publisher,
//                    Integer.parseInt(price),
//                    Integer.parseInt(spinnerYearPublisher.getValue().toString())
//            );
//            boolean isSuccess = controller.editBook(editBook);
//            if(isSuccess){
//                setTableData();
//                clearText();
//            }
//        }
    }

    ///TODO:REMOVE ALL

    private void removeAll(){
        warningDialog(StringConstants.questionAllDelete);
    }
}