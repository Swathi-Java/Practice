package com.lancesoft.idgenerator;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.boot.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class CustomIdGenerator extends SequenceStyleGenerator {
	public static final String VALUE_PREFIX_PARAMETER="value";
	public static final String VALUE_PREFIX_DEFAULT="";
	public String valuePrefix;
	public static final String NUMBER_FORMAT_PARAMETER="numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT="%d";
	public String numberFormat;
	
	public void configure(Type type,Properties params,ServiceRegistry serviceRegistry) throws MappingException{
		super.configure(LongType.INSTANCE,params,serviceRegistry);
		valuePrefix=ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params,VALUE_PREFIX_DEFAULT);
		numberFormat=ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params,NUMBER_FORMAT_DEFAULT);
	}
	public Serializable generate(SharedSessionContractImplementor session,Object object) throws HibernateException
	{
		return valuePrefix+String.format(numberFormat,super.generate(session, object));
		
	}
	
} 
