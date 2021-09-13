/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dto.DVD;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daniel
 * Methods to interact with DVD dto
 */
public class DVDLibraryView {
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    /**
     * Helper Method passed to controller to display main UI menu
     * @return menu selection
     */
    
    public int printMenuAndGetSelection(){
            io.print("Welcome to your DVD Collection");
            io.print("1. View all DVDs");
            io.print("2. View a DVD's info");
            io.print("3. Add a new DVD");
            io.print("4. Remove a DVD");
            io.print("5. Edit a DVD ");
            io.print("6. Search for a DVD");
            io.print("7. Exit");
            return(io.readInt("Please select from the above choices.", 1, 7));
    }
    
    /**
     * Helper Method passed to controller to create a new DVD dto object.
     * @return DVD dto object created from user inputs
     */
    
    public DVD getNewDVDInfo() {
        String DVDTitle = io.readString("Please enter the DVD title");
        String releaseDate = io.readString("Please enter when the DVD was released");
        String mpaaRating = io.readString("Please enter the MPAA rating");
        String directorName = io.readString("Please enter the Director's name");
        String studioName = io.readString("Please enter the studio's name");
        String noteAdditional = io.readString("Please enter any addition information on this DVD");
        
        DVD newDVD = new DVD(DVDTitle);
        newDVD.setReleaseDate(releaseDate);
        newDVD.setDirectorName(directorName);
        newDVD.setMpaaRating(mpaaRating);
        newDVD.setStudio(studioName);
        newDVD.setNoteAdditional(noteAdditional);
        return newDVD;
    }
    
    /** 
     * Overloaded Helper method that takes a previousDVD as a parameter, and prompts for changes in member variables
     * @return updated DVD object with desired changes
    */
    public DVD getNewDVDInfo(DVD previousDVD){
        DVD newDVD = previousDVD;
        if (previousDVD != null){
            if (io.readYesNo("Do you want to change the title?")){
                String newTitle = "";
                do{
                    newTitle = io.readString("Please enter the DVD title");
                }while (newTitle.trim().isEmpty());
                newDVD.setTitle(newTitle);
            }
            if (io.readYesNo("Do you want to change the release Date")){
                newDVD.setReleaseDate(io.readString("Please enter when the DVD was released"));
            }
            if (io.readYesNo("Do you want to change the MPAA rating")){
                newDVD.setMpaaRating(io.readString("Please enter the MPAA rating"));
            }
            if (io.readYesNo("Do you want to change the Director")){
                newDVD.setDirectorName(io.readString("Please enter the Director's name"));
            }
            if (io.readYesNo("Do you want to change the studio")){
                newDVD.setStudio(io.readString("Please enter the studio's name"));
            }
            if (io.readYesNo("Do you want to change additional notation")){
                newDVD.setNoteAdditional(io.readString("Please enter any addition information on this DVD"));
            }

            return newDVD;
        }
        else{
            return previousDVD;
        }
    }
    
    /**
     * Helper Method to Controller that sorted displays the list of current DVD library
     * @param DVDList
     */
    public void displayDVDLibrary(List<DVD> DVDList){  
        io.print("Viewing Library...");
        if (DVDList.size()>0){
            Collections.sort(DVDList);
            for (DVD currentDVD : DVDList) {
                String DVDInfoString = String.format("%s (%s), %s",
                      currentDVD.getTitle(),currentDVD.getReleaseDate(),currentDVD.getDirectorName());
                io.print(DVDInfoString);
            }
        }

        io.readString("Please hit enter to continue.");
    }
    

    /**
     * Displays DVD list with index 1-n, then prompts user to input 1-n to view additional information on DVD.
     * @param DVDList
     */
    public void displayDVDFromLibraryByChoice(List<DVD> DVDList){
        io.print("Viewing Library...");
        if(DVDList.size() > 0){
            int index = 1;
            for (DVD currentDVD : DVDList) {
                String DVDInfoString = String.format("%s. %s (%s) %s", index++,currentDVD.getTitle(),currentDVD.getReleaseDate(),currentDVD.getDirectorName());
                io.print(DVDInfoString);
            }
            int choice = io.readInt("Please select the DVD from the above choices.", 1, DVDList.size());
            DVD currentDVD = DVDList.get(choice-1);
            io.print(String.format("Title: %s\nRelease Date: (%s)\nDirector: %s\nMPAA Rating: %s\nStudio: %s\nAdditonal Notes: %s",
            currentDVD.getTitle(),currentDVD.getReleaseDate(),currentDVD.getDirectorName(),
            currentDVD.getMpaaRating(),currentDVD.getStudio(),currentDVD.getNoteAdditional()));
        }
        io.readString("Please hit enter to continue.");
    }

    /**
     * Helper method to ask user for desired DVD title for Key in use with DAO
     * @return
     */
    public String getDVDTitleByChoice() {
        return io.readString("Please enter the DVD's title.");
    }

    
    /**====================Helper Methods to print events to console====================*/
    /**
     * Helper method toString for a DVD object
     * @param currentDVD
     */
    public void displayDVDDetails(DVD currentDVD) {
        if (currentDVD != null) {
            io.print(String.format("Title: %s\nRelease Date: %s\nDirector: %s\nMPAA Rating: %s\nStudio: %s\nAdditonal Notes: %s",currentDVD.getTitle(),currentDVD.getReleaseDate(),currentDVD.getDirectorName(),currentDVD.getMpaaRating(),currentDVD.getStudio(),currentDVD.getNoteAdditional()));
        } else {
            io.print("Unable to find DVD in the library.");
        }
        io.readString("Please hit enter to continue.");
    }

    /**
     * Helper method to see if DAO inserted DVD object
     * @param currentDVD
     */

    public void displayInsertResult(DVD currentDVD){
        if (currentDVD == null){
            io.print("A DVD with this title already exists.");
        }else{
            io.print("Successfully added to the library.");
        }
        io.readString("Please hit enter to continue.");
    }

        /**
     * Helper method to see if DAO removed DVD object
     * @param currentDVD
     */
    public void displayRemoveResult(DVD removedDVD) {
        if(removedDVD != null){
          io.print("DVD successfully removed from library.");
        }else{
          io.print("Unable to find DVD in the library.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayEditResult(DVD removedDVD) {
        if(removedDVD != null){
          io.print("DVD successfully Edited.");
        }else{
          io.print("Unable to find DVD in the library.");
        }
        io.readString("Please hit enter to continue.");
    }


    public void displayCreateSuccessBanner() {
        io.print("DVD successfully inserted into library.");
        io.readString("Please hit enter to continue");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }


    public void displayViewAllBanner() {
        io.print("Selected:  View all DVDs");
    }

    public void displayViewDVDBanner() {
        io.print("Selected:  View a DVD's info");
    }
    public void displayAddBanner() {
        io.print("Selected:  Add a new DVD");
    }
    public void displayRemoveBanner() {
        io.print("Selected:  Remove a DVD");
    }
    public void displayEditBanner() {
        io.print("Selected:  Edit a DVD");
    }
    public void displaySearchBanner() {
        io.print("Selected:  Search for a DVD");
    }
    public void displayEmptyLibraryBanner() {
        io.readString("There is nothing in the library, Please hit enter to continue.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }


}
