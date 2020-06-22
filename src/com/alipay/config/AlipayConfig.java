package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092400582883";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDXkWO7+71FbwBn16DadddtB1oHb131qRisZB1CB0e52k5cKV6UhfxMGDE5NHAsxQw73R2ySSnHTfTEThcjZLORwJkmAkP737mbsMzfe343hVWW2e3ZGJw669Vnxa4S6Wa3+S6ljaG9XOCOKIoU97Bo2yzOuDsw7MhpxthIhjEcW1rV4a0vGdgxERGMOLHKysX+GrEc+O+uaDevpbis4OsVrpsfOvGvo+UQR/KAipKUr2XMBNStV7g7stfa3rqKu0eKVHYwhVPa4JLdsjWLoReBWORpQAOzz6cV2/fuGAFPjsnkmUIvMFa0J2fvb74Hd6eUvJDFIhRckEFynm7+s1KlAgMBAAECggEAF8timONmtv1TrCKvDK4pQ02mcF+onW823ACJAjrPfgJM1/txBy/q83NQK6JQJ4DwosL7fix5QhimxexgvXVmJNZ/kSR64JiHYloXoyt8eSBsnCQeDvKafB6ABd5aIphE0FXfAkMp8T8JQmfTJhFZFZnrzj2juvjH/nUGdqrpTNnMwSXCHAvB3X4jtdLr4xrXoJCj8SEAUzQplBJnkhedv5KmujzljrTCuBPHaxENRQJ7PR0hFjNsJmyTVUCdVmTpMvHiqMxg8CMgiscHQCgRIsu08REsTbkQJ+eo+Oa0rS9m9oYO8mcDp1lgl63lwwRLWuG0cSSI7x0IeqTi9m73QQKBgQDxv36/rMRyN9k+LAsfYKHitxKT4or3hWkJadjYSPbpZ8r/ZXDEoCNYoxXNHXOtBOI+s16QTYElY3xCdnXhUDP4wXLyKQ5C1ok/VV/ikGD3cU7FIf2Kw8/6/5yuo9KDArgKjP143gY6N0fG2qnuH+22k+F17QpqsqVPCKPg6H0H+QKBgQDkRseZSqMLMXxLjl962FVhbEA46QC1jUU44YKSzR4IgKYFk5ViOmG1zSbW77Tb3PT9xuOfoSWwk4ixfypCysNXSHQJs9dC95lWS9KSJK3avdZ2320IFmHYE2wy1YBAzIR/26Ref5hzUXNp1njBgR9ot1oaP3aARY6rFRGkZ9IDDQKBgQCoXzRbMWxdFNLEv447m2UE73cL8vPQ82U1vjfeY+s8oyK6gJ9rAxG7MVME2idv8P/Wpb0OCj0Rmlm4PKNbey3HaoyxZrDdEmji6IZw2RgAHzW6jTL2i+z2J0OsSsNapfEiwBHmNdTmhQwDztYd2LUKvbKBHMhtieEiy6TAB4zVmQKBgQCb0dCnS3I1zsaYUIvOL+NACANilXG9e7v3kr9tc4P/q8kn31DF5zIRRgMwDhm3RoEYxW1U5kvy1xIkjrgLNZrXdoZ2pQLYHGjXphQLW+wsdw7wv5wOPDD3rHJb1K6iDLiZChWNx60JclzErvhopboJ4bYoWo+KCXDUSSJsxc1t9QKBgEbT8gnY7Y/tmgBAQCqQnI60Dv8GZcXnsX3Sx30o5GWLthYV6fPRKkYZBzH9iIN9spT4/reDuWtGJqyU1ePuoqz31HQ31cpvDjrlzsH991S1YbAdbpDW+KfckRdPSvq09eRppPJKCkjyFWqwlkhmmbmFiLJeUkfTRmRlwKqGn/IQ";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7oi4azl48jeZU8/5fvI5V0Sw+XEyNT2L22eAlJ5sa0amDxlsR4pTo7unEpdfi+SQ4Bam5T38lIoJgp4XEsBj8fmtvFQPGSv3CBi0jXpxE6JwQyXX2zzQD0W/YQWXIBiSw4Byf+8ZYwbrB3OtwAqIX+Yj9swS0awAvVGg+IgXRhE4gw3UM94ij4Inh24aYPVzR4kWPpSaHbsAIhjy0lWDh+wYWETg7Z+rN0udx3vqcQKAQr1hb8YxmNyIkTn6LX2UyhB5jOVq0hFS4RcDZ4SwjLpiPNouYwOH2FbQJCqygqSj4aTf7eOMjrAC+Xu6/Fw/jWp02g+TvIZVJfdiu8FdUQIDAQAB";

