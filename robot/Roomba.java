package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/TestRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 25, 13);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba = new Robot(25,13,East,0);


	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		
int largestPile = 0;
int totalPiles = 0;
int beepers;
int largestX = startX;
int largestY = startY;
int totalBeepers = 0;
for(int i= 0; i<14; i++)
{
while (roomba.frontIsClear())
{
beepers = 0;
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
	beepers++;
	totalBeepers++;
}
if (beepers > 0){
	totalPiles++;
}
if (beepers > largestPile){
	largestPile = beepers;
	largestX = roomba.street();
	largestY = roomba.avenue();
} 
	roomba.move();
}
roomba.turnLeft();
roomba.move();
roomba.turnLeft();
while (roomba.frontIsClear())
{
beepers = 0;
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
	beepers++;
	totalBeepers++;
}
if (beepers > 0){
	totalPiles++;
}
if (beepers > largestPile){
	largestPile = beepers;
	largestX = roomba.street();
	largestY = roomba.avenue();
} 
	roomba.move();
}
roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
roomba.move();
roomba.turnLeft();
roomba.turnLeft();
roomba.turnLeft();
while (roomba.frontIsClear())
{
beepers = 0;
while (roomba.nextToABeeper())
{
	roomba.pickBeeper();
	beepers++;
	totalBeepers++;
}
if (beepers >0){
	totalPiles++;
}
if (beepers > largestPile){
	largestPile = beepers;
	largestX = roomba.street();
	largestY = roomba.avenue();
} 
	roomba.move();
}
{
	System.out.print("The most amount of beepers in a pile is ");
	System.out.println(largestPile);
	System.out.print("The total amount of piles is ");
	System.out.println(totalPiles);
	System.out.print("The coordinate of the largest pile is ");
	System.out.println(largestX  + "," + largestY );
}
}
		return totalBeepers;
	}
}
