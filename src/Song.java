

public class Song {
    private final int year;
    private final int ID;
    private final String title;
    private final String artist;
    private final String genre;
    public Song(String t,String a,int id,String g, int y) {

        title = t;
        artist = a;
        ID = id;
        genre = g;
        year = y;
    }
    public String getTitle()
    {
        return title;
    }
    public String getGenre()
    {
        return genre;
    }
    public String getArtist()
    {
        return artist;
    }
    public int getID()
    {
        return ID;
    }
    public String toString() {
        String str = String.format(title+","+artist+","+ID+","+genre+","+year);
        return str;
    }
}
