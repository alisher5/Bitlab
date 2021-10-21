public class Cars {

    private Long id;
    private String name;
    private int price;
    private double engineVolume;

    public Cars(Long id, String name, int price, double engineVolume) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.engineVolume = engineVolume;
    }

    public Cars() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.price + " " + this.engineVolume;
    }
}
