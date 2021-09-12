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
 */
public class DVDLibraryView {
    private UserIO io;
    
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
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
    
    public DVD getEditedDVDInfo(DVD previousDVD){
        DVD newDVD = previousDVD;

        if (previousDVD != null){
            if (io.readYesNo("Do you want to change the title?")){
                newDVD.setTitle(io.readString("Please enter the DVD title"));
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
    
    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully inserted into library.  Please hit enter to continue");
    }

    public void displayDVDLibrary(List<DVD> DVDList){  
        Collections.sort(DVDList);
        for (DVD currentDVD : DVDList) {
            String DVDInfoString = String.format("#%s : %s %s",
                  currentDVD.getTitle(),currentDVD.getReleaseDate(),currentDVD.getDirectorName());
            io.print(DVDInfoString);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDVDFromLibraryByChoice(List<DVD> DVDList){
        int index = 1;
        for (DVD currentDVD : DVDList) {
            String DVDInfoString = String.format("%s. %s : %s %s", index++,currentDVD.getTitle(),currentDVD.getReleaseDate(),currentDVD.getDirectorName());
            io.print(DVDInfoString);
        }
        DVD currentDVD = DVDList.get(io.readInt("Which Movie do you want to see", 0, DVDList.size()-1));
        String DVDInfoString = String.format("Title: %s ((%s))",currentDVD.getTitle(),currentDVD.getReleaseDate());
        io.print(DVDInfoString);
        
        io.readString("Please hit enter to continue.");

    }
    
    
    public String getDVDTitleByChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(DVD currentDVD) {
        if (currentDVD != null) {
            String DVDInfoString = String.format("Title: %s ((%s))",currentDVD.getTitle(),currentDVD.getReleaseDate());
            io.print(DVDInfoString);
        } else {
            io.print("Cannot find this in the library.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void wasDVDInserted(DVD currentDVD){
        System.out.println(currentDVD);
        if (currentDVD == null){
            io.print("A DVD with this title already exists.");
        }else{
            io.print("Successfully added to the library.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayRemoveResult(DVD removedDVD) {
        if(removedDVD != null){
          io.print("Student successfully removed.");
        }else{
          io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

}
