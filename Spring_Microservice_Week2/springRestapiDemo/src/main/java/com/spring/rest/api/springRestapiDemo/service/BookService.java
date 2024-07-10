package com.spring.rest.api.springRestapiDemo.service;

import com.spring.rest.api.springRestapiDemo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static ArrayList<Book> blist=new ArrayList<Book>();
    static
    {
        blist.add(new Book(23,"SpringBoot","Maya"));
        blist.add(new Book(13,"IKIGAI","abc"));
        blist.add(new Book(53,"DBMS","bipin desai"));
        blist.add(new Book(16,"Software Eng","abc"));
        blist.add(new Book(11,"Secret","Rhonda"));
    }

    public List<Book> getAll()
    {
        //  BookService. booklist();
        return blist;
    }


    public  Book getSingleById(int id)
    {
        Book b=null;
        try
        {
            b = blist.stream().filter(bk->bk.id==id).findFirst().get(); // stream in java8
            /*
             * Iterator lt=blist.iterator(); // return
             * blist.stream().filter(bb->bb.getId()==id).findFirst().get(); // return b;
             * while(lt.hasNext()) { b=(Book)lt.next(); if(b.getId()==id) {
             * System.out.println("name;"+b.getName()); break; }
             *
             * } System.out.println("Book :"+b);
             *
             * return b;
             */
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return b;
    }

}
