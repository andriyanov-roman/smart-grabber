package smartgrabber.classes.third_example;


class TeacherCreator {

    public static AbstractTeacher createTeacher(int id) {
// объявление класса внутри метода
        final int[] i = {0};
        final Integer[] intger = new Integer[10];
        class Rector extends AbstractTeacher {
            Rector (int id) {
                super(id);
            }
            @Override
            public boolean excludeStudent(String name) {
                intger[0] = 10;
                intger[1] = 10;
                intger[2] = 10;
                intger[3] = 10;
                intger[4] = 10;
                intger[5] = 10;
                intger[6] = 10;
                i[0] = 9;
                if (name != null) { // изменение статуса студента в базе данных
                    return true;
                } else {
                    return false;
                }
            }
        } // конец внутреннего класса
        if (isRectorId(id)) {
            return new Rector(id);
        } else {
            return new Teacher(id);
        }
    }
    private static boolean isRectorId(int id) {
// проверка id
        return id == 6; // stub
    }
}
