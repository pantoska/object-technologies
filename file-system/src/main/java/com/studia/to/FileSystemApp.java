package com.studia.to;

import com.studia.to.decorator.FolderDecoratory;
import com.studia.to.model.File;
import com.studia.to.model.Folder;

import java.util.Scanner;

public class FileSystemApp {

    public static void main(String [ ] args) {
        FolderDecoratory folderDecoratory = new FolderDecoratory();
        Folder root = new Folder();
        Folder folder = new Folder();
        File file = new File();
        Scanner sc = new Scanner(System.in);
        String input;

       root.setName("root");
       root.setParent(null);

       folderDecoratory.addNode("folder1", root, folder);
       folderDecoratory.addNode("folder2", root, folder);
       folderDecoratory.addNode("folder3", root, folder);

       folderDecoratory.addNode("folder1.1", folderDecoratory.getNode("folder1"), folder);
       folderDecoratory.addNode("folder2.1", folderDecoratory.getNode("folder2"), folder);
       folderDecoratory.addNode("folder3.1", folderDecoratory.getNode("folder3"), folder);

       folderDecoratory.addNode("plik1", folderDecoratory.getNode("folder1"), file);
       folderDecoratory.addNode("plik2", folderDecoratory.getNode("folder2"), file);
       folderDecoratory.addNode("plik3", folderDecoratory.getNode("folder3"), file);

//       for(int i =0;i<3;i++){
//           System.out.println("Podaj nazwę folderu " + i);
//           folderDecoratory.addNode(sc.nextLine(), root, new Folder());
//       }
//
//        for(int i=0;i<3;i++) {
//            System.out.println("Podaj nazwę kolejnego folderu i gdzie chcesz go stworzyć(rodzic)");
//            input = sc.nextLine();
//            String parent = sc.nextLine();
//            folderDecoratory.addNode(input, folderDecoratory.getNode(parent), new Folder());
//        }
//
//        for(int i=0;i<3;i++){
//            System.out.println("Podaj nazwę pliku i gdzie chcesz go stworzyć(rodzic)");
//            input = sc.nextLine();
//            String parent = sc.nextLine();
//            folderDecoratory.addNode(input, folderDecoratory.getNode(parent), new File());
//
//        }
        folderDecoratory.printAllContent();

        System.out.println("Napisz nazwę katalogu, którego zawartość chcesz wyświetlić");
        folderDecoratory.printFolderContent(sc.nextLine(),0);

    }
}
