package com.igeek.hbut.shixi;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igeek.hbut.shixi.HttpClientTest;

public class Pachong {
	public static void main(String[] args) throws Exception {
		//1加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2获取连接
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pilipili?useUnicode=true&characterEncoding=utf-8&useSSL=FALSE&serverTimezone=UTC", "root", "114514");
    	//3获得语句执行者
    	Statement st = conn.createStatement();
    	
    	for(int page=1; page<200; page++) {
    		System.out.println("页码：" + page);
    		String result = HttpClientTest.getNoParam("https://api.bilibili.com/x/web-interface/newlist?rid="+page);
			System.out.println(result);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			HashMap<String, Object> resultMap = objectMapper.readValue(result, HashMap.class);
			HashMap<String, Object> dataMap = (HashMap<String, Object>)resultMap.get("data");
			ArrayList<HashMap<String, Object>> dataList = (ArrayList<HashMap<String, Object>>)dataMap.get("archives");
			
			//时间格式化
	    	DateFormat dateFormat1 = new SimpleDateFormat("YYYYMMdd");
	    	DateFormat dateFormat2 = new SimpleDateFormat("YYYY-MM-dd");
	    	
	    	for(int i=0; i<dataList.size(); i++) {
				HashMap<String, Object> videoMap = dataList.get(i);
				//视频aid
				//String aid = (String)videoMap.get("aid");
				String aid =videoMap.get("aid").toString();
				System.out.println(aid);
				//视频bvid
				String bvid =(String)videoMap.get("bvid");
				System.out.println(bvid);
				//视频cid
				//String cid =(String)videoMap.get("cid");
				String cid =videoMap.get("cid").toString();
				System.out.println(cid);
				//duration
				//String duration =(String)videoMap.get("duration");
				String duration =videoMap.get("duration").toString();
				System.out.println(duration);
				//pic
				String pic =(String)videoMap.get("pic");
				System.out.println(pic);
				//desc
				String desc =(String)videoMap.get("desc");
				System.out.println(desc);
				//title
				String title =(String)videoMap.get("title");
				System.out.println(title);
				//copyright
				//String copyright =(String)videoMap.get("copyright");
				String copyright =videoMap.get("copyright").toString();
				System.out.println(copyright);
				//tid
				//String tid =(String)videoMap.get("tid");
				String tid =videoMap.get("tid").toString();
				System.out.println(tid);
				//tname
				String tname =(String)videoMap.get("tname");
				System.out.println(tname);
				//videos
				//String videos =(String)videoMap.get("videos");
				String videos =videoMap.get("videos").toString();
				System.out.println(videos);
				
				HashMap<String, Object> ownerMap = (HashMap<String, Object>)videoMap.get("owner");
				//mid
				//String mid =ownerMap.get("mid");
				String mid =ownerMap.get("mid").toString();
				System.out.println(mid);
				//ctime
				//String ctime =(String)videoMap.get("ctime");
				String ctime =videoMap.get("ctime").toString();
				System.out.println(ctime);
				//pubupdate
				String pubupdate =(String)videoMap.get("pubupdate");
				System.out.println(pubupdate);
				
				HashMap<String, Object> statMap = (HashMap<String, Object>)videoMap.get("stat");
				//stat_coin
				//String stat_coin =(String)statMap.get("coin");
				String stat_coin =statMap.get("coin").toString();
				System.out.println(stat_coin);
				//stat_danmuku
				String stat_danmuku =(String)statMap.get("danmuku");
				System.out.println(stat_danmuku);
				//stat_dislike
				//String stat_dislike =(String)statMap.get("dislike");
				String stat_dislike =statMap.get("dislike").toString();
				System.out.println(stat_dislike);
				//stat_favorite
				//String stat_favorite =(String)statMap.get("favorite");
				String stat_favorite =statMap.get("favorite").toString();
				System.out.println(stat_favorite);
				//stat_like
				//String stat_like =(String)statMap.get("like");
				String stat_like =statMap.get("like").toString();
				System.out.println(stat_like);
				//stat_reply
				//String stat_reply =(String)statMap.get("reply");
				String stat_reply =statMap.get("reply").toString();
				System.out.println(stat_reply);
				//stat_share
				//String stat_share =(String)statMap.get("share");
				String stat_share =statMap.get("share").toString();
				System.out.println(stat_share);
				//stat_view
				//String stat_view =(String)statMap.get("view");
				String stat_view =statMap.get("view").toString();
				System.out.println(stat_view);
				
			/*	//vip_type
				String vip_type =(String)videoMap.get("vip_type");
				System.out.println(vip_type);*/
				
				/*//create_time
				String create_time =(String)videoMap.get("create_time");
				System.out.println(create_time);
				//update_time
				String update_time =(String)videoMap.get("update_time");
				System.out.println(update_time);*/
				
				try {
				String videoSql = "INSERT video (aid, bvid, cid, pic, descc, title, copyright, tid, tname, videos, mid, ctime, pubupdate, stat_coin, stat_danmuku, stat_dislike, stat_favorite, stat_like, stat_reply, stat_share, stat_view, create_time, update_time) VALUES ('" + aid + "', '" + bvid +"', '" + cid + "', '" + pic + "', '" + desc +"', '" + title +"', '" + copyright + "', '" + tid +"', '" + tname +"', '" + videos +"', '" + mid +"', '" + ctime +"', '" + pubupdate +"', '" + stat_coin +"', '" + stat_danmuku +"', '" + stat_dislike +"', '" + stat_favorite +"', '" + stat_like +"', '" + stat_reply +"', '" + stat_share +"', '" + stat_view +"', now(), now()) ON DUPLICATE KEY UPDATE update_time=now()";
				                //"INSERT item (item_id, item_name, primary_image, min_salePrice, max_salePrice, min_marketPrice, max_marketPrice, gmt_create, gmt_update)                                                                                             VALUES ('" + itemId + "', '" + title +"', '" + primaryImage + "', '" + minSalePrice + "', '" + maxSalePrice +"', '" + minMarketPrice +"', '" + maxMarketPrice + "', now(), now()) ON DUPLICATE KEY UPDATE gmt_update=now()";
				System.out.println(videoSql);
				st.executeUpdate(videoSql);
				}catch(Exception e) {
					continue;
				}
	    	
    	}
	    	TimeUnit.MILLISECONDS.sleep((long) (Math.random()*3000));//毫秒
    	}
	}
}
