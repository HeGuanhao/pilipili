package com.igeek.hbut.shixi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {

	public static void main(String[] args) {
		//getNoParam();
		//getByParam();
		//postNoParam();
		//postByParam();
	}

	/**
	 * 无参GET请求测试
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String getNoParam(String url) {
		String result = null;
		
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建http GET请求
		HttpGet httpGet = new HttpGet(url);
		// 执行请求
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				// 请求体内容
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				result = content;
				//System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return result;
	}

	// get有参数
	public static String getByParam(String url, Map<String, String> paramMap) {
		String result = null;
		
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// response 对象
		CloseableHttpResponse response = null;
		try {
			StringBuilder params = new StringBuilder();
			paramMap.forEach((key, value) -> {
				params.append(key + "=" + value + "&");
			});
			System.out.println(url + "?" + params);
			
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(url + "?" + params);
			
			// 执行http get请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				result = EntityUtils.toString(response.getEntity(), "UTF-8");
				// 内容写入文件
				//FileUtils.writeStringToFile(new File("D:/tmp/baidu-param.html"), content, "UTF-8");
				//System.out.println("内容长度：" + content.length());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//post无参
	public static String postNoParam(String url) {
		String result = null;
		
		// 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        //伪装浏览器请求
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
                //内容写入文件
                //FileUtils.writeStringToFile(new File("D:/tmp/oschina.html"), content, "UTF-8");
                //System.out.println("内容长度："+content.length());
            }
        } catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return result;
	}
	
	//post带参
	public static String postByParam(String url, Map<String, String> paramMap) {
		String result = null;
		
		// 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        
        paramMap.forEach((key, value) -> {
        	parameters.add(new BasicNameValuePair(key, value));
        });
        
        CloseableHttpResponse response = null;
        try {
        	// 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(formEntity);
            //伪装浏览器
            httpPost.setHeader("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
                //内容写入文件
                //FileUtils.writeStringToFile(new File("d:/tmp/oschina-param.html"), content, "UTF-8");
                //System.out.println("内容长度："+content.length());
            }
        } catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return result;
	}
	
	//post带参
		public static String postByJsonParam(String url, String jsonParam) {
			String result = null;
			
			// 创建Httpclient对象
	        CloseableHttpClient httpclient = HttpClients.createDefault();
	        // 创建http POST请求
	        HttpPost httpPost = new HttpPost(url);
	        
	        CloseableHttpResponse response = null;
	        try {
	        	StringEntity stringEntity = new StringEntity(jsonParam, "UTF-8");
	            httpPost.setEntity(stringEntity);
	            
	            //伪装浏览器
	            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36");
	            httpPost.setHeader("content-type", "application/json;charset=UTF-8");
	            httpPost.setHeader("accept", "*/*");
	            httpPost.setHeader("accept-encoding", "gzip, deflate, br");
	            httpPost.setHeader("accept-language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7");
	            // 执行请求
	            response = httpclient.execute(httpPost);
	            // 判断返回状态是否为200
	            if (response.getStatusLine().getStatusCode() == 200) {
	                result = EntityUtils.toString(response.getEntity(), "UTF-8");
	                //内容写入文件
	                //FileUtils.writeStringToFile(new File("d:/tmp/oschina-param.html"), content, "UTF-8");
	                //System.out.println("内容长度："+content.length());
	            }
	        } catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (response != null) {
						response.close();
					}
					httpclient.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	        return result;
		}
	
}
