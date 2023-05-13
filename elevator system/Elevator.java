import java.util.*;

//An elevatar goes up, it continues to go up until there are no "drepoffs or "pickup requests in that direction

public class Elevator {

private static final int MIN_FLOOR=0;
private static final int MAX_FLOOR = 10;
private static int processingtime =500;//ms

private int currentFloor;
private Direction currentDireccion;

//keeps track of people waiting starting four : V(List of All the destination floor from that floor)
 private Map<Integer,List <Integer>> requestPathsMap;

private Boolean[] currentricordestinations;

public Elevator() {
 this.currentFloor=0;
 this.currentDirection=Direction.UP;//If at botten, the life will go up 
 this.requestedPathanap=new HashMap<>();
 this.currentFloseDestinations=new Boolean[MAX_FLOOR + 1]; 
 Arrays. fill (this.current=Flourbestinations, Booless.FALSE);
}
public void setProcessingTime(int processingTime) { 
    Elevate.processingtime=processingTime;
}
public int getCurrentFloor() {

   return this.currentFloor;
}
public Map<Integer, List<Intager>> getRequestedpathMap() {

   return this.requestedPathMap;
}
public clean getCurrentFionatinationa() {
   return this.currentFloorDestinations;
}

public void start() throws InterruptedException {
   currentDirection = Direction.UP;//Assumption the lift is on ground floor initially

 do {

    System.out.println("-------"); 
    processFloor(currentFloor); 
    System.out.println("--------"); 
} 
 while (currentDirection = Direction. IDLE);

System.out.println("No one is waiting and" +
         "no one is looking to go anywhere"); 
System.out.println("Chilling for now");
}

public void lunchtimeElevatorRush() {

Random random = new Random();

for (int i = 0; i < 30; i++) { 
    callElevator (random.nextInt(11), 
    random.nextInt(10) + 1);
}
}

//TO DO #1

public void callElevator (int start, int destination) {

     if (isInvalidFloor (start) || isinvalidFloor (destination) || start==destination) {

System.out.println("INVALID FLOORS. Try again"); return;
     }
    if (requestedPathsMap.containsKey (start)) //if already START is in map, add the destination in the list
    requestedPathsMap.get(start).add (destination);
    else 
    {//else add the new key aas START with the list containing our DESTINATION 
       requestedPathsMap.put(start, new ArrayList<>() {{
       add (destination);
       }});  
    }
}

//TO DO #2

private void processFloor (int floor) throws InterruptedException {

if (currentFloorDestinations[floor]) //Deboarding if any people who reached this destination floor

System.out.println("UN-BOARDING at Floor: " + floor);
  if (requestedPathsMap.containsKey(floor)) //Onboarding people and their destination

System.out.println("BOARDING at Floor : " + floor); requestedPathsMap.get(floor).forEach (destinationFloor ->
  currentFloorDestinations[destinationFloor] = true); //Marked true for next traversals
  requestedPathsMap. remove (floor); //removing the entry from map as we have marked all the destination

currentFloorDestinations [floor] false; //Marked false as we are just arrived in the current floor

moveElevator ();
}
//TO DO #3

private void moveElevator() throws InterruptedException {

  //SETIING OF DIRECTION
  //IDELING the elevator

if (!Arrays.asList (currentFloorDestinations).contains(true) && requestedPathsMap.isEmpty()) 
   { //STOPPING THE ELEVATOR :checking destinations are reached and request list is empty 
    currentDirection = Direction.IDLE;//this will break the while loop in our initial start() method
    return;
}
   else if (isInvalidFloor(currentFloor + 1)) {//SWITCH TO DOWN direction when reached top floor
   currentDirection = Direction.DOWN;
   }
   else if (isInvalidFloor(currentFloor - 1)) {//SWITCH TO DOWN direction when reached bottom floor
      currentDirection = Direction.UP;
   
   }
   switch (currentDirection) {//Move the elevator Enhanced switch available only in JDK14 onwards case UP-> moveUp();
      case UP: {
      moveUp();
      break;
      }
      case DOWN: {
      moveDown();
      break;
      }
   default: 
      System.out.println("Elevator Malfunctioned");
   }   
}

      private void moveUp() throws InterruptedException { 
      currentFloor++; 
      System.out.println("GOING UP TO " + currentFloor); 
      Thread.sleep (processingTime);
      }
      
      private void moveDown() throws InterruptedException { 
         currentFloor--; 
         System.out.println("GOING DOWN TO " + currentFloor); 
         Thread.sleep(processingTime);
      }
      
      private boolean isInvalidFloor (int floor) {
      return floor < MIN_FLOOR || floor>MAX_FLOOR;
      }
   }