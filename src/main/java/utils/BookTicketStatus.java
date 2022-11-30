package utils;

public enum BookTicketStatus {
    UNPAID("unpaid", "Chưa thanh toán"),
    PAID("paid", "Đã thanh toán"),

    CANCEL("cancel", "Bị hủy");
    private String id, name;

    BookTicketStatus(String id, String name) {
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

    public static BookTicketStatus getById(String id) {
        for (BookTicketStatus e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return UNPAID;
    }

    public static BookTicketStatus getByName(String name) {
        for (BookTicketStatus e : values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return UNPAID;
    }

}
