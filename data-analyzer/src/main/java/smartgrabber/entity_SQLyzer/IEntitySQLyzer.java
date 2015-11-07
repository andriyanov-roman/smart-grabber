package smartgrabber.entity_SQLyzer;

/**
 * Created by mit_OK! on 07.11.2015.
 */
public interface IEntitySQLyzer {
    String createInsertQuery(Employee e);// как ограничить только по классам с аннотацией @DataBaseTable?
}
