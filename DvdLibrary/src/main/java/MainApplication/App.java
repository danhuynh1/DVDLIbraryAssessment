package MainApplication;

import controller.DVDLibraryController;
import dao.DVDLibraryDao;
import dao.DVDLibraryDaoFileImpl;
import ui.DVDLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/**
 *
 * @author Daniel
 */

 /**Main to DvdLibrary, an application that allows users to input from console DVDs into a library, with details, ability to add/remove/edit/search/view
  * Assumes DVD titles are "unique" in purpose of a key to search, uses DVD_TITLE.toUpperCase() as a key in hashmap storage
  *TODO: Change key to an index to allow multiple DVDs of the same title but different DVD
  *TODO: Catch user input error bugs
  *TODO: Create new LIBRARY_FILE.txt if not found
  *TODO: Limit MPAARatings, Standardize Release Date Format, stop user from inputting null on appropriate members
  *KNOWN BUGS: having member fields empty from creation/edit messes with saving, need to throw exceptions on null input from console
  */

public class App {
    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao,myView);
        controller.run();
    }   
}
