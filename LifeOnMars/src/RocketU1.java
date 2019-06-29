import java.util.Random;

public class RocketU1 extends Rocket {

    // Rocket U1 constructor assign parameters
    RocketU1(){
        super(100,10000,18000,0);
    }

    public boolean launch(){
        double randLaunch = new Random().nextDouble();
        double launchExplodeU1 = 0.05*(getCurrentWeight()/(getMaxWeight()-getRocketWeight()));
        if (launchExplodeU1 < randLaunch){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean land(){
        double randLaunch = new Random().nextDouble();
        double launchLandU1 = 0.01*(getCurrentWeight()/(getMaxWeight()-getRocketWeight()) );
        if (launchLandU1 < randLaunch){
            return true;
        }
        else{
            return false;
        }
    }
}
