package com.studia.to;

import com.studia.to.controller.Controller;
import com.studia.to.service.Service;
import com.studia.to.view.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        View view = new View();
        Service service = new Service();
        view.getInput();
        service.getList();

    }
}
