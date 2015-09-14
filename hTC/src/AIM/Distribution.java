package AIM;

public class Distribution {
	
	// must delete
	public static double sportingCounter = 0;
	public static double diningCounter = 0;
	public static double entertainmentCounter = 0;
	public static double workingCounter = 0;
	public static double shoppingCounter = 0;
	public static double transportationCounter = 0;
	
	public double sportingHit = 0;
	public double diningHit = 0;
	public double entertainmentHit = 0;
	public double workingHit = 0;
	public double shoppingHit = 0;
	public double transportationHit = 0;
	public double unknow = 0;
	
	
	/* for app usage training */
	public int counter = 0;
	public int counterApp = 200; //每個人使用不同APP的上限
	public String [][][] appDistribution = new String[counterApp][2][6];
	public int []activityDistribution = new int[6]; //每個activity上app的分布情形
	public double activeActivities = 6; // 每一個user執行了多少活動 (6種裡面執行了幾種
	
	public Distribution()
	{
		//初始化
		for(int i = 0; i < counterApp; i++) {
			appDistribution[i][0][0] = null;
			for(int j = 0; j < 6; j++) {
				appDistribution[i][1][j] = "0";
			}
		}
	}
}
