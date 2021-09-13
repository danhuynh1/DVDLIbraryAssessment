
package dao;

import dto.DVD;
import java.util.List;

/**
 * @author Daniel
 */
public interface DVDLibraryDao {
    /**
     * 
     * Adds DVD object associated with  DVD.title.toUpperCase() key to DVDLibraryStorage Hashmap
     * @param title: Title of DVD desired to get information
     * @return DVD object associated with title that was added or null if not added
     */
    DVD addDVD(String title, DVD newDVD) throws DVDLibraryDaoException;
    
    /**
     * Gets all DVD values from DVDLibraryStorage Hashmap
     * @return
     * @throws DVDLibraryDaoException
     */
    List<DVD> getAllDVDs() throws DVDLibraryDaoException;


    /**
     * Gets DVD object associated from title.toUpperCase() key from DVDLibraryStorage Hashmap
     * @param title: Title of DVD desired to get information
     * @return DVD object associated with title that was found or null if not added
     * @throws DVDLibraryDaoException
     */
    DVD getDVD(String title) throws DVDLibraryDaoException;

    /**
     * Removes DVD object mapped to key title.toUpperCase
     * @param title : Title of DVD to remove
     * @return DVD object associated with title that was removed or null if unable to remove
     * @throws DVDLibraryDaoException
     */
    DVD removeDVD(String title) throws DVDLibraryDaoException; 

}