package smartgrabber.examples.collectionanalyzer;

import java.util.Collection;

/**
 * Created by randriyanov on 24.10.15.
 */
public interface ICollectionPositionAnalyzer extends ICollectionCommonAnalyzer {
    Number checkTimeStartInserting (Collection collection);
    Number checkTimeMiddleInserting(Collection collection);
    Number checkTimeEndInserting(Collection collection);
}
