import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Simulation {


    // Read text file
    Scanner fileLogic(String fileName) {
        File getPhaseCargo = new File(fileName);
        Scanner cargoScan = null;
        try {
            cargoScan = new Scanner(getPhaseCargo);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading text file");
        }
        return cargoScan;
    }

    ArrayList<Rocket> loadItem(String path, int rocketType) {
        ArrayList<Cargo> cargoList = new ArrayList<>();
        ArrayList<Rocket> rocketList = new ArrayList<>();
        Rocket rocket;

        Scanner scanner = fileLogic(path);
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                String[] cargoLine = scanner.nextLine().split("=");
                cargoList.add(new Cargo(cargoLine[0], Integer.parseInt(cargoLine[1])));
            }
            if (rocketType == Main.ROCKET1) {
                rocket = new RocketU1();
            } else {
                rocket = new RocketU2();
            }

            if (cargoList.size() != 0) {
                for (int i = 0; i < cargoList.size(); i++) {
                    if (rocket.canCarry(cargoList.get(i))) {
                        rocket.carry(cargoList.get(i));
                    } else {
                        rocketList.add(rocket);
                        rocket = new RocketU1();
                        rocket.carry(cargoList.get(i));
                    }
                }
                rocketList.add(rocket);

            }
        }
        return rocketList;
    }

    public int runSimulation(ArrayList<Rocket> sendRocketList){
        int totalCost =  0;
        boolean launching;
        boolean landing;

        for(int i = 0; i < sendRocketList.size(); i++){
            launching = sendRocketList.get(i).launch();
            landing = sendRocketList.get(i).land();
            if(launching & landing){
                totalCost += sendRocketList.get(i).getCost();
            }
            else{
                while(!launching || !landing){
                    launching = sendRocketList.get(i).launch();
                    landing = sendRocketList.get(i).land();
                    totalCost += sendRocketList.get(i).getCost();
                }
            }
        }
        return totalCost;

    }



}
