��Ƴ��bLAB Server

[Dataset]
3D-AIM:
| learning curve:  20% training data�B40% training data�B60% training data�B80% training data�U�ۤ@��folder
  | 20
  | 40
  | 60
  | 80
| cross validation: �C20% data�@��folder
  | 0_20
  | 20_40
  | 40_60
  | 60_80
  | 80_100
| random: training and testing data�H���D��
  | Hardware_Original: hardware original data
  | Hardware_Testing: hardware testing data (random)
  | Hardware_Training: hardware training data (random)
  | Software_Original: software original data
  | Software_Training: software training data (random)
  | Software_Testing: software testing data (random)
  
SVM: training and testing data (svm format)
| training
| testing
| optimized SVM model: �wtrain�n��optimized SVM model
| default SVM model: �wtrain�n��default SVM model

Bayesian: training and testing data (R format)
| training
| testing
-------------------------------------------------------------------------------------------- 
[Package]
AIM: training (�@��γo�Ӱ�����)
| AreaCategory.java: mapping table of location category and activity
| Cluster.java: OPTICS�|�Ψ쪺class
| DataPoint.java: OPTICS�|�Ψ쪺class
| Distribution.java: 
| GPSData.java: OPTICS�|�Ψ쪺class
| HttpRequest.java: �qfoursquare�W�o��public opinion
| InferenceResult.java: �ΨӲέp�@�ǹ��絲�G
| main.java
| Optics.java: source code of OPTICS
| Parameter.java: �ѼƳ]�w�Ae.g., dataset���|�B���@��user��
| Parser.java: parse software data and hardware data
| Profile.java: �ѼƳ]�w
| SoftwarePhase.java: classification�ɡAsoftware part�p��C�@��activity�o�ͪ����v

AIMtesting: testing (�@��γo�Ӱ�����)
| AreaCategory.java: mapping table of location category and activity
| Cluster.java: OPTICS�|�Ψ쪺class
| GPSData.java: OPTICS�|�Ψ쪺class
| HttpRequest.java: �qfoursquare�W�o��public opinion
| main.java
| Parameter.java: �ѼƳ]�w�Ae.g., dataset���|�B���@��user��
| Parser.java: parse software data and hardware data
| Profile.java: �ѼƳ]�w
| SoftwarePhase.java: classification�ɡAsoftware part�p��C�@��activity�o�ͪ����v

OnlineTesting: training (�ΨӲ���jar)
| .java�PAIM

OnlineTraining: testing (�ΨӲ���jar�Aoutput�u������������)
| .java�PAIMtesting

SVM: training and testing for svm
RBaysian: training and testing for Naive Bayesian
TrainingTest: �ΨӱN��l��Ƥ���training data�Mtesting data
---------------------------------------------------------------------------------------------
[ ���� ]
(1) Performance of different threshold
	threshold: AIMtesting��main.java����726��
	precision & recall: AIMtesting��main.java����872��~878��Ӻ�
						�άO�ۤv�O�ܼƥh��, e.g., AIMtesting��main.java����825~831��

(2) Average Performance
	CART & Bayesian: (i) ��Dateset => Bayesian�̪�training�Mtesting data�A�M���R�]����
					 (ii) CART�]�O��R�]�A�u�Ocall���P��model
					 (iii) script example�bDateset => Bayesian�̪�baysian.R�Bcart.R
					 (vi) �C�]�@��user�A���F�n��training and testing data�����|�~�٭n�����ơA�C��user�����ƦbRBaysian��Parameter.java����187~200��
					 (V) �]����bR��console�Upre
				 
	optimized/default SVM: Svm��main.java����39�B46��Otraining�Mtesting�����|
						   Svm��main.java����48��A"cost"�N��svm��penalty parameter

	3D-AIM: AIM��Parameter.java����136��model���ͪ����|
			AIMtesting��Parameter.java����107�欰model�����|
			(i) random: �NAIM��Parameter.java����33�B127��training�����|����random��training
						�NAIMtesting��Parameter.java����32�B70��testing�����|����random��testing
			(ii) cross validation: �NAIM��Parameter.java����33�B127��training�����|����cross validation��training
								   �NAIMtesting��Parameter.java����32�B70��testing�����|����cross validation��testingg
			(iii) optimized: AIMtesting��main.java����548~692��Ψӧ�̨Ϊ�alpha�Bbeta�Bgamma (�P�ɵ��ѱ�698~905��)
		
