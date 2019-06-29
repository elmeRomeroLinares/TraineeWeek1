public class RocketU2 extends Rocket {

    // Rocket U2 constructor assign parameters
    RocketU2(){
        super(120,18000,29000,0);
    }

    public boolean launch(double randLaunch){
        double launchExplodeU2 = 0.04*(getCurrentWeight()/(getMaxWeight()-getRocketWeight()));
        if (launchExplodeU2 < randLaunch){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean land(double randLand){
        double launchLandU2 = 0.08*(getCurrentWeight()/(getMaxWeight()-getRocketWeight()));
        if (launchLandU2 < randLand){
            return true;
        }
        else{
            return false;
        }
    }
}
