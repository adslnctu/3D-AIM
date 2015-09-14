package Model;

import java.util.HashMap;
import java.util.Map;

public class CategoryUsage {
	
	/* 因為每次都用http query會太久，所以開map來存 */
	Map<String, String> mapping = new HashMap<String, String>();
	public int topK = 10;
	// top 10 (category, frequency)
	
	// imei 353567051351832
//	public String[] diningApp = {"Built-in","工具","通訊","社交","媒體與影片","財經","生產應用","新聞與雜誌","旅遊與地方資訊","null",};
//	public String[] transportationApp = {"Built-in","通訊","工具","社交","媒體與影片","生產應用","音樂與音效","旅遊與地方資訊","新聞與雜誌","null",};
//	public String[] sportingApp = {"Built-in","通訊","社交","工具","媒體與影片","音樂與音效","生產應用","天氣","新聞與雜誌","交通運輸",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051351956
//	public String[] diningApp = {"Built-in","通訊","生產應用","新聞與雜誌","null","null","null","null","null","null",};
//	public String[] transportationApp = {"Built-in","通訊","新聞與雜誌","工具","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","生產應用","工具","通訊","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"Built-in","通訊","工具","社交","生產應用","解謎","街機","購物","生活品味","策略",};
//	public String[] transportationApp = {"Built-in","通訊","工具","社交","生產應用","街機","解謎","購物","生活品味","新聞與雜誌",};
//	public String[] sportingApp = {"Built-in","通訊","工具","生產應用","社交","解謎","街機","購物","生活品味","天氣",};
//	public String[] workingApp = {"Built-in","通訊","工具","社交","生產應用","解謎","街機","購物","策略","生活品味",};
//	public String[] entertainmentApp = {"Built-in","通訊","工具","社交","生產應用","解謎","街機","生活品味","新聞與雜誌","健康塑身",};
//	public String[] shoppingApp = {"Built-in","通訊","生產應用","社交","工具","街機","生活品味","購物","解謎","健康塑身",};
	
