[Dataset]
3D-AIM:
| learning curve:  20% training data、40% training data、60% training data、80% training data各自一個folder
  | 20
  | 40
  | 60
  | 80
| cross validation: 每20% data一個folder
  | 0_20
  | 20_40
  | 40_60
  | 60_80
  | 80_100
| random: training and testing data隨機挑選
  | Hardware_Original: hardware original data
  | Hardware_Testing: hardware testing data
  | Hardware_Training: hardware training data
  | Software_Original: software original data
  | Software_Training: software training data
  | Software_Testing: software testing data
  
SVM: training and testing data (svm format)
| training
| testing
| optimized SVM model: 已train好的optimized SVM model
| default SVM model: 已train好的default SVM model

Bayesian: training and testing data (R format)
| training
| testing
-------------------------------------------------------------------------------------------- 
[Package]
AIM: training (一般用這個做實驗)
| AreaCategory.java: mapping table of location category and activity
| Cluster.java: OPTICS會用到的class
| DataPoint.java: OPTICS會用到的class
| Distribution.java: 
| GPSData.java: OPTICS會用到的class
| HttpRequest.java: 從foursquare上得到public opinion
| InferenceResult.java: 用來統計一些實驗結果
| main.java
| Optics.java: source code of OPTICS
| Parameter.java: 參數設定，e.g., dataset路徑、哪一個user等
| Parser.java: parse software data and hardware data
| Profile.java: 參數設定
| SoftwarePhase.java: classification時，software part計算每一個activity發生的機率

AIMtesting: testing (一般用這個做實驗)
| AreaCategory.java: mapping table of location category and activity
| Cluster.java: OPTICS會用到的class
| GPSData.java: OPTICS會用到的class
| HttpRequest.java: 從foursquare上得到public opinion
| main.java
| Parameter.java: 參數設定，e.g., dataset路徑、哪一個user等
| Parser.java: parse software data and hardware data
| Profile.java: 參數設定
| SoftwarePhase.java: classification時，software part計算每一個activity發生的機率

OnlineTesting: training (用來產生jar)
| .java同AIM

OnlineTraining: testing (用來產生jar，output只有推測的活動)
| .java同AIMtesting

SVM: training and testing for svm
RBaysian: training and testing for Naive Bayesian
TrainingTest: 用來將原始資料切成training data和testing data
---------------------------------------------------------------------------------------------
[ 實驗 ]
(1) Performance of different threshold
threshold: AIMtesting的main.java中的726行
precision & recall: AIMtesting的main.java中的872行~878行來算
                  或是自己令變數

(2) Average Performance
CART & Bayesian: (i) 用Dateset => Bayesian裡的training和testing data，然後用R跑實驗
                 (ii) CART也是用R跑，只是call不同的model
				 (iii) script example在Dateset => Bayesian裡的baysian.R、cart.R

optimized/default SVM: Svm的main.java中的39、46行是training和testing的路徑
                       Svm的main.java中的48行，"cost"代表svm的penalty parameter

3D-AIM: (i) random: 將AIM的Parameter.java中的33、174行training的路徑換成random的training
                    將AIMtesting的Parameter.java中的32、70行testing的路徑換成random的testing
        (ii) cross validation: 將AIM的Parameter.java中的33、174行training的路徑換成cross validation的training
                               將AIMtesting的Parameter.java中的32、70行testing的路徑換成cross validation的testingg
        (iii) optimized: AIMtesting的main.java中的548~692行用來找最佳的alpha、beta、gamma
		
(3) Learning Curve
CART & Bayesian: (i) training and testing data未產生，要用RBaysian這個package來產生R format的testing and training data
                 (ii) 用R跑實驗
				 
3D-AIM: (i) training and testing data已產生好，在Dateset => 3D-AIM => learning curve
        (ii) 將AIM的Parameter.java中的33、174行training的路徑換成learning curve的training
        (iii) 將AIMtesting的Parameter.java中的32、70行testing的路徑換成learning curve的testing
		
SVM: (i) training and testing data未產生，要用RBaysian這個package來產生svm format的testing and training data
     (ii) 將Svm的main.java中的39、46行training和testing的路徑換成learning curve的training和testing
 
(4) Performance of threshold-based model
同(1)

(5) Single activity accuracy (precision)
AIMtesting的main.java中的873~879行，e.g., profile.diningHit為推測正確的dining數，profile.diningTotal為全部dining數

(6) Inference Ability of Different Feature
AIMtesting的main.java中的768行 (i) scoreForSoftware[j]: 從software part中所得到每一個activity發生的機率
                               (ii) scoreForLocation[j]: 從spatial-temporal中所得到每一個activity發生的機率
							   (iii) scoreForDistributionMatrix[j]: 從motion part中所得到每一個activity發生的機率
                               e.g., 要測motion part+software part就是scoreForDistributionMatrix[j]+scoreForSoftware[j];
							   
(7) Average Execution Time
3D-AIM: (i) training: AIM的main.java中的143、486、487、573、1151、1152、1160行
        (ii) testing: AIMtesting的main.java中的32、330、331、358、419、783、860、861、884行

(8) Model Size
3D-AIM: AIM的main.java中的1145行設定產生model的路徑
        AIMtesting的main.java中的34行設定model的路徑
SVM: Svm的main.java中的39行設定產生model的路徑

(9) Size of Training Data
每個user的hardware data + software data的file size總和

(10) Impact of stay point parameters
time threshold (min): AIM的Parameter.java中的267行
distance threshold (km): AIM的Parameter.java中的268行

(11) Impact of OPTICS parameters.
radius (km): AIM的Parameter.java中的271行
mpt: AIM的Parameter.java中的271行

(12) Impact of top k for application list.
top k: AIM的Profile.java中的92行
       AIMtesting的Profile.java中的67行
general scoring: AIMtesting的SoftwarePhase中的57、63、69、76、83、89行
weighted scoring: AIMtesting的SoftwarePhase.java中的56、62、68、75、82、88行
---------------------------------------------------------------------------------------------
[論文繪圖]
軟體: draw.io (online website)
source files: 都放在論文的script裡

DailyLifeExample: Figure 1: An example of user daily file
SPandFR: Figure 2: An example of GPS, stay point and frequent region
framweork: Figure 3: An overview framework of 3D-AIM.
AppExample: Figure 5: An example of user’s application list when performing certain activities
PublicOpinionExample: Figure 7: Category distribution of POI in a region where user has never been before
---------------------------------------------------------------------------------------------
[實驗結果繪圖]
軟體: Gnuplot
script: 都放在論文的script裡

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