package com.timbhuchalka;

import java.util.Scanner;

class Contact{

      private String firstname;
      private String lastname;
      private String adress;
      private String city;
      private String state;
      private String zip;
      private String ponenumber;
      private String email;

    public Contact(String firstname, String lastname, String adress, String city, String state, String zip, String ponenumber, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ponenumber = ponenumber;
        this.email = email;
    }
}



        public class AdressB {


        public static void main(String[] args) {
            System.out.println("welcome to addressbook ");
            Scanner sc=new Scanner(System.in);
                String firstname;
                String lastname;
                String adress;
                String city;
                String state;
                String zip;
                String ponen;
                String email;
            System.out.println("Enter firstname,lastname,adress,city,state,zip,phonen,email");
            Contact Person1= new Contact(firstname= sc.nextLine(),lastname= sc.nextLine(), adress= sc.nextLine(),city= sc.nextLine(),state=sc.nextLine(),zip=sc.nextLine(), ponen= sc.nextLine(),email= sc.nextLine());
            System.out.println(Person1.toString());
        }
    }
