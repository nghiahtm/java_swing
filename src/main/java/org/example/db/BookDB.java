package org.example.db;
import org.example.common.constants.ResultDataCommon;
import org.example.models.BookModel;
import org.example.models.DetailBookModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDB {
    private static BookDB instance;
    public static BookDB getInstance() {
        if (instance == null) {
            instance = new BookDB();
        }
        return instance;
    }

    public List<DetailBookModel> getBook() {
        List<DetailBookModel> books = new ArrayList<>();
        String sqlUser = "SELECT * from detail_books";
       try {
           ResultSet rs = ResultDataCommon.getResult(sqlUser);
           while (rs.next()){
               DetailBookModel bookData = DetailBookModel.parseBookData(rs);
               books.add(bookData);
           }
           return  books;
       }catch (SQLException exp){
           System.out.println("Error "+exp);
       }
       return null;
    }

    public boolean isAddSuccessBook(BookModel book) {
        String sqlUser =
                "Insert Into books " +
                        "(title,name,selling_price,publish_year,id_author,id_genre,id_publisher,insb_code) values ('"
                        +book.title+"','"
                        +book.name+"','"
                        +book.sellingPrice+"','"
                        +book.publishYear+"','"
                        +book.idAuthor+"','"
                        +book.idGenre+"','"
                        +book.idPublisher+"','"
                        +book.isnb+
                        "')";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return  true;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return false;
    }
    public boolean isRemoveBook(int id) {
        String sqlUser =
                "DELETE FROM books WHERE id='"+id+"'";
        try {
            ResultDataCommon.executeUpdateData(sqlUser);
            return  true;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return false;
    }

    public boolean isEditSuccess(BookModel bookModel) {
        String sqlUser =
                "UPDATE books " +
                        "SET " +
                        "title='"+ bookModel.title+"',"+
                        "name='"+ bookModel.name+"',"+
                        "id_publisher='"+ bookModel.idPublisher+"',"+
                        "selling_price='"+ bookModel.sellingPrice+"',"+
                        "publish_year='"+ bookModel.publishYear+"'"+
                        "id_author='"+ bookModel.idAuthor+"'"+
                        "id_genre='"+ bookModel.idGenre+"'"+
                        "WHERE id='"+ bookModel.idBook+"'";
        try {
            System.out.println("success");
            ResultDataCommon.executeUpdateData(sqlUser);
            return true;
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return false;
    }

    public boolean isINSBExistInDb(String isnb) {
        boolean isExist = false;
        String sqlUser =
                "Select name from books where insb_code='"+isnb+"'";
        try {
            ResultSet rs = ResultDataCommon.getResult(sqlUser);
            while (rs.next()){
                isExist = true;
                break;
            }
        }catch (SQLException exp){
            System.out.println(exp);
        }
        return isExist;
    }
}
