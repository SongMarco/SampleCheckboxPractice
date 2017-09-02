package nova.samplecheckbox;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017-09-02.
 */
public class ListViewItem {
    private Drawable icon ;
    private String text ;

    public void setIcon(Drawable icon) {
        this.icon = icon ;
    }
    public void setText(String text) {
        this.text = text ;
    }

    public Drawable getIcon() {
        return this.icon ;
    }

    public String getText() {
        return this.text ;
    }
}

