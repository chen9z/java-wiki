package wiki.annotation;

/**
 * Created by chen on 2020/7/17.
 */
public class Apple {
    @FruitName(name="小黄花")
    private String name;

    private String weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }


}
