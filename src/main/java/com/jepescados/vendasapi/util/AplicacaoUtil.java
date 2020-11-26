package com.jepescados.vendasapi.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;


public class AplicacaoUtil {
	public static final String FORMATO_DATA_HORA = "yyyy-MM-dd HH:mm:ss";
	public static final DateTimeFormatter FORMATADOR_DATA_HORA = DateTimeFormatter.ofPattern(FORMATO_DATA_HORA);
	
	
	public static String converterParaJson(Object objeto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"));

		return mapper.writeValueAsString(objeto);
	}
	
	public static String converterParaString(Throwable ex) {
		StringWriter stringWriter= new StringWriter();
		PrintWriter printWriter= new PrintWriter(stringWriter);
		ex.printStackTrace(printWriter);

		return stringWriter.toString();
	}
	
	public static Map<String, Object> converterJsonParaMap(String json)
			throws JsonParseException, JsonMappingException, IOException {

		return new ObjectMapper().readValue(json, new TypeReference<HashMap<String, Object>>() {
		});
	}

	public static <T> List<T> converterJsonParaList(String json, Class<T> classe)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.findAndRegisterModules().readValue(json,
				objectMapper.getTypeFactory().constructCollectionType(List.class, classe));
	}



}
