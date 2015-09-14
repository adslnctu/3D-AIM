package Model;
/*
	entropy frequency和frequency好像顛倒
*/
public class AppUsage {
	
	public int topK = 10;
	
	/* TF-IDF */
	// imei 353567051351832
	public String[] diningApp = {"com.facebook.katana:dash","com.htc.backup","com.google.android.music:main","com.mtk","com.htc.widget.process2","com.htc.dnatransfer","com.htc.calendar","com.htc.cs.dm","jp.naver.line.android:sub","com.htc.ml.transportation",};
	public String[] transportationApp = {"org.mozilla.firefox.UpdateService","jp.naver.line.android:sub","com.google.android.googlequicksearchbox:search","com.google.android.apps.maps","com.google.android.tts","com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","com.fd.httpd","com.android.chrome",};
	public String[] sportingApp = {"com.htc.Weather","com.htc.album","com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","com.kkbox.alc.android","com.nuangjamnong.magicmancamera","com.google.android.googlequicksearchbox:search","idv.nightgospel.TWRailScheduleLookUp","com.skype.raider",};
	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};	
	
	// imei 353567051351956
//	public String[] diningApp = {"com.android.mms","com.skype.raider","com.google.android.calendar","com.google.android.apps.magazines","com.htc.cs.dm","com.google.android.talk","com.google.android.gm","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin",};
//	public String[] transportationApp = {"com.htc.resetnotify","com.android.settings","com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk","com.htc.android.worldclock","com.htc.cs.dm","com.htc.idlescreen.base","com.fd.httpd",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup","com.android.updater","com.android.htccontacts","com.htc.task","com.google.android.googlequicksearchbox:search","com.htc.android.worldclock","com.google.android.calendar","com.google.android.gm",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.htc.widget.process4","com.htc.framework","com.htc.wifidisplay","com.htc.photoenhancer","com.alibaba.mobileim","com.htc.backup","com.htc.home.personalize","com.twitter.android","com.android.camera","com.supercell.clashofclans",};
//	public String[] transportationApp = {"com.ertanto.kompas.official","com.oovoo","com.dexetra.friday:fridayservice","com.nike.plusgps:remote","com.htc.ml.transportation","com.bbm","android.process.htcmessage","com.alibaba.mobileim","com.dexetra.friday","com.taobao.taobao:notify",};
//	public String[] sportingApp = {"org.orangenose.games","com.htc.aurora","com.htc.AutoMotive","com.htc.Weather","com.alibaba.mobileim","com.supercell.clashofclans","com.htc.android.worldclock","system:ui","com.dotgears.flappybird","com.taobao.taobao:notify",};
//	public String[] workingApp = {"com.htc.framework","com.htc.wifidisplay","com.htc.photoenhancer","com.oovoo","com.htc.home.personalize","com.supercell.clashofclans","com.htc.backup","com.bbm","com.alibaba.mobileim","com.htc.plugin.news",};
//	public String[] entertainmentApp = {"com.ertanto.kompas.official","com.htc.socialnetwork.facebook","com.htc.ml.transportation","com.htc.android.worldclock","com.htc.android.htcime:provider","com.google.android.apps.docs","com.android.htccontacts","com.google.android.googlequicksearchbox","com.android.packageinstaller","com.htc.sensetv_home",};
//	public String[] shoppingApp = {"com.oovoo","com.dexetra.trail:trailsync","com.dexetra.trail","com.dexetra.trail:trailservice","com.nike.plusgps:remote","com.htc.android.htcime:provider_latin","com.bbm","jp.naver.line.android:sub","jp.naver.android.npush","jp.naver.SJLINEPANG",};

	
	// imei 353567051353648
//	public String[] diningApp = {"com.sina.mfweibo.image","com.gameloft.android.ANMP.GloftDMHM","com.android.settings","com.skype.android.access","jp.naver.android.npush","com.htc.idlescreen.base","com.wmyc.activity","com.htc.widget.process1","com.android.mms","com.taobao.taobao:containerprocess2",};
//	public String[] transportationApp = {"com.android.chrome","com.htc.dnatransfer","com.magisto","com.taobao.appcenter:notify","com.yahoo.mobile.client.android.weather:com.yahoo.snp.service","com.google.android.apps.unveil","com.liulishuo.engzo:bdservice_v1","com.sf.activity","com.google.android.gsf.login","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.opensense.social","com.android.vending","com.google.android.gm","com.htc.socialnetwork.wechatplugin","com.google.android.keep","com.google.android.music:main","com.google.android.partnersetup","com.htc.widget.process1","com.htc.android.mail:sync","com.google.android.syncadapters.calendar",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.google.android.youtube","com.google.android.apps.uploader","com.htc.opensense.social","com.google.android.apps.plus","com.htc.widget.process2","com.facebook.katana","com.android.vending","com.google.android.partnersetup","com.google.android.googlequicksearchbox",};
//	public String[] transportationApp = {"com.htc.ml.transportation:remote","com.htc.ml.transportation","com.htc.idlescreen.shortcut","tunein.service","com.htc.widget.process2","com.facebook.katana","com.google.android.music:main","net.avs234:remote","com.google.android.syncadapters.calendar","com.google.android.apps.plus",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"ecowork.housefun","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.google.android.googlequicksearchbox:search","com.htc.reportagent","com.tencent.mm","org.mozilla.firefox","com.google.android.apps.plus","com.htc.opensense.social","com.fd.httpd",};
//	public String[] entertainmentApp = {"com.htc.cloudstorage.dropbox","com.htc.pen","mong.moptt","com.android.defcontainer","com.htc.task","com.htc.idlescreen.Nolockscreen","com.ddim.happygo","com.she.eReader","com.google.android.tts","com.htc.widget.process4",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.beetalk","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.google.android.gms.drive","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","jp.naver.line.android","com.baidu.netdisk:remote","com.google.android.apps.genie.geniewidget","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"tw.com.mcd.mcdalarm","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","jp.naver.line.android","com.htc.pen","com.htc.reportagent","com.beetalk","com.google.android.gms.drive",};
//	public String[] entertainmentApp = {"jp.co.applica.HomoxMarch","com.htc.task","com.htc.android.worldclock","kr.co.vcnc.android.couple","com.com2us.rooms.normal.freefull.google.global.android.common","com.android.packageinstaller","com.htc.android.mail:sync","com.htc.widget.process3","com.google.android.music:main","com.google.android.setupwizard",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.widget.process3","com.htc.android.worldclock","com.htc.android.mail:sync","com.google.android.gms.drive","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.dnatransfer","com.htc.reportagent","com.htc.showme","com.htc.cs.dm","com.htc.opensense.social","com.android.htccontacts","com.skype.raider","com.google.android.gms:snet","com.htc.socialnetwork.wechatplugin","com.htc.stock:remote",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.widget.process1","com.facebook.katana:nodex","com.android.chrome:sandboxed_process10","com.android.chrome:sandboxed_process4","com.htc.friendstream.sinaweiboplugin","com.google.android.gm","com.htc.widget.process4","com.google.android.gms.unstable","com.htc.opensense.social","com.android.systemui:recentapp",};
//	public String[] transportationApp = {"jp.naver.line.android:upload","com.android.chrome:sandboxed_process7","com.android.chrome:sandboxed_process6","com.android.chrome:sandboxed_process5","com.android.systemui:recentapp","com.htc.friendstream.sinaweiboplugin","com.htc.widget.process4","com.htc.android.htcime","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.plugin.news","com.htc.mms.backupagent","com.htc.cs","com.htc.friendstream.sinaweiboplugin","com.htc.widget.process1","com.htc.android.mail:sync","com.htc.widget.process4","com.google.android.gm","com.google.android.gms.unstable","com.android.chrome:sandboxed_process0",};
//	public String[] entertainmentApp = {"com.UfoCrashGames.FullBlast","com.htc.android.mail:sync","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355027054515550
//	public String[] diningApp = {"com.popularapp.periodcalendar","com.htc.widget.process1","com.htc.mms.backupagent","jp.naver.pick:service","com.htc.backup","com.htc.widget.process2","com.google.android.music:main","com.hyxen.app.RailTimeline","com.htc.android.worldclock","com.google.android.calendar",};
//	public String[] transportationApp = {"com.htc.backup","com.google.android.music:main","jp.naver.pick:service","com.htc.widget.process2","com.hyxen.app.RailTimeline","com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.google.android.gm","com.popoinnovation.nowin",};
//	public String[] sportingApp = {"com.android.chrome:sandboxed_process3","com.android.providers.partnerbookmarks","com.android.chrome:sandboxed_process0","com.google.android.partnersetup","com.android.chrome:sandboxed_process2","com.jumplife.tvdrama","com.htc.android.worldclock","com.google.android.calendar","com.google.android.gm","com.sina.weibo",};
//	public String[] workingApp = {"jp.naver.pick:service","com.htc.widget.process2","com.htc.task","com.google.android.partnersetup","com.htc.launcher.add_to_home","com.htc.aurora","com.htc.widget.process1","com.htc.backup","com.google.android.music:main","com.popularapp.periodcalendar",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.htc.android.mail:sync","com.android.chrome:sandboxed_process1","com.android.systemui:recentapp","com.htc.reportagent","com.htc.shoebox.engine.relevance","com.android.chrome:sandboxed_process0","com.google.android.partnersetup","com.tul.aviate","com.google.android.apps.magazines",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"com.sonyericsson.conversations","com.bbs.reader","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.facebook.orca","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","com.sonyericsson.xhs","com.sonyericsson.android.smartsearch","com.madhead.tos.zh.ex:NotificationReceiver","com.skype.raider","com.sonyericsson.android.socialphonebook","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	355859056961972
//	public String[] diningApp = {"com.htc.dnatransfer","com.htc.backup","com.google.android.talk","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.htc.friendstream.sinaweiboplugin","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB","com.htc.providers.settings:remote","com.google.android.partnersetup","com.htc.cs","com.android.defcontainer","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"com.htc.dnatransfer","com.htc.backup","com.google.android.talk","null","null","null","null","null","null","null"};
	
	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.android.worldclock","com.android.mms","com.lylynx.smsscheduler","com.inventec.dreye.htc","com.tunewiki.lyricplayer.android:player","com.htc.idlescreen.base","com.htc.calendar","com.htc.android.htcime:provider_latin","com.htc.dockmode",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.chrome","com.android.chrome:sandboxed_process0","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader","com.google.android.gms.unstable","com.renren.xiaonei.android","com.android.calendar","com.trafficctr.miui","com.android.providers.calendar",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo","com.duomi.android.manufacturer","com.android.fileexplorer","com.xiaomi.channel","com.sohu.inputmethod.sogou:pushservice","com.android.updater",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 864690022758703
//	public String[] diningApp = {"com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.android.deskclock","com.qualcomm.cabl","com.android.thememanager","com.tul.aviate","com.trafficctr.miui","com.qualcomm.svi","com.miui.guardprovider",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.facebook.katana","com.facebook.orca","com.android.chrome","com.expensemanager:remote","com.expensemanager","com.foursquare.robin","com.joelapenna.foursquared","com.google.android.gms.wearable","com.google.android.apps.plus","com.google.android.talk",};
//	public String[] workingApp = {"com.dexetra.friday","com.google.android.gms.wearable","com.google.android.talk","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","jp.naver.line.android","com.google.android.apps.docs","com.google.android.youtube",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","com.miui.backup","com.miui.bugreport","jp.naver.line.android:sub","com.android.vending","com.android.fileexplorer:remote","com.android.updater","com.android.thememanager","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	/* TF-IDF */
	
	
	
	
	
	/* Frequency */

	// imei 353567051351832
