class ParkingSystem {

    int big;
    int medium;
    int small;
    int[] cap;
    int[] lot;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        this.cap = new int[3];
        this.lot = new int[3];
        
        this.cap[0] = big;
        this.cap[1] = medium;
        this.cap[2] = small;
    }
    
    public boolean addCar(int carType) {
        int i = carType - 1;
        if (this.lot[i] >= this.cap[i]) {
            return false;
        }
        this.lot[i]++;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */