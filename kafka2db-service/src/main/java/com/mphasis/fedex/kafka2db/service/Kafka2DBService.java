package com.mphasis.fedex.kafka2db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.mphasis.fedex.kafka2db.catalogue.dao.CatalogueDAO;
import com.mphasis.fedex.kafka2db.catalogue.model.Catalogue;
import com.mphasis.fedex.kafka2db.order.dao.OrderDAO;
import com.mphasis.fedex.kafka2db.order.model.Order;
import com.mphasis.fedex.kafka2db.user.dao.UserDAO;
import com.mphasis.fedex.kafka2db.user.model.User;

import lombok.extern.slf4j.Slf4j;

@EnableBinding(Sink.class)
@Slf4j
@EnableAutoConfiguration
public class Kafka2DBService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	CatalogueDAO catalogueDAO;
	
	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='User'")
	public void saveUsers(User user) {
		user = userDAO.saveUser(user);
		log.info("Database save completed for user object : " + user);
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='Order'")
	public void saveOrder(Order order) {
		order = orderDAO.saveOrder(order);
		log.info("Database save completed for order object : " + order);
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='Catalogue'")
	public void saveCatalogue(Catalogue catalogue) {
		catalogue = catalogueDAO.saveCatalogue(catalogue);
		log.info("Database save completed for catalogue object : " + catalogue);
	}

}
