package com.enums;

/**
 * 季节测试枚举
 */
public class TestSeason2 {
    public static void main(String[] args) {
        SeasonEnum spring = SeasonEnum.SPRING;
        System.out.println(spring);
        System.out.println(spring.getSeasonName());
        //1.values
        SeasonEnum[] seasonEnums = SeasonEnum.values();
        for (SeasonEnum season : seasonEnums) {
            System.out.println(season);
        }
        //2.valueOf
        String str = "SPRING";
        SeasonEnum seasonEnum2 = SeasonEnum.valueOf(str);
        System.out.println(seasonEnum2);
        //3.枚举类实现接口
        spring.show();
    }
}

interface Info {
    void show();
}

/**
 * enum枚举类
 */
enum SeasonEnum implements Info {
    /**
     * SPRING、SUMMER、AUTUMN、WINTER都重写了接口的show()方法
     */
    SPRING("spring", "春天") {
        public void show() {
            System.out.println("春天来了");
        }
    },
    SUMMER("summer", "夏天") {
        public void show() {
            System.out.println("夏天来了");
        }
    },
    AUTUMN("autumn", "秋天") {
        public void show() {
            System.out.println("秋天来了");
        }
    },
    WINTER("winter", "冬天") {
        public void show() {
            System.out.println("冬天来了");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

//    @Override
//    public void show() {
//        System.out.println("枚举类实现接口");
//    }
}