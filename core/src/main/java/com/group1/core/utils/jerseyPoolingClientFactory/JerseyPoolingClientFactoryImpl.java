package com.group1.core.utils.jerseyPoolingClientFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class JerseyPoolingClientFactoryImpl implements JerseyPoolingClientFactroy {

	private Client client;

	private int maxTotal = 2000;

	private int defaultMaxPerRoute = 1000;

	private ClientConfig clientConfig;

	public JerseyPoolingClientFactoryImpl() {
	}

	public JerseyPoolingClientFactoryImpl(ClientConfig clientConfig) {
		this.clientConfig = clientConfig;
	}

	public JerseyPoolingClientFactoryImpl(int maxTotal, int defaultMaxPerRoute) {
		this.maxTotal = maxTotal;
		this.defaultMaxPerRoute = defaultMaxPerRoute;
	}

	@Override
	public void destroy() throws Exception {
		this.client.close();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.clientConfig == null) {
			final ClientConfig clientConfig = new ClientConfig();
			// 连接池管理实例，该类是线程安全的，支持多并发操作
			PoolingHttpClientConnectionManager pcm = new PoolingHttpClientConnectionManager();
			pcm.setMaxTotal(this.maxTotal);
			pcm.setDefaultMaxPerRoute(this.defaultMaxPerRoute);
			
			clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, pcm); 
		     
		     
		      // 使用配置Apache连接器，默认连接器为HttpUrlConnector 
		      clientConfig.connectorProvider(new ApacheConnectorProvider()); 
			client = ClientBuilder.newClient(clientConfig);
		} else {

			client = ClientBuilder.newClient(this.clientConfig);
		}
	}

	@Override
	public Client getObject() throws Exception {
		if (null == this.client) {
			return ClientBuilder.newClient();
		}
		return this.client;
	}

	@Override
	public Class<?> getObjectType() {
		return (this.client == null ? Client.class : this.client.getClass());
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}