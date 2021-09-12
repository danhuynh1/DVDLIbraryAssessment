
package dao;

import dto.DVD;
import java.util.List;

/**
 * @author Daniel
 */
public interface DVDLibraryDao {
    DVD addDVD(String title, DVD newDVD);
    List<DVD> getAllDVDs();
    DVD getDVD(String title);
    DVD removeDVD(String title); 
}
