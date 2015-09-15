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
  | Hardware_Testing: hardware testing data
  | Hardware_Training: hardware training data
  | Software_Original: software original data
  | Software_Training: software training data
  | Software_Testing: software testing data
  
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
                  �άO�ۤv�O�ܼ�

(2) Average Performance
CART & Bayesian: (i) ��Dateset => Bayesian�̪�training�Mtesting data�A�M���R�]����
                 (ii) CART�]�O��R�]�A�u�Ocall���P��model
				 (iii) script example�bDateset => Bayesian�̪�baysian.R�Bcart.R

optimized/default SVM: Svm��main.java����39�B46��Otraining�Mtesting�����|
                       Svm��main.java����48��A"cost"�N��svm��penalty parameter

3D-AIM: (i) random: �NAIM��Parameter.java����33�B174��training�����|����random��training
                    �NAIMtesting��Parameter.java����32�B70��testing�����|����random��testing
        (ii) cross validation: �NAIM��Parameter.java����33�B174��training�����|����cross validation��training
                               �NAIMtesting��Parameter.java����32�B70��testing�����|����cross validation��testingg
        (iii) optimized: AIMtesting��main.java����548~692��Ψӧ�̨Ϊ�alpha�Bbeta�Bgamma
		
(3) Learning Curve
CART & Bayesian: (i) training and testing data�����͡A�n��RBaysian�o��package�Ӳ���R format��testing and training data
                 (ii) ��R�]����
				 
3D-AIM: (i) training and testing data�w���ͦn�A�bDateset => 3D-AIM => learning curve
        (ii) �NAIM��Parameter.java����33�B174��training�����|����learning curve��training
        (iii) �NAIMtesting��Parameter.java����32�B70��testing�����|����learning curve��testing
		
SVM: (i) training and testing data�����͡A�n��RBaysian�o��package�Ӳ���svm format��testing and training data
     (ii) �NSvm��main.java����39�B46��training�Mtesting�����|����learning curve��training�Mtesting
 
(4) Performance of threshold-based model
�P(1)

(5) Single activity accuracy (precision)
AIMtesting��main.java����873~879��Ae.g., profile.diningHit���������T��dining�ơAprofile.diningTotal������dining��

(6) Inference Ability of Different Feature
AIMtesting��main.java����768�� (i) scoreForSoftware[j]: �qsoftware part���ұo��C�@��activity�o�ͪ����v
                               (ii) scoreForLocation[j]: �qspatial-temporal���ұo��C�@��activity�o�ͪ����v
							   (iii) scoreForDistributionMatrix[j]: �qmotion part���ұo��C�@��activity�o�ͪ����v
                               e.g., �n��motion part+software part�N�OscoreForDistributionMatrix[j]+scoreForSoftware[j];
							   
(7) Average Execution Time
3D-AIM: (i) training: AIM��main.java����143�B486�B487�B573�B1151�B1152�B1160��
        (ii) testing: AIMtesting��main.java����32�B330�B331�B358�B419�B783�B860�B861�B884��

(8) Model Size
3D-AIM: AIM��main.java����1145��]�w����model�����|
        AIMtesting��main.java����34��]�wmodel�����|
SVM: Svm��main.java����39��]�w����model�����|

(9) Size of Training Data
�C��user��hardware data + software data��file size�`�M

(10) Impact of stay point parameters
time threshold (min): AIM��Parameter.java����267��
distance threshold (km): AIM��Parameter.java����268��

(11) Impact of OPTICS parameters.
radius (km): AIM��Parameter.java����271��
mpt: AIM��Parameter.java����271��

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