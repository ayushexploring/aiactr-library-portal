package com.example.ayush.dbms;

public class Products {

    private String _roll ;
    private String _name ;
    private String _book ;
    private String _bookID ;
    private String _DOI ;

    public String get_roll() {
        return _roll;
    }

    public String get_name() {
        return _name;
    }

    public String get_book() {
        return _book;
    }

    public String get_bookID() {
        return _bookID;
    }

    public String get_DOI() {
        return _DOI;
    }

    public Products(String roll, String name, String book, String bookID, String DOI) {
        this._roll = roll;
        this._name = name;
        this._book = book;
        this._bookID = bookID;
        this._DOI = DOI;
    }
}
