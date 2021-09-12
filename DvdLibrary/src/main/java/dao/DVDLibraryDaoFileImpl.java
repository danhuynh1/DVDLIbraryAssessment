/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Daniel
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    
    private Map<String, DVD> DVDLibraryStorage = new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD newDVD) {
        DVD insertedDVD = null;
        if (DVDLibraryStorage.containsKey(title.toUpperCase()) == false){
            DVDLibraryStorage.put(title.toUpperCase(), newDVD);
            return newDVD;
        }
        return insertedDVD;
    }
    
    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(DVDLibraryStorage.values());
    }

    @Override
    public DVD getDVD(String title) {
        return DVDLibraryStorage.get(title.toUpperCase());
    }

    @Override
    public DVD removeDVD(String title) {
        DVD removedDVD = DVDLibraryStorage.remove(title.toUpperCase());
        return removedDVD;
    }    




}
