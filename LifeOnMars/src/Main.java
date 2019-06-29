import java.util.ArrayList;

public class Main {
    private static final String cargoPhase1Text = "phase1.txt";
    private static final String cargoPhase2Text = "phase2.txt";
    static final int ROCKET1 = 0;
    static final int ROCKET2 = 1;

    public static void main(String [] args){

        Simulation marsSimulation = new Simulation();

        ArrayList<Rocket> phase1RocketsU1 = marsSimulation.loadItem(cargoPhase1Text,ROCKET1);
        ArrayList<Rocket> phase1RocketsU2 = marsSimulation.loadItem(cargoPhase1Text,ROCKET2);
        ArrayList<Rocket> phase2RocketsU1 = marsSimulation.loadItem(cargoPhase2Text,ROCKET1);
        ArrayList<Rocket> phase2RocketsU2 = marsSimulation.loadItem(cargoPhase2Text,ROCKET2);

        int totalCostU1 = marsSimulation.runSimulation(phase1RocketsU1)+marsSimulation.runSimulation(phase2RocketsU1);
        int totalCostU2 = marsSimulation.runSimulation(phase1RocketsU2)+marsSimulation.runSimulation(phase2RocketsU2);

        System.out.println("U1 total cost: "+totalCostU1+" millions");
        System.out.println("U2 total cost: "+totalCostU2+" millions");
        if(totalCostU1 < totalCostU2){
            System.out.println("Rockets U1 cost is lower for this simulation");
        }
        else{
            System.out.println("Rockets U2 cost is lower for this simulation");
        }

    }

}
