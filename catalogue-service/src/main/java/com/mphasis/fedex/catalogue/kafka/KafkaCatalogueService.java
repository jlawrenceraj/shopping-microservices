package com.mphasis.fedex.catalogue.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.mphasis.fedex.catalogue.model.Catalogue;

@EnableBinding(Source.class)
public class KafkaCatalogueService {
	
	@Autowired
	MessageChannel output;

	public Catalogue saveCatalogue(Catalogue catalogue) {
		output.send(MessageBuilder.withPayload(catalogue).setHeader("type", "Catalogue").build());
		return catalogue;
	}
}