//	public String[] diningApp = {"com.google.android.music:main","com.mtk","jp.naver.android.npush","com.htc.widget.process2","com.facebook.katana:dash","tunein.service","com.google.android.googlequicksearchbox","com.google.android.gsf.login","com.htc.studio.pm.android","com.google.android.youtube",};
//	public String[] transportationApp = {"com.htc.studio.pm.android","jp.naver.line.android","com.google.android.gms","com.facebook.katana","com.sina.mfweibo","com.google.android.gsf.login","com.google.android.gm","com.google.android.youtube","com.android.settings","net.emome.hamiapps.am",};
//	public String[] sportingApp = {"com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","tunein.service","com.google.android.partnersetup","com.facebook.katana","com.google.android.youtube","com.google.android.gms","jp.naver.line.android","com.android.settings",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"com.android.mms","com.skype.raider","com.google.android.apps.magazines","com.google.android.talk","com.htc.cs.dm","com.google.android.calendar","com.google.android.gm","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin",};
//	public String[] transportationApp = {"com.htc.resetnotify","com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk","com.android.settings","com.htc.android.worldclock","com.htc.cs.dm","com.htc.idlescreen.base","com.htc.task",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup","com.android.updater","com.android.htccontacts","com.google.android.googlequicksearchbox:search","com.htc.android.worldclock","com.htc.idlescreen.base","com.htc.task","com.google.android.calendar",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.facebook.katana","com.htc.studio.pm.android","com.facebook.orca","com.htc.bgp","com.google.android.gms","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search","com.android.settings",};
//	public String[] transportationApp = {"com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.htcpowermanager:remote","com.htc.studio.pm.android","com.htc.widget.process2","com.android.settings","com.google.android.gms","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search",};
//	public String[] sportingApp = {"com.htc.studio.pm.android","com.facebook.katana","com.facebook.orca","com.htc.bgp","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.google.android.gms","com.google.android.googlequicksearchbox:search","com.rootuninstaller.taskbarw8","com.android.settings",};
//	public String[] workingApp = {"com.facebook.katana","com.htc.bgp","com.facebook.orca","com.htc.studio.pm.android","com.htc.widget.process2","com.google.android.gms","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search","com.htc.htcpowermanager:remote","com.google.android.gms.wearable",};
//	public String[] entertainmentApp = {"com.google.android.gms","com.htc.studio.pm.android","com.facebook.katana","com.facebook.orca","com.htc.bgp","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.rootuninstaller.taskbarw8","com.android.vending","com.google.android.googlequicksearchbox:search",};
//	public String[] shoppingApp = {"com.facebook.orca","com.htc.bgp","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.facebook.katana","jp.naver.line.android","com.oovoo","jp.naver.SJLGWR","com.google.android.gms","com.htc.studio.pm.android",};

	
	// imei 353567051353648
//	public String[] diningApp = {"com.htc.bgp","com.dazhihui.spsc","com.android.settings","com.htc.htcpowermanager:remote","com.sina.mfweibo","jp.naver.line.android","com.sina.mfweibo.image","com.gameloft.android.ANMP.GloftDMHM","com.google.android.gms","com.htc.studio.pm.android",};
//	public String[] transportationApp = {"com.netease.mobimail","com.sankuai.meituan","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.douban.group","com.yahoo.mobile.client.android.weather:com.yahoo.mobile.client.android.weather.service.WeatherServiceWatchdog","com.jiepang.android","com.magisto:automation_service","com.alibaba.mobileim","com.eg.android.AlipayGphone",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.bgp","com.dazhihui.spsc","com.netease.mobimail","com.sankuai.meituan","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.douban.group","com.yahoo.mobile.client.android.weather:com.yahoo.mobile.client.android.weather.service.WeatherServiceWatchdog","com.jiepang.android","com.magisto:automation_service",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.android.browser","com.android.settings","com.sina.mfweibo","com.htc.htcpowermanager:remote","com.htc.widget.process2","com.htc.opensense.social","com.google.android.youtube","com.google.android.apps.uploader","com.htc.idlescreen.base",};
//	public String[] transportationApp = {"com.android.settings","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.sina.mfweibo","com.google.android.gms","com.google.android.gsf.login","com.htc.idlescreen.base","android.process.media","com.facebook.katana",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.browser","com.google.android.apps.maps","com.android.settings","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.sina.mfweibo","com.htc.reportagent","com.google.android.gms","ecowork.housefun",};
//	public String[] entertainmentApp = {"com.htc.cloudstorage.dropbox","com.htc.idlescreen.Nolockscreen","tw.groupon","jp.naver.line.android","com.hovans.autoguard","com.google.android.tts","com.google.android.apps.maps","com.htc.pen","mong.moptt","com.android.defcontainer",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.google.android.googlequicksearchbox:search","com.beetalk",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","com.google.android.googlequicksearchbox:search","com.android.vending",};
//	public String[] entertainmentApp = {"jp.co.applica.HomoxMarch","com.htc.opensense.social","com.htc.task","kr.co.vcnc.android.couple","com.google.android.gsf.login","com.htc.idlescreen.base","com.android.packageinstaller","com.google.android.music:main","com.google.android.setupwizard","com.htc.sensetv_home",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.htcpowermanager:remote","com.android.settings","android.process.media","com.sina.mfweibo","com.google.android.apps.plus","com.google.android.tts","com.google.android.gsf.login","com.tencent.mm:push","com.htc.widget.process2","com.google.android.apps.maps",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.gsf.login","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.android.settings","android.process.media","com.sina.mfweibo","com.htc.backup","com.google.android.gm","com.google.android.partnersetup","com.google.android.apps.plus",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.widget.process1","com.google.android.gm","com.htc.friendstream.sinaweiboplugin","com.google.android.gms.unstable","la.droid.qr","com.sina.weibo","com.twitter.android","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android",};
//	public String[] transportationApp = {"com.google.android.music:main","com.google.android.setupwizard","com.htc.friendstream.sinaweiboplugin","la.droid.qr","com.sina.weibo","com.twitter.android","com.estrongs.android.pop","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.music:main","com.google.android.setupwizard","la.droid.qr","com.sina.weibo","com.twitter.android","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android","com.android.settings","com.htc.widget.process2",};
//	public String[] entertainmentApp = {"com.htc.android.mail:sync","com.UfoCrashGames.FullBlast","com.google.android.music:main","com.google.android.setupwizard","la.droid.qr","com.sina.weibo","com.twitter.android","com.estrongs.android.pop","com.google.android.apps.magazines","com.google.android.apps.maps",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"jp.naver.pick:service","com.google.android.gm","com.google.android.apps.magazines","com.twitter.android","com.google.android.setupwizard","com.google.android.calendar","com.htc.android.worldclock","la.droid.qr","com.cht.custservice","com.google.android.tts",};
//	public String[] transportationApp = {"com.htc.widget.process2","jp.naver.pick:service","com.mobisystems.office","com.sina.weibo","com.google.android.gm","com.google.android.gms.unstable","com.google.android.apps.maps","com.google.android.apps.magazines","com.twitter.android","com.google.android.setupwizard",};
//	public String[] sportingApp = {"com.android.chrome:sandboxed_process3","com.google.android.partnersetup","com.android.vending","com.mobisystems.office","com.htc.friendstream.sinaweiboplugin","com.android.providers.partnerbookmarks","com.sina.weibo","com.google.android.gm","com.google.android.gms.unstable","com.google.android.setupwizard",};
//	public String[] workingApp = {"jp.naver.pick:service","com.htc.widget.process2","com.android.vending","com.google.android.gm","jp.naver.line.android","com.sina.weibo","com.google.android.apps.magazines","com.twitter.android","com.google.android.setupwizard","com.google.android.apps.plus",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.google.android.partnersetup","com.android.chrome:sandboxed_process1","com.htc.friendstream.sinaweiboplugin","com.android.systemui:recentapp","com.htc.reportagent","com.htc.shoebox.engine.relevance","com.google.android.apps.maps","com.htc.android.mail:sync","com.google.android.apps.magazines",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"android.process.acore","com.sony.smallapp.managerservice","jp.naver.android.npush","com.sonyericsson.lockscreen.uxpnxt","com.sonyericsson.tvout.mhl","com.sonymobile.experienceflow2","com.sonyericsson.crashmonitor","com.google.android.talk","com.sonyericsson.android.locationbasedwifi:service","com.sonyericsson.conversations",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.sonymobile.experienceflow2","android.process.acore","com.facebook.orca","com.sonyericsson.crashmonitor","com.sony.smallapp.managerservice","jp.naver.android.npush","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","com.google.android.gm","com.google.android.talk",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"com.htc.dnatransfer","com.htc.backup","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.htc.friendstream.sinaweiboplugin","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB","com.htc.providers.settings:remote","com.google.android.partnersetup","com.htc.cs","com.android.defcontainer","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"com.htc.dnatransfer","com.htc.backup","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.android.worldclock","com.android.mms","com.htc.reportagent","com.htc.cs","com.lylynx.smsscheduler","com.htc.task","com.htc.notes","com.dale.doors.hundred.hardest","com.google.android.apps.translate",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.chrome","com.android.chrome:sandboxed_process0","com.htc.reportagent","com.htc.cs","com.htc.task","com.htc.notes","com.dale.doors.hundred.hardest","com.google.android.apps.translate","com.google.android.apps.uploader","com.yahoo.mobile.client.android.flickr:com.yahoo.snp.service",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader","com.google.android.gms.unstable","com.renren.xiaonei.android","com.android.calendar","com.trafficctr.miui","com.android.providers.calendar",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo","com.duomi.android.manufacturer","com.android.fileexplorer","com.xiaomi.channel","com.sohu.inputmethod.sogou:pushservice","com.android.updater",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 864690022758703
//	public String[] diningApp = {"com.android.thememanager","com.android.deskclock","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.qualcomm.cabl","com.tul.aviate","com.trafficctr.miui","com.qualcomm.svi","com.miui.guardprovider",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.facebook.katana","com.facebook.orca","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","jp.naver.line.android","com.android.chrome","com.expensemanager:remote","com.expensemanager","com.android.browser",};
//	public String[] workingApp = {"com.miui.weather2:receiverreportweather","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","jp.naver.line.android","com.android.thememanager","com.android.deskclock","com.google.android.gms.wearable","com.miui.home","com.dexetra.friday",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","com.miui.backup","com.miui.bugreport","com.android.thememanager","com.miui.weather2:receiverreportweather","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","jp.naver.line.android","com.android.fileexplorer:remote",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	/* Frequency */
	
	
	
	
	
	
	
	
	/* Entropy Frequency */

	// imei 353567051351832
//	public String[] diningApp = {"jp.naver.android.npush","com.google.android.youtube","com.htc.studio.pm.android","com.google.android.music:main","com.google.android.googlequicksearchbox","com.google.android.gms","com.google.android.gsf.login","jp.naver.line.android","com.google.android.gm","com.facebook.katana",};
//	public String[] transportationApp = {"com.htc.studio.pm.android","com.facebook.katana","com.google.android.gms","com.sina.mfweibo","jp.naver.line.android","com.google.android.youtube","com.google.android.gm","com.android.settings","com.google.android.gsf.login","net.emome.hamiapps.am",};
//	public String[] sportingApp = {"com.facebook.katana","com.google.android.partnersetup","com.google.android.youtube","com.google.android.gms","com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","jp.naver.line.android","tunein.service","com.android.settings",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"com.skype.raider","com.google.android.calendar","com.android.mms","com.google.android.apps.magazines","com.htc.cs.dm","com.google.android.talk","com.google.android.gm","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin",};
//	public String[] transportationApp = {"com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk","com.htc.resetnotify","com.htc.android.worldclock","com.htc.cs.dm","com.htc.idlescreen.base","com.android.settings","com.htc.task",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.task","com.google.android.googlequicksearchbox:search","com.htc.android.worldclock","com.google.android.calendar","com.google.android.gm","com.htc.android.mail:sync","com.google.android.gsf.login","com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.facebook.orca","com.facebook.katana","com.htc.bgp","com.htc.studio.pm.android","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.google.android.gms","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search","com.android.settings",};
//	public String[] transportationApp = {"com.htc.htcpowermanager:remote","com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.widget.process2","com.htc.studio.pm.android","com.android.settings","com.google.android.gms","com.htc.idlescreen.base","com.google.android.googlequicksearchbox:search",};
//	public String[] sportingApp = {"com.htc.studio.pm.android","com.htc.htcpowermanager:remote","com.facebook.orca","com.htc.widget.process2","com.facebook.katana","com.htc.bgp","com.google.android.gms","com.htc.idlescreen.base","com.google.android.googlequicksearchbox:search","com.android.settings",};
//	public String[] workingApp = {"com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.studio.pm.android","com.htc.widget.process2","com.google.android.gms","com.google.android.googlequicksearchbox:search","com.rootuninstaller.taskbarw8","com.htc.htcpowermanager:remote","com.android.settings",};
//	public String[] entertainmentApp = {"com.htc.studio.pm.android","com.facebook.orca","com.htc.widget.process2","com.facebook.katana","com.google.android.gms","com.htc.bgp","com.htc.htcpowermanager:remote","com.android.vending","com.android.settings","com.rootuninstaller.taskbarw8",};
//	public String[] shoppingApp = {"com.facebook.orca","com.htc.bgp","com.htc.htcpowermanager:remote","com.htc.widget.process2","com.facebook.katana","jp.naver.line.android","jp.naver.SJLGWR","com.android.settings","com.google.android.gms","com.htc.studio.pm.android",};

	
	// imei 353567051353648
//	public String[] diningApp = {"com.htc.htcpowermanager:remote","com.sina.mfweibo","com.dazhihui.spsc","com.android.settings","jp.naver.line.android","com.htc.bgp","com.htc.studio.pm.android","com.htc.backup","com.google.android.gms","com.sina.mfweibo.image",};
//	public String[] transportationApp = {"com.netease.mobimail","com.alipay.android.app","com.google.android.googlequicksearchbox:search","com.htc.studio.pm.android","android.process.media","com.sankuai.meituan","com.htc.htcpowermanager:remote","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.sina.mfweibo",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.bgp","com.dazhihui.spsc","com.google.android.gms","com.netease.mobimail","com.htc.studio.pm.android","com.sankuai.meituan","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.douban.group","com.yahoo.mobile.client.android.weather:com.yahoo.mobile.client.android.weather.service.WeatherServiceWatchdog",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	
	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.sina.mfweibo","com.google.android.youtube","com.htc.htcpowermanager:remote","com.htc.idlescreen.base","com.google.android.apps.uploader","com.android.settings","com.android.browser","com.htc.opensense.social","com.google.android.apps.plus",};
