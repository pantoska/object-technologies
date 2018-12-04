package com.studia.to.name;

import com.studia.to.name.Name;

import java.util.HashSet;
import java.util.Set;

public class NameRepository {
    protected Set<Name> names = new HashSet<>();

    protected void addName(String name) {
        names.add(new Name(name));
    }


    public Name findName(String name){
        for(Name n: names)
            if(name.equals(n.getName())) {
                return n;
            }
        Name nameObj = new Name(name);
        names.add(nameObj);
        return nameObj;
    }

    public void showRepository(){
        for(Name name:names){
            System.out.print(name + " ");
        }
    }
}
