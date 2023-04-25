package model;

public class Connection {
    private String from;
    private String to;
    private int length;

    public Connection(String from, String to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    //MODIFIES: this
    //EFFECTS: sets from
    public void setFrom(String newFrom) {
        from = newFrom;
    }

    //MODIFIES: this
    //EFFECTS: sets to
    public void setTo(String newTo) {
        to = newTo;
    }

    //EFFECTS: returns from
    public String getFrom() {
        return from;
    }

    //EFFECTS: returns to
    public String getTo() {
        return to;
    }

    //EFFECTS: returns length
    public int getLength() {
        return length;
    }

}
