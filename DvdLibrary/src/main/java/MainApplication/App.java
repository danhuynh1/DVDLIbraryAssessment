/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainApplication;

import controller.DVDLibraryController;

/**
 *
 * @author Daniel
 */


public class App {
    public static void main(String[] args) {
        System.out.println("hi");
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();
    }   
}
