package com.timbhuchalka;

import java.util.ArrayList;
import java.util.Scanner;

class Contact
{
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String pNum;
    private String email;


    public Contact(){
    }

    public Contact(String firstName, String lastName, String city, String state, String pNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.pNum = pNum;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public ArrayList<Contact> addAPersonInList(ArrayList<Contact> contacts, int i)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter firstname, lastname,  city, state, phone number, emailID");
        firstName = sc.nextLine();
        lastName = sc.nextLine();
        city = sc.nextLine();
        state = sc.nextLine();
        pNum = sc.nextLine();
        email = sc.nextLine();
        contacts.add(i,new Contact(firstName, lastName, city, state, pNum, email));
        return contacts;
    }

    public void showPeopleList(ArrayList<Contact> contacts)
    {
        for (Contact contact : contacts) {
            String s = " " + contact.toString();
            System.out.println(s);
        }
    }

    public ArrayList<Contact> editContactList(ArrayList<Contact> contacts, String fname)
    {
        int m = 0;
        for (Contact contact : contacts) {
            int i = contacts.indexOf(contact);
            if(contacts.get(i).getFirstName().equals(fname)){
                contacts=contacts.get(i).addAPersonInList(contacts,i);
                contacts.remove(contact);
                System.out.println("check");
                m = 1;
                break;
            }
        }
        if(m == 0){
            System.out.println("Contact not found with this name");
        }
        return contacts;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pNum='" + pNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class AdressB {
    public static void main(String[] args) {
        System.out.println("Welcome");
        Scanner sc =new Scanner(System.in);
        Contact contacts = new Contact();
        ArrayList<Contact> contactList = new ArrayList<>();

        System.out.println("enter number of people you want to add");
        int numOfPerson = sc.nextInt();
        for(int i= 0;i<numOfPerson;i++){
            contactList = contacts.addAPersonInList(contactList,i);
        }

        contacts.showPeopleList(contactList);

        System.out.println("Enter first name of Contact which you want to edit");
        Scanner sname =new Scanner(System.in);
        String pname = sname.nextLine();
        contactList = contacts.editContactList(contactList,pname);
        System.out.println("this is edited list");
        contacts.showPeopleList(contactList);
    }
}