	// imei 353567051353648
//	public String[] diningApp = {"Built-in","工具","通訊","休閒","社交","商業","生產應用","媒體與影片","購物","財經",};
//	public String[] transportationApp = {"Built-in","通訊","工具","社交","商業","購物","財經","生產應用","休閒","攝影",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","通訊","工具","社交","新聞與雜誌","商業","財經","購物","生產應用","攝影",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354810
//	public String[] diningApp = {"Built-in","社交","工具","媒體與影片","生產應用","新聞與雜誌","旅遊與地方資訊","音樂與音效","通訊","生活品味",};
//	public String[] transportationApp = {"Built-in","社交","工具","生產應用","通訊","音樂與音效","媒體與影片","新聞與雜誌","旅遊與地方資訊","生活品味",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","旅遊與地方資訊","工具","通訊","社交","生活品味","購物","媒體與影片","新聞與雜誌","生產應用",};
//	public String[] entertainmentApp = {"Built-in","工具","旅遊與地方資訊","生活品味","購物","圖書與參考資源","社交","通訊","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354901
//	public String[] diningApp = {"Built-in","社交","通訊","解謎","新聞與雜誌","個人化","休閒","賽車遊戲","生產應用","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","解謎","個人化","社交","通訊","休閒","生活品味","新聞與雜誌","賽車遊戲","生產應用",};
//	public String[] entertainmentApp = {"Built-in","社交","休閒","解謎","工具","賽車遊戲","生產應用","冒險","新聞與雜誌","個人化",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"Built-in","社交","工具","新聞與雜誌","旅遊與地方資訊","通訊","生活品味","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","社交","通訊","工具","旅遊與地方資訊","生活品味","新聞與雜誌","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 355027051966921
//	public String[] diningApp = {"Built-in","社交","通訊","生產應用","新聞與雜誌","旅遊與地方資訊","街機","null","null","null",};
//	public String[] transportationApp = {"Built-in","社交","生產應用","通訊","新聞與雜誌","旅遊與地方資訊","街機","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","社交","生產應用","通訊","新聞與雜誌","旅遊與地方資訊","街機","工具","健康塑身","媒體與影片",};
//	public String[] entertainmentApp = {"Built-in","社交","生產應用","街機","新聞與雜誌","旅遊與地方資訊","通訊","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355027054515550
//	public String[] diningApp = {"Built-in","工具","生產應用","社交","通訊","解謎","新聞與雜誌","旅遊與地方資訊","健康塑身","交通運輸",};
//	public String[] transportationApp = {"Built-in","工具","社交","生產應用","通訊","解謎","商業","交通運輸","新聞與雜誌","旅遊與地方資訊",};
//	public String[] sportingApp = {"Built-in","工具","生產應用","通訊","社交","商業","null","null","null","null",};
//	public String[] workingApp = {"Built-in","工具","社交","通訊","生產應用","新聞與雜誌","旅遊與地方資訊","商業","解謎","交通運輸",};
//	public String[] entertainmentApp = {"Built-in","工具","社交","生產應用","通訊","解謎","新聞與雜誌","個人化","旅遊與地方資訊","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355387051404228
//	public String[] diningApp = {"Built-in","通訊","個人化","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","通訊","個人化","娛樂","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355859056961972
//	public String[] diningApp = {"Built-in","通訊","工具","社交","新聞與雜誌","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"Built-in","通訊","社交","工具","新聞與雜誌","null","null","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"Built-in","通訊","工具","社交","新聞與雜誌","null","null","null","null","null",};
	
	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"Built-in","工具","攝影","通訊","解謎","休閒","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","解謎","工具","攝影","通訊","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"Built-in","社交","圖書與參考資源","通訊","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"Built-in","社交","通訊","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 864690022758703
//	public String[] diningApp = {"Built-in","個人化","通訊","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"Built-in","通訊","社交","工具","財經","個人化","動作","媒體與影片","旅遊與地方資訊","策略",};
//	public String[] workingApp = {"Built-in","通訊","工具","個人化","媒體與影片","生活品味","生產應用","動作","圖書與參考資源","社交",};
//	public String[] entertainmentApp = {"Built-in","通訊","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};



	
	
	
	
	
	
	
	
	
	
	
	
	
	// top 10 (category, tf idf)
	// imei 353567051351832
//	public String[] diningApp = {"財經","旅遊與地方資訊","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"音樂與音效","旅遊與地方資訊","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"音樂與音效","天氣","交通運輸","財經","null","null","null","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051351956
//	public String[] diningApp = {"生產應用","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"生產應用","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"策略","財經","天氣","教育","動作","圖書與參考資源","null","null","null","null",};
//	public String[] transportationApp = {"攝影","策略","財經","天氣","圖書與參考資源","旅遊與地方資訊","null","null","null","null",};
//	public String[] sportingApp = {"休閒","天氣","策略","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"策略","圖書與參考資源","天氣","旅遊與地方資訊","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"旅遊與地方資訊","策略","圖書與參考資源","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"天氣","旅遊與地方資訊","財經","null","null","null","null","null","null","null",};		
	
	// imei 353567051353648
//	public String[] diningApp = {"媒體與影片","旅遊與地方資訊","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"圖書與參考資源","解謎","生活品味","媒體與影片","娛樂","旅遊與地方資訊","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354810
//	public String[] diningApp = {"媒體與影片","生產應用","健康塑身","音樂與音效","攝影","null","null","null","null","null",};
//	public String[] transportationApp = {"生產應用","音樂與音效","媒體與影片","健康塑身","策略","攝影","天氣","購物","圖書與參考資源","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"購物","媒體與影片","生產應用","音樂與音效","天氣","攝影","圖書與參考資源","null","null","null",};
//	public String[] entertainmentApp = {"購物","圖書與參考資源","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354901
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"生活品味","博奕","媒體與影片","動作","娛樂","策略","冒險","null","null","null",};
//	public String[] entertainmentApp = {"冒險","策略","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"健康塑身","媒體與影片","圖書與參考資源","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355027054515550
	public String[] diningApp = {"健康塑身","交通運輸","旅遊與地方資訊","個人化","商業","null","null","null","null","null",};
	public String[] transportationApp = {"交通運輸","商業","旅遊與地方資訊","null","null","null","null","null","null","null",};
	public String[] sportingApp = {"商業","null","null","null","null","null","null","null","null","null",};
	public String[] workingApp = {"健康塑身","交通運輸","旅遊與地方資訊","商業","財經","媒體與影片","博奕","個人化","null","null",};
	public String[] entertainmentApp = {"個人化","旅遊與地方資訊","null","null","null","null","null","null","null","null",};
	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"娛樂","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355859056961972
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"休閒","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"圖書與參考資源","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 864690022758703
//	public String[] diningApp = {"個人化","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"社交","財經","動作","媒體與影片","旅遊與地方資訊","策略","個人化","null","null","null",};
//	public String[] workingApp = {"生活品味","生產應用","媒體與影片","圖書與參考資源","個人化","動作","商業","社交","新聞與雜誌","旅遊與地方資訊",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/* top 10, category + package name, frequency */

	// imei 353567051351832
