public class MusicLibrary {
    private Album[] albums = new Album[0];
    private int songNum;
    private double duration;
    private String name;
    public MusicLibrary(){
        songNum = 0;
        duration = 0;
    }
    public MusicLibrary(String name){
        this.name = name;
        songNum = 0;
        duration = 0;
    }
    public void add(Album album){
        increaseSize();
        albums[albums.length-1] = album;
        songNum += album.getSongNum();
        duration += album.getDuration();
    }
    public void increaseSize(){
        Album[] temp = new Album[albums.length+1];
        for (int i = 0; i < albums.length; i++){
            temp[i] = albums[i];
        }
        albums = temp;
    }
    public void remove(int index){
        songNum -= albums[index].getSongNum();
        duration -= albums[index].getDuration();
        Album[] temp = new Album[albums.length-1];
        for (int i = 0; i < index; i++){
            temp[i] = albums[i];
        }
        for (int i = index; i < temp.length; i++){
            temp[i] = albums[i+1];
        }
        albums = temp;
    }
    public void doubleSize(){}

    public Album getAlbum(int index){
        if (-1 < index && index < albums.length){
            return albums[index];
        } else {
            System.out.println("Index out of bounds");
            return null;
        }
    }
    public int titleSearchLinear(String target){
        for (int i = 0; i < albums.length; i++){
            if (albums[i] != null && albums[i].getTitle().toLowerCase().contains(target.toLowerCase())){
                return i;
            }
        }
        return -1;
    }
    public int artistSearchLinear(String target){
        for (int i = 0; i < albums.length; i++){
            if (albums[i] != null && albums[i].getArtist().toLowerCase().contains(target.toLowerCase())){
                return i;
            }
        }
        return -1;
    }
    public int titleSearchBinary(String target){
        int low = 0, high = albums.length-1, middle = (low + high)/2;
        while (target.toLowerCase().compareTo(albums[middle].getTitle().toLowerCase()) != 0 && low <= high){
            if (target.toLowerCase().compareTo(albums[middle].getTitle().toLowerCase()) < 0){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + high)/2;
        }
        if (target.toLowerCase().compareTo(albums[middle].getTitle().toLowerCase()) == 0){
            return middle;
        } else {
            return -1;
        }
    }
    public int artistSearchBinary(String target){
        int low = 0, high = albums.length-1, middle = (low + high)/2;
        while (target.toLowerCase().compareTo(albums[middle].getArtist().toLowerCase()) != 0 && low <= high){
            if (target.toLowerCase().compareTo(albums[middle].getArtist().toLowerCase()) < 0){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + high)/2;
        }
        if (target.toLowerCase().compareTo(albums[middle].getArtist().toLowerCase()) == 0){
            return middle;
        } else {
            return -1;
        }
    }
    public int allSearchBinary(String target){
        boolean titleSearch = true;
        int low = 0, high = albums.length-1, middle = (low + high)/2;
        while (target.toLowerCase().compareTo(albums[middle].getTitle().toLowerCase()) != 0 && low <= high){
            if (target.toLowerCase().compareTo(albums[middle].getTitle().toLowerCase()) < 0){
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + high)/2;
        }
        if (target.toLowerCase().compareTo(albums[middle].getTitle().toLowerCase()) != 0){
            while (target.toLowerCase().compareTo(albums[middle].getArtist().toLowerCase()) != 0 && low <= high){
                if (target.toLowerCase().compareTo(albums[middle].getArtist().toLowerCase()) < 0){
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
                middle = (low + high)/2;
            }
        }
        if (target.toLowerCase().compareTo(albums[middle].getArtist().toLowerCase()) == 0){
            return middle;
        } else {
            return -1;
        }
    }
    public void titleSortSelection(){
        int min;
        Album temp;
        for (int i = 0; i < albums.length-1; i++) {
            min = i;
            for (int j = i + 1; j < albums.length; j++) {
                if (albums[j].getTitle().toLowerCase().compareTo(albums[min].getTitle().toLowerCase()) < 0) {
                    min = j;
                }
            }
            temp = albums[min];
            albums[min] = albums[i];
            albums[i] = temp;
        }
    }
    public void artistSortInsertion(){
        Album temp;
        for (int i = 1; i < albums.length; i++){
            temp = albums[i];
            for (int j = i - 1; j >= 0; j--){
                if (temp.getArtist().toLowerCase().compareTo(albums[j].getArtist().toLowerCase()) < 0){
                    albums[j + 1] = albums[j];
                    albums[j] = temp;
                }
            }
        }
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < albums.length; i++){
            str += albums[i].toString()+"\n";
        }
        str += songNum+" tracks, "+duration;
        return str;
    }
}