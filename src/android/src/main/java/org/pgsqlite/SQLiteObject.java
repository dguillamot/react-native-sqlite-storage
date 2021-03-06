package org.pgsqlite;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/**
 * Created by aporebsk on 11/28/15.
 *
 * Overwrite default JSONObject implementation to allow creation of object using initial load factor
 */
public class SQLiteObject extends JSONObject {
    public SQLiteObject(){
        super();
    }

    public SQLiteObject(int size){
        super();
        try {
            Field valuesField = JSONObject.class.getDeclaredField("nameValuePairs");
            valuesField.setAccessible(true);
            // valuesField.set(valuesField, new LinkedHashMap<String, Object>(size)); // dguillamot - failing with error
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
