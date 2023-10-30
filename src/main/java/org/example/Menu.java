package org.example;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItmes;

    public Menu(List<MenuItem> menuItems) {
        this.menuItmes = menuItems;
    }

    public MenuItem choose(String name) {
        return this.menuItmes.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));
    }
}
