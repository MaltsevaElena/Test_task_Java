package task3;

import java.util.Objects;

public class ValuesJSON {

    private int id;
    private String values;

    public ValuesJSON(int id, String values) {
        this.id = id;
        this.values = values;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValuesJSON that = (ValuesJSON) o;

        if (id != that.id) return false;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ValuesJSON{" +
                "id=" + id +
                ", values='" + values + '\'' +
                '}';
    }
}
