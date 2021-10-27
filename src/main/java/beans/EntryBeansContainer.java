package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EntryBeansContainer {

    private List<EntryBean> entryBeansContainer;

    public EntryBeansContainer() {
        this.entryBeansContainer = new ArrayList<>();
    }

    public EntryBeansContainer(List<EntryBean> entryBeans) {
        this.entryBeansContainer = entryBeans;
    }

    public List<EntryBean> getEntryBeansContainer() {
        return entryBeansContainer;
    }

    public void setEntryBeansContainer(List<EntryBean> entryBeansContainer) {
        this.entryBeansContainer = entryBeansContainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntryBeansContainer)) return false;
        EntryBeansContainer that = (EntryBeansContainer) o;
        return Objects.equals(getEntryBeansContainer(), that.getEntryBeansContainer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEntryBeansContainer());
    }

    @Override
    public String toString() {
        return "EntryBeansContainer{" +
                "entryBeansContainer=" + entryBeansContainer +
                '}';
    }
}
