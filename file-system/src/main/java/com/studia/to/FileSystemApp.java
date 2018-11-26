package com.studia.to;

import com.studia.to.controller.FileSystemController;
import com.studia.to.model.File;
import com.studia.to.model.Folder;
import com.studia.to.model.Node;

import java.util.Scanner;

public class FileSystemApp {

    public static void main(String [ ] args) {
        FileSystemController fileSystemController = new FileSystemController();
        Folder root = new Folder();
        Folder folder = new Folder();
        File file = new File();
        Scanner sc = new Scanner(System.in);
        String input;

       root.setName("root");
       root.setParent(null);

       fileSystemController.addNode("folder1", root, folder);
       fileSystemController.addNode("folder2", root, folder);
       fileSystemController.addNode("folder3", root, folder);
       //fileSystemController.addNode("plik0.0", root, file);

       fileSystemController.addNode("folder1.1", fileSystemController.getNode("folder1"), folder);
       fileSystemController.addNode("folder2.1", fileSystemController.getNode("folder2"), folder);
       fileSystemController.addNode("folder3.1", fileSystemController.getNode("folder3"), folder);

       fileSystemController.addNode("plik1", fileSystemController.getNode("folder1"), file);
       fileSystemController.addNode("plik2", fileSystemController.getNode("folder2"), file);
       fileSystemController.addNode("plik3", fileSystemController.getNode("folder3"), file);


        //fileSystemController.addNode("plik1.2", fileSystemController.getNode("folder2"), file);





//       for(int i =0;i<3;i++){
//           System.out.println("Podaj nazwę folderu " + i);
//           fileSystemController.addNode(sc.nextLine(), root, new Folder());
//       }
//
//        for(int i=0;i<3;i++) {
//            System.out.println("Podaj nazwę kolejnego folderu i gdzie chcesz go stworzyć(rodzic)");
//            input = sc.nextLine();
//            String parent = sc.nextLine();
//            fileSystemController.addNode(input, fileSystemController.getNode(parent), new Folder());
//        }
//
//        for(int i=0;i<3;i++){
//            System.out.println("Podaj nazwę pliku i gdzie chcesz go stworzyć(rodzic)");
//            input = sc.nextLine();
//            String parent = sc.nextLine();
//            fileSystemController.addNode(input, fileSystemController.getNode(parent), new File());
//
//        }

        fileSystemController.printAllContent();

        System.out.println("Napisz nazwę katalogu, którego zawartość chcesz wyświetlić");
        fileSystemController.printFolderContent(sc.nextLine());

    }
}
