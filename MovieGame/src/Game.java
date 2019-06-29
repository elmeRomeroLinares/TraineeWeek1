import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Game {

    private static final String MOVIE_NAME = "movies.txt";

    // Function Variables for buildGames
    private String movie;
    public String movHide;


    //movie String
    String[] movieStrings = new String[2];


    public void startGame() {

        // Function Read and Scan File
        Scanner movieScan = fileLogic();
        // Handles Null return
        if(movieScan != null){
            String[] movGame = buildGame(movieScan);
            display(movGame);
        }
        else{
             System.out.println("Error while reading files");
        }

    }


    private Scanner fileLogic(){
        File movieFile = new File(MOVIE_NAME);
        Scanner movieScan = null;
        try {
            movieScan = new Scanner(movieFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading text file");
        }
        return movieScan;
    }

    private String[] buildGame(Scanner scan){

        //Create ArrayList
        ArrayList<String> movName = new ArrayList<>();

        // mov gets number of movies in file
        int mov = 0;
        while(scan.hasNextLine()){
            movName.add(scan.nextLine());
            mov++;
        }

        // Generates random movie number
        int guessMov = (int) (Math.random() * mov + 1);

        // Hide movie name (can be a method that other classes can use?)
        movie = movName.get(guessMov - 1);
        movHide = movie.replaceAll("[a-zA-Z]","-");
        movieStrings[0] = movie;
        movieStrings[1] = movHide;

        return movieStrings;
    }

    private void display(String[] dispMovie ){
        int numFail = 0;
        ArrayList<String> wrLetter = new ArrayList<>();
        ArrayList<Integer> multiIndex = new ArrayList<>();
        StringBuilder newMovHide = new StringBuilder(dispMovie[1]);

        System.out.println(movie);
        System.out.println(movHide);

        do{
            // Prints
            System.out.println("You are guessing:"+ newMovHide);
            System.out.println("You have guessed ("+numFail+") wrong letters"+wrLetter);
            System.out.println("Guess a letter:");

            // Scan for Letters and converts to char
            Scanner scanLetter = new Scanner(System.in);
            String inLetter = scanLetter.nextLine();
            char inChar = inLetter.charAt(0);
            boolean thisTry = dispMovie[0].contains(inLetter);

            // Check for coincidence
            if(thisTry){

                // Seek every index of the Character on the title (Can it be a Class?)
                int firstIndex = dispMovie[0].indexOf(inLetter);
                multiIndex.add(firstIndex);

                int lastIndex = dispMovie[0].lastIndexOf(inLetter);

                if(lastIndex != firstIndex){
                    int nextIndex = dispMovie[0].indexOf(inLetter,firstIndex+1);
                    multiIndex.add(nextIndex);
                    do{
                        nextIndex = dispMovie[0].indexOf(inLetter,nextIndex);
                    }while(nextIndex != lastIndex);
                }

                for (int m = 0; m < multiIndex.size(); m++){
                    newMovHide.setCharAt(multiIndex.get(m),inChar);
                }

                multiIndex.clear();
            }
            else{
                wrLetter.add(inLetter);
                numFail++;
            }

            if(newMovHide.toString().equals(dispMovie[0])){
                System.out.println("congratulation you have WON, you guess: "+newMovHide);
                break;
            }

        }while(numFail <10);

        if ( numFail == 10 ){
            System.out.println("Sorry, you have lost, the answer was: " + dispMovie[0]);
        }

    }

}
