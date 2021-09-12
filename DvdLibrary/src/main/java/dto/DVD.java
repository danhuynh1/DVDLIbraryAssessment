/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Daniel
 */
public class DVD implements Comparable <DVD> {
    private String title;
    private String releaseDate;
    private String directorName;
    private String mpaaRating;
    private String studio;
    private String noteAdditional;

    public DVD(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

        public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    
    
    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNoteAdditional() {
        return noteAdditional;
    }

    public void setNoteAdditional(String noteAdditional) {
        this.noteAdditional = noteAdditional;
    }

    @Override
    public int compareTo(DVD o) {
        return this.getTitle().compareTo(o.getTitle());
    }


}