//	public String[] diningApp = {"工具","通訊","社交","新聞與雜誌","com.google.process.location","com.htc.idlescreen.shortcut","媒體與影片","com.google.android.gsf.login","com.android.systemui","com.android.location.fused",};
//	public String[] transportationApp = {"工具","通訊","社交","新聞與雜誌","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused","com.android.nfc","com.htc.studio.pm.android",};
//	public String[] sportingApp = {"通訊","工具","社交","媒體與影片","音樂與音效","新聞與雜誌","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"通訊","社交","生產應用","新聞與雜誌","工具","com.android.nfc","com.htc.studio.pm.android","com.google.process.location","system","com.android.mms",};
//	public String[] transportationApp = {"通訊","社交","新聞與雜誌","工具","com.htc.resetnotify","com.android.nfc","com.htc.studio.pm.android","com.google.process.location","system","android.process.media",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"通訊","工具","社交","生產應用","com.htc.ml.transportation","com.android.nfc","com.htc.studio.pm.android","com.google.process.location","com.android.updater","system",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"通訊","工具","社交","新聞與雜誌","com.htc.idlescreen.shortcut","android.process.acore","com.example.nctuhtclogger","com.android.phone","com.android.htcdialer","com.google.process.gapps",};
//	public String[] transportationApp = {"通訊","工具","社交","新聞與雜誌","生產應用","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused","com.android.nfc",};
//	public String[] sportingApp = {"通訊","工具","生產應用","社交","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused","新聞與雜誌","com.android.nfc",};
//	public String[] workingApp = {"通訊","工具","社交","生產應用","新聞與雜誌","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused","com.android.nfc",};
//	public String[] entertainmentApp = {"通訊","工具","社交","新聞與雜誌","生產應用","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused","com.android.nfc",};
//	public String[] shoppingApp = {"通訊","生產應用","社交","工具","新聞與雜誌","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused","com.android.nfc",};

	// imei 353567051353648
