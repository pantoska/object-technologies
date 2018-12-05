package com.studia.to.phone;

import com.studia.to.name.Name;
import com.studia.to.name.NameWrapper;

import java.util.*;

public class PhoneNumberRepository extends Name{
    private Map<NameWrapper,Set<PhoneNumber>> numbers = new HashMap<>();

    public void addNumber(String name, String surname, PhoneNumber number){
        addName(name);
        addName(surname);

        NameWrapper nameWrapper = new NameWrapper(findName(name),findName(surname));
        Set<PhoneNumber> phoneNumbers = numbers.get(nameWrapper);
        if(phoneNumbers == null) {
            phoneNumbers = new HashSet<>();
            numbers.put(nameWrapper, phoneNumbers);
        }
        phoneNumbers.add(number);

    }

    public Set<PhoneNumber> findPhoneNumbers(String name, String surname) {
        NameWrapper nameWrapper = new NameWrapper(findName(name), findName(surname));
        return numbers.get(nameWrapper);
    }

    public void showContent(){
        showRepository();
    }
}
