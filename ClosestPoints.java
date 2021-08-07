package Arrays;
import java.util.Scanner;

public class ClosestPoints {
	
	public static void main(String[] args) {
		//Prompt user to enter the number of points in the plane
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of points: ");
		int numberOfPoints = input.nextInt();
		
		//Create an array to store points. Points are 2D objects as they have x and y values
		double[][] points = new double[numberOfPoints][2]; //Create a new 2D array
		System.out.println("Enter " + numberOfPoints + " points: ");
		for(int i = 0; i < points.length; i++) { //Read the points from the user
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}
		
		//p1 and p2 are the indices in the points' array
		int p1 = 0, p2 = 1; 
		double shortestDistance = distance(points[p1][0], points[p1][1], 
				points[p2][0], points[p2][1]);	//Find the two closest points on the coordinate plane
		
		//Compute distance for every two points
		for (int i = 0; i < points.length; i++) { //for each point i
			for(int j = i + 1; j < points.length; j++) { //for each point j
				double distance = distance(points[i][0], points[i][1],
						points[j][0], points[j][1]);
				
				if (shortestDistance > distance) {
					p1 = i; //update p1
					p2 = j; //update p2
					shortestDistance = distance; //Update shortestDistance
				}
			}
		}
		
		//Display result
		System.out.println("The closest two points are " +
		"(" + points[p1][0] + ", " + points[p1][1] + ") and (" +
				points[p2][0] + ", " + points[p2][1] + ")");
	} //end main()
	
	/** Compute the distance b/t two points (x1, y1) and (x2, y2)*/
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt( (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) );
	} //end distance
	
	
}