package OnlineTraining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
	
	public Profile()
	{
		for(int i = 0; i < MAX_ACTIVITY; i++) {
			speed[i] = 0;
			for(int j = 0; j < 6; j++) {
				distributionMatrixScore[i][j] = 0;
				softwareScore[i][j] = 0;
				locationScore[i][j] = 0;
			}
		}
	}
	
	// 2475 有最多的activity 600多個，故令700
	public static int MAX_ACTIVITY = 700;
	
	// weighted table for motion classifier
	public static int[][] weightedTable = new int [24][6];
	
	// time distribution for location classifier
	static Map<Integer,Integer> wTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> shTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> spTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> tTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> dTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> eTimeDistribution = new HashMap<Integer, Integer>();
    
    // GPS points for location classifier
    public static List<GPSData> trajectory = new ArrayList<>();
   
  	public static ArrayList<DataPoint> dpoints = new ArrayList<DataPoint>();
  	public static ArrayList<DataPoint> stayPointSet = new ArrayList<DataPoint>();
  	// Clusters for location classifier
  	public static ArrayList<Cluster> clusters = new ArrayList<Cluster>();
  	
  	// name of each gps point for optics algorithm
  	public static double gpsPointName = 0;
  	public static double gpsPointName2 = 0;
  	
  	public static String[] diningApp = new String[30];
	public static String[] transportationApp = new String[30];
	public static String[] sportingApp = new String[30];
	public static String[] workingApp = new String[30];
	public static String[] entertainmentApp = new String[30];
	public static String[] shoppingApp = new String[30];
	
	
	public static int[][] distributionMatrixScore = new int[MAX_ACTIVITY][6];
	public static int[][] softwareScore = new int[MAX_ACTIVITY][6];
	public static int[][] locationScore = new int[MAX_ACTIVITY][6];
	public static double[] speed = new double[MAX_ACTIVITY];
	public static double[] std = new double[MAX_ACTIVITY];
	public static String[] lable = new String[MAX_ACTIVITY];
	
	public static int numberOfFile = 0;
	public int correct = 0;
	public int total = 0;
	
	
	public static int transportationGPSNoHit = 0;
	public static int diningGPSNoHit = 0;

	public static int sportingGPSNoHit = 0;
	public static int workingGPSNoHit = 0;
	public static int entertainmentGPSNoHit = 0;
	public static int shoppingGPSNoHit = 0;
	
	public static int diningHit = 0;
	public static int transportationHit = 0;
	public static int sportingHit = 0;
	public static int workingHit = 0;
	public static int entertainmentHit = 0;
	public static int shoppingHit = 0;
	
	public static int diningTotal = 0;
	public static int transportationTotal = 0;
	public static int sportingTotal = 0;
	public static int workingTotal = 0;
	public static int entertainmentTotal = 0;
	public static int shoppingTotal = 0;
	
	public double gpsTotal = 0;
	public double gpsHit = 0;
	public int topk = 30;
	public double distance = 0.5; // for stay point detect
	public double trainingGps =0;
	public double flagGps = 0;
}
