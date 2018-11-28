package com.wlopera.spring.wrapper;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.wlopera.spring.domain.AbstractInit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonRootName("Wrapper")
@Getter
@Setter
@ToString
public class AbstractWrapper implements Serializable {
	
	private static final long serialVersionUID = 8346687824289515002L;
	private List<AbstractInit> list;
	
}
