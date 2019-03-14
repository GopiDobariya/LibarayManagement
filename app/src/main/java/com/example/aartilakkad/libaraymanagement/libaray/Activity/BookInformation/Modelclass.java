package com.example.aartilakkad.libaraymanagement.libaray.Activity.BookInformation;

public class Modelclass {
    String bookname;
    String sourceid;
    String authorname;

    public Modelclass(String bookname, String sourceid, String authorname) {
        this.bookname = bookname;
        this.sourceid = sourceid;
        this.authorname = authorname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
}
