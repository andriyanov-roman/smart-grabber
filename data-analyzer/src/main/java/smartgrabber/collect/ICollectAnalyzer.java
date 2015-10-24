package smartgrabber.collect;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Queue;

/**
 * Created by Администратор on 24.10.2015.
 */
public interface ICollectAnalyzer <T extends  Collection> extends  ICommonAnalyzer{
    <U extends  Number> U checkTimeMiddleInsert (T t);
}
