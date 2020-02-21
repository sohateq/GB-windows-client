package retrofitModel.entity;

import com.google.gson.annotations.Expose;

public class InfoData {

    @Expose
    private Integer infoId;
    @Expose
    private String name; // Наисменование элеента
    @Expose
    private Double weight; // Вес элемента
    @Expose
    private Double priceSv;
    @Expose
    private Double priceRin; // Закупочноя цена
    @Expose
    private Double priceDzsl;

    public InfoData(Integer infoId, String name, Double weight, Double priceSv, Double priceRin, Double priceDzsl) {
        this.infoId = infoId;
        this.name = name;
        this.weight = weight;
        this.priceSv = priceSv;
        this.priceRin = priceRin;
        this.priceDzsl = priceDzsl;
    }

    public InfoData(String name, Double weight, Double priceSv, Double priceRin, Double priceDzsl) {
        this.name = name;
        this.weight = weight;
        this.priceSv = priceSv;
        this.priceRin = priceRin;
        this.priceDzsl = priceDzsl;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPriceSv() {
        return priceSv;
    }

    public Double getPriceRin() {
        return priceRin;
    }

    public Double getPriceDzsl() {
        return priceDzsl;
    }

    @Override
    public String toString() {
        return "InfoData{" +
                "infoId=" + infoId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", priceSv=" + priceSv +
                ", priceRin=" + priceRin +
                ", priceDzsl=" + priceDzsl +
                '}';
    }
}