package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Time extends Model {

    private int id;

    private Timestamp startTime, endTime;

    public Time() {    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public static Time getFromResultSet(ResultSet rs) throws SQLException {
        Time t = new Time();
        t.setId(rs.getInt("id"));
        t.setStartTime(rs.getTimestamp("startTime"));
        t.setEndTime(rs.getTimestamp("endTime"));
        return t;
    }

    @Override
    public String toString() {
        return "Route{" + "id=" + id + "startTime=" + startTime + ", endTime=" + endTime + '}';
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
                this.getId(), this.getStartTime(), this.getEndTime()
        };
    }

}