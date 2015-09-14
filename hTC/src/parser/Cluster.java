package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cluster {

	public List<DataPoint> gpsPoint;
	public double centralLon;
	public double centralLat;
	public Map<Integer, Integer> working = new HashMap<Integer,Integer>();
	public Map<Integer, Integer> entertainment = new HashMap<Integer,Integer>();
	public Map<Integer, Integer> dining = new HashMap<Integer,Integer>();
	public Map<Integer, Integer> shopping = new HashMap<Integer,Integer>();
	public Map<Integer, Integer> sporting = new HashMap<Integer,Integer>();
	//public Map<Integer, Integer> transportation = new HashMap<Integer,Integer>();
	public Map<Integer, Integer> transportation = new HashMap<Integer,Integer>();
	public Cluster()
	{
		gpsPoint = new ArrayList<DataPoint>();
	}
	
}
