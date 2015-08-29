package org.drewandjen.model;

/**
 * Created by dhite on 8/29/15.
 */
public class MasterListItem {

    private int id;

    private String name;

    public MasterListItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MasterListItem() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MasterListItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterListItem that = (MasterListItem) o;

        if (id != that.id) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
