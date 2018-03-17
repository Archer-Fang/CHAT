package se.zust.orm.entity;

public class Relation {
    private Integer concernId;

    private Integer concernedId;

    public Integer getConcernId() {
        return concernId;
    }

    public void setConcernId(Integer concernId) {
        this.concernId = concernId;
    }

    public Integer getConcernedId() {
        return concernedId;
    }

    public void setConcernedId(Integer concernedId) {
        this.concernedId = concernedId;
    }
}