//	public String[] transportationApp = {"com.sina.mfweibo","com.android.settings","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.htc.idlescreen.base","android.process.media","com.htc.widget.process2","com.google.android.gms","com.facebook.katana","com.google.android.gsf.login",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.browser","com.android.settings","com.htc.widget.process2","com.google.android.apps.maps","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.sina.mfweibo","com.htc.reportagent","com.google.android.gms","android.process.media",};
//	public String[] entertainmentApp = {"com.htc.task","com.htc.idlescreen.Nolockscreen","com.htc.studio.pm.android","android.process.media","com.htc.pen","com.htc.htcpowermanager:remote","com.htc.idlescreen.base","mong.moptt","com.sina.mfweibo","com.ddim.happygo",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051354901
//	public String[] diningApp = {"com.google.android.googlequicksearchbox:search","com.beetalk","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","android.process.media","com.htc.htcpowermanager:remote","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.google.android.gms.drive","com.zeptolab.ctr.ads",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.google.android.googlequicksearchbox:search","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.android.vending","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold",};
//	public String[] entertainmentApp = {"com.htc.task","com.google.android.googlequicksearchbox:search","com.android.chrome","com.htc.android.worldclock","com.android.settings:remote","com.google.android.apps.magazines","android.process.media","kr.co.vcnc.android.couple","com.com2us.rooms.normal.freefull.google.global.android.common","com.android.packageinstaller",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.google.android.apps.maps","com.google.android.apps.magazines","android.process.media","com.google.android.tts","com.htc.htcpowermanager:remote","com.google.android.music:main","com.google.android.apps.plus","com.android.settings","com.twitter.android","com.sina.mfweibo",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.gsf.login","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.android.settings","android.process.media","com.sina.mfweibo","com.htc.backup","com.google.android.apps.plus","com.google.android.gm","com.google.android.partnersetup",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.friendstream.sinaweiboplugin","com.google.android.apps.magazines","com.google.android.apps.maps","com.android.camera","com.plurk.android","la.droid.qr","com.google.android.gm","com.sina.weibo","com.htc.widget.process4","com.htc.widget.process1",};
//	public String[] transportationApp = {"com.android.systemui:recentapp","com.htc.friendstream.sinaweiboplugin","com.google.android.apps.magazines","com.google.android.apps.maps","com.estrongs.android.pop","com.android.camera","com.plurk.android","la.droid.qr","com.sina.weibo","com.htc.widget.process4",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"la.droid.qr","com.sina.weibo","com.twitter.android","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android","com.google.android.music:main","com.android.settings","com.google.android.setupwizard","com.htc.widget.process2",};
//	public String[] entertainmentApp = {"com.google.android.apps.magazines","com.google.android.apps.maps","com.estrongs.android.pop","com.android.camera","com.plurk.android","la.droid.qr","com.sina.weibo","com.htc.android.mail:sync","com.google.android.music:main","com.htc.widget.process2",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.android.camera","android.process.media","com.google.android.gm","la.droid.qr","com.popoinnovation.nowin","com.htc.htcpowermanager:remote","com.twitter.android",};
//	public String[] transportationApp = {"com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.android.camera","android.process.media","com.google.android.gm","la.droid.qr","com.popoinnovation.nowin","com.sina.weibo","com.htc.htcpowermanager:remote",};
//	public String[] sportingApp = {"com.htc.android.worldclock","com.google.android.calendar","com.android.camera","android.process.media","com.google.android.gm","la.droid.qr","com.sina.weibo","com.htc.htcpowermanager:remote","com.android.vending","com.google.android.apps.plus",};
//	public String[] workingApp = {"com.google.android.gm","jp.naver.line.android","jp.naver.pick:service","com.htc.widget.process2","la.droid.qr","com.sina.weibo","com.google.android.apps.plus","com.cht.custservice","com.google.android.tts","com.google.android.apps.unveil",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.google.android.apps.magazines","com.android.camera","android.process.media","la.droid.qr","com.popoinnovation.nowin","com.htc.android.mail:sync","com.htc.htcpowermanager:remote","com.google.android.apps.plus","com.twitter.android",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"android.process.acore","jp.naver.android.npush","com.sony.smallapp.managerservice","com.sonyericsson.tvout.mhl","com.sonyericsson.lockscreen.uxpnxt","com.sonyericsson.crashmonitor","com.sonyericsson.android.locationbasedwifi:service","com.google.android.talk","com.sonymobile.experienceflow2","com.google.android.gm",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.sonymobile.experienceflow2","android.process.acore","com.facebook.orca","com.sonyericsson.crashmonitor","com.sony.smallapp.managerservice","jp.naver.android.npush","com.google.android.gm","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","com.sonyericsson.lockscreen.uxpnxt",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.htc.dnatransfer","com.android.vending",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.friendstream.sinaweiboplugin","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.android.vending",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.htc.dnatransfer","com.android.vending",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.reportagent","com.htc.cs","com.htc.task","com.htc.android.worldclock","com.android.mms","com.htc.notes","com.dale.doors.hundred.hardest","com.google.android.apps.translate","com.google.android.apps.uploader",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.notes","com.htc.task","com.android.chrome","com.dale.doors.hundred.hardest","com.google.android.apps.translate","com.google.android.apps.uploader","com.android.settings","com.zeptolab.ctr.ads","com.yahoo.mobile.client.android.flickr:com.yahoo.snp.service","com.htc.reportagent",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader","com.google.android.gms.unstable","com.renren.xiaonei.android","com.android.calendar","com.trafficctr.miui","com.android.providers.calendar",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo","com.duomi.android.manufacturer","com.android.fileexplorer","com.xiaomi.channel","com.sohu.inputmethod.sogou:pushservice","com.android.updater",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	// imei 864690022758703
//	public String[] diningApp = {"com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.android.deskclock","com.qualcomm.cabl","com.miui.home","com.android.thememanager","com.tul.aviate","com.trafficctr.miui","com.qualcomm.svi",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.android.deskclock","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.android.browser","com.miui.player","jp.naver.line.android","com.miui.weather2:weatherservice","com.miui.gallery","com.facebook.katana",};
//	public String[] workingApp = {"com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","jp.naver.line.android","com.android.deskclock","com.miui.home","com.android.thememanager","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","jp.naver.line.android:sub","com.miui.home","com.android.vending","com.android.fileexplorer:remote","com.android.updater","com.android.thememanager","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","com.miui.cloudservice",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null",};

	/* Entropy Frequency */
	
	
	
	/** top 5 **/
	/** top 5 **/
	/** top 5 **/
	/** top 5 **/
	/** top 5 **/
	/** top 5 **/
	
	
	
	
	/* TF-IDF */
	// imei 353567051351832
//	public String[] diningApp = {"com.facebook.katana:dash","com.htc.backup","com.google.android.music:main","com.mtk","com.htc.widget.process2",};
//	public String[] transportationApp = {"org.mozilla.firefox.UpdateService","jp.naver.line.android:sub","com.google.android.googlequicksearchbox:search","com.google.android.apps.maps","com.google.android.tts",};
//	public String[] sportingApp = {"com.htc.Weather","com.htc.album","com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player",};
//	public String[] workingApp = {"null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"com.android.mms","com.skype.raider","com.google.android.calendar","com.google.android.apps.magazines","com.htc.cs.dm",};
//	public String[] transportationApp = {"com.htc.resetnotify","com.android.settings","com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup","com.android.updater","com.android.htccontacts",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.htc.widget.process4","com.htc.framework","com.htc.wifidisplay","com.htc.photoenhancer","com.alibaba.mobileim",};
//	public String[] transportationApp = {"com.ertanto.kompas.official","com.oovoo","com.dexetra.friday:fridayservice","com.nike.plusgps:remote","com.htc.ml.transportation",};
//	public String[] sportingApp = {"org.orangenose.games","com.htc.aurora","com.htc.AutoMotive","com.htc.Weather","com.alibaba.mobileim",};
//	public String[] workingApp = {"com.htc.framework","com.htc.wifidisplay","com.htc.photoenhancer","com.oovoo","com.htc.home.personalize",};
//	public String[] entertainmentApp = {"com.ertanto.kompas.official","com.htc.socialnetwork.facebook","com.htc.ml.transportation","com.htc.android.worldclock","com.htc.android.htcime:provider",};
//	public String[] shoppingApp = {"com.oovoo","com.dexetra.trail:trailsync","com.dexetra.trail","com.dexetra.trail:trailservice","com.nike.plusgps:remote",};

	// imei 353567051353648
//	public String[] diningApp = {"com.sina.mfweibo.image","com.gameloft.android.ANMP.GloftDMHM","com.android.settings","com.skype.android.access","jp.naver.android.npush",};
//	public String[] transportationApp = {"com.android.chrome","com.htc.dnatransfer","com.magisto","com.taobao.appcenter:notify","com.yahoo.mobile.client.android.weather:com.yahoo.snp.service",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.opensense.social","com.android.vending","com.google.android.gm","com.htc.socialnetwork.wechatplugin","com.google.android.keep",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.google.android.youtube","com.google.android.apps.uploader","com.htc.opensense.social","com.google.android.apps.plus",};
//	public String[] transportationApp = {"com.htc.ml.transportation:remote","com.htc.ml.transportation","com.htc.idlescreen.shortcut","tunein.service","com.htc.widget.process2",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"ecowork.housefun","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.google.android.googlequicksearchbox:search","com.htc.reportagent",};
//	public String[] entertainmentApp = {"com.htc.cloudstorage.dropbox","com.htc.pen","mong.moptt","com.android.defcontainer","com.htc.task",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.beetalk","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.google.android.gms.drive","com.zeptolab.ctr.ads",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"tw.com.mcd.mcdalarm","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold",};
//	public String[] entertainmentApp = {"jp.co.applica.HomoxMarch","com.htc.task","com.htc.android.worldclock","kr.co.vcnc.android.couple","com.com2us.rooms.normal.freefull.google.global.android.common",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.widget.process3","com.htc.android.worldclock","com.htc.android.mail:sync","com.google.android.gms.drive","null",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.dnatransfer","com.htc.reportagent","com.htc.showme","com.htc.cs.dm","com.htc.opensense.social",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.widget.process1","com.facebook.katana:nodex","com.android.chrome:sandboxed_process10","com.android.chrome:sandboxed_process4","com.htc.friendstream.sinaweiboplugin",};
//	public String[] transportationApp = {"jp.naver.line.android:upload","com.android.chrome:sandboxed_process7","com.android.chrome:sandboxed_process6","com.android.chrome:sandboxed_process5","com.android.systemui:recentapp",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.plugin.news","com.htc.mms.backupagent","com.htc.cs","com.htc.friendstream.sinaweiboplugin","com.htc.widget.process1",};
//	public String[] entertainmentApp = {"com.UfoCrashGames.FullBlast","com.htc.android.mail:sync","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"com.popularapp.periodcalendar","com.htc.widget.process1","com.htc.mms.backupagent","jp.naver.pick:service","com.htc.backup",};
//	public String[] transportationApp = {"com.htc.backup","com.google.android.music:main","jp.naver.pick:service","com.htc.widget.process2","com.hyxen.app.RailTimeline",};
//	public String[] sportingApp = {"com.android.chrome:sandboxed_process3","com.android.providers.partnerbookmarks","com.android.chrome:sandboxed_process0","com.google.android.partnersetup","com.android.chrome:sandboxed_process2",};
//	public String[] workingApp = {"jp.naver.pick:service","com.htc.widget.process2","com.htc.task","com.google.android.partnersetup","com.htc.launcher.add_to_home",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.htc.android.mail:sync","com.android.chrome:sandboxed_process1","com.android.systemui:recentapp","com.htc.reportagent",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"com.sonyericsson.conversations","com.bbs.reader","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.facebook.orca","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","com.sonyericsson.xhs","com.sonyericsson.android.smartsearch",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"com.htc.dnatransfer","com.htc.backup","com.google.android.talk","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"com.htc.friendstream.sinaweiboplugin","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB","com.htc.providers.settings:remote","com.google.android.partnersetup",};
//	public String[] workingApp = {"null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"com.htc.dnatransfer","com.htc.backup","com.google.android.talk","null","null",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.android.worldclock","com.android.mms","com.lylynx.smsscheduler","com.inventec.dreye.htc",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.android.chrome","com.android.chrome:sandboxed_process0","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 864690022758703
//	public String[] diningApp = {"com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.android.deskclock","com.qualcomm.cabl",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"com.facebook.katana","com.facebook.orca","com.android.chrome","com.expensemanager:remote","com.expensemanager",};
//	public String[] workingApp = {"com.dexetra.friday","com.google.android.gms.wearable","com.google.android.talk","com.android.vending","com.android.updater",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","com.miui.backup","com.miui.bugreport","jp.naver.line.android:sub","com.android.vending",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	/* TF-IDF */
	
	
	
	
	
	/* Frequency */
	
	// imei 353567051351832
