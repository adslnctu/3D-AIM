package parser;

public class Distribution {
	
	//public String [][][] appDistribution = new String[200][2][6];
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
