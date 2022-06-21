package GenericClass;

public class GenericsAndInheritance {
}

interface GenericClass<T>{

}

class Son implements GenericClass<String>{

}

class Son1<T> implements GenericClass<T>{

}

class Son2<T> implements GenericClass{

}

class son4 implements GenericClass{

}