(3) Learning Curve
	CART & Bayesian: (i) training and testing data�����͡A�n��RBaysian�o��package�Ӳ���R format��testing and training data
					 (ii) RBaysian��Parameter.java������9��format�]0
					 (iii) RBaysian��Parameter.java����56�B90�B109�B131��n�]�wtraining and testing data��source
					 (iv) RBaysian��main.java����251�B252��]�w���ͥX�Ӫ�training and testing data�����|
					 (v) ��R�]����
					 
	3D-AIM: (i) training and testing data�w���ͦn�A�bDateset => 3D-AIM => learning curve
			(ii) �NAIM��Parameter.java����33�B127��training�����|����learning curve��training
			(iii) �NAIMtesting��Parameter.java����32�B70��testing�����|����learning curve��testing
			
	SVM: (i) training and testing data�����͡A�n��RBaysian�o��package�Ӳ���svm format��testing and training data
	     (ii) RBaysian��Parameter.java������9��format�]1
		 (iii) RBaysian��Parameter.java����56�B90�B109�B131��n�]�wtraining and testing data��source
		 (iv) RBaysian��main.java����256�B257��]�w���ͥX�Ӫ�training and testing data�����|
		 (v) ��Svm package�]����A�NSvm��main.java����39�B46��training�Mtesting�����|����learning curve��training�Mtesting
	 
(4) Performance of threshold-based model
	�P(1)

(5) Single activity accuracy (precision)
	AIMtesting��main.java����891~896��Ae.g., profile.diningHit���������T��dining�ơAprofile.diningTotal������dining��

(6) Inference Ability of Different Feature
	AIMtesting��main.java����768�� (i) scoreForSoftware[j]: �qsoftware part���ұo��C�@��activity�o�ͪ����v
								   (ii) scoreForLocation[j]: �qspatial-temporal���ұo��C�@��activity�o�ͪ����v
								   (iii) scoreForDistributionMatrix[j]: �qmotion part���ұo��C�@��activity�o�ͪ����v
								   e.g., �n��motion part+software part�N�OscoreForDistributionMatrix[j]+scoreForSoftware[j];
								   �̦������C
							   
(7) Average Execution Time
	3D-AIM: (i) training: AIM��main.java����143�B486�B487�B573�B1151�B1152�B1160��
			(ii) testing: AIMtesting��main.java����32�B331�B332�B359�B420�B784�B878�B879�B902��
	SVM:  (i) ���qtraining time: Svm��main.java����38�B41�洡�J���q�ɶ���system call
	      (ii) ���qtesting time: Svm��main.java����45�B49�洡�J���q�ɶ���system call
		  
(8) Model Size
	3D-AIM: AIM��Parameter.java����137��]�w����model�����|
			AIMtesting��Parameter.java����107��]�wmodel�Ҧb�����|
	SVM: Svm��main.java����39��]�w����model�����|

