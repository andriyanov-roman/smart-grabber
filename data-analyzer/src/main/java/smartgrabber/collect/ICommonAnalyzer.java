package smartgrabber.collect;

import java.util.Collection;

/**
 * Created by Администратор on 24.10.2015.
 */
public interface ICommonAnalyzer <T extends Collection, Map>{
    <U extends  Number> U checkTimeStartInsert (T t);
    <U extends  Number> U checkTimeEndInsert(T t);
    <U extends  Number> U checkTimeDelete(T t);
    <U extends  Number> U  analyzeMemorySize(T t);
}
