package smartgrabber.examples.collectionanalyzer;

import java.util.Collection;

/**
 * Created by mit_OK! on 24.10.2015.
 */
public interface ICollectionDeleteAnalyzer extends ICollectionTimeAnalyzer {
    Number checkTimeDeletingElement (Collection collection);
}
