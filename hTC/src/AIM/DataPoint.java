package AIM;

public class DataPoint {
	
	// new added
	private String activity;
	private String timestamp;
	private double speed;
	
    private String name; 
    private double dimensioin[]; 
    private double coreDistance; 
    private double reachableDistance; 

    public DataPoint(){
    }

    public DataPoint(DataPoint e){
    	// new added
    	this.activity = e.activity;
    	this.timestamp = e.timestamp;
    	this.speed = e.speed;
    	
        this.name=e.name;
        this.dimensioin=e.dimensioin;
        this.coreDistance=e.coreDistance;
        this.reachableDistance=e.reachableDistance;
    }

    public DataPoint(double dimensioin[], String name, String activity, String timestamp, double speed){
    	// new added
    	this.activity = activity;
    	this.timestamp = timestamp;
    	this.speed = speed;
    	
    	this.name=name;
        this.dimensioin=dimensioin;
        this.coreDistance=-1;
        this.reachableDistance=-1;
    }


    
    public DataPoint(double[] dimensioin, String name) {
    	
    	
    	
    	this.name=name;
        this.dimensioin=dimensioin;
        this.coreDistance=-1;
        this.reachableDistance=-1;
	}

	public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public double[] getDimensioin() {
        return dimensioin;
    }
    
    public void setDimensioin(double[] dimensioin) {
        this.dimensioin = dimensioin;
    }
    
    public double getCoreDistance() {
        return coreDistance;
    }
    public void setCoreDistance(double coreDistance) {
        this.coreDistance = coreDistance;
    }
    
    public double getReachableDistance() {
        return reachableDistance;
    }
    
    public void setReachableDistance(double reachableDistance) {
        this.reachableDistance = reachableDistance;
    }
    
    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    public String getActivity() {
    	return activity;
    }
    
    public double getLongitude()
    {
    	return dimensioin[1];
    }
    
    public double getLatitude()
    {
    	return dimensioin[0];
    }
    
    public String getTimestamp()
    {
    	return timestamp;
    }
    
    public double getSpeed()
    {
    	return speed;
    }
  
}
