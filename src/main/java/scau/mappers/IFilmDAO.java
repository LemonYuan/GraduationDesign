package scau.mappers;

import java.util.LinkedHashMap;
import java.util.List;

public interface IFilmDAO {
    public List<LinkedHashMap<String,Object>> getFilmsByCategory();
}
