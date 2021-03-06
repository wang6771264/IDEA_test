package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {

    public static void main(String[] args) {
        String[] test1 = {"遵义市","淄博市","资阳市","驻马店市","株洲市","周口市","舟山市","肇庆市","长春市","张掖市","张家口市","张家界市","湛江市","云浮市","岳阳市","玉溪市","榆林市","永州市","营口市","鹰潭市","银川市","益阳市","宜春市","宜昌市","宜宾市","盐城市","延边市","延安市","烟台市","雅安市","宣城市","许昌市","徐州市","宿州市","宿迁市","兴安盟市","信阳市","新余市","新乡市","襄阳市","湘西市","湘潭市","咸阳市","西宁市","武威市","芜湖市","乌兰察布市","乌海市","温州市","渭南市","潍坊市","威海市","铜仁市","铜陵市","铜川市","通辽市","通化市","铁岭市","天水市","天门市","泰安市","台州市","遂宁市","松原市","四平市","绍兴市","邵阳市","上饶市","商丘市","商洛市","三门峡市","日照市","泉州市","曲靖市","衢州市","庆阳市","清远市","黔南市","齐齐哈尔市","濮阳市","莆田市","萍乡市","平凉市","平顶山市","盘锦市","内江市","南阳市","南通市","南昌市","那曲市","梅州市","马鞍山市","漯河市","洛阳市","娄底市","陇南市","龙岩市","六盘水市","六安市","柳州市","临沂市","临夏州市","聊城市","辽源市","辽阳市","连云港市","丽水市","兰州市","开封市","酒泉市","九江市","景德镇市","晋中市","锦州市","金华市","金昌市","焦作市","嘉峪关市","佳木斯市","济源市","济宁市","吉林市市","吉安市","黄山市","黄冈市","淮南市","淮北市","淮安市","怀化市","湖州市","葫芦岛市","呼伦贝尔市","呼和浩特市","红河州市","衡阳市","衡水市","鹤壁市","菏泽市","汉中市","邯郸市","哈尔滨市","桂林市","贵阳市","广安市","赣州市","甘南州市","阜阳市","阜新市","抚州市","鄂尔多斯市","东营市","定西市","丹东市","大同市","大庆市","大连市","大理州市","达州市","滁州市","赤峰市","承德市","郴州市","朝阳市","常德市","亳州市","滨州市","毕节市","本溪市","宝鸡市","包头市","蚌埠市","百色市","白银市","白山市","白城市","巴彦淖尔市","鞍山市","安阳市","安顺市","安庆市","安康市"};
        System.out.println(test1.length);
        HashSet<String> set = new HashSet<>(Arrays.asList(test1));
        List<String> lst2 = new ArrayList<>(Arrays.asList(test1));
        System.out.println(set.size());
        for (String s : test1) {
            if(Collections.frequency(lst2, s) > 1){
                System.out.println(s);
            }
        }
        System.out.println("-------------------分割线--------------------");
        String[] test2 = {"安庆市","蚌埠市","亳州市","滁州市","阜阳市","淮北市","淮南市","黄山市","六安市","马鞍山市","宿州市","铜陵市","芜湖市","宣城市","龙岩市","莆田市","泉州市","兰州市","白银市","定西市","嘉峪关市","金昌市","酒泉市","陇南市","平凉市","庆阳市","天水市","武威市","张掖市","梅州市","清远市","云浮市","湛江市","肇庆市","百色市","桂林市","柳州市","贵阳市","安顺市","六盘水市","遵义市","承德市","邯郸市","衡水市","张家口市","安阳市","鹤壁市","济源市","焦作市","开封市","洛阳市","漯河市","南阳市","平顶山市","濮阳市","三门峡市","商丘市","新乡市","信阳市","许昌市","周口市","驻马店市","哈尔滨市","大庆市","佳木斯市","齐齐哈尔市","黄冈市","天门市","襄阳市","宜昌市","常德市","郴州市","衡阳市","怀化市","娄底市","邵阳市","湘潭市","益阳市","永州市","岳阳市","张家界市","株洲市","长春市","白城市","白山市","辽源市","四平市","松原市","通化市","淮安市","连云港市","南通市","宿迁市","徐州市","盐城市","南昌市","抚州市","赣州市","吉安市","景德镇市","九江市","萍乡市","上饶市","新余市","宜春市","鹰潭市","鞍山市","本溪市","朝阳市","大连市","丹东市","阜新市","葫芦岛市","锦州市","辽阳市","盘锦市","铁岭市","营口市","呼和浩特市","巴彦淖尔市","包头市","赤峰市","鄂尔多斯市","呼伦贝尔市","通辽市","乌海市","乌兰察布市","银川市","西宁市","滨州市","东营市","菏泽市","济宁市","聊城市","临沂市","日照市","泰安市","威海市","潍坊市","烟台市","淄博市","大同市","晋中市","安康市","宝鸡市","汉中市","商洛市","铜川市","渭南市","咸阳市","延安市","榆林市","达州市","广安市","内江市","遂宁市","雅安市","宜宾市","资阳市","曲靖市","玉溪市","湖州市","金华市","丽水市","衢州市","绍兴市","台州市","温州市","舟山市"};
        List<String> lst3 = new ArrayList<>(Arrays.asList(test2));
        for (String s : lst2) {
            if(!lst3.contains(s)){
                System.out.println(s);
            }
        }

        //String[] test3 = {"安庆市","蚌埠市","亳州市","滁州市","阜阳市","淮北市","淮南市","黄山市","六安市","马鞍山市","宿州市","铜陵市","芜湖市","宣城市","龙岩市","莆田市","泉州市","兰州市","白银市","定西市","嘉峪关市","金昌市","酒泉市","陇南市","平凉市","庆阳市","天水市","武威市","张掖市","惠州市","梅州市","清远市","云浮市","湛江市","肇庆市","百色市","桂林市","柳州市","贵阳市","安顺市","六盘水市","遵义市","承德市","邯郸市","衡水市","张家口市","安阳市","鹤壁市","济源市","焦作市","开封市","洛阳市","漯河市","南阳市","平顶山市","濮阳市","三门峡市","商丘市","新乡市","信阳市","许昌市","周口市","驻马店市","哈尔滨市","大庆市","佳木斯市","齐齐哈尔市","黄冈市","天门市","宜昌市","常德市","郴州市","衡阳市","怀化市","娄底市","邵阳市","湘潭市","益阳市","永州市","岳阳市","张家界市","株洲市","长春市","白城市","白山市","吉林市","辽源市","四平市","松原市","通化市","淮安市","连云港市","南通市","宿迁市","徐州市","盐城市","南昌市","抚州市","赣州市","吉安市","景德镇市","九江市","萍乡市","上饶市","新余市","宜春市","鹰潭市","鞍山市","本溪市","朝阳市","大连市","丹东市","阜新市","葫芦岛市","锦州市","辽阳市","盘锦市","铁岭市","营口市","呼和浩特市","巴彦淖尔市","包头市","赤峰市","鄂尔多斯市","呼伦贝尔市","通辽市","乌海市","乌兰察布市","银川市","西宁市","滨州市","东营市","菏泽市","济宁市","聊城市","临沂市","日照市","泰安市","威海市","潍坊市","烟台市","淄博市","大同市","晋中市","安康市","宝鸡市","汉中市","商洛市","铜川市","渭南市","咸阳市","延安市","榆林市","达州市","广安市","内江市","遂宁市","雅安市","宜宾市","资阳市","曲靖市","玉溪市","湖州市","金华市","丽水市","衢州市","绍兴市","台州市","温州市","舟山市","毕节市","铜仁市","济源市",};
        //
        ////List<String> lst1 = new ArrayList<>(Arrays.asList(test1));
        //List<String> lst2 = new ArrayList<>(Arrays.asList(test2));
        //List<String> lst3 = new ArrayList<>(Arrays.asList(test3));
        //lst2.addAll(lst3);

        //字符串堆对比
        //List<String> lst4 = new ArrayList<>();
        //for (String s : lst2) {
        //    if(Collections.frequency(lst2, s) < 2){
        //        lst4.add(s);
        //    }
        //}
        //循环字符对比
        //for (String s : lst2) {
        //    if(!lst3.contains(s)){
        //        System.out.println(s);
        //    }
        //}

        //Date d = new Date(new Date().getTime());
        //System.out.println(d);
        //System.out.println(lst3);

        //String str = "大连市";
        //String str1 = "新疆维吾尔族自治州";
        //System.out.println(str1.replaceAll("^(.*)[市]$", "$1"));
    }

    public static class MessageEvent{
        private Integer msg_code;
        private Short msg_root_key;
        private String content;

        public Integer getMsg_code( ) {
            return msg_code;
        }

        public void setMsg_code(Integer msg_code) {
            this.msg_code = msg_code;
        }

        public Short getMsg_root_key( ) {
            return msg_root_key;
        }

        public void setMsg_root_key(Short msg_root_key) {
            this.msg_root_key = msg_root_key;
        }

        public String getContent( ) {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
