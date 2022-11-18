package com.dictionary.service.impl;

import com.dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String, String> stringMap = new HashMap<>();
    static {
        stringMap.put("mouse","chuột");
        stringMap.put("cat","mèo");
        stringMap.put("dog","chó");
        stringMap.put("tiger","hổ");
        stringMap.put("lion","sư tử");
    }
    @Override
    public Map<String, String> result() {
        return stringMap;
    }
}
