package task3;

import java.util.List;
import java.util.Objects;

public class TestJSON {

    private int id;
    private String title;
    private String value;
    private List<TestJSON> values;

    public TestJSON() {
    }

    public TestJSON(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
    }

    public TestJSON(int id, String title, String value, List<TestJSON> values) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = values;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TestJSON> getValues() {
        return values;
    }

    public void setValues(List<TestJSON> values) {
        this.values = values;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestJSON testJSON = (TestJSON) o;

        if (id != testJSON.id) return false;
        if (!Objects.equals(title, testJSON.title)) return false;
        if (!Objects.equals(value, testJSON.value)) return false;
        return Objects.equals(values, testJSON.values);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (values != null ? values.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestJSON{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}