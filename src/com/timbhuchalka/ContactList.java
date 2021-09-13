package com.timbhuchalka;

import java.util.ArrayList;
import java.util.Map;

/**
 To manage Multiple AddressBooks created a Contact list Class
 */
public class ContactList{
    ArrayList<Contact> aList;

    public ContactList(ArrayList<Contact> aList) {
        this.aList = aList;
    }

    public static Map<String,ArrayList<Contact>> add(String addressBookName, Map<String,ArrayList<Contact>> drive)
    {
        ArrayList<Contact> contactList = new ArrayList<>();
        drive.put(addressBookName,contactList);
        return drive;
    }

}


