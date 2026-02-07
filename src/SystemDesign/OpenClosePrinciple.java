package SystemDesign;

abstract class DBPersistance {
    abstract void save();
}
class SaveToSQLDB extends DBPersistance{
    void save(){

    }
}
class SaveToMongoDB extends DBPersistance{
    void save(){

    }
}
class SaveToFile{
    void save(){

    }
}

public  class OpenClosePrinciple {
    public static void main(String[] args) {
        DBPersistance dbsave = new SaveToMongoDB();
        dbsave.save();
    }
}

