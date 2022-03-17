package task3;

import java.util.List;
import java.util.Objects;

public class Root {

    private List<TestJSON> tests;

    public Root() {
    }

    public Root(List<TestJSON> testJson) {
        this.tests = testJson;
    }

    public List<TestJSON> getTestJson() {
        return tests;
    }

    public void setTestJson(List<TestJSON> testJson) {
        this.tests = testJson;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Root root = (Root) o;

        return Objects.equals(tests, root.tests);
    }

    @Override
    public int hashCode() {
        return tests != null ? tests.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Root{ tests=" + tests + '}';
    }
}