//	public String[] diningApp = {"com.google.android.music:main","com.mtk","jp.naver.android.npush","com.htc.widget.process2","com.facebook.katana:dash",};
//	public String[] transportationApp = {"com.htc.studio.pm.android","jp.naver.line.android","com.google.android.gms","com.facebook.katana","com.sina.mfweibo",};
//	public String[] sportingApp = {"com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","tunein.service","com.google.android.partnersetup",};
//	public String[] workingApp = {"null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"com.android.mms","com.skype.raider","com.google.android.apps.magazines","com.google.android.talk","com.htc.cs.dm",};
//	public String[] transportationApp = {"com.htc.resetnotify","com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup","com.android.updater","com.android.htccontacts",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.facebook.katana","com.htc.studio.pm.android","com.facebook.orca","com.htc.bgp","com.google.android.gms",};
//	public String[] transportationApp = {"com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.htcpowermanager:remote","com.htc.studio.pm.android",};
//	public String[] sportingApp = {"com.htc.studio.pm.android","com.facebook.katana","com.facebook.orca","com.htc.bgp","com.htc.widget.process2",};
//	public String[] workingApp = {"com.facebook.katana","com.htc.bgp","com.facebook.orca","com.htc.studio.pm.android","com.htc.widget.process2",};
//	public String[] entertainmentApp = {"com.google.android.gms","com.htc.studio.pm.android","com.facebook.katana","com.facebook.orca","com.htc.bgp",};
//	public String[] shoppingApp = {"com.facebook.orca","com.htc.bgp","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.facebook.katana",};

	// imei 353567051353648
//	public String[] diningApp = {"com.htc.bgp","com.dazhihui.spsc","com.android.settings","com.htc.htcpowermanager:remote","com.sina.mfweibo",};
//	public String[] transportationApp = {"com.netease.mobimail","com.sankuai.meituan","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.douban.group",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.bgp","com.dazhihui.spsc","com.netease.mobimail","com.sankuai.meituan","com.jiubang.app.bgz",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.android.browser","com.android.settings","com.sina.mfweibo","com.htc.htcpowermanager:remote",};
//	public String[] transportationApp = {"com.android.settings","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.sina.mfweibo",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.android.browser","com.google.android.apps.maps","com.android.settings","com.htc.widget.process2","com.htc.idlescreen.shortcut",};
//	public String[] entertainmentApp = {"com.htc.cloudstorage.dropbox","com.htc.idlescreen.Nolockscreen","tw.groupon","jp.naver.line.android","com.hovans.autoguard",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","android.process.media",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.baidu.netdisk:bdservice_v1",};
//	public String[] entertainmentApp = {"jp.co.applica.HomoxMarch","com.htc.opensense.social","com.htc.task","kr.co.vcnc.android.couple","com.google.android.gsf.login",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.htcpowermanager:remote","com.android.settings","android.process.media","com.sina.mfweibo","com.google.android.apps.plus",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.gsf.login","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.android.settings","android.process.media",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.widget.process1","com.google.android.gm","com.htc.friendstream.sinaweiboplugin","com.google.android.gms.unstable","la.droid.qr",};
//	public String[] transportationApp = {"com.google.android.music:main","com.google.android.setupwizard","com.htc.friendstream.sinaweiboplugin","la.droid.qr","com.sina.weibo",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.music:main","com.google.android.setupwizard","la.droid.qr","com.sina.weibo","com.twitter.android",};
//	public String[] entertainmentApp = {"com.htc.android.mail:sync","com.UfoCrashGames.FullBlast","com.google.android.music:main","com.google.android.setupwizard","la.droid.qr",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"jp.naver.pick:service","com.google.android.gm","com.google.android.apps.magazines","com.twitter.android","com.google.android.setupwizard",};
//	public String[] transportationApp = {"com.htc.widget.process2","jp.naver.pick:service","com.mobisystems.office","com.sina.weibo","com.google.android.gm",};
//	public String[] sportingApp = {"com.android.chrome:sandboxed_process3","com.google.android.partnersetup","com.android.vending","com.mobisystems.office","com.htc.friendstream.sinaweiboplugin",};
//	public String[] workingApp = {"jp.naver.pick:service","com.htc.widget.process2","com.android.vending","com.google.android.gm","jp.naver.line.android",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.google.android.partnersetup","com.android.chrome:sandboxed_process1","com.htc.friendstream.sinaweiboplugin","com.android.systemui:recentapp",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"android.process.acore","com.sony.smallapp.managerservice","jp.naver.android.npush","com.sonyericsson.lockscreen.uxpnxt","com.sonyericsson.tvout.mhl",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.sonymobile.experienceflow2","android.process.acore","com.facebook.orca","com.sonyericsson.crashmonitor",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"com.htc.dnatransfer","com.htc.backup","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"com.htc.friendstream.sinaweiboplugin","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB","com.htc.providers.settings:remote","com.google.android.partnersetup",};
//	public String[] workingApp = {"null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"com.htc.dnatransfer","com.htc.backup","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.android.worldclock","com.android.mms","com.htc.reportagent","com.htc.cs",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.android.chrome","com.android.chrome:sandboxed_process0","com.htc.reportagent","com.htc.cs","com.htc.task",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 864690022758703
//	public String[] diningApp = {"com.android.thememanager","com.android.deskclock","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"com.facebook.katana","com.facebook.orca","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice",};
//	public String[] workingApp = {"com.miui.weather2:receiverreportweather","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","jp.naver.line.android",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","com.miui.backup","com.miui.bugreport","com.android.thememanager","com.miui.weather2:receiverreportweather",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	/* Frequency */
	
	
	
	
	
	
	
	
	/* Entropy Frequency */
	
	// imei 353567051351832
//	public String[] diningApp = {"jp.naver.android.npush","com.google.android.youtube","com.htc.studio.pm.android","com.google.android.music:main","com.google.android.googlequicksearchbox",};
//	public String[] transportationApp = {"com.htc.studio.pm.android","com.facebook.katana","com.google.android.gms","com.sina.mfweibo","jp.naver.line.android",};
//	public String[] sportingApp = {"com.facebook.katana","com.google.android.partnersetup","com.google.android.youtube","com.google.android.gms","com.htc.bluetooth.le.profiles",};
//	public String[] workingApp = {"null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"com.skype.raider","com.google.android.calendar","com.android.mms","com.google.android.apps.magazines","com.htc.cs.dm",};
//	public String[] transportationApp = {"com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk","com.htc.resetnotify",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.task","com.google.android.googlequicksearchbox:search","com.htc.android.worldclock","com.google.android.calendar","com.google.android.gm",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.facebook.orca","com.facebook.katana","com.htc.bgp","com.htc.studio.pm.android","com.htc.widget.process2",};
//	public String[] transportationApp = {"com.htc.htcpowermanager:remote","com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.widget.process2",};
//	public String[] sportingApp = {"com.htc.studio.pm.android","com.htc.htcpowermanager:remote","com.facebook.orca","com.htc.widget.process2","com.facebook.katana",};
//	public String[] workingApp = {"com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.studio.pm.android","com.htc.widget.process2",};
//	public String[] entertainmentApp = {"com.htc.studio.pm.android","com.facebook.orca","com.htc.widget.process2","com.facebook.katana","com.google.android.gms",};
//	public String[] shoppingApp = {"com.facebook.orca","com.htc.bgp","com.htc.htcpowermanager:remote","com.htc.widget.process2","com.facebook.katana",};
	
	// imei 353567051353648
//	public String[] diningApp = {"com.htc.htcpowermanager:remote","com.sina.mfweibo","com.dazhihui.spsc","com.android.settings","jp.naver.line.android",};
//	public String[] transportationApp = {"com.netease.mobimail","com.alipay.android.app","com.google.android.googlequicksearchbox:search","com.htc.studio.pm.android","android.process.media",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.bgp","com.dazhihui.spsc","com.google.android.gms","com.netease.mobimail","com.htc.studio.pm.android",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
		
	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.sina.mfweibo","com.google.android.youtube","com.htc.htcpowermanager:remote","com.htc.idlescreen.base",};
//	public String[] transportationApp = {"com.sina.mfweibo","com.android.settings","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.htc.idlescreen.base",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.android.browser","com.android.settings","com.htc.widget.process2","com.google.android.apps.maps","com.htc.idlescreen.shortcut",};
//	public String[] entertainmentApp = {"com.htc.task","com.htc.idlescreen.Nolockscreen","com.htc.studio.pm.android","android.process.media","com.htc.pen",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.google.android.googlequicksearchbox:search","com.beetalk","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","android.process.media",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.google.android.googlequicksearchbox:search",};
//	public String[] entertainmentApp = {"com.htc.task","com.google.android.googlequicksearchbox:search","com.android.chrome","com.htc.android.worldclock","com.android.settings:remote",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.google.android.apps.maps","com.google.android.apps.magazines","android.process.media","com.google.android.tts","com.htc.htcpowermanager:remote",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.gsf.login","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.android.settings","android.process.media",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.friendstream.sinaweiboplugin","com.google.android.apps.magazines","com.google.android.apps.maps","com.android.camera","com.plurk.android",};
//	public String[] transportationApp = {"com.android.systemui:recentapp","com.htc.friendstream.sinaweiboplugin","com.google.android.apps.magazines","com.google.android.apps.maps","com.estrongs.android.pop",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"la.droid.qr","com.sina.weibo","com.twitter.android","com.google.android.apps.magazines","com.google.android.apps.maps",};
//	public String[] entertainmentApp = {"com.google.android.apps.magazines","com.google.android.apps.maps","com.estrongs.android.pop","com.android.camera","com.plurk.android",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.android.camera","android.process.media",};
//	public String[] transportationApp = {"com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.android.camera","android.process.media",};
//	public String[] sportingApp = {"com.htc.android.worldclock","com.google.android.calendar","com.android.camera","android.process.media","com.google.android.gm",};
//	public String[] workingApp = {"com.google.android.gm","jp.naver.line.android","jp.naver.pick:service","com.htc.widget.process2","la.droid.qr",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.google.android.apps.magazines","com.android.camera","android.process.media","la.droid.qr",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"android.process.acore","jp.naver.android.npush","com.sony.smallapp.managerservice","com.sonyericsson.tvout.mhl","com.sonyericsson.lockscreen.uxpnxt",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.sonymobile.experienceflow2","android.process.acore","com.facebook.orca","com.sonyericsson.crashmonitor",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.friendstream.sinaweiboplugin","com.htc.htcdialer",};
//	public String[] workingApp = {"null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.reportagent","com.htc.cs","com.htc.task","com.htc.android.worldclock",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.notes","com.htc.task","com.android.chrome","com.dale.doors.hundred.hardest","com.google.android.apps.translate",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader",};
//	public String[] sportingApp = {"null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo",};
//	public String[] entertainmentApp = {"null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	// imei 864690022758703
//	public String[] diningApp = {"com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.android.deskclock","com.qualcomm.cabl",};
//	public String[] transportationApp = {"null","null","null","null","null",};
//	public String[] sportingApp = {"com.android.deskclock","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.android.browser",};
//	public String[] workingApp = {"com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","jp.naver.line.android",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","jp.naver.line.android:sub","com.miui.home","com.android.vending","com.android.fileexplorer:remote",};
//	public String[] shoppingApp = {"null","null","null","null","null",};
	
	/* Entropy Frequency */
	
	
	
	
	/** top 15 **/
	/** top 15 **/
	/** top 15 **/
	/** top 15 **/
	/** top 15 **/
	/** top 15 **/
	
	
	
	
	
	/* TF-IDF */
	// imei 353567051351832
