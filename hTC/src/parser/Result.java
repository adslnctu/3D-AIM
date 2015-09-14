package parser;

public class Result {

	
	public int counterSporting = 0;
	public int counterTransportation = 0;
	public int counterDining = 0;
	public int counterWorking = 0;
	public int counterShopping = 0;
	public int counterEntertainment = 0;
	
	public double maxSporting;
	public double avgSporting;
	public double minSporting;
	public double powSporting;
	public double stdSporting;
	
	public double maxTransportation;
	public double avgTransportation;
	public double minTransportation;
	public double powTransportation;
	public double stdTransportation;
	
	public double maxDining;
	public double avgDining;
	public double minDining;
	public double powDining;
	public double stdDining;
	
	public double maxWorking;
	public double avgWorking;
	public double minWorking;
	public double powWorking;
	public double stdWorking;
	
	public double maxShopping;
	public double avgShopping;
	public double minShopping;
	public double powShopping;
	public double stdShopping;
	
	public double maxEntertainment;
	public double avgEntertainment;
	public double minEntertainment;
	public double powEntertainment;
	public double stdEntertainment;
	

	public Result()
	{
		maxSporting = 0;
		avgSporting = 0;
		minSporting = 100;
		powSporting = 0;
		stdSporting = 0;
		
		maxTransportation = 0;
		avgTransportation = 0;
		minTransportation = 100;
		powTransportation = 0;
		stdTransportation = 0;
		
		maxDining = 0;
		avgDining = 0;
		minDining = 100;
		powDining = 0;
		stdDining = 0;
		
		maxWorking = 0;
		avgWorking = 0;
		minWorking = 100;
		powWorking = 0;
		stdWorking = 0;
		
		maxShopping = 0;
		avgShopping = 0;
		minShopping = 100;
		powShopping = 0;
		stdShopping = 0;
		
		maxEntertainment = 0;
		avgEntertainment = 0;
		minEntertainment = 100;
		powEntertainment = 0;
		stdEntertainment = 0;
	}
	
	/*public void setcounterSporting(double value)
	{
		counterSporting++;
	}
	
	public void setcounterTransportation(double value)
	{
		counterTransportation++;
	}
	
	public void setMaxSporting(double value)
	{
		counterDining++;
	}
	
	public void setMaxSporting(double value)
	{
		counterWorking++;
	}
	
	public void setMaxSporting(double value)
	{
		counterShopping++;
	}
	
	public void setMaxSporting(double value)
	{
		counterEntertainment++;
	}*/
	
	

	
	public void setMaxSporting(double value)
	{
		maxSporting = value;
	}
	
	public void setAvgSporting(double value)
	{
		avgSporting += value;
		powSporting += Math.pow(value,2);
	}
	
	public void setMinSporting(double value)
	{
		minSporting = value;
	}
	
	public void setStdSporting(double value)
	{
		stdSporting += value;
	}
	
	public void setMaxTransportation(double value)
	{
		maxTransportation = value;
	}
	
	public void setAvgTransportation(double value)
	{
		avgTransportation += value;
		powTransportation += Math.pow(value,2);
	}
	
	public void setMinTransportation(double value)
	{
		minTransportation = value;
	}
	
	public void setStdTransportation(double value)
	{
		stdTransportation += value;
	}
	
	public void setMaxDining(double value)
	{
		maxDining = value;
	}
	
	public void setAvgDining(double value)
	{
		avgDining += value;
		powDining += Math.pow(value,2);
	}
	
	public void setMinDining(double value)
	{
		minDining = value;
	}
	
	public void setStdDining(double value)
	{
		stdDining += value;
	}
	
	public void setMaxWorking(double value)
	{
		maxWorking = value;
	}
	
	public void setAvgWorking(double value)
	{
		avgWorking += value;
		powWorking += Math.pow(value,2);
	}
	
	public void setMinWorking(double value)
	{
		minWorking = value;
	}
	
	public void setStdWorking(double value)
	{
		stdWorking += value;
	}
	
	public void setMaxShopping(double value)
	{
		maxShopping = value;
	}
	
	public void setAvgShopping(double value)
	{
		avgShopping += value;
		powShopping += Math.pow(value,2);
	}
	
	public void setMinShopping(double value)
	{
		minShopping = value;
	}
	
	public void setStdShopping(double value)
	{
		stdShopping += value;
	}
	
	public void setMaxEntertainment(double value)
	{
		maxEntertainment = value;
	}
	
	public void setAvgEntertainment(double value)
	{
		avgEntertainment += value;
		powEntertainment += Math.pow(value,2);
	}
	
	public void setMinEntertainment(double value)
	{
		minEntertainment = value;
	}
	
	public void setStdEntertainment(double value)
	{
		stdEntertainment += value;
	}
	
	
	
	
	
	public double getMaxSporting()
	{
		return maxSporting;
	}
	
	public double getAvgSporting()
	{
		return avgSporting;
	}
	
	public double getMinSporting()
	{
		return minSporting;
	}
	
	public double getStdSporting()
	{
		return stdSporting;
	}
	
	public double getMaxTransportation()
	{
		return maxTransportation;
	}
	
	public double getAvgTransportation()
	{
		return avgTransportation;
	}
	
	public double getMinTransportation()
	{
		return minTransportation;
	}
	
	public double getStdTransportation()
	{
		return stdTransportation;
	}
	
	public double getMaxDining()
	{
		return maxDining;
	}
	
	public double getAvgDining()
	{
		return avgDining;
	}
	
	public double getMinDining()
	{
		return minDining;
	}
	
	public double getStdDining()
	{
		return stdDining;
	}
	
	public double getMaxWorking()
	{
		return maxWorking;
	}
	
	public double getAvgWorking()
	{
		return avgWorking;
	}
	
	public double getMinWorking()
	{
		return minWorking;
	}
	
	public double getStdWorking()
	{
		return stdWorking;
	}
	
	public double getMaxShopping()
	{
		return maxShopping;
	}
	
	public double getAvgShopping()
	{
		return avgShopping;
	}
	
	public double getMinShopping()
	{
		return minShopping;
	}
	
	public double getStdShopping()
	{
		return stdShopping;
	}
	
	public double getMaxEntertainment()
	{
		return maxEntertainment;
	}
	
	public double getAvgEntertainment()
	{
		return avgEntertainment;
	}
	
	public double getMinEntertainment()
	{
		return minEntertainment;
	}
	
	public double getStdEntertainment()
	{
		return stdEntertainment;
	}
	
}
