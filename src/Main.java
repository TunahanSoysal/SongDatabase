import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void addSong(StringTree nameTree, StringTree artistTree, StringTree genreTree, AVLintTree IntTree){
        Scanner scn = new Scanner(System.in);
        int s = 10;
        System.out.println("enter a name,artist,id,genre,year for the song in the given order");
        String tempName = scn.next();
        String tempArtist = scn.next();
        int tempId = scn.nextInt();
        String tempGenre = scn.next();
        int tempYear = scn.nextInt();

        Song newSong = new Song(tempName,tempArtist,tempId,tempGenre,tempYear);
        nameTree.insert(newSong.getTitle().toLowerCase(),s+1);
        artistTree.insert(newSong.getArtist().toLowerCase(),s+1);
        genreTree.insert(newSong.getGenre().toLowerCase(),s+1);
        IntTree.root = IntTree.insert(IntTree.root, newSong.getID(),s+1);
        s++;

        ArrayList<Song>newSongArray = new ArrayList<>();

        ArrayList<ArrayList<Song>> newSongs = new ArrayList<>();

        newSongArray.add(newSong);
        newSongs.add(newSongArray);
        System.out.println(newSongs);
        System.out.println(s);


    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        StringTree nameTree = new StringTree();
        StringTree artistTree = new StringTree();
        StringTree genreTree = new StringTree();
        AVLintTree IntTree = new AVLintTree();
        addSong(nameTree,artistTree,genreTree,IntTree);




        String[][] songs2 = new String[10][5];

        for (int i = 0; i<10; i++){
            String[] temp = Files.readAllLines(Paths.get("C:\\Users\\soysa\\IdeaProjects\\untitled2\\src\\sound.txt")).get(i).split(";");
            Song sng = new Song(temp[0],temp[1],Integer.parseInt(temp[2]),temp[3],Integer.parseInt(temp[4]));
            nameTree.insert(sng.getTitle().toLowerCase(),i);
            artistTree.insert(sng.getArtist().toLowerCase(),i);
            genreTree.insert(sng.getGenre().toLowerCase(),i);
            IntTree.root = IntTree.insert(IntTree.root, sng.getID(),i);

        }

        for (int k = 0;k<10;k++){
            String[] temp2 = Files.readAllLines(Paths.get("C:\\Users\\soysa\\IdeaProjects\\untitled2\\src\\sound.txt")).get(k).split(";");
            for (int j = 0; j<5;j++){
                songs2[k][j]=temp2[j];
            }
        }

        System.out.println(Arrays.deepToString(songs2));


        System.out.println("enter the name of a music: ");

        String x = scn.next();

        System.out.println(nameTree.isInTree(x.toLowerCase()));

        if (nameTree.search(nameTree.root, x.toLowerCase())==null)

            System.out.println("there is no song like this");
        else

            System.out.println(Arrays.toString(songs2[nameTree.search(nameTree.root, x.toLowerCase()).index]));


        System.out.println("enter the name of a artist: ");

        String z = scn.next();

        System.out.println(artistTree.isInTree(z.toLowerCase()));

        if (artistTree.search(artistTree.root, z.toLowerCase())==null){

            System.out.println("there is no song like this");
        }else

            System.out.println(Arrays.toString(songs2[artistTree.search(artistTree.root, z.toLowerCase()).index]));


        System.out.println("\nenter a id:");

        int y = scn.nextInt();

        if (IntTree.search(IntTree.root, y)==null)

            System.out.println("no song has this id");
        else

            System.out.println(Arrays.toString(songs2[IntTree.search(IntTree.root, y).index]));

        System.out.println("enter min bound:");
        int min = scn.nextInt();
        System.out.println("enter max bound:");
        int max = scn.nextInt();
        for (int q = min;q<=max;q++){
            System.out.println(Arrays.toString(songs2[IntTree.search(IntTree.root, q).index]));
        }


        System.out.println("enter a genre:");
        String gnr = scn.next().toLowerCase();
        for (int w = 0;w< songs2.length;w++){
            if (songs2[w][3].toLowerCase().equals(gnr)){
                System.out.println(Arrays.toString(songs2[w]));
            }
        }






    }
}
