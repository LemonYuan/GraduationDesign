package scau.services;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import scau.mappers.IFilmDAO;

@Service
public class FilmServices implements IFilmServices{
	@Autowired
    IFilmDAO iFilmDAO;
	
	public JsonObject getFilmsByCategory(){
		List<LinkedHashMap<String, Object>> film_list=iFilmDAO.getFilmsByCategory();
		JsonObject jo=new JsonObject();
		JsonArray ja=new JsonArray();
		for(int i=0;i<film_list.size();i++){
			int index=0;
			LinkedHashMap hm=film_list.get(i);
			JsonObject tem_jo=new JsonObject();
			Iterator iter=hm.entrySet().iterator();
			while(iter.hasNext()){
				Entry entry = (Entry) iter.next();
				if(index==0){
					tem_jo.addProperty("name", entry.getValue().toString());
					index=1;
				}
				else{
					System.out.println( entry.getKey()+"  "+entry.getValue());
					tem_jo.addProperty("value", entry.getValue().toString());
					index=0;
				}
			}
			ja.add(tem_jo);
		}
		jo.add("data", ja);
		System.out.println(jo.toString());
		return jo;
	}
}
