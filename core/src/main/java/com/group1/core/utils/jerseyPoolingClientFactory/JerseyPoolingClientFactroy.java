package com.group1.core.utils.jerseyPoolingClientFactory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import javax.ws.rs.client.Client;

public interface JerseyPoolingClientFactroy extends FactoryBean<Client>, InitializingBean, DisposableBean {
}
