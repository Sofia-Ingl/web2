package beans;

import java.util.ArrayList;
import java.util.List;

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
}
