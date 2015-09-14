package AIM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cluster {
	
	public List<DataPoint> gpsPoint;
	double centralLon;
	double centralLat;
	Map<Integer, Integer> working = new HashMap<Integer,Integer>();
	Map<Integer, Integer> entertainment = new HashMap<Integer,Integer>();
	Map<Integer, Integer> dining = new HashMap<Integer,Integer>();
	Map<Integer, Integer> shopping = new HashMap<Integer,Integer>();
	Map<Integer, Integer> sporting = new HashMap<Integer,Integer>();
	Map<Integer, Integer> transportation = new HashMap<Integer,Integer>();
	
	public Cluster()
	{
		gpsPoint = new ArrayList<DataPoint>();
		
	}
	
}
