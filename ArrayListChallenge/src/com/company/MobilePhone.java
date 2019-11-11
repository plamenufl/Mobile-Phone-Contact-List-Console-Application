package com.company;


import java.util.ArrayList;


public class MobilePhone {
    private ArrayList<Contact> arrayList= new ArrayList<>();

//    public MobilePhone() {
//    }

    public void printArrayList(){
        if(arrayList.isEmpty()){
            System.out.println("There are no contacts to print in this list");
        }else{
            for(int i = 0; i < arrayList.size(); i++){
                System.out.println("Contact: " + arrayList.get(i).getName() + " " + arrayList.get(i).getPhoneNumber());
            }
        }

    }

    public void SearchContact(String name){
        //create object here
        Contact contact = new Contact(name);

         int index = findContact(contact);
        System.out.println(arrayList.get(index).getName() + " " + arrayList.get(index).getPhoneNumber()) ;
       // System.out.println(foundContact.getName() + " " + foundContact.getPhoneNumber());

    }

    public void addContact(String name, String phoneNumber){
        //create object here
        Contact contact = new Contact(name, phoneNumber);

        addContact(onFile(contact));

    }

    private void addContact(Contact contact){

        if(contact != null){
            arrayList.add(contact);
        }else{
            System.out.println("Contact is already stored.");
        }
    }

    public void modifyContact(String name, String phone){

        Contact contact = new Contact(name, phone);
        modifyContact(contact, findContact(contact));
    }


    private void modifyContact(Contact contact, int index){
        if(index >= 0){
       //   String name =  arrayList.get(index).getName();
       //    String phone = arrayList.get(index).getPhoneNumber();
           arrayList.set(index, contact);
        }else{
            System.out.println("Cannot modify contact because it doesn't exist in list");
        }

    }

    public void removeContact(String name, String phoneNumber) {
        //create object here
        Contact contact = new Contact(name, phoneNumber);

        removeContact(findContact(contact));

    }
   private void removeContact(int index){
        if(index >= 0){
            arrayList.remove(index);
        }else{
            System.out.println("Cannot remove contact because it doesn't exist in list");
        }
    }
    //tomorrow try to fix this by passing only the name maybe?

        private int findContact(Contact contact){

        int index = 0;
        if (arrayList.isEmpty()) {
           return -1;
        }else{
            for(int i = 0; i < arrayList.size(); i++){
                String name = arrayList.get(i).getName();
                if(name.equals(contact.getName())){
                    index = i;
                    break;
                }else{
                    index = -1;
                }
            }
            return index;
        }

    //return arrayList.indexOf(contact);
    }

    private Contact onFile(Contact contact){
        int index = findContact(contact);
        if(index >= 0){
            return null;
        }else{
            return contact;
        }
    }

}