//	public String[] diningApp = {"com.facebook.katana:dash","com.htc.backup","com.google.android.music:main","com.mtk","com.htc.widget.process2","com.htc.dnatransfer","com.htc.calendar","com.htc.cs.dm","jp.naver.line.android:sub","com.htc.ml.transportation","com.htc.AutoMotive","com.htc.reportagent","iec.mychatsticker2.line","com.android.chrome","com.google.android.tts",};
//	public String[] transportationApp = {"org.mozilla.firefox.UpdateService","jp.naver.line.android:sub","com.google.android.googlequicksearchbox:search","com.google.android.apps.maps","com.google.android.tts","com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","com.fd.httpd","com.android.chrome","com.htc.widget.process2","com.tencent.mm","com.htc.opensense.social","null","null",};
//	public String[] sportingApp = {"com.htc.Weather","com.htc.album","com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","com.kkbox.alc.android","com.nuangjamnong.magicmancamera","com.google.android.googlequicksearchbox:search","idv.nightgospel.TWRailScheduleLookUp","com.skype.raider","com.android.mms","com.tencent.mm","com.htc.opensense.social","com.htc.socialnetwork.wechatplugin","com.google.android.gms.ui",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051351956
//	public String[] diningApp = {"com.android.mms","com.skype.raider","com.google.android.calendar","com.google.android.apps.magazines","com.htc.cs.dm","com.google.android.talk","com.google.android.gm","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin","com.htc.notes:NotesService","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.resetnotify","com.android.settings","com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk","com.htc.android.worldclock","com.htc.cs.dm","com.htc.idlescreen.base","com.fd.httpd","com.htc.syncagent","com.htc.task","com.htc.android.mail:sync","com.htc.notes:NotesService","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup","com.android.updater","com.android.htccontacts","com.htc.task","com.google.android.googlequicksearchbox:search","com.htc.android.worldclock","com.google.android.calendar","com.google.android.gm","com.htc.android.mail:sync","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin","com.htc.idlescreen.base",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051352475
//	public String[] diningApp = {"com.htc.widget.process4","com.htc.framework","com.htc.wifidisplay","com.htc.photoenhancer","com.alibaba.mobileim","com.htc.backup","com.htc.home.personalize","com.twitter.android","com.android.camera","com.supercell.clashofclans","com.taobao.taobao:notify","com.htc.ml.transportation","com.android.chrome:sandboxed_process0","com.htc.MediaCacheService","com.dropbox.android:crash_uploader",};
//	public String[] transportationApp = {"com.ertanto.kompas.official","com.oovoo","com.dexetra.friday:fridayservice","com.nike.plusgps:remote","com.htc.ml.transportation","com.bbm","android.process.htcmessage","com.alibaba.mobileim","com.dexetra.friday","com.taobao.taobao:notify","com.htc.android.htcime:provider_latin","com.htc.widget.process4","com.htc.ml.transportation:remote","com.htc.android.worldclock","com.htc.widget.process1",};
//	public String[] sportingApp = {"org.orangenose.games","com.htc.aurora","com.htc.AutoMotive","com.htc.Weather","com.alibaba.mobileim","com.supercell.clashofclans","com.htc.android.worldclock","system:ui","com.dotgears.flappybird","com.taobao.taobao:notify","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.framework","com.htc.wifidisplay","com.htc.photoenhancer","com.oovoo","com.htc.home.personalize","com.supercell.clashofclans","com.htc.backup","com.bbm","com.alibaba.mobileim","com.htc.plugin.news","com.htc.widget.process1","com.htc.widget.process4","com.taobao.taobao:notify","com.dexetra.trail","com.dexetra.trail:trailservice",};
//	public String[] entertainmentApp = {"com.ertanto.kompas.official","com.htc.socialnetwork.facebook","com.htc.ml.transportation","com.htc.android.worldclock","com.htc.android.htcime:provider","com.google.android.apps.docs","com.android.htccontacts","com.google.android.googlequicksearchbox","com.android.packageinstaller","com.htc.sensetv_home","com.google.android.syncadapters.calendar","com.google.android.gm","com.alibaba.mobileim","com.htc.widget.process1","com.google.android.apps.maps",};
//	public String[] shoppingApp = {"com.oovoo","com.dexetra.trail:trailsync","com.dexetra.trail","com.dexetra.trail:trailservice","com.nike.plusgps:remote","com.htc.android.htcime:provider_latin","com.bbm","jp.naver.line.android:sub","jp.naver.android.npush","jp.naver.SJLINEPANG","com.htc.widget.process1","com.dexetra.friday:fridaysync","com.dexetra.friday","com.htc.backup","com.htc.Weather",};

	// imei 353567051353648
//	public String[] diningApp = {"com.sina.mfweibo.image","com.gameloft.android.ANMP.GloftDMHM","com.android.settings","com.skype.android.access","jp.naver.android.npush","com.htc.idlescreen.base","com.wmyc.activity","com.htc.widget.process1","com.android.mms","com.taobao.taobao:containerprocess2","com.taobao.taobao:PushService_v1","com.jingwei.card","com.google.android.youtube","com.android.browser","com.android.settings:remote",};
//	public String[] transportationApp = {"com.android.chrome","com.htc.dnatransfer","com.magisto","com.taobao.appcenter:notify","com.yahoo.mobile.client.android.weather:com.yahoo.snp.service","com.google.android.apps.unveil","com.liulishuo.engzo:bdservice_v1","com.sf.activity","com.google.android.gsf.login","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.opensense.social","com.android.vending","com.google.android.gm","com.htc.socialnetwork.wechatplugin","com.google.android.keep","com.google.android.music:main","com.google.android.partnersetup","com.htc.widget.process1","com.htc.android.mail:sync","com.google.android.syncadapters.calendar","com.htc.task.gtask","com.google.android.apps.books","com.android.settings","com.madhead.tos.zh","com.android.chrome",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.google.android.youtube","com.google.android.apps.uploader","com.htc.opensense.social","com.google.android.apps.plus","com.htc.widget.process2","com.facebook.katana","com.android.vending","com.google.android.partnersetup","com.google.android.googlequicksearchbox","com.htc.android.mail:sync","com.htc.sensetv_home","com.tencent.mm:push","com.htc.widget.process1","com.htc.reportagent",};
//	public String[] transportationApp = {"com.htc.ml.transportation:remote","com.htc.ml.transportation","com.htc.idlescreen.shortcut","tunein.service","com.htc.widget.process2","com.facebook.katana","com.google.android.music:main","net.avs234:remote","com.google.android.syncadapters.calendar","com.google.android.apps.plus","com.htc.opensense.social","com.maxmpz.audioplayer","com.android.settings:remote","com.android.noisefield","jp.co.projectmode.redminepm",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"ecowork.housefun","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.google.android.googlequicksearchbox:search","com.htc.reportagent","com.tencent.mm","org.mozilla.firefox","com.google.android.apps.plus","com.htc.opensense.social","com.fd.httpd","com.htc.htcMessageUploader","com.iknow99.ezetc:post","com.htc.backup","com.htc.idlescreen.Nolockscreen","tw.groupon",};
//	public String[] entertainmentApp = {"com.htc.cloudstorage.dropbox","com.htc.pen","mong.moptt","com.android.defcontainer","com.htc.task","com.htc.idlescreen.Nolockscreen","com.ddim.happygo","com.she.eReader","com.google.android.tts","com.htc.widget.process4","tw.groupon","jp.naver.line.android","com.hovans.autoguard","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.beetalk","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.google.android.gms.drive","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","jp.naver.line.android","com.baidu.netdisk:remote","com.google.android.apps.genie.geniewidget","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"tw.com.mcd.mcdalarm","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","jp.naver.line.android","com.htc.pen","com.htc.reportagent","com.beetalk","com.google.android.gms.drive","com.htc.opensense.social","jp.productpro.SoftDevelopTeam.SlotKingdom","jp.productpro.SoftDevelopTeam.DungeonAlone","jp.productpro.SoftDevelopTeam.FloodTower","com.htc.task",};
//	public String[] entertainmentApp = {"jp.co.applica.HomoxMarch","com.htc.task","com.htc.android.worldclock","kr.co.vcnc.android.couple","com.com2us.rooms.normal.freefull.google.global.android.common","com.android.packageinstaller","com.htc.android.mail:sync","com.htc.widget.process3","com.google.android.music:main","com.google.android.setupwizard","com.htc.sensetv_home","com.wayi.fk","com.htc.cs.dm","com.google.android.gsf.login","com.htc.opensense.social",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.widget.process3","com.htc.android.worldclock","com.htc.android.mail:sync","com.google.android.gms.drive","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.dnatransfer","com.htc.reportagent","com.htc.showme","com.htc.cs.dm","com.htc.opensense.social","com.android.htccontacts","com.skype.raider","com.google.android.gms:snet","com.htc.socialnetwork.wechatplugin","com.htc.stock:remote","com.htc.launcher.fakescreen","com.android.updater","com.iknow99.ezetc:post","com.sdgtl.watch","com.tencent.mm",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.widget.process1","com.facebook.katana:nodex","com.android.chrome:sandboxed_process10","com.android.chrome:sandboxed_process4","com.htc.friendstream.sinaweiboplugin","com.google.android.gm","com.htc.widget.process4","com.google.android.gms.unstable","com.htc.opensense.social","com.android.systemui:recentapp","jp.naver.line.android:sub","com.clapfootgames.laserwarsfree","com.htc.contacts","com.htc.cs.dm","com.android.chrome:sandboxed_process0",};
//	public String[] transportationApp = {"jp.naver.line.android:upload","com.android.chrome:sandboxed_process7","com.android.chrome:sandboxed_process6","com.android.chrome:sandboxed_process5","com.android.systemui:recentapp","com.htc.friendstream.sinaweiboplugin","com.htc.widget.process4","com.htc.android.htcime","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB","com.android.chrome:sandboxed_process4","jp.naver.line.android:sub","com.google.android.gms.unstable","com.htc.cs.dm","com.android.chrome:sandboxed_process0",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.plugin.news","com.htc.mms.backupagent","com.htc.cs","com.htc.friendstream.sinaweiboplugin","com.htc.widget.process1","com.htc.android.mail:sync","com.htc.widget.process4","com.google.android.gm","com.google.android.gms.unstable","com.android.chrome:sandboxed_process0","com.htc.opensense.social","com.htc.task","com.nero.android.htc.sync","com.htc.android.worldclock","com.htc.dnatransfer",};
//	public String[] entertainmentApp = {"com.UfoCrashGames.FullBlast","com.htc.android.mail:sync","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"com.popularapp.periodcalendar","com.htc.widget.process1","com.htc.mms.backupagent","jp.naver.pick:service","com.htc.backup","com.htc.widget.process2","com.google.android.music:main","com.hyxen.app.RailTimeline","com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.google.android.gm","com.popoinnovation.nowin","com.twitter.android","net.mori.freerdp",};
//	public String[] transportationApp = {"com.htc.backup","com.google.android.music:main","jp.naver.pick:service","com.htc.widget.process2","com.hyxen.app.RailTimeline","com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.google.android.gm","com.popoinnovation.nowin","com.sina.weibo","com.google.android.gms.unstable","com.twitter.android","com.mobisystems.office","net.mori.freerdp",};
//	public String[] sportingApp = {"com.android.chrome:sandboxed_process3","com.android.providers.partnerbookmarks","com.android.chrome:sandboxed_process0","com.google.android.partnersetup","com.android.chrome:sandboxed_process2","com.jumplife.tvdrama","com.htc.android.worldclock","com.google.android.calendar","com.google.android.gm","com.sina.weibo","com.android.vending","com.google.android.gms.unstable","com.mobisystems.office","com.google.android.setupwizard","null",};
//	public String[] workingApp = {"jp.naver.pick:service","com.htc.widget.process2","com.htc.task","com.google.android.partnersetup","com.htc.launcher.add_to_home","com.htc.aurora","com.htc.widget.process1","com.htc.backup","com.google.android.music:main","com.popularapp.periodcalendar","com.hyxen.app.RailTimeline","com.google.android.gm","com.sina.weibo","com.google.android.apps.magazines","com.android.vending",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.htc.android.mail:sync","com.android.chrome:sandboxed_process1","com.android.systemui:recentapp","com.htc.reportagent","com.htc.shoebox.engine.relevance","com.android.chrome:sandboxed_process0","com.google.android.partnersetup","com.tul.aviate","com.google.android.apps.magazines","com.popoinnovation.nowin","com.twitter.android","net.mori.freerdp","com.google.android.apps.maps","com.DreamFactory.ChineseChess",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"com.sonyericsson.conversations","com.bbs.reader","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.facebook.orca","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","com.sonyericsson.xhs","com.sonyericsson.android.smartsearch","com.madhead.tos.zh.ex:NotificationReceiver","com.skype.raider","com.sonyericsson.android.socialphonebook","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"com.htc.dnatransfer","com.htc.backup","com.google.android.talk","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.htc.friendstream.sinaweiboplugin","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB","com.htc.providers.settings:remote","com.google.android.partnersetup","com.htc.cs","com.android.defcontainer","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"com.htc.dnatransfer","com.htc.backup","com.google.android.talk","null","null","null","null","null","null","null","null","null","null","null","null"};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.android.worldclock","com.android.mms","com.lylynx.smsscheduler","com.inventec.dreye.htc","com.tunewiki.lyricplayer.android:player","com.htc.idlescreen.base","com.htc.calendar","com.htc.android.htcime:provider_latin","com.htc.dockmode","com.htc.rosiewidgets.showme","com.mywoo.clog","com.htc.socialnetwork.facebook","com.htc.android.mail:directpush","com.android.vending",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.chrome","com.android.chrome:sandboxed_process0","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader","com.google.android.gms.unstable","com.renren.xiaonei.android","com.android.calendar","com.trafficctr.miui","com.android.providers.calendar","com.xiaomi.mitunes","com.google.android.partnersetup","com.google.android.wearable.app","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo","com.duomi.android.manufacturer","com.android.fileexplorer","com.xiaomi.channel","com.sohu.inputmethod.sogou:pushservice","com.android.updater","com.zhihu.android","com.moji.mjweather:pushservice","com.android.mms","com.miui.cloudservice","com.miui.bugreport",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 864690022758703
//	public String[] diningApp = {"com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.android.deskclock","com.qualcomm.cabl","com.android.thememanager","com.tul.aviate","com.trafficctr.miui","com.qualcomm.svi","com.miui.guardprovider","com.xiaomi.mitunes","com.google.android.partnersetup","com.miui.bugreport:remote","com.android.email","com.google.android.gm",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.facebook.katana","com.facebook.orca","com.android.chrome","com.expensemanager:remote","com.expensemanager","com.foursquare.robin","com.joelapenna.foursquared","com.google.android.gms.wearable","com.google.android.apps.plus","com.google.android.talk","com.tryagent","com.android.deskclock","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice",};
//	public String[] workingApp = {"com.dexetra.friday","com.google.android.gms.wearable","com.google.android.talk","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","jp.naver.line.android","com.google.android.apps.docs","com.google.android.youtube","com.pleco.chinesesystem","system:ui","com.google.android.gms.maps","com.android.deskclock","com.android.thememanager",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","com.miui.backup","com.miui.bugreport","jp.naver.line.android:sub","com.android.vending","com.android.fileexplorer:remote","com.android.updater","com.android.thememanager","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","com.miui.cloudservice","com.android.browser","com.miui.player","jp.naver.line.android","com.miui.gallery",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	/* TF-IDF */





	/* Frequency */

	// imei 353567051351832