//	public String[] diningApp = {"社交","通訊","工具","生產應用","購物","新聞與雜誌","休閒","com.android.settings","攝影","com.google.process.location",};
//	public String[] transportationApp = {"社交","通訊","工具","購物","生產應用","攝影","新聞與雜誌","com.google.process.location","商業","com.google.android.googlequicksearchbox:search",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"社交","通訊","工具","新聞與雜誌","購物","生產應用","攝影","com.htc.idlescreen.shortcut","com.tencent.mm:push","android.process.acore",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354810
//	public String[] diningApp = {"社交","新聞與雜誌","工具","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","com.android.location.fused","com.android.nfc","system","com.sina.mfweibo",};
//	public String[] transportationApp = {"社交","新聞與雜誌","工具","生產應用","com.android.settings","com.google.process.location","com.android.systemui","com.android.location.fused","com.android.nfc","system",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"新聞與雜誌","旅遊與地方資訊","com.google.process.location","com.android.systemui","com.android.location.fused","com.android.nfc","system","android.process.acore","com.htc.bgp","com.htc.android.htcime",};
//	public String[] entertainmentApp = {"工具","旅遊與地方資訊","com.htc.cloudstorage.dropbox","購物","com.android.settings","com.android.nfc","com.htc.studio.pm.android","com.google.process.location","com.htc.pen","system",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354901
//	public String[] diningApp = {"社交","新聞與雜誌","生產應用","通訊","com.baidu.netdisk","工具","com.android.nfc","com.google.process.location","system","android.process.media",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"社交","新聞與雜誌","生產應用","工具","解謎","com.google.process.location","com.htc.idlescreen.shortcut","com.android.systemui","個人化","com.android.location.fused",};
//	public String[] entertainmentApp = {"社交","工具","生產應用","新聞與雜誌","com.android.settings","com.android.nfc","com.google.process.location","com.htc.opensense.social","system","com.htc.idlescreen.base",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"工具","社交","新聞與雜誌","通訊","com.android.settings","com.android.nfc","com.google.process.location","system","com.sina.mfweibo","android.process.media",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"通訊","工具","社交","新聞與雜誌","com.google.process.location","com.htc.idlescreen.Nolockscreen","com.google.android.gms.wearable","com.android.browser","com.google.android.googlequicksearchbox:search","com.android.systemui",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 355027051966921
//	public String[] diningApp = {"通訊","社交","工具","生產應用","新聞與雜誌","com.htc.htcdialer","com.android.settings","com.google.android.gms.unstable","com.google.process.location","com.android.camera",};
//	public String[] transportationApp = {"通訊","社交","工具","生產應用","新聞與雜誌","com.htc.htcdialer","com.android.settings","com.google.process.location","com.android.camera","教育",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"通訊","社交","工具","生產應用","新聞與雜誌","com.google.process.location","教育","com.google.android.gms.wearable","com.google.android.googlequicksearchbox:search","com.android.systemui",};
//	public String[] entertainmentApp = {"社交","通訊","工具","生產應用","新聞與雜誌","com.htc.htcdialer","com.android.settings","街機","com.google.process.location","com.android.camera",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355027054515550
//	public String[] diningApp = {"工具","通訊","生產應用","社交","新聞與雜誌","解謎","com.cleanmaster.mguard:service","街機","com.google.process.location","com.android.camera",};
//	public String[] transportationApp = {"工具","通訊","社交","生產應用","解謎","新聞與雜誌","com.htc.htcdialer","com.android.settings","com.cleanmaster.mguard:service","街機",};
//	public String[] sportingApp = {"通訊","工具","生產應用","社交","com.htc.htcdialer","com.android.settings","com.cleanmaster.mguard:service","com.android.chrome:sandboxed_process0","街機","com.google.android.gms.unstable",};
//	public String[] workingApp = {"通訊","工具","社交","生產應用","新聞與雜誌","解謎","com.cleanmaster.mguard:service","街機","com.google.process.location","教育",};
//	public String[] entertainmentApp = {"工具","通訊","社交","生產應用","解謎","新聞與雜誌","com.htc.htcdialer","com.android.settings","com.android.chrome:sandboxed_process1","com.cleanmaster.mguard:service",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355387051404228
//	public String[] diningApp = {"通訊","工具","社交","com.sonyericsson.psm.sysmonservice","com.sonyericsson.tvout.mhl","com.sonyericsson.smartcard","com.sonyericsson.pws","com.sonyericsson.android.bootinfo:remote","com.sonymobile.dlna","com.android.nfc",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"通訊","工具","社交","com.sonyericsson.psm.sysmonservice","com.sonyericsson.smartcard","com.sonyericsson.android.bootinfo:remote","com.sonymobile.photoanalyzer","com.google.process.location","com.sonyericsson.home","com.sonyericsson.advancedwidget.clock:lockscreen",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355859056961972
//	public String[] diningApp = {"通訊","社交","工具","com.sina.weibo:remote","com.htc.htcdialer","com.android.settings","com.android.nfc","org.simalliance.openmobileapi.service:remote","com.google.process.location","system",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"社交","通訊","com.sina.weibo:remote","com.htc.htcdialer","com.android.settings","工具","com.android.nfc","org.simalliance.openmobileapi.service:remote","com.google.process.location","system",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"通訊","社交","工具","com.sina.weibo:remote","com.htc.htcdialer","com.android.settings","com.android.nfc","org.simalliance.openmobileapi.service:remote","com.google.process.location","system",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"工具","社交","通訊","com.google.process.location","com.htc.clock3dwidget","媒體與影片","com.google.android.gsf.login","com.android.systemui","com.zdworks.android.toolbox:zdbox","com.android.htccontacts",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"工具","社交","通訊","com.android.settings","com.android.chrome:sandboxed_process0","com.htc.htcMessageUploader","攝影","com.google.process.location","com.htc.smartnetwork","system",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"通訊","工具","社交","com.xiaomi.xmsf","com.qualcomm.services.location","com.android.settings","com.android.calendar","com.google.android.gms.unstable","com.android.nfc","com.google.process.location",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"社交","通訊","工具","com.xiaomi.xmsf","com.miui.cloudservice","com.qualcomm.services.location","com.sina.weibo:remote","com.android.settings","com.miui.gallery","com.svox.pico",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 864690022758703
//	public String[] diningApp = {"工具","com.xiaomi.xmsf","com.qualcomm.services.location","com.android.settings","com.android.calendar","com.miui.weather2:weatherservice","com.svox.pico","com.android.nfc","com.google.process.location","system",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"通訊","工具","社交","com.xiaomi.xmsf","com.android.settings","com.android.calendar","com.miui.weather2:weatherservice","com.google.process.location","com.android.mms","com.miui.miwallpaper",};
//	public String[] workingApp = {"工具","通訊","com.xiaomi.xmsf","com.android.settings","com.android.calendar","com.google.process.location","com.android.mms","com.miui.miwallpaper","com.miui.networkassistant","com.android.smspush",};
//	public String[] entertainmentApp = {"工具","com.miui.cloudservice","com.xiaomi.xmsf","com.qualcomm.services.location","com.android.settings","com.miui.gallery","com.android.calendar","com.miui.weather2:weatherservice","com.svox.pico","com.miui.bugreport",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};


	
	
	
	
	
	
	
	
	
	
	
	/* top 10, category + package name, TF-IDF */
	// imei 353567051351832
