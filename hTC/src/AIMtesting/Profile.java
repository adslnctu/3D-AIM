package AIMtesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Profile {
	
	public static int mon = 0;
	public static int tue = 0;
	public static int wen = 0;
	public static int thu = 0;
	public static int fri = 0;
	public static int sat = 0;
	public static int sun = 0;
	
	public static int twoPointFour = 0;
	
	public static int totalGps = 0;
	public static int publicOpinionUsed = 0;
	
	public static int publicHit = 0;
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
	
	public static int numberOfFile = 0;
	public static int MAX_ACTIVITY = 700;
	public static double[][] distributionMatrixScore = new double[MAX_ACTIVITY][6];
	public static double[][] softwareScore = new double[MAX_ACTIVITY][6];
	public static double[][] locationScore = new double[MAX_ACTIVITY][6];
	public static double[] speed = new double[MAX_ACTIVITY];
	public static double[] std = new double[MAX_ACTIVITY];
	public static String[] lable = new String[MAX_ACTIVITY];
	public int[][] weightedTable = new int [24][6];
	
	public double threshold = 0;
	public int weightedTableIndex = 0;
	public static ArrayList<Cluster> clusters = new ArrayList<Cluster>();
	public int frIndex = -1;
	public Cluster cluster;
	public static String[] diningApp = new String[30];
	public static String[] transportationApp = new String[30];
	public static String[] sportingApp = new String[30];
	public static String[] workingApp = new String[30];
	public static String[] entertainmentApp = new String[30];
	public static String[] shoppingApp = new String[30];
	static Map<Integer,Integer> wTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> shTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> spTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> tTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> dTimeDistribution = new HashMap<Integer, Integer>();
    static Map<Integer,Integer> eTimeDistribution = new HashMap<Integer, Integer>();
    
    
    public int topk =  30;
    public Profile()
    {
    	for(int i = 0 ; i < topk; i++)
    	{
    		diningApp[i] = "null";
    		transportationApp[i] = "null";
    		sportingApp[i] = "null";
    		workingApp[i] = "null";
    		entertainmentApp[i] = "null";
    		shoppingApp[i] = "null";
    	}
    }
}
