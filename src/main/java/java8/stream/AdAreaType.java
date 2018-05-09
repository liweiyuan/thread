package java8.stream;

public enum AdAreaType {
    EXCLUDE,
    INCLUDE,
    ALL;

    public static boolean contains(String type){
        for(AdAreaType areaType:AdAreaType.values()){
            if(areaType.name().equals(type)){
                return true;
            }
        }
        return false;
    }
}