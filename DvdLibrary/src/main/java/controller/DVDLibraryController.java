
package controller;

import dao.DVDLibraryDao;
import dao.DVDLibraryDaoException;
import dto.DVD;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.DVDLibraryView;

/**
 *
 * @author Daniel
 * Controller layer for DVDLibrary
 */
public class DVDLibraryController {
    private DVDLibraryView view; 
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.view = view;
        this.dao=dao;
    }

    public void run(){
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {
    
                menuSelection = getMenuSelection();
    
                switch (menuSelection) {
                    case 1:
                        viewAllBanner();
                        viewDVDLibrary();
                        break;
                    case 2:
                        viewDVDBanner();
                        viewDVDInfo();
                        break;
                    case 3:
                        viewAddBanner();
                        makeNewDVD();
                        break;
                    case 4:
                        viewRemoveBanner();
                        removeDVD();
                        break;
                    case 5:
                        viewEditBanner();
                        editDVD();
                        break;
                    case 6:
                        viewSearchBanner();
                        searchDVDInfo();
                        break;             
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
    
            }

        }
        exitMessage();
    }catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void makeNewDVD() throws DVDLibraryDaoException{
        DVD newDVD = view.getNewDVDInfo() ;
        view.displayInsertResult(dao.addDVD(newDVD.getTitle(), newDVD));

    }
    private void viewDVDLibrary() throws DVDLibraryDaoException{
       view.displayDVDLibrary(dao.getAllDVDs());
    }
    private void viewDVDInfo() throws DVDLibraryDaoException{
        view.displayDVDFromLibraryByChoice(dao.getAllDVDs());
    }
    private void searchDVDInfo() throws DVDLibraryDaoException{
        view.displayDVDDetails(dao.getDVD(view.getDVDTitleByChoice()));
    }
    private void removeDVD() throws DVDLibraryDaoException {
        String toBeRemovedDVD = view.getDVDTitleByChoice();
        DVD removedDVD = dao.removeDVD(toBeRemovedDVD);
        view.displayRemoveResult(removedDVD);
    }

    //not sure if this is legal.. but can reorganize upon request
    private void editDVD() throws DVDLibraryDaoException{
        if (dao.getAllDVDs().size() > 0){
            String toBeRemovedDVD = view.getDVDTitleByChoice();
            DVD removedDVD = dao.removeDVD(toBeRemovedDVD);
            DVD newDVD = view.getNewDVDInfo(removedDVD);
            view.displayRemoveResult(dao.addDVD(newDVD.getTitle(), newDVD));
        }else{
            view.displayEmptyLibraryBanner();
        }

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }

    private void viewAllBanner(){
        view.displayViewAllBanner();
    }
    private void viewDVDBanner(){
        view.displayViewDVDBanner();
    }
    private void viewAddBanner(){
        view.displayAddBanner();
    }
    private void viewRemoveBanner(){
        view.displayRemoveBanner();
    }
    private void viewEditBanner(){
        view.displayEditBanner();
    }
    private void viewSearchBanner(){
        view.displaySearchBanner();
    }

}

