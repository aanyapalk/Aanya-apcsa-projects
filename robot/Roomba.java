package robot;

import kareltherobot.*;

public class Roomba implements Directions {

    public static void main(String[] args) {
        // LEAVE THIS ALONE!!!!!!
        String worldName = "robot/finalTest.wld";
        World.setDelay(0);
        Roomba cleaner = new Roomba();
        int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
        //System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");  
        //System.out.println("Roomba cleaned up a total of " + totalBeepers + " piles.");
    }

    // declared here so it is visible in all the methods!
    private Robot roomba;

    public int cleanRoom(String worldName, int startX, int startY) {

        // A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

        World.readWorld(worldName);
        World.setVisible(true);
        boolean end = true;
        roomba = new Robot(startX, startY, East, 0); 
        int numOfBeepers = 0; 
        int units = 0; 
        int numOfPiles = 0;  
        int pileOfMaxBeepers = 0; 
        int street = roomba.street();   
        int ave = roomba.avenue();      

        while(end){
            while(roomba.frontIsClear()){
                roomba.move(); 
                units++; 
                int max2 = 0;
                if(roomba.nextToABeeper() == true){

                    numOfPiles++; 
                    int currentPileSize = 0;
                    while(roomba.nextToABeeper()){
                        roomba.pickBeeper(); 
                        numOfBeepers++; 
                        max2 += 1;
                        if(max2 >= pileOfMaxBeepers){
                            pileOfMaxBeepers = max2;
                            street = roomba.street(); 
                            ave = roomba.avenue(); 
                        }
                    } 
                }
            }
            if(roomba.facingEast() && !roomba.frontIsClear()){
                roomba.turnLeft(); 
                if(!roomba.frontIsClear()){
                    units++;
                    end = false;
                }
                else{
                    roomba.move();
                    units++; 
                    roomba.turnLeft(); 
                }
                ; 
            }
            else if(roomba.facingWest() && !roomba.frontIsClear()){
                turnRight(roomba); 
                if(!roomba.frontIsClear()){
                    units++; 
                    end = false; 
                }else{
                roomba.move(); 
                units++;  
                turnRight(roomba); 
                }
            }
        } 

        double averagePileSize = (double)numOfBeepers/numOfPiles ; 
        double percentDirty = (double)numOfPiles / units; 

        
        System.out.println("Total number of Beepers = "+ numOfBeepers);
        System.out.println("Total number of Piles = "+ numOfPiles); 
        System.out.println("Total Squares traveled: "+units); 
        System.out.println("The maximum number of beepers in a pile is "+pileOfMaxBeepers); 
        System.out.println("Coordinates: ("+street+ ", "+ave+")"); 
        //System.out.println("Relative Coordinates: ("+(street-startX)+", "+(ave - startY)+")");
        System.out.println("Average Pile size = "+ averagePileSize); 
        System.out.println("Percent dirty: "+percentDirty); 

        return numOfPiles; 
    }

    public static void turnRight(Robot roomba){
        roomba.turnLeft(); 
        roomba.turnLeft(); 
        roomba.turnLeft(); 
    }
}