//	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
//	public static String app_id = "2016092400582883";
//	
//	// 商户私钥，您的PKCS8格式RSA2私钥
//    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDI6qI7GTbq2Ksu1l6VsCw13U25KrFTE6LS0lGJfRyqNBXBDeWU9MQAc29FhoYTTYf9CDuVKi3XiCI5qCBFYSh/WlcpaBNnx8MovyWHIM4mg/UDHnFffWiG4OiG05X6iayeu9UlXZx4rBlQfBSr2pS8qgf36dWkY8/NFsjeoKuu3aVuNPV3Dm0qZaHALV8+0O1zEeUhH/mdvdIfLg9stM1TnHED+iCuaXw+ir2SrWXJTx6WKSyM2QQhDgdaKTg5VO3U4itMKc3VECh49eDczWKmPycgnaBLTa2L625b4wtZomjp7sxgWfi0laTFeBXbgGKQKGHX7zrVoqdxgIQE6ohRAgMBAAECggEAPtAkIgfTBH7ynbUFYxTt7XUfnHk9cPSdnf2E4lAMCyY3euCmWvhe4qk0K29QMW62yiOtxQenx09XK+FlHWuvpokO4PIZxwNL/0wrJmDaMm5kxjHZTfo+GJTt/WDe7bHnFsUwcPsgNRXQ4Dm6mLPAdm9OCHLBiSBvUfYCnJ9srUEuUec0PWBoykyFGP7Rr6c22KWdQiN2X7AZ3o2yxsu9AZMIHIkStDPOLYWd501PV4U7GxwyJzaFIsZiB+nDcJKnboS0Bz/Wfx7bckUJddL42SbY+/apCxfppLFJRKkgr34fr+X+tffPtY4+a6CYCMai8qQWKTbJfIVHd3KNGZG1xQKBgQDryugrAEcOFfxWtNaTr5cKM5dH5ARR6jM609YBHi+4Oycsdrty9D9mH3l0KVRu6jwMKbnaTwRjJMlEqMBdvOMrKKeXDoil5S8WDE0ZLYVbOkOsGMWdvNY1sg4TRr/WsdtbtaAyqLEL9mKM3gX7Mtgylat8vsEzFgEPbXwL43JBrwKBgQDaIpMyFhAswWgJ6p3xX9xVxj0uDZt+FIr1eEEv0sSOlpb095VTNqpzQ4qj/2qZOib+LZ8FofDP5gwAGY3LmdfAyLCLnsBCDRMOL+4QwRsKVNva9A6Sy9Pn5OxWUqSelqzJLxaa3gyI+D/pvQ06SlCngo16RDyNeTPeADgKLXRV/wKBgAN+VyBD+cmIo9t5BHDduiQpjYVAKJw6FxY5C0Oq+dQF9FehTreuTL4rmzYQYrLd/5PCjoFgiFUbt2uwAGGjKc565LjFO1sR4Te3aPEFjqNCYrxLBaqHoLjc8X5xnugEbJaYQ05c13qw5Nbndzk4kKF3PDo17VDfc5aR7bOTZB77AoGAN2sVTmJAlb5FOk+69LnP9pK4tFyMpol9jEOS/B1mBnvHulC0RUHcKBB+xo97e5ZElcrtXbb4wTjGz7euSI27PKVABRi964n6z13p86O7xPIuMQBUO4NBQObuDDhOzmOlXi9yZMIJGTtIsY9wLuD2gLgwTWHMqHykasBPfHZz2e0CgYEAryawqKj6dELq3r6vf6ZkwZyxwk/EZE02QRET3wAI1p6HO/jZzQHxeuJ/IcOyIupQDMq0z1Knx9DO5k/lzaO4V4BK/mRsTkl3kyC0mBfltjByuy7ob0UiO/2C18fIvPrJ5wjO2qE7xQpSzb6x1HbfQIq+Xg/CmIaEdoy3wOWC/w8=";
//	
//	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyOqiOxk26tirLtZelbAsNd1NuSqxUxOi0tJRiX0cqjQVwQ3llPTEAHNvRYaGE02H/Qg7lSot14giOaggRWEof1pXKWgTZ8fDKL8lhyDOJoP1Ax5xX31ohuDohtOV+omsnrvVJV2ceKwZUHwUq9qUvKoH9+nVpGPPzRbI3qCrrt2lbjT1dw5tKmWhwC1fPtDtcxHlIR/5nb3SHy4PbLTNU5xxA/ogrml8Poq9kq1lyU8eliksjNkEIQ4HWik4OVTt1OIrTCnN1RAoePXg3M1ipj8nIJ2gS02ti+tuW+MLWaJo6e7MYFn4tJWkxXgV24BikChh1+861aKncYCEBOqIUQIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/book_object/web-page/index.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://localhost:8080/book_object/web-page/return_url.jsp";
	public static String return_url = "http://localhost:8080/book_object/web-page/index	.jsp";
	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord 要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
