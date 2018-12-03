package com.studia.to.phone;

import com.studia.to.name.Name;
import com.studia.to.name.NameWrapper;

import java.util.*;

public class PhoneNumberRepository extends Name{
    private Map<NameWrapper,PhoneNumber> numbers = new HashMap<>();
    private Set<NameWrapper> nameWrappersList = new HashSet<>();

    public void addNumber(String name, String surname, PhoneNumber number){
        addName(name);
        addName(surname);

        NameWrapper nameWrapper = getName(name,surname);
        if(nameWrapper == null) {
            nameWrapper = new NameWrapper(name, surname);
            nameWrappersList.add(nameWrapper);
        }

        numbers.put(nameWrapper,number);
    }

    public Set<PhoneNumber> findPhoneNumbers(String name, String surname){
        Set<PhoneNumber> phoneNumbers = new HashSet<>();
        for (Map.Entry<NameWrapper, PhoneNumber> entry : numbers.entrySet()){
            if(name.equals("null") || surname.equals("null")) {
                if (entry.getKey().getName().equals(name) || entry.getKey().getSurname().equals(surname)) {
                    phoneNumbers.add(entry.getValue());
                }
            }
            else{
                if(entry.getKey().getName().equals(name) && entry.getKey().getSurname().equals(surname)) {
                    phoneNumbers.add(entry.getValue());
                }
            }
        }
        return phoneNumbers;
    }

    private NameWrapper getName(String name,String surname){
        for(NameWrapper nw: nameWrappersList)
            if (nw.getSurname().equals(surname)) {
                if (nw.getName().equals(name))
                    return null;
                else return new NameWrapper(name, nw.getSurname());
            } else {
                for (NameWrapper nw1: nameWrappersList)
                    if (nw1.getName().equals(name))
                        return new NameWrapper(nw1.getName(),surname);
            }
        return null;
    }

    public void showContent(){
        showRepository();
    }
}
