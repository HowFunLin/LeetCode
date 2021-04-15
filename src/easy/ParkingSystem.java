package easy;

public class ParkingSystem
{
	private int[] place = new int[3];
	
	public ParkingSystem(int big, int medium, int small) {
		place[0] = big;
		place[1] = medium;
		place[2] = small;
    }
    
    public boolean addCar(int carType) {
    	if(place[carType - 1] == 0)
    		return false;
    	else
    	{
    		place[carType - 1]--;
    		return true;
    	}
    }
}
