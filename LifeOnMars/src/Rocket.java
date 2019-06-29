public class Rocket implements SpaceShip {
    private int cost;
    private int rocketWeight;
    private int maxWeight;
    private int currentWeight;

    public Rocket(int cost, int rocketWeight, int maxWeight, int currentWeight) {
        this.cost = cost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
    }

    @Override
    public boolean launch(){
        return true;
    }

    @Override
    public boolean land(){
        return true;
    }

    @Override
    public boolean canCarry(Cargo newCargo){
        int possibleWeight = currentWeight + newCargo.cargoWeight;
        if(possibleWeight < maxWeight) {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void carry(Cargo newCargo){
        currentWeight += newCargo.cargoWeight;

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public void setRocketWeight(int rocketWeight) {
        this.rocketWeight = rocketWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
}
