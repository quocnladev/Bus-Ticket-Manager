package utils;

public enum BookTicketType {
    LOCAL("local", "Tại bến"),
    ONLINE("online", "Đặt qua điện thoại");
    private String id, name;

    BookTicketType(String id, String name) {
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

    public static BookTicketType getById(String id) {
        for (BookTicketType e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return LOCAL;
    }

    public static BookTicketType getByName(String name) {
        for (BookTicketType e : values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return LOCAL;
    }

}
