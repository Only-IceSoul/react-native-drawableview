package com.jjkit.drawableview;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public class ModUtil {

    static float clamp(float v){
        return v > 1 ? 1 : (v < 0 ? 0 : v);
    }

    static String getString(ReadableMap m, String name, String optional){
        if(m != null){
            String v = m.getString(name);
            if(v != null){
                return v;
            }
        }
        return optional;
    }
    static double getDouble(ReadableMap m, String name, double optional){
        if(m != null){
            return m.getDouble(name);
        }
        return optional;
    }
    static int getInt(ReadableMap m, String name, int optional){
        if(m != null){
            return m.getInt(name);
        }
        return optional;
    }
    static boolean getBoolean(ReadableMap m, String name, boolean optional){
        if(m != null){
            return m.getBoolean(name);
        }
        return optional;
    }
    static ReadableArray getArray(ReadableMap m, String name, ReadableArray optional){
        if(m != null){
            ReadableArray v = m.getArray(name);
            if(v != null){
                return v;
            }
        }
        return optional;
    }
}