//	public String[] diningApp = {"com.google.android.music:main","com.mtk","jp.naver.android.npush","com.htc.widget.process2","com.facebook.katana:dash","tunein.service","com.google.android.googlequicksearchbox","com.google.android.gsf.login","com.htc.studio.pm.android","com.google.android.youtube","jp.naver.line.android","com.google.android.gms","com.google.android.gm","jp.naver.line.android:sub","com.facebook.katana",};
//	public String[] transportationApp = {"com.htc.studio.pm.android","jp.naver.line.android","com.google.android.gms","com.facebook.katana","com.sina.mfweibo","com.google.android.gsf.login","com.google.android.gm","com.google.android.youtube","com.android.settings","net.emome.hamiapps.am","com.google.android.googlequicksearchbox","android.process.media","com.htc.htcpowermanager:remote","com.google.android.partnersetup","com.tencent.mm:push",};
//	public String[] sportingApp = {"com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","tunein.service","com.google.android.partnersetup","com.facebook.katana","com.google.android.youtube","com.google.android.gms","jp.naver.line.android","com.android.settings","com.sina.mfweibo","org.mozilla.firefox","android.process.media","com.htc.htcpowermanager:remote","net.emome.hamiapps.am",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051351956
//	public String[] diningApp = {"com.android.mms","com.skype.raider","com.google.android.apps.magazines","com.google.android.talk","com.htc.cs.dm","com.google.android.calendar","com.google.android.gm","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin","com.htc.notes:NotesService","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.resetnotify","com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk","com.android.settings","com.htc.android.worldclock","com.htc.cs.dm","com.htc.idlescreen.base","com.htc.task","com.fd.httpd","com.htc.syncagent","com.htc.android.mail:sync","com.htc.notes:NotesService","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup","com.android.updater","com.android.htccontacts","com.google.android.googlequicksearchbox:search","com.htc.android.worldclock","com.htc.idlescreen.base","com.htc.task","com.google.android.calendar","com.google.android.gm","com.htc.android.mail:sync","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051352475
//	public String[] diningApp = {"com.facebook.katana","com.htc.studio.pm.android","com.facebook.orca","com.htc.bgp","com.google.android.gms","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search","com.android.settings","com.estoty.game2048","com.google.android.gms.wearable","com.nhn.nni","com.sina.mfweibo","com.taobao.taobao",};
//	public String[] transportationApp = {"com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.htcpowermanager:remote","com.htc.studio.pm.android","com.htc.widget.process2","com.android.settings","com.google.android.gms","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search","com.sina.mfweibo","com.htc.idlescreen.base","com.nhn.nni","com.estoty.game2048","jp.naver.SJLGWR",};
//	public String[] sportingApp = {"com.htc.studio.pm.android","com.facebook.katana","com.facebook.orca","com.htc.bgp","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.google.android.gms","com.google.android.googlequicksearchbox:search","com.rootuninstaller.taskbarw8","com.android.settings","com.google.android.gms.wearable","com.htc.idlescreen.base","com.estoty.game2048","com.sina.mfweibo","com.android.vending",};
//	public String[] workingApp = {"com.facebook.katana","com.htc.bgp","com.facebook.orca","com.htc.studio.pm.android","com.htc.widget.process2","com.google.android.gms","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search","com.htc.htcpowermanager:remote","com.google.android.gms.wearable","com.android.settings","com.nhn.nni","com.android.vending","com.estoty.game2048","com.taobao.taobao",};
//	public String[] entertainmentApp = {"com.google.android.gms","com.htc.studio.pm.android","com.facebook.katana","com.facebook.orca","com.htc.bgp","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.rootuninstaller.taskbarw8","com.android.vending","com.google.android.googlequicksearchbox:search","com.android.settings","com.google.android.gsf.login","com.google.android.gms.wearable","com.estoty.game2048","com.htc.idlescreen.base",};
//	public String[] shoppingApp = {"com.facebook.orca","com.htc.bgp","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.facebook.katana","jp.naver.line.android","com.oovoo","jp.naver.SJLGWR","com.google.android.gms","com.htc.studio.pm.android","com.android.settings","android.process.media","jp.naver.android.npush","com.dropbox.android","mobi.infolife.taskmanager",};

	// imei 353567051353648
//	public String[] diningApp = {"com.htc.bgp","com.dazhihui.spsc","com.android.settings","com.htc.htcpowermanager:remote","com.sina.mfweibo","jp.naver.line.android","com.sina.mfweibo.image","com.gameloft.android.ANMP.GloftDMHM","com.google.android.gms","com.htc.studio.pm.android","com.htc.backup","com.htc.widget.process1","jp.naver.android.npush","com.wmyc.activity","com.taobao.taobao:PushService_v1",};
//	public String[] transportationApp = {"com.netease.mobimail","com.sankuai.meituan","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.douban.group","com.yahoo.mobile.client.android.weather:com.yahoo.mobile.client.android.weather.service.WeatherServiceWatchdog","com.jiepang.android","com.magisto:automation_service","com.alibaba.mobileim","com.eg.android.AlipayGphone","com.zhihu.android","com.alibaba.mobileim:remote","com.youdao.dict:yddictclip","com.taobao.taobao:push","com.alipay.pushservice",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.bgp","com.dazhihui.spsc","com.netease.mobimail","com.sankuai.meituan","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.douban.group","com.yahoo.mobile.client.android.weather:com.yahoo.mobile.client.android.weather.service.WeatherServiceWatchdog","com.jiepang.android","com.magisto:automation_service","com.alibaba.mobileim","com.eg.android.AlipayGphone","com.zhihu.android","com.alibaba.mobileim:remote","com.youdao.dict:yddictclip",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.android.browser","com.android.settings","com.sina.mfweibo","com.htc.htcpowermanager:remote","com.htc.widget.process2","com.htc.opensense.social","com.google.android.youtube","com.google.android.apps.uploader","com.htc.idlescreen.base","com.google.android.apps.plus","com.facebook.katana","com.google.android.apps.maps","com.htc.reportagent","android.process.media",};
//	public String[] transportationApp = {"com.android.settings","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.sina.mfweibo","com.google.android.gms","com.google.android.gsf.login","com.htc.idlescreen.base","android.process.media","com.facebook.katana","com.google.android.music:main","com.htc.ml.transportation:remote","com.htc.ml.transportation","com.google.android.apps.plus","com.maxmpz.audioplayer",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.browser","com.google.android.apps.maps","com.android.settings","com.htc.widget.process2","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.sina.mfweibo","com.htc.reportagent","com.google.android.gms","ecowork.housefun","com.google.android.googlequicksearchbox:search","com.htc.idlescreen.Nolockscreen","tw.groupon","jp.naver.line.android","com.google.android.gsf.login",};
//	public String[] entertainmentApp = {"com.htc.cloudstorage.dropbox","com.htc.idlescreen.Nolockscreen","tw.groupon","jp.naver.line.android","com.hovans.autoguard","com.google.android.tts","com.google.android.apps.maps","com.htc.pen","mong.moptt","com.android.defcontainer","com.android.browser","com.htc.task","com.android.settings","com.htc.widget.process4","com.htc.htcpowermanager:remote",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.google.android.googlequicksearchbox:search","com.beetalk","com.google.android.gms.drive","com.htc.htcpowermanager:remote","jp.naver.line.android","com.android.vending","com.square_enix.million_tw",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","com.google.android.googlequicksearchbox:search","com.android.vending","com.square_enix.million_tw","com.htc.htcpowermanager:remote","jp.naver.line.android","tw.com.mcd.mcdalarm","com.android.settings",};
//	public String[] entertainmentApp = {"jp.co.applica.HomoxMarch","com.htc.opensense.social","com.htc.task","kr.co.vcnc.android.couple","com.google.android.gsf.login","com.htc.idlescreen.base","com.android.packageinstaller","com.google.android.music:main","com.google.android.setupwizard","com.htc.sensetv_home","com.android.settings","com.google.android.apps.plus","com.android.vending","android.process.media","com.htc.widget.process2",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.htc.htcpowermanager:remote","com.android.settings","android.process.media","com.sina.mfweibo","com.google.android.apps.plus","com.google.android.tts","com.google.android.gsf.login","com.tencent.mm:push","com.htc.widget.process2","com.google.android.apps.maps","com.twitter.android","com.google.android.music:main","com.google.android.apps.magazines","com.google.android.apps.uploader","com.htc.widget.process1",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.gsf.login","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.android.settings","android.process.media","com.sina.mfweibo","com.htc.backup","com.google.android.gm","com.google.android.partnersetup","com.google.android.apps.plus","com.facebook.katana","com.htc.dnatransfer","com.google.android.talk","com.google.android.tts","com.htc.idlescreen.base",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.widget.process1","com.google.android.gm","com.htc.friendstream.sinaweiboplugin","com.google.android.gms.unstable","la.droid.qr","com.sina.weibo","com.twitter.android","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android","com.android.settings","com.htc.opensense.social","com.htc.widget.process4","com.htc.widget.process2","com.android.mms",};
//	public String[] transportationApp = {"com.google.android.music:main","com.google.android.setupwizard","com.htc.friendstream.sinaweiboplugin","la.droid.qr","com.sina.weibo","com.twitter.android","com.estrongs.android.pop","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android","com.android.settings","com.htc.widget.process4","com.htc.widget.process2","com.android.mms","com.google.android.talk",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.music:main","com.google.android.setupwizard","la.droid.qr","com.sina.weibo","com.twitter.android","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android","com.android.settings","com.htc.widget.process2","com.android.mms","com.google.android.talk","com.htc.plugin.news","com.estrongs.android.pop","com.htc.android.mail:sync",};
//	public String[] entertainmentApp = {"com.htc.android.mail:sync","com.UfoCrashGames.FullBlast","com.google.android.music:main","com.google.android.setupwizard","la.droid.qr","com.sina.weibo","com.twitter.android","com.estrongs.android.pop","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android","com.android.settings","com.htc.widget.process2","com.android.mms","com.android.chrome:sandboxed_process3",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"jp.naver.pick:service","com.google.android.gm","com.google.android.apps.magazines","com.twitter.android","com.google.android.setupwizard","com.google.android.calendar","com.htc.android.worldclock","la.droid.qr","com.cht.custservice","com.google.android.tts","com.google.android.apps.unveil","android.process.media","com.google.android.gms.wearable","com.htc.widget.process2","com.android.camera",};
//	public String[] transportationApp = {"com.htc.widget.process2","jp.naver.pick:service","com.mobisystems.office","com.sina.weibo","com.google.android.gm","com.google.android.gms.unstable","com.google.android.apps.maps","com.google.android.apps.magazines","com.twitter.android","com.google.android.setupwizard","jp.naver.line.android","com.google.android.music:main","com.google.android.calendar","com.google.android.apps.plus","com.android.settings",};
//	public String[] sportingApp = {"com.android.chrome:sandboxed_process3","com.google.android.partnersetup","com.android.vending","com.mobisystems.office","com.htc.friendstream.sinaweiboplugin","com.android.providers.partnerbookmarks","com.sina.weibo","com.google.android.gm","com.google.android.gms.unstable","com.google.android.setupwizard","jp.naver.line.android","com.google.android.calendar","com.google.android.apps.plus","com.android.settings","com.htc.android.worldclock",};
//	public String[] workingApp = {"jp.naver.pick:service","com.htc.widget.process2","com.android.vending","com.google.android.gm","jp.naver.line.android","com.sina.weibo","com.google.android.apps.magazines","com.twitter.android","com.google.android.setupwizard","com.google.android.apps.plus","la.droid.qr","com.cht.custservice","com.google.android.tts","com.google.android.apps.unveil","com.android.settings",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.google.android.partnersetup","com.android.chrome:sandboxed_process1","com.htc.friendstream.sinaweiboplugin","com.android.systemui:recentapp","com.htc.reportagent","com.htc.shoebox.engine.relevance","com.google.android.apps.maps","com.htc.android.mail:sync","com.google.android.apps.magazines","com.twitter.android","jp.naver.line.android","com.google.android.apps.plus","com.android.settings","la.droid.qr",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"android.process.acore","com.sony.smallapp.managerservice","jp.naver.android.npush","com.sonyericsson.lockscreen.uxpnxt","com.sonyericsson.tvout.mhl","com.sonymobile.experienceflow2","com.sonyericsson.crashmonitor","com.google.android.talk","com.sonyericsson.android.locationbasedwifi:service","com.sonyericsson.conversations","com.bbs.reader","com.google.android.gm","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.sonymobile.experienceflow2","android.process.acore","com.facebook.orca","com.sonyericsson.crashmonitor","com.sony.smallapp.managerservice","jp.naver.android.npush","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","com.google.android.gm","com.google.android.talk","com.sonyericsson.lockscreen.uxpnxt","com.sonyericsson.android.locationbasedwifi:service","com.sonyericsson.tvout.mhl","com.sonyericsson.xhs","com.sonyericsson.android.smartsearch",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"com.htc.dnatransfer","com.htc.backup","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.android.vending","com.facebook.katana","com.google.android.apps.plus","com.android.settings","com.google.process.gapps",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.htc.friendstream.sinaweiboplugin","com.htc.shoebox.engine.relevance","com.htc.android.htcime:contactDB","com.htc.providers.settings:remote","com.google.android.partnersetup","com.htc.cs","com.android.defcontainer","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"com.htc.dnatransfer","com.htc.backup","android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.android.vending","com.facebook.katana","com.google.android.apps.plus","com.android.settings","com.google.process.gapps",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.android.worldclock","com.android.mms","com.htc.reportagent","com.htc.cs","com.lylynx.smsscheduler","com.htc.task","com.htc.notes","com.dale.doors.hundred.hardest","com.google.android.apps.translate","com.google.android.apps.uploader","com.yahoo.mobile.client.android.flickr:com.yahoo.snp.service","com.htc.htcMessageUploader","com.htc.notes:NotesService","com.yahoo.mobile.client.android.flickr",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.chrome","com.android.chrome:sandboxed_process0","com.htc.reportagent","com.htc.cs","com.htc.task","com.htc.notes","com.dale.doors.hundred.hardest","com.google.android.apps.translate","com.google.android.apps.uploader","com.yahoo.mobile.client.android.flickr:com.yahoo.snp.service","com.htc.htcMessageUploader","com.htc.notes:NotesService","com.yahoo.mobile.client.android.flickr","com.android.settings","com.zeptolab.ctr.ads",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader","com.google.android.gms.unstable","com.renren.xiaonei.android","com.android.calendar","com.trafficctr.miui","com.android.providers.calendar","com.xiaomi.mitunes","com.google.android.partnersetup","com.google.android.wearable.app","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo","com.duomi.android.manufacturer","com.android.fileexplorer","com.xiaomi.channel","com.sohu.inputmethod.sogou:pushservice","com.android.updater","com.zhihu.android","com.moji.mjweather:pushservice","com.android.mms","com.miui.cloudservice","com.miui.bugreport",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 864690022758703
//	public String[] diningApp = {"com.android.thememanager","com.android.deskclock","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.qualcomm.cabl","com.tul.aviate","com.trafficctr.miui","com.qualcomm.svi","com.miui.guardprovider","com.xiaomi.mitunes","com.miui.bugreport:remote","com.google.android.partnersetup","com.miui.home","com.miui.weather2:weatherservice",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.facebook.katana","com.facebook.orca","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","jp.naver.line.android","com.android.chrome","com.expensemanager:remote","com.expensemanager","com.android.browser","com.miui.player","com.miui.gallery","com.android.deskclock","com.miui.weather2:receiverreportweather","com.miui.weather2:weatherservice",};
//	public String[] workingApp = {"com.miui.weather2:receiverreportweather","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","jp.naver.line.android","com.android.thememanager","com.android.deskclock","com.google.android.gms.wearable","com.miui.home","com.dexetra.friday","com.android.fileexplorer:remote","com.google.android.talk","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","com.miui.backup","com.miui.bugreport","com.android.thememanager","com.miui.weather2:receiverreportweather","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","jp.naver.line.android","com.android.fileexplorer:remote","com.android.browser","com.miui.player","com.miui.gallery","jp.naver.line.android:sub","com.miui.cloudservice",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	/* Frequency */








	/* Entropy Frequency */

	// imei 353567051351832
