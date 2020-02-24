public class MusicLibraryClient {
    public static void main(String[] args) {
        MusicLibrary myLibrary = new MusicLibrary();

        Album a1 = new Album("First", "One Guy", 10, 42.5);
        Album a2 = new Album("This Music", "some Band", 9, 36);
        Album a3 = new Album("Play", "People", 12, 39.1);
        Album a4 = new Album("a", "Andy", 8, 23.3);
        Album a5 = new Album("b", "Bot", 7, 24.7);
        Album a6 = new Album("c", "Celery", 14, 56.3);
        Album a7 = new Album("d", "hut", 5, 15.5);
        Album a8 = new Album("e", "Zoot", 12, 47.0);

        myLibrary.add(a1);
        myLibrary.add(a2);
        myLibrary.add(a3);
        myLibrary.add(a4);
        myLibrary.add(a5);
        myLibrary.add(a6);
        myLibrary.add(a7);
        myLibrary.add(a8);

        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        myLibrary.doubleSize();

        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        myLibrary.remove(1);
        myLibrary.add(a3);
        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        int loc1 = myLibrary.titleSearchLinear("FIRST");
        int loc2 = myLibrary.artistSearchLinear("peop");
        System.out.println(myLibrary.getAlbum(loc1));
        System.out.println(myLibrary.getAlbum(loc2));

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        System.out.println(myLibrary);
        System.out.println("sorting...");
        myLibrary.titleSortSelection();
        System.out.println("sorted. printing...");
        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        System.out.println("sorting...");
        myLibrary.artistSortInsertion();
        System.out.println("sorted. printing...");
        System.out.println(myLibrary);

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        //allSearchBinary could only work if both title and album were sorted
        /*int loc3 = myLibrary.allSearchBinary("First");
        int loc4 = myLibrary.allSearchBinary("Bot");
        System.out.println(myLibrary.getAlbum(loc3));
        System.out.println(myLibrary.getAlbum(loc4));*/
    }
}
