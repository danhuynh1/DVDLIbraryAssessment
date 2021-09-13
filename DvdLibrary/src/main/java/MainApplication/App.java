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

  *Comments:
  As I did this on my own, each function I regression tested with the rest of the program for each function, agile-like. 
  I did all my handling with the Hashmap in the Model, any commands with Cntroller, and had UI functions in the View. 

  Following the class code-along example, I interconnected each component so that limited imports were necessary, to result in loose-coupling.
  Otherwise, java libraries were dependent injections, where initialization of instances are done in the App java class.

  Encapsulation & Abstraction is used in private fields, using appropriate getter setters, and private methods for classes like the fileIO and marshalling
  Using Interfaces for classes like contracts to make sure it is known how the class should function.
  We use the External given UserIO class to easily reuse code.


  The DVD Library hashmap is 'composed' of DVDs, which have members or attributes of the desired information

  Data Marshalling is used to save the file in a way that can be reread in the future, in this case, members of a DVD object are seperated with the Delimiter :: and combined for storage in a txt file, then 
  upon requiring the library again, the txt file is read, each line is unmarshalled  to a DVD Object for the DVDLibrary usage
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
