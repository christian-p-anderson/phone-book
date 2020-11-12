package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    // do constructors with a linked HashMap

    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }


    public PhoneBook() {
        this.phonebook = new LinkedHashMap<String, List<String>>();
    }


    public void add(String name, String phoneNumber) {
        // check to see f the key already exists before adding new name (key) and phone number

        if(this.phonebook.containsKey(name)) {
            List<String> updatedNums = this.phonebook.get(name);
            updatedNums.add(phoneNumber);
            this.phonebook.replace(name, updatedNums);
        } else {
            this.phonebook.put(name, Collections.singletonList(phoneNumber));
        }

        // Collections.singletonList() is used to return an immutable list containing only the specified object
    }


    public void addAll(String name, String... phoneNumbers) {

        if(phonebook.containsKey(name)) {
            List<String> updatedNumbers = this.phonebook.get(name);
            updatedNumbers.addAll(Arrays.asList(phoneNumbers));
            this.phonebook.replace(name, updatedNumbers);
        } else {
            this.phonebook.put(name, Arrays.asList(phoneNumbers));
        }

        // Arrays.asList() is used to return a fixed-size list backed by the specified array. the returned list is
        // serializable and implements RandomAccess
    }


    public void remove(String name) {
        this.phonebook.remove(name);

        // the argument you pass in remove() is the key of the key : value pair you want to remove
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        // verify name exists in keys
        // return the value of the key, value pair

         boolean entryInPhonebook = hasEntry(name);

         if (entryInPhonebook) {
             return this.phonebook.get(name);
         } else {
             return null;
         }

    }

    public String reverseLookup(String phoneNumber)  {

        String nameAssocWithPhoneNo = "";
        Set<String> allKeys = this.phonebook.keySet();

        for ( String key : allKeys) {
            List<String> values = this.phonebook.get(key);
            if (values.contains(phoneNumber)) {
                nameAssocWithPhoneNo = key;
            } else {
                return "";
            }
        }

        return nameAssocWithPhoneNo;

    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();

        for (String key : this.phonebook.keySet()) {
            contactNames.add(key);
        }

        return contactNames;


    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