//	public String[] diningApp = {"jp.naver.android.npush","com.google.android.youtube","com.htc.studio.pm.android","com.google.android.music:main","com.google.android.googlequicksearchbox","com.google.android.gms","com.google.android.gsf.login","jp.naver.line.android","com.google.android.gm","com.facebook.katana","com.mtk","tunein.service","android.process.media","com.htc.htcpowermanager:remote","com.google.android.calendar",};
//	public String[] transportationApp = {"com.htc.studio.pm.android","com.facebook.katana","com.google.android.gms","com.sina.mfweibo","jp.naver.line.android","com.google.android.youtube","com.google.android.gm","com.android.settings","com.google.android.gsf.login","net.emome.hamiapps.am","android.process.media","com.htc.htcpowermanager:remote","com.google.android.googlequicksearchbox","com.tencent.mm:push","org.mozilla.firefox",};
//	public String[] sportingApp = {"com.facebook.katana","com.google.android.partnersetup","com.google.android.youtube","com.google.android.gms","com.htc.bluetooth.le.profiles","com.android.bluetooth","tunein.player","jp.naver.line.android","tunein.service","com.android.settings","com.sina.mfweibo","org.mozilla.firefox","android.process.media","com.htc.htcpowermanager:remote","net.emome.hamiapps.am",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051351956
//	public String[] diningApp = {"com.skype.raider","com.google.android.calendar","com.android.mms","com.google.android.apps.magazines","com.htc.cs.dm","com.google.android.talk","com.google.android.gm","com.google.android.gsf.login","com.rsupport.mvagent","com.htc.android.htcime:provider_latin","com.htc.notes:NotesService","null","null","null","null",};
//	public String[] transportationApp = {"com.skype.raider","com.google.android.googlequicksearchbox:search","com.google.android.apps.magazines","com.google.android.talk","com.htc.resetnotify","com.htc.android.worldclock","com.htc.cs.dm","com.htc.idlescreen.base","com.android.settings","com.htc.task","com.fd.httpd","com.htc.android.mail:sync","com.htc.syncagent","com.htc.notes:NotesService","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.task","com.google.android.googlequicksearchbox:search","com.htc.android.worldclock","com.google.android.calendar","com.google.android.gm","com.htc.android.mail:sync","com.google.android.gsf.login","com.htc.ml.transportation","com.sdgtl.watch","com.google.android.partnersetup","com.rsupport.mvagent","com.htc.android.htcime:provider_latin","com.htc.idlescreen.base","com.android.updater","com.android.htccontacts",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
	
	// imei 353567051352475
//	public String[] diningApp = {"com.facebook.orca","com.facebook.katana","com.htc.bgp","com.htc.studio.pm.android","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.google.android.gms","com.rootuninstaller.taskbarw8","com.google.android.googlequicksearchbox:search","com.android.settings","com.estoty.game2048","com.google.android.gms.wearable","com.nhn.nni","com.sina.mfweibo","com.htc.idlescreen.base",};
//	public String[] transportationApp = {"com.htc.htcpowermanager:remote","com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.widget.process2","com.htc.studio.pm.android","com.android.settings","com.google.android.gms","com.htc.idlescreen.base","com.google.android.googlequicksearchbox:search","com.rootuninstaller.taskbarw8","com.sina.mfweibo","jp.naver.SJLGWR","com.nhn.nni","com.estoty.game2048",};
//	public String[] sportingApp = {"com.htc.studio.pm.android","com.htc.htcpowermanager:remote","com.facebook.orca","com.htc.widget.process2","com.facebook.katana","com.htc.bgp","com.google.android.gms","com.htc.idlescreen.base","com.google.android.googlequicksearchbox:search","com.android.settings","com.google.android.gsf.login","com.rootuninstaller.taskbarw8","com.google.android.gms.wearable","com.android.vending","com.sina.mfweibo",};
//	public String[] workingApp = {"com.htc.bgp","com.facebook.orca","com.facebook.katana","com.htc.studio.pm.android","com.htc.widget.process2","com.google.android.gms","com.google.android.googlequicksearchbox:search","com.rootuninstaller.taskbarw8","com.htc.htcpowermanager:remote","com.android.settings","com.google.android.gms.wearable","com.android.vending","com.nhn.nni","android.process.media","com.htc.idlescreen.base",};
//	public String[] entertainmentApp = {"com.htc.studio.pm.android","com.facebook.orca","com.htc.widget.process2","com.facebook.katana","com.google.android.gms","com.htc.bgp","com.htc.htcpowermanager:remote","com.android.vending","com.android.settings","com.rootuninstaller.taskbarw8","com.google.android.gsf.login","com.google.android.googlequicksearchbox:search","com.htc.idlescreen.base","com.google.android.gms.wearable","android.process.media",};
//	public String[] shoppingApp = {"com.facebook.orca","com.htc.bgp","com.htc.htcpowermanager:remote","com.htc.widget.process2","com.facebook.katana","jp.naver.line.android","jp.naver.SJLGWR","com.android.settings","com.google.android.gms","com.htc.studio.pm.android","android.process.media","com.expensemanager:remote","mobi.infolife.taskmanager","com.dropbox.android","com.htc.idlescreen.base",};
		
	// imei 353567051353648
//	public String[] diningApp = {"com.htc.htcpowermanager:remote","com.sina.mfweibo","com.dazhihui.spsc","com.android.settings","jp.naver.line.android","com.htc.bgp","com.htc.studio.pm.android","com.htc.backup","com.google.android.gms","com.sina.mfweibo.image","com.gameloft.android.ANMP.GloftIAHM","jp.naver.android.npush","com.youdao.note","com.htc.idlescreen.base","com.wmyc.activity",};
//	public String[] transportationApp = {"com.netease.mobimail","com.alipay.android.app","com.google.android.googlequicksearchbox:search","com.htc.studio.pm.android","android.process.media","com.sankuai.meituan","com.htc.htcpowermanager:remote","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.sina.mfweibo","com.google.android.talk","com.dazhihui.spsc","com.douban.group","com.yahoo.mobile.client.android.weather:com.yahoo.mobile.client.android.weather.service.WeatherServiceWatchdog","com.jiepang.android",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.bgp","com.dazhihui.spsc","com.google.android.gms","com.netease.mobimail","com.htc.studio.pm.android","com.sankuai.meituan","com.jiubang.app.bgz","com.sf.activity:bdservice_v1","com.douban.group","com.yahoo.mobile.client.android.weather:com.yahoo.mobile.client.android.weather.service.WeatherServiceWatchdog","com.jiepang.android","com.magisto:automation_service","com.alibaba.mobileim","com.eg.android.AlipayGphone","com.zhihu.android",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
		
	// imei 353567051354810
