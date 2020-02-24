public class Album {
    private String title;
    private String artist;
    private int songNum;
    private double duration;
    public Album(String title, String artist, int songNum, double duration){
        this.title = title;
        this.artist = artist;
        this.songNum = songNum;
        this.duration = duration;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public int getSongNum(){
        return songNum;
    }
    public double getDuration(){
        return duration;
    }
    public String toString(){
        String str = "";
        str += "\""+title+"\" by "+artist;
        return str;
    }
}
