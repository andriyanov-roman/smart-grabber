package smartgrabber.entity_SQLyzer;

/**
 * Created by mit_OK! on 07.11.2015.
 */
public interface IEntitySQLyzer<T, A extends DataBaseTable> {
    String createInsertQuery(T t, A a);// ��� ���������� ������ �� ������� � ���������� @DataBaseTable?
}