//	public String[] diningApp = {"com.htc.idlescreen.shortcut","com.sina.mfweibo","com.google.android.youtube","com.htc.htcpowermanager:remote","com.htc.idlescreen.base","com.google.android.apps.uploader","com.android.settings","com.android.browser","com.htc.opensense.social","com.google.android.apps.plus","com.htc.widget.process2","com.facebook.katana","android.process.media","com.android.vending","com.google.android.partnersetup",};
//	public String[] transportationApp = {"com.sina.mfweibo","com.android.settings","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.htc.idlescreen.base","android.process.media","com.htc.widget.process2","com.google.android.gms","com.facebook.katana","com.google.android.gsf.login","com.google.android.music:main","com.google.android.apps.plus","com.htc.opensense.social","com.maxmpz.audioplayer","com.android.settings:remote",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.android.browser","com.android.settings","com.htc.widget.process2","com.google.android.apps.maps","com.htc.idlescreen.shortcut","com.htc.htcpowermanager:remote","com.sina.mfweibo","com.htc.reportagent","com.google.android.gms","android.process.media","com.google.android.apps.plus","com.google.android.gsf.login","com.htc.opensense.social","com.htc.idlescreen.base","com.htc.studio.pm.android",};
//	public String[] entertainmentApp = {"com.htc.task","com.htc.idlescreen.Nolockscreen","com.htc.studio.pm.android","android.process.media","com.htc.pen","com.htc.htcpowermanager:remote","com.htc.idlescreen.base","mong.moptt","com.sina.mfweibo","com.ddim.happygo","com.she.eReader","com.google.android.apps.maps","com.google.android.tts","com.htc.widget.process4","com.android.settings",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051354901
//	public String[] diningApp = {"com.google.android.googlequicksearchbox:search","com.beetalk","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","android.process.media","com.htc.htcpowermanager:remote","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.google.android.gms.drive","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","com.shere.assistivetouch.service","com.android.vending","com.square_enix.million_tw","jp.naver.line.android",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"android.process.media","com.htc.widget.process2","com.buzzpia.aqua.appwidget.clock","com.shere.assistivetouch.service","com.google.android.googlequicksearchbox:search","com.baidu.netdisk:bdservice_v1","com.baidu.netdisk","com.android.vending","com.zeptolab.ctr.ads","com.thepixelizers.android.opensea.ui.gold","com.square_enix.million_tw","com.htc.htcpowermanager:remote","jp.naver.line.android","com.android.settings","tw.com.mcd.mcdalarm",};
//	public String[] entertainmentApp = {"com.htc.task","com.google.android.googlequicksearchbox:search","com.android.chrome","com.htc.android.worldclock","com.android.settings:remote","com.google.android.apps.magazines","android.process.media","kr.co.vcnc.android.couple","com.com2us.rooms.normal.freefull.google.global.android.common","com.android.packageinstaller","la.droid.qr","com.htc.android.mail:sync","com.htc.widget.process3","com.htc.htcpowermanager:remote","com.gameloft.android.ANMP.GloftA8HM",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 353567051355254
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.google.android.apps.maps","com.google.android.apps.magazines","android.process.media","com.google.android.tts","com.htc.htcpowermanager:remote","com.google.android.music:main","com.google.android.apps.plus","com.android.settings","com.twitter.android","com.sina.mfweibo","com.tencent.mm:push","com.htc.widget.process2","com.google.android.apps.uploader","com.google.android.gsf.login","com.htc.widget.process1",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.google.android.gsf.login","com.htc.widget.process2","com.htc.htcpowermanager:remote","com.android.settings","android.process.media","com.sina.mfweibo","com.htc.backup","com.google.android.apps.plus","com.google.android.gm","com.google.android.partnersetup","com.facebook.katana","com.google.android.tts","com.htc.idlescreen.base","com.tencent.mm:push","com.google.android.talk",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 355027051966921
//	public String[] diningApp = {"com.htc.friendstream.sinaweiboplugin","com.google.android.apps.magazines","com.google.android.apps.maps","com.android.camera","com.plurk.android","la.droid.qr","com.google.android.gm","com.sina.weibo","com.htc.widget.process4","com.htc.widget.process1","com.htc.widget.process2","com.google.android.gms.unstable","com.android.settings","com.twitter.android","com.android.mms",};
//	public String[] transportationApp = {"com.android.systemui:recentapp","com.htc.friendstream.sinaweiboplugin","com.google.android.apps.magazines","com.google.android.apps.maps","com.estrongs.android.pop","com.android.camera","com.plurk.android","la.droid.qr","com.sina.weibo","com.htc.widget.process4","com.google.android.music:main","com.htc.widget.process2","com.android.settings","com.google.android.setupwizard","com.twitter.android",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"la.droid.qr","com.sina.weibo","com.twitter.android","com.google.android.apps.magazines","com.google.android.apps.maps","com.plurk.android","com.google.android.music:main","com.android.settings","com.google.android.setupwizard","com.htc.widget.process2","com.android.mms","com.google.android.talk","com.estrongs.android.pop","com.htc.friendstream.sinaweiboplugin","com.htc.android.mail:sync",};
//	public String[] entertainmentApp = {"com.google.android.apps.magazines","com.google.android.apps.maps","com.estrongs.android.pop","com.android.camera","com.plurk.android","la.droid.qr","com.sina.weibo","com.htc.android.mail:sync","com.google.android.music:main","com.htc.widget.process2","com.android.settings","com.google.android.setupwizard","com.UfoCrashGames.FullBlast","com.twitter.android","com.android.mms",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355027054515550
//	public String[] diningApp = {"com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.android.camera","android.process.media","com.google.android.gm","la.droid.qr","com.popoinnovation.nowin","com.htc.htcpowermanager:remote","com.twitter.android","com.cht.custservice","net.mori.freerdp","com.DreamFactory.ChineseChess","com.google.android.tts","com.google.android.gms.wearable",};
//	public String[] transportationApp = {"com.htc.android.worldclock","com.google.android.calendar","com.google.android.apps.magazines","com.android.camera","android.process.media","com.google.android.gm","la.droid.qr","com.popoinnovation.nowin","com.sina.weibo","com.htc.htcpowermanager:remote","com.google.android.apps.plus","com.google.android.gms.unstable","com.twitter.android","com.htc.backup","com.mobisystems.office",};
//	public String[] sportingApp = {"com.htc.android.worldclock","com.google.android.calendar","com.android.camera","android.process.media","com.google.android.gm","la.droid.qr","com.sina.weibo","com.htc.htcpowermanager:remote","com.android.vending","com.google.android.apps.plus","com.google.android.gms.unstable","com.google.android.talk","com.mobisystems.office","com.android.chrome:sandboxed_process0","com.google.android.partnersetup",};
//	public String[] workingApp = {"com.google.android.gm","jp.naver.line.android","jp.naver.pick:service","com.htc.widget.process2","la.droid.qr","com.sina.weibo","com.google.android.apps.plus","com.cht.custservice","com.google.android.tts","com.google.android.apps.unveil","com.google.android.apps.magazines","com.android.vending","com.twitter.android","com.android.settings","com.google.android.setupwizard",};
//	public String[] entertainmentApp = {"com.nero.android.htc.sync","com.google.android.apps.magazines","com.android.camera","android.process.media","la.droid.qr","com.popoinnovation.nowin","com.htc.android.mail:sync","com.htc.htcpowermanager:remote","com.google.android.apps.plus","com.twitter.android","com.google.android.talk","com.android.chrome:sandboxed_process0","com.android.chrome:sandboxed_process1","com.google.android.partnersetup","com.cht.custservice",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355387051404228
//	public String[] diningApp = {"android.process.acore","jp.naver.android.npush","com.sony.smallapp.managerservice","com.sonyericsson.tvout.mhl","com.sonyericsson.lockscreen.uxpnxt","com.sonyericsson.crashmonitor","com.sonyericsson.android.locationbasedwifi:service","com.google.android.talk","com.sonymobile.experienceflow2","com.google.android.gm","com.sonyericsson.conversations","com.bbs.reader","null","null","null",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.sonyericsson.tetherentitlementcheck","com.sonymobile.experienceflow2","android.process.acore","com.facebook.orca","com.sonyericsson.crashmonitor","com.sony.smallapp.managerservice","jp.naver.android.npush","com.google.android.gm","com.sonyericsson.credentialmanagerservice:credentialmanagerservice","com.sonyericsson.lockscreen.uxpnxt","com.google.android.talk","com.sonyericsson.android.locationbasedwifi:service","com.sonyericsson.tvout.mhl","com.sonyericsson.xhs","com.sonyericsson.android.smartsearch",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	355859056961972
//	public String[] diningApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.htc.dnatransfer","com.android.vending","com.facebook.katana","com.google.android.apps.plus","com.android.settings","com.google.process.gapps","com.facebook.orca",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.friendstream.sinaweiboplugin","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.android.vending","com.facebook.katana","com.google.android.apps.plus","com.android.settings","com.google.process.gapps","com.facebook.orca",};
//	public String[] workingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"android.process.acore","com.google.process.location","com.google.android.googlequicksearchbox:search","com.htc.htcdialer","com.google.android.wearablepreview.app","org.simalliance.openmobileapi.service:remote","android.process.media","com.android.systemui","com.htc.dnatransfer","com.android.vending","com.facebook.katana","com.google.android.apps.plus","com.android.settings","com.google.process.gapps","com.facebook.orca",};

	// imei	356440047806292
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.android.settings:remote","com.htc.reportagent","com.htc.cs","com.htc.task","com.htc.android.worldclock","com.android.mms","com.htc.notes","com.dale.doors.hundred.hardest","com.google.android.apps.translate","com.google.android.apps.uploader","com.yahoo.mobile.client.android.flickr:com.yahoo.snp.service","com.htc.htcMessageUploader","com.lylynx.smsscheduler","com.htc.notes:NotesService","com.yahoo.mobile.client.android.flickr",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.htc.notes","com.htc.task","com.android.chrome","com.dale.doors.hundred.hardest","com.google.android.apps.translate","com.google.android.apps.uploader","com.android.settings","com.zeptolab.ctr.ads","com.yahoo.mobile.client.android.flickr:com.yahoo.snp.service","com.htc.reportagent","com.htc.htcMessageUploader","com.android.chrome:sandboxed_process0","com.htc.notes:NotesService","com.htc.cs","com.yahoo.mobile.client.android.flickr",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei	863360029004219
//	public String[] diningApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] transportationApp = {"com.douban.group","com.google.android.googlequicksearchbox:search","com.android.deskclock","android.process.media","com.douban.book.reader","com.google.android.gms.unstable","com.renren.xiaonei.android","com.android.calendar","com.trafficctr.miui","com.android.providers.calendar","com.xiaomi.mitunes","com.google.android.partnersetup","com.google.android.wearable.app","null","null",};
//	public String[] sportingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] workingApp = {"com.UCMobile.intl:push","com.sina.weibo:remote","com.svox.pico","com.android.packageinstaller","com.sina.weibo","com.duomi.android.manufacturer","com.android.fileexplorer","com.xiaomi.channel","com.sohu.inputmethod.sogou:pushservice","com.android.updater","com.zhihu.android","com.moji.mjweather:pushservice","com.android.mms","com.miui.cloudservice","com.miui.bugreport",};
//	public String[] entertainmentApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	// imei 864690022758703
//	public String[] diningApp = {"com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.android.deskclock","com.qualcomm.cabl","com.miui.home","com.android.thememanager","com.tul.aviate","com.trafficctr.miui","com.qualcomm.svi","com.miui.guardprovider","com.xiaomi.mitunes","com.google.android.partnersetup","com.miui.weather2:weatherservice","com.miui.bugreport:remote",};
//	public String[] transportationApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};
//	public String[] sportingApp = {"com.android.deskclock","com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.android.browser","com.miui.player","jp.naver.line.android","com.miui.weather2:weatherservice","com.miui.gallery","com.facebook.katana","com.facebook.orca","com.miui.weather2:receiverreportweather","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search",};
//	public String[] workingApp = {"com.android.vending","com.android.updater","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","jp.naver.line.android","com.android.deskclock","com.miui.home","com.android.thememanager","com.qualcomm.location.XT","com.qualcomm.qcrilmsgtunnel","com.google.android.googlequicksearchbox:search","com.qualcomm.cabl","com.google.android.gms.wearable","com.android.fileexplorer:remote","com.tul.aviate",};
//	public String[] entertainmentApp = {"jp.naver.android.npush","jp.naver.line.android:sub","com.miui.home","com.android.vending","com.android.fileexplorer:remote","com.android.updater","com.android.thememanager","com.miui.weather2:reportweatherservice","com.miui.weather2:receiverreportweather","com.miui.cloudservice","com.miui.backup","com.android.browser","com.miui.bugreport","com.miui.player","jp.naver.line.android",};
//	public String[] shoppingApp = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",};

	/* Entropy Frequency */
	
	// 最後改成training完後，用檔案的方式載入
	public AppUsage() 
	{	
	}
}
/* TF-IDF */
// imei 353567051351832

// imei 353567051351956

// imei 353567051352475

// imei 353567051353648

// imei 353567051354810

// imei 353567051354901

// imei 353567051355254

// imei 355027051966921

// imei	355027054515550

// imei	355387051404228

// imei	355859056961972

// imei	356440047806292

// imei	863360029004219

// imei 864690022758703

/* TF-IDF */





/* Frequency */

// imei 353567051351832

// imei 353567051351956
	
// imei 353567051352475
	
// imei 353567051353648
	
// imei 353567051354810

// imei 353567051354901

// imei 353567051355254

// imei 355027051966921

// imei	355027054515550

// imei	355387051404228

// imei	355859056961972

// imei	356440047806292

// imei	863360029004219

// imei 864690022758703

/* Frequency */








/* Entropy Frequency */

// imei 353567051351832

// imei 353567051351956
		
// imei 353567051352475
		
// imei 353567051353648
		
// imei 353567051354810

// imei 353567051354901
	
// imei 353567051355254

// imei 355027051966921

// imei	355027054515550

// imei	355387051404228

// imei	355859056961972

// imei	356440047806292

// imei	863360029004219

// imei 864690022758703

/* Entropy Frequency */
