
package dao;

import dto.DVD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Daniel
 * Methods to load/save/write/remove to storage and memory of DVDLibrary
 * 
 */

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    public static final String LIBRARY_FILE = "DVD_LIBRARY.txt";
    public static final String DELIMITER = "::";
    private Map<String, DVD> DVDLibraryStorage = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD newDVD)  throws DVDLibraryDaoException {
        loadLibrary();
        DVD insertedDVD = null;
        if (DVDLibraryStorage.containsKey(title.toUpperCase()) == false){
            DVDLibraryStorage.put(title.toUpperCase(), newDVD);
            writeLibrary();
            return newDVD;
        }
        return insertedDVD;
    }
    
    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList<>(DVDLibraryStorage.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        return DVDLibraryStorage.get(title.toUpperCase());
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        loadLibrary();
        DVD removedDVD = DVDLibraryStorage.remove(title.toUpperCase());
        writeLibrary();
        return removedDVD;
    }    

    
    private DVD unmarshallDVD(String DVDAsText) {
        /*
        DVDAsText is expecting a line from file as
        DVDTITLE::RELEASEDATE::DIRECTORSNAME::MPAARATING::STUDIONAME::ADDITIONALINFORMATION
        Such as
        Iron Man::2008::Jon Favreau::PG-13::Marvel Studios::I like this movie
        and creates object from the line tokens.
        */
        String[] DVDTokens = DVDAsText.split(DELIMITER);
        DVD DVDFromFile = new DVD(DVDTokens[0],DVDTokens[1],DVDTokens[2],DVDTokens[3],DVDTokens[4],DVDTokens[5]);
        return DVDFromFile;
    }


    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        DVD currentDVD;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentDVD = unmarshallDVD(currentLine);
    

            DVDLibraryStorage.put(currentDVD.getTitle().toUpperCase(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD myDvd){
        String DVDAsText = myDvd.getTitle() + DELIMITER;
        DVDAsText+= myDvd.getReleaseDate() + DELIMITER;
        DVDAsText+= myDvd.getDirectorName() + DELIMITER;
        DVDAsText+= myDvd.getMpaaRating()+ DELIMITER;
        DVDAsText+= myDvd.getStudio()+ DELIMITER;
        DVDAsText+= myDvd.getNoteAdditional();

        return DVDAsText;
    }
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD Library data.", e);
        }

        String DVDAsText;
        List<DVD> DVDList = getAllDVDs();
        for (DVD currentDVD : DVDList) {

            DVDAsText = marshallDVD(currentDVD);

            out.println(DVDAsText);

            out.flush();
        }

        out.close();
    }
}