//	public String[] diningApp = {"com.facebook.katana:dash","com.google.android.music:main","財經","com.htc.widget.process2","com.htc.dnatransfer","com.htc.calendar","com.htc.cs.dm","jp.naver.line.android:sub","com.htc.ml.transportation","com.htc.AutoMotive",};
//	public String[] transportationApp = {"org.mozilla.firefox.UpdateService","jp.naver.line.android:sub","com.android.bluetooth","com.google.android.googlequicksearchbox:search","音樂與音效","旅遊與地方資訊","com.htc.bluetooth.le.profiles","com.fd.httpd","com.htc.opensense.social","com.htc.widget.process2",};
//	public String[] sportingApp = {"音樂與音效","天氣","com.android.bluetooth","com.htc.bluetooth.le.profiles","com.nuangjamnong.magicmancamera","com.google.android.googlequicksearchbox:search","交通運輸","com.android.mms","com.htc.opensense.social","com.htc.resetnotify",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"com.android.mms","生產應用","com.htc.notes:NotesService","com.google.android.gsf.login","com.htc.android.htcime:provider_latin","com.htc.cs.dm","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.resetnotify","com.android.settings","com.google.android.googlequicksearchbox:search","com.htc.idlescreen.base","com.htc.cs.dm","com.fd.httpd","com.htc.syncagent","com.htc.task","com.htc.notes:NotesService","com.htc.android.mail:sync",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.ml.transportation","com.android.updater","com.sdgtl.watch","com.google.android.partnersetup","com.android.htccontacts","生產應用","com.htc.idlescreen.base","com.htc.task","com.google.android.googlequicksearchbox:search","com.htc.android.mail:sync",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.htc.widget.process4","com.htc.photoenhancer","com.htc.framework","com.htc.wifidisplay","com.htc.home.personalize","com.android.camera","策略","com.taobao.taobao:notify","com.htc.ml.transportation","com.android.chrome:sandboxed_process0",};
//	public String[] transportationApp = {"com.dexetra.friday:fridayservice","com.nike.plusgps:remote","com.htc.ml.transportation","android.process.htcmessage","com.taobao.taobao:notify","com.htc.android.htcime:provider_latin","com.htc.widget.process4","com.htc.ml.transportation:remote","com.htc.widget.process1","com.android.chrome:sandboxed_process0",};
//	public String[] sportingApp = {"休閒","com.htc.aurora","com.htc.AutoMotive","天氣","策略","system:ui","com.dotgears.flappybird","com.taobao.taobao:notify","null","null",};
//	public String[] workingApp = {"com.htc.photoenhancer","com.htc.framework","com.htc.wifidisplay","com.htc.home.personalize","策略","com.htc.plugin.news","com.htc.widget.process1","com.htc.widget.process4","com.taobao.taobao:notify","com.dexetra.trail:trailservice",};
//	public String[] entertainmentApp = {"com.htc.socialnetwork.facebook","com.htc.ml.transportation","com.android.htccontacts","com.htc.android.htcime:provider","com.android.packageinstaller","com.htc.sensetv_home","com.google.android.syncadapters.calendar","com.htc.widget.process1","旅遊與地方資訊","jp.naver.android.npush",};
//	public String[] shoppingApp = {"com.dexetra.trail:trailsync","com.dexetra.trail:trailservice","com.nike.plusgps:remote","com.htc.android.htcime:provider_latin","jp.naver.line.android:sub","jp.naver.android.npush","com.htc.widget.process1","com.dexetra.friday:fridaysync","天氣","com.android.settings:remote",};
	
	// imei 353567051353648