(9) Size of Training Data
	�C��user��hardware data + software data��file size�`�M

(10) Impact of stay point parameters
	time threshold (min): AIM��Parameter.java����144��
	distance threshold (km): AIM��Parameter.java����145��

(11) Impact of OPTICS parameters.
	radius (km): AIM��Parameter.java����148��
	mpt: AIM��Parameter.java����149��

(12) Impact of top k for application list.
	top k: AIM��Profile.java����92��
		   AIMtesting��Profile.java����67��
	general scoring: AIMtesting��SoftwarePhase����57�B63�B69�B76�B83�B89��
	weighted scoring: AIMtesting��SoftwarePhase.java����56�B62�B68�B75�B82�B88��
---------------------------------------------------------------------------------------------
[�פ�ø��]
�n��: draw.io (online website)
source files: ����b�פ媺script��

DailyLifeExample: Figure 1: An example of user daily file
SPandFR: Figure 2: An example of GPS, stay point and frequent region
framweork: Figure 3: An overview framework of 3D-AIM.
AppExample: Figure 5: An example of user��s application list when performing certain activities
PublicOpinionExample: Figure 7: Category distribution of POI in a region where user has never been before
---------------------------------------------------------------------------------------------
[���絲�Gø��]
�n��: Gnuplot
script: ����b�פ媺script��

PRG: Figure 4: Performance of different threshold.
plotPRG: draw Figure 4

accuracy.txt: Figure 8(a): Average Performance
plotAccuracy.txt: draw Figure 8(a)

learning_curve.txt: Figure 8(b): Learning Curve
plotLC.txt: draw Figure 8(b)

motion.txt: Figure 9: Performance of threshold-based model
plotMotion.txt: draw Figure 9

activity.txt: Figure 10: Single activity accuracy
plotActivity.txt: draw Figure 10

feature.txt: Figure 11: Inference Ability of Different Feature
plotFeature.txt: draw Figure 11

time.txt: Figure 12: Average Execution Time
plotTime.txt: draw Figure 12

model.txt: Figure 13 (b): Model Size
plotModel.txt: draw Figure 13 (b)

trainingsize.txt: Figure 13 (a): Size of Training Data
plotTraining: draw Figure 13 (a)

sp.txt: Figure 14: Impact of stay point parameters
plotSP.txt: draw Figure 14

optics.txt: Figure 15: Impact of OPTICS parameters.
plotOPTICS.txt: draw Figure 15

topk.txt: Figure 16: Impact of top k for application list.
plotTopk.txt: draw Figure 16
---------------------------------------------------------------------------------------------
[NCTU Assist] �bNCTU-Assist.rar��
NCTU Assist�O�@�Ө㦳inference ability��logger�A��������W����ƨäW�Ǩ�server
client��(�]�N�Oapp)�Asource code�|��쪺�a�観
(1) com.example.myactivity.staticdata��SiteUrl.java������9���ܦ�����data��A�ntrigger�o��php�ӱ����ϥΪ̦b���ƻ򬡰�(�]�N�Otrigger�ڭ̪�model)
(2) com.example.myactivity.staticdata��SiteUrl.java������10��O�ڭ̱������~�A�ntrigger�o��php�ӧ�label
(3) com.example.myactivity��UploadService.java����66~74��]�w�q����W�����쪺data�n�W�Ǩ���̡A�Ҧpcode���N�O�W�Ǩ�lab's server�Alikekaito�ؿ����U(73�B74����hardware and software data�W�Ǩ줣�P���ؿ��U)

sever�ݪ�php
(1) AIMtesting.php: �W�ǧ�data��|trigger�o��script�A�ھ�user�W�Ǫ�hardware and software data�hcall onlinetesting.jar�Ӱ����ʪ����� (onlinetesting.jar�|�ھڤ��P��user�htrigger�ӤH�ƪ�model)
                    ��19�B20��O�W�ǧ���hardware and software data�Ҧb����m
(2) setlabel_new.php: �Y�ڭ̱����X�Ӫ����ʤ��O�ϥΪ̥��b�����A�ϥΪ̴N�|���slabel activity�A�o�ɴN�|trigger�o��php�A�o��script�|�A�hcall setlabel_0401.py
                      �Y�ڭ̱����X�Ӫ����ʬO�ϥΪ̥��b�����A�]�|trigger�o��php(�u�Olabel�@�˪�activity)�A�o��script�|�A�hcall setlabel_0401.py
(3) setlabel_0401.py: �Ψӭ��slabel���ϥΪ̤W�Ǫ�data��activity�A�|��쪺�a�観
                      (i) 20�B21��: hardware data�Msoftware data�����|
					  (ii) 10�B11��: ���slabel�L��data�|�Q���ʨ�o��Ӹ��|�U�A�@�ˤ]�O��hardware and software data
(4) run.php: �C�j6�p�ɴN�|call explorer.jar�Monlinetraining.jar�ӥhtraining�Ҧ�user��model (�o��php�u�n����L�@���N�|�ä[�]�U�h)

             ��8��O�w�g���slabel�L��hardware data�����|
*Notice: /home/likekaito/public_html/htc_logdata/
         /home/likekaito/public_html/htc_logdata_software/
		 �W�������O�q����W������data�@�}�l�|�Q�W�Ǩ�o��Ӧ�m
		 
	     /home/likekaito/public_html/htc_logdata_withLabel/
		 /home/likekaito/public_html/htc_logdata_withLabel_software/
		 �W�������O���slabel�L��hardware and software data�|�q�쥻�W�Ǫ���m���ʨ�W���o��Ӧ�m