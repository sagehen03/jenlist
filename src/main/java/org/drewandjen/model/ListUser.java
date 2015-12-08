package org.drewandjen.model;

/**
 * Created by dhite on 11/28/15.
 */
public class ListUser {

    private String name;

    private int id;

    public ListUser(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListUser listUser = (ListUser) o;

        if (id != listUser.id) return false;
        return !(name != null ? !name.equals(listUser.name) : listUser.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
