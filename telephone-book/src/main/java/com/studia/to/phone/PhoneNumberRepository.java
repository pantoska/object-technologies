package com.studia.to.phone;

import com.studia.to.name.Name;
import com.studia.to.name.NameWrapper;

import java.util.*;

public class PhoneNumberRepository extends Name{
    private Map<NameWrapper,Set<PhoneNumber>> numbers = new HashMap<>();
//    private Set<NameWrapper> nameWrappersList = new HashSet<>();
//    private Set<PhoneNumber> phoneNumberList = new HashSet<>();


    public void addNumber(String name, String surname, PhoneNumber number){
        addName(name);
        addName(surname);

        NameWrapper nameWrapper = new NameWrapper(findName(name),findName(surname));
        Set<PhoneNumber> phoneNumbers = numbers.get(nameWrapper);
        if(phoneNumbers == null) {
            phoneNumbers = new HashSet<>();//285d
            numbers.put(nameWrapper, phoneNumbers);//285d
        }
        phoneNumbers.add(number);

    }

    public Set<PhoneNumber> findPhoneNumbers(String name, String surname)
        Set<PhoneNumber> phoneNumbers = numbers.get(new NameWrapper(name, surname));
        return phoneNumbers;
    }



    public void showContent(){
        showRepository();
    }
}
