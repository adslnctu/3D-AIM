package parser;

public class Distribution {
	
	//public String [][][] appDistribution = new String[200][2][6];
	public int counter = 0;
	public int counterApp = 200; //�C�ӤH�ϥΤ��PAPP���W��
	public String [][][] appDistribution = new String[counterApp][2][6];
	public int []activityDistribution = new int[6]; //�C��activity�Wapp����������
	public double activeActivities = 6; // �C�@��user����F�h�֬��� (6�ظ̭�����F�X��
	
	public Distribution()
	{
		//��l��
		for(int i = 0; i < counterApp; i++) {
			appDistribution[i][0][0] = null;
			for(int j = 0; j < 6; j++) {
				appDistribution[i][1][j] = "0";
			}
		}
	}
}
