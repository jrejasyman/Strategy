package Strategy;

interface Strategy<T>{ public void comparation(context c);}

class Person
{
    private String name;
    private int age;
    private int dni;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getDni() {
        return dni;
    }
    
    public Person(String _name, int _age, int _dni)
    {
        name = _name;
        age = _age;
        dni = _dni;
    }
    
   
    
}

class context
{
    private final Person[] People = {new Person("Juan", 21, 46318419),
                        new Person("Ana",19, 43526578), 
                        new Person("Luis",15, 82674023)};
    
    public Person[] getPeople()
    {
        return People;
    }
}

class strategy_name implements Strategy<Person>
{
    @Override
    public void comparation(context c){
        Person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if((nuevo[j].getName().compareTo(nuevo[j+1].getName())>0))
                {
                    Person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strategy_name_inv implements Strategy<Person>
{
    @Override
    public void comparation(context c){
        Person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if((nuevo[j].getName().compareTo(nuevo[j+1].getName())<0))
                {
                    Person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strategy_Age implements Strategy<Person>
{
    @Override
    public void comparation(context c){
        Person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getAge()>nuevo[j+1].getAge())
                {
                    Person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strategy_ge_inv implements Strategy<Person>
{
    @Override
    public void comparation(context c){
        Person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getAge()<nuevo[j+1].getAge())
                {
                    Person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class strategy_dni implements Strategy<Person>
{
    @Override
    public void comparation(context c){
        Person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getDni()>nuevo[j+1].getDni())
                {
                    Person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class strategy_dni_inv implements Strategy<Person>
{
    @Override
    public void comparation(context c){
        Person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getDni()<nuevo[j+1].getDni())
                {
                    Person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

public class PatronStrategy {

    static context contexto = new context();
    public static void main(String[] args) {
        Strategy<Person> strategia = new Strategy_ge_inv();
        strategia.comparation(contexto);
        Person[] nuevo = contexto.getPeople();
        for (Person nuevo1 : nuevo) {
            System.out.println(nuevo1.getName() + " " + nuevo1.getAge() + " " + nuevo1.getDni());
        }

    }

}