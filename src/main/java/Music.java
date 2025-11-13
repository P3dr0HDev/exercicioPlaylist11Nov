public class Music {

    private String name;
    private String style;
    private int bpm;

    public Music (String name, String style, int bpm){
        this.name = name;
        this.style = style;
        this.bpm = bpm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }
}
