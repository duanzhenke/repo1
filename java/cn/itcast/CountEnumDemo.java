package cn.itcast;

public enum CountEnumDemo {

    One(1,"珊莎"),Two(2,"龙妈"),Three(3,"雪诺"),Four(4,"兰尼斯特，詹姆"),Five(5,"刺客之王，二丫"),Six(6,"夜王");

    private Integer id;
    private  String name;
    CountEnumDemo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static  CountEnumDemo forEach(int index){
        CountEnumDemo[] values = CountEnumDemo.values();
        for (CountEnumDemo value : values) {
            if (index==value.id){
                return  value;
            }
        }
        return null;
    }
}
