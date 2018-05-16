package forkJoinPoolTest;

import lombok.Data;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class ForkJoinPoolTest3 {
    public ConcurrentHashMap<String, Object> conHashMap;

    @Data
    public static class Province{
        private String code;
        private List<City> cities;
    }

    @Data
    public static class City{
        private Integer id;
        private String name;
        private String code;

    }

    private void initData(){
        String[] names = {"北京", "重庆", "上海", "测试"};
        String[] code = {"10101","10201", "10301", "10401"};
        String[] proCode = {"101","102", "103", "104"};

        //init province
        for (String s : proCode) {
            Province province = new Province();
            province.setCode(s);
            conHashMap.put(s, province);
        }
        //init cities
        for (int i = 0; i < 100; i++) {
        }

    }

    private void test3(){

    }
}
