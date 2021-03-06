package handler;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAO;
import test.Controller;

public class Handler {
	
	private final static Logger logger = LogManager.getLogger(Controller.class);
	DAO dao = new DAO();
	static String json;
	
	public String getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		String req = request.getQueryString();
		logger.info("Im in getAllParts Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			json = new ObjectMapper().writeValueAsString(query_pairs);
			logger.info("JSON: " + json.toString());
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return "Getting All Parts with Args: " + query_pairs.toString();
		}
		return "Getting All Parts!";
	}
	
	public String getResourceById(@PathVariable int rid) {
		logger.info("Im in getPartById Method");
		return "Getting Part By Id: " + rid;
	}
	
	public String getAllSuppliers(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSupplierById(int sid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getAllCustomers(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCustomerById(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllTowns(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTownByID(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllRegions(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRegionById(int reg_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllCategories(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCategoryById(int cat_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	//=================================================================
	
	private static Map<String, String> splitQuery(HttpServletRequest request) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new HashMap<String, String>();
	    String req = request.getQueryString();
	    String[] pairs = req.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
	    }
	    return query_pairs;
	}
	
	private static String jsonObject() {
		
		return json;
	}
	
}
