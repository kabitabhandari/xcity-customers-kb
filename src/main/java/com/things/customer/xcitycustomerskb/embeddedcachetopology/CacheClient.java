package com.things.customer.xcitycustomerskb.embeddedcachetopology;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.stereotype.Component;

@Component
public class CacheClient {

    public static final String HAZEL_CAST_CACHE_NAME = "cars";
    private final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(createConfig());

    public Car put(String key, Car value){
        IMap<String, Car> map = hazelcastInstance.getMap(HAZEL_CAST_CACHE_NAME);
        return map.putIfAbsent(key, value);
        /*
        note putIfAbsent: If the specified key is not already associated with a value, associate it with the given value. This is equivalent to
         if (!map.containsKey(key))
             return map.put(key, value);
         else
             return map.get(key);
         */
    }

    public Car get(String key){

        IMap<String, Car> map = hazelcastInstance.getMap(HAZEL_CAST_CACHE_NAME);
        if(!map.isEmpty()) {
            return map.get(key);
        }
        return null;
    }

    public Config createConfig() {
        Config config = new Config();
        config.addMapConfig(mapConfig());
        config.getSerializationConfig().addSerializerConfig(serializerConfig());
        return config;
    }

    private SerializerConfig serializerConfig() {
        return  new SerializerConfig()
                .setImplementation(new CarSerializer())
                .setTypeClass(Car.class);
    }

    private MapConfig mapConfig() {
        MapConfig mapConfig = new MapConfig(HAZEL_CAST_CACHE_NAME);
        mapConfig.setTimeToLiveSeconds(360);
        mapConfig.setMaxIdleSeconds(20);
        return mapConfig;
    }
}