//	public String[] diningApp = {"com.sina.mfweibo.image","com.android.settings","com.htc.idlescreen.base","com.android.mms","com.wmyc.activity","jp.naver.android.npush","com.taobao.taobao:PushService_v1","com.htc.widget.process1","com.taobao.taobao:containerprocess2","com.android.browser",};
//	public String[] transportationApp = {"com.liulishuo.engzo:bdservice_v1","com.htc.dnatransfer","com.taobao.appcenter:notify","com.google.android.gsf.login","com.yahoo.mobile.client.android.weather:com.yahoo.snp.service","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.opensense.social","com.android.vending","com.htc.socialnetwork.wechatplugin","com.google.android.music:main","com.google.android.partnersetup","com.htc.widget.process1","com.htc.android.mail:sync","com.google.android.syncadapters.calendar","圖書與參考資源","com.htc.task.gtask",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};	
	
	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.htc.opensense.social","媒體與影片","com.google.android.apps.uploader","生產應用","com.htc.widget.process2","com.android.vending","com.google.android.partnersetup","com.htc.android.mail:sync","健康塑身",};
//	public String[] transportationApp = {"com.htc.ml.transportation","com.htc.ml.transportation:remote","生產應用","com.htc.idlescreen.shortcut","tunein.service","com.htc.widget.process2","com.google.android.music:main","net.avs234:remote","com.google.android.syncadapters.calendar","com.htc.opensense.social",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.widget.process2","com.htc.idlescreen.shortcut","com.google.android.googlequicksearchbox:search","com.htc.reportagent","com.htc.opensense.social","com.fd.httpd","com.htc.htcMessageUploader","com.iknow99.ezetc:post","購物","com.htc.idlescreen.Nolockscreen",};
//	public String[] entertainmentApp = {"com.htc.cloudstorage.dropbox","com.htc.pen","com.android.defcontainer","購物","圖書與參考資源","com.htc.idlescreen.Nolockscreen","com.htc.task","com.htc.widget.process4","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.baidu.netdisk","com.baidu.netdisk:bdservice_v1","com.google.android.gms.drive","com.thepixelizers.android.opensea.ui.gold","com.baidu.netdisk:remote","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"生活品味","com.baidu.netdisk","com.baidu.netdisk:bdservice_v1","com.thepixelizers.android.opensea.ui.gold","com.htc.pen","com.htc.reportagent","com.google.android.gms.drive","com.htc.opensense.social","博奕","com.htc.task",};
//	public String[] entertainmentApp = {"com.htc.opensense.social","com.android.packageinstaller","com.google.android.music:main","com.htc.task","com.htc.android.mail:sync","com.google.android.gsf.login","冒險","com.htc.widget.process3","com.htc.sensetv_home","com.htc.cs.dm",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.widget.process3","com.htc.android.mail:sync","com.google.android.gms.drive","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.dnatransfer","com.htc.showme","com.htc.reportagent","com.htc.opensense.social","com.htc.cs.dm","com.android.htccontacts","com.htc.resetnotify","com.htc.launcher.fakescreen","com.htc.stock:remote","com.google.android.gms:snet",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 355027051966921
//	public String[] diningApp = {"com.facebook.katana:nodex","com.htc.widget.process1","com.android.chrome:sandboxed_process10","com.android.chrome:sandboxed_process4","com.google.android.gms.unstable","com.htc.opensense.social","com.htc.friendstream.sinaweiboplugin","com.htc.widget.process4","com.android.chrome:sandboxed_process0","com.android.systemui:recentapp",};
//	public String[] transportationApp = {"com.android.chrome:sandboxed_process5","jp.naver.line.android:upload","com.android.chrome:sandboxed_process7","com.android.chrome:sandboxed_process6","com.htc.friendstream.sinaweiboplugin","com.android.systemui:recentapp","com.htc.widget.process4","com.android.chrome:sandboxed_process4","com.htc.shoebox.engine.relevance","com.htc.android.htcime",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.plugin.news","com.htc.mms.backupagent","com.htc.cs","com.htc.friendstream.sinaweiboplugin","com.htc.widget.process1","com.htc.android.mail:sync","com.htc.widget.process4","com.android.chrome:sandboxed_process0","com.google.android.gms.unstable","com.htc.opensense.social",};
//	public String[] entertainmentApp = {"com.htc.android.mail:sync","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355027054515550
//	public String[] diningApp = {"com.htc.mms.backupagent","健康塑身","com.htc.widget.process1","jp.naver.pick:service","com.htc.widget.process2","交通運輸","com.google.android.music:main","com.popoinnovation.nowin","com.hyxen.app.RailTimeline:adlocus","com.google.android.setupwizard",};
//	public String[] transportationApp = {"交通運輸","com.google.android.music:main","jp.naver.pick:service","com.htc.widget.process2","com.google.android.gms.unstable","商業","com.popoinnovation.nowin","com.hyxen.app.RailTimeline:adlocus","com.google.android.setupwizard","旅遊與地方資訊",};
//	public String[] sportingApp = {"com.android.chrome:sandboxed_process3","com.android.providers.partnerbookmarks","com.android.chrome:sandboxed_process0","com.android.chrome:sandboxed_process2","com.google.android.partnersetup","com.jumplife.tvdrama","com.google.android.gms.unstable","商業","com.android.vending","com.google.android.setupwizard",};
//	public String[] workingApp = {"jp.naver.pick:service","com.htc.widget.process2","com.htc.task","com.google.android.partnersetup","com.htc.launcher.add_to_home","com.htc.aurora","com.htc.widget.process1","com.google.android.music:main","健康塑身","交通運輸",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.android.chrome:sandboxed_process1","com.android.systemui:recentapp","com.htc.android.mail:sync","com.htc.shoebox.engine.relevance","com.htc.reportagent","com.android.chrome:sandboxed_process0","com.google.android.partnersetup","個人化","com.popoinnovation.nowin",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"com.sonyericsson.conversations","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","娛樂","com.sonyericsson.android.smartsearch","com.madhead.tos.zh.ex:NotificationReceiver","com.sonyericsson.android.socialphonebook","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"com.htc.dnatransfer","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.htc.friendstream.sinaweiboplugin","com.htc.cs","com.google.android.partnersetup","com.htc.shoebox.engine.relevance","com.htc.providers.settings:remote","com.htc.android.htcime:contactDB","com.android.defcontainer","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"com.htc.dnatransfer","null","null","null","null","null","null","null","null","null",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.android.mms","com.tunewiki.lyricplayer.android:player","com.inventec.dreye.htc","com.htc.idlescreen.base","com.htc.calendar","com.htc.android.htcime:provider_latin","com.htc.dockmode","com.htc.socialnetwork.facebook","com.htc.rosiewidgets.showme",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.chrome:sandboxed_process0","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.calendar","com.google.android.gms.unstable","圖書與參考資源","android.process.media","com.android.deskclock","com.google.android.partnersetup","com.google.android.googlequicksearchbox:search","com.android.providers.calendar","com.xiaomi.mitunes","com.trafficctr.miui",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.miui.cloudservice","com.sina.weibo:remote","com.miui.gallery","com.svox.pico","com.miui.bugreport","com.android.updater","com.moji.mjweather:pushservice","com.android36kr.app.pushservice","com.android.mms","com.android.packageinstaller",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 864690022758703
//	public String[] diningApp = {"com.android.thememanager","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.android.deskclock","com.google.android.partnersetup","com.google.android.googlequicksearchbox:search","com.miui.guardprovider","com.qualcomm.cabl","com.xiaomi.mitunes","個人化",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"社交","com.expensemanager:remote","財經","com.google.android.gms.wearable","com.android.browser","com.miui.weather2:reportweatherservice","com.miui.gallery","com.android.updater","com.android.vending","com.android.deskclock",};
//	public String[] workingApp = {"生活品味","生產應用","com.google.android.gms.wearable","com.miui.weather2:reportweatherservice","com.android.updater","com.miui.weather2:receiverreportweather","com.android.vending","system:ui","com.google.android.gms.maps","媒體與影片",};
//	public String[] entertainmentApp = {"com.miui.bugreport","com.miui.backup","jp.naver.android.npush","com.miui.cloudservice","com.miui.gallery","com.android.updater","com.miui.weather2:receiverreportweather","com.android.thememanager","com.android.vending","com.android.browser",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

}
