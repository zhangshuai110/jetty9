package com.java;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import sun.misc.IOUtils;

public class TestJavaProxy {

	public static void main(String[] args) throws IOException {
		Properties prop = System.getProperties();
		// HTTP代理的IP设置
		prop.setProperty("http.proxyHost", "10.28.0.254");
		// HTTP代理的端口设置
		prop.setProperty("http.proxyPort", "80");
		// 这里也可以设置不需要使用代理的地址
		prop.setProperty("http.nonProxyHosts", "localhost|10.28.0.*");
		// 设置HTTPS安全访问的代理服务器地址与端口
		prop.setProperty("https.proxyHost", "10.28.0.254");
		prop.setProperty("https.proxyPort", "443");
		// 对于安全访问的过滤地址属性同样是http.nonProxyHosts并没有https.nonProxyHosts

		// FTP的代理设置入下
		prop.setProperty("ftp.proxyHost", "192.168.0.254");
		prop.setProperty("ftp.proxyPort", "2121");
		prop.setProperty("ftp.nonProxyHosts", "localhost|192.168.0.*");
		// SOCKS的代理设置
		prop.setProperty("socksProxyHost", "192.168.0.254");
		prop.setProperty("socksProxyPort", "8000");

		// 设置登陆到代理服务器的用户名和密码
		Authenticator.setDefault(new MyAuthenticator("userName", "Password"));
		// **************
		// JDK5及其之后版本引入新的代理配置，可以满足对特定连接进行配置
		// **************
		URL url = new URL("http://www.shanhe114.com");
		// 创建代理服务器
		InetSocketAddress addr = new InetSocketAddress("10.28.0.4", 8080);
		// Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr); //SOCKS代理
		Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // HTTP代理
		// 其他方式可以见Proxy.Type属性
		URLConnection conn = url.openConnection(proxy);
		InputStream in = conn.getInputStream();
		// InputStream in = url.openStream();
		byte[] content = IOUtils.readFully(in, 0, true);
		System.out.println(content);

	}

}
