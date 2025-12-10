package modul09;

import java.io.Serializable;

public class UserConfig implements Serializable {
    private String username;
    private int font;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFontSize() {
        return font;
    }

    public void setFontSize(int font) {
        this.font = font;
    }
}