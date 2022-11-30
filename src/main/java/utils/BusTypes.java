package utils;

public enum BusTypes {

    SEAT("seat","Ghế ngồi"),

    BED("bed","Giường nằm");

    private String id, name;

    BusTypes(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static BusTypes getById(String id) {
        for (BusTypes e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return SEAT;
    }

    public static BusTypes getByName(String name) {
        for (BusTypes e : values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return SEAT;
    }

}
