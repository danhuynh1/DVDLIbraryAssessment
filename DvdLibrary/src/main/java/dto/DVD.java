
package dto;

/**
 *
 * @author Daniel
 * DVD dto 
 */
public class DVD implements Comparable <DVD> {
    private String title;
    private String releaseDate;
    private String directorName;
    private String mpaaRating;
    private String studio;
    private String noteAdditional;
    private final String UNKNOWN = " ";

    public DVD(String title) {
        this.title = title;
        this.releaseDate=UNKNOWN;
        this.directorName=UNKNOWN;
        this.mpaaRating=UNKNOWN;
        this.studio=UNKNOWN;
        this.noteAdditional=UNKNOWN;
    }

    public DVD(String title, String releaseDate, String directorName, String mpaaRating, String studio, String noteAdditional){
        this.title = title;
        this.releaseDate=releaseDate;
        this.directorName=directorName;
        this.mpaaRating=mpaaRating;
        this.studio=studio;
        this.noteAdditional=noteAdditional;
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
