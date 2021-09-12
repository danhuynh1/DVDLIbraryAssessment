/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import dto.DVD;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/**
 *
 * @author Daniel
 */
public class DVDLibraryController {
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryView view = new DVDLibraryView(io); 
    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {  
            menuSelection = view.printMenuAndGetSelection();
            switch (menuSelection) {
                case 1:
                    viewDVDLibrary();
                    break;
                case 2:
                    viewDVDInfo();
                    break;
                case 3:
                    makeNewDVD();
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                    editDVD();
                    break;
                case 6:
                    searchDVDInfo();
                    break;             
                case 7:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
    
    private void makeNewDVD(){
        DVD newDVD = view.getNewDVDInfo();
        view.wasDVDInserted(dao.addDVD(newDVD.getTitle(), newDVD));
    }
    private void viewDVDLibrary(){
       view.displayDVDLibrary(dao.getAllDVDs());
    }
    private void viewDVDInfo(){
        //TODO: op
        if (dao.getAllDVDs().size() > 0)
            view.displayDVDFromLibraryByChoice(dao.getAllDVDs());
        else{
            System.out.println("nothing");
        }
        //view.displayStudent(dao.getDVD(view.getDVDTitleByChoice()));
    }
    private void searchDVDInfo(){
        view.displayStudent(dao.getDVD(view.getDVDTitleByChoice()));
    }
    private void removeDVD() {
        String toBeRemovedDVD = view.getDVDTitleByChoice();
        DVD removedDVD = dao.removeDVD(toBeRemovedDVD);
        view.displayRemoveResult(removedDVD);
    }
    private void editDVD(){
        String toBeRemovedDVD = view.getDVDTitleByChoice();
        DVD removedDVD = dao.removeDVD(toBeRemovedDVD);
        DVD newDVD = view.getEditedDVDInfo(removedDVD);
        view.wasDVDInserted(dao.addDVD(newDVD.getTitle(), newDVD));
    }
}

