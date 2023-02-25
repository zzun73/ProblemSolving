package leetcode.easy.Num1603;

class ParkingSystem {

    int[] space;

    public ParkingSystem(int big, int medium, int small) {
        space = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (--space[carType - 1] >= 0) {
            return true;
        } else {
            return false;
        }
    }
}


/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */