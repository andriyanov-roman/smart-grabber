package smartgrabber.collection_analyzer.lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mit_OK! on 08.11.2015.
 */
public class ArrayListAnalyzer<T> extends ListAnalyzerImpl {

    public ArrayListAnalyzer(ArrayList list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }

    public class OneElementAdder implements IExecutor {
        private T elementForAdding;

        public OneElementAdder(T elementForAdding) {
            this.elementForAdding = elementForAdding;
        }

        public T getElementForAdding() {
            return elementForAdding;
        }

        public void setElementForAdding(T elementForAdding) {
            this.elementForAdding = elementForAdding;
        }

        @Override
        public void execute() {
            list.add(elementForAdding);
        }
    }

    public class ManyElementsAdder implements IExecutor {
        private Collection<? extends T> elementsForAdding;

        public ManyElementsAdder(Collection<? extends T> elementsForAdding) {
            this.elementsForAdding = elementsForAdding;
        }

        public Collection<? extends T> getElementsForAdding() {
            return elementsForAdding;
        }

        public void setElementsForAdding(Collection<? extends T> elementsForAdding) {
            this.elementsForAdding = elementsForAdding;
        }

        @Override
        public void execute() {
            list.addAll(elementsForAdding);
        }
    }

    public class RemoverByObject implements IExecutor {
        private T elementForRemoving;

        public RemoverByObject(T elementForRemoving) {
            this.elementForRemoving = elementForRemoving;
        }

        public T getElementForAdding() {
            return elementForRemoving;
        }

        public void setElementForAdding(T elementForAdding) {
            this.elementForRemoving = elementForAdding;
        }

        @Override
        public void execute() {
            list.remove(elementForRemoving);
        }
    }

    public class RemoverByNumber implements IExecutor {
        private int elementNumber;

        public RemoverByNumber(int elementNumber) {
            this.elementNumber = elementNumber;
        }

        public int getElementNumber() {
            return elementNumber;
        }

        public void setElementNumber(int elementNumber) {
            this.elementNumber = elementNumber;
        }

        @Override
        public void execute() {
            list.remove(elementNumber);
        }
    }

}
