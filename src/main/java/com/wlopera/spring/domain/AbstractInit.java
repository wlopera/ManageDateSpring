package com.wlopera.spring.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AbstractInit  implements Serializable{
	
	private static final long serialVersionUID = 4984851815744043782L;
	
	private Integer key;
	private String value;
	
}
