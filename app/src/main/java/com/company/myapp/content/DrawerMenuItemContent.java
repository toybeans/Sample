package com.company.myapp.content;

import com.company.myapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryo on 2015/09/22.
 */
public class DrawerMenuItemContent {

    public static List<DrawerMenuItem> ITEMS = new ArrayList<DrawerMenuItem>();

    static {

        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));
        addItem(new DrawerMenuItem(R.drawable.ico_home_50, R.string.hello_world));

    }

    private static void addItem(DrawerMenuItem item) { ITEMS.add(item);}

    public static class DrawerMenuItem {
        public int rImg;
        public int rTitle;

        public DrawerMenuItem(int _rImg, int _rTitle) {
            this.rImg   = _rImg;
            this.rTitle = _rTitle;
        }
    }
}
