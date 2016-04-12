package com.cruz.sec.persistence.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

public abstract interface TransactionsDao {

//	String OPER_GET = "CALL STORE_PRO( #{CUR1, mode=OUT, jdbcType=CURSOR, javaType=java.sql.ResultSet, resultMap=fnResult} )";
//	
//	@Select(OPER_GET)
//	@Options(statementType = StatementType.CALLABLE)
//	public abstract Object getIncidents(Map<String, Object> params);
	
	@Select(value = "{"
			+ " #{map.resultado, mode=OUT, jdbcType=CURSOR, resultMap = fnObtenerTarjeta} = "
			+ " call .VENF_TARJETABIN ("
			+ " #{binData, mode=IN, jdbcType=NUMERIC}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)
	public void obtenerInfoTarjeta(@Param("map") Map<String, Object> resultado, @Param("binData") String binData);
	
}
