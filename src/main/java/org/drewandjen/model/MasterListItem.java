package org.drewandjen.model;

/**
 * Created by dhite on 8/29/15.
 */
public class MasterListItem {

    private int id;

    private String name;

    private String category;

    public MasterListItem(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
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
                ", category='" + category + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterListItem that = (MasterListItem) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(category != null ? !category.equals(that.category) : that.category != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
