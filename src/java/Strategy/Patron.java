package Strategy;

interface Strate<T>{ public void comparation(Context c);}

class person
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
    
    public person(String _name, int _age, int _dni)
    {
        name = _name;
        age = _age;
        dni = _dni;
    }
    
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public int getDni()
    {
        return dni;
    }
    
}

class Context
{
    private final person[] People = {new person("Juan", 21, 46318419),
                        new person("Ana",19, 43526578), 
                        new person("Luis",15, 82674023)};
    
    public person[] getPeople()
    {
        return People;
    }
}

class strate_name implements Strate<person>
{
    @Override
    public void comparation(Context c){
        person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if((nuevo[j].getName().compareTo(nuevo[j+1].getName())>0))
                {
                    person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strate_name_inv implements Strate<person>
{
    @Override
    public void comparation(Context c){
        person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if((nuevo[j].getName().compareTo(nuevo[j+1].getName())<0))
                {
                    person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strategy_age implements Strate<person>
{
    @Override
    public void comparation(Context c){
        person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getAge()>nuevo[j+1].getAge())
                {
                    person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strategy_age_inv implements Strate<person>
{
    @Override
    public void comparation(Context c){
        person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getAge()<nuevo[j+1].getAge())
                {
                    person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strategy_dni implements Strate<person>
{
    @Override
    public void comparation(Context c){
        person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getDni()>nuevo[j+1].getDni())
                {
                    person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

class Strategy_dni_inv implements Strate<person>
{
    @Override
    public void comparation(Context c){
        person [] nuevo = c.getPeople();
        for(int i=1;i<nuevo.length;i++){
            for(int j=0;j<nuevo.length-i;j++){
                if(nuevo[j].getDni()<nuevo[j+1].getDni())
                {
                    person temp;
                    temp = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = temp;
                }
            }
            
        }
    }
}

public class Patron {

    static Context contexto = new Context();
    public static void main(String[] args) {
        Strate<person> strategia = new Strategy_age_inv();
        strategia.comparation(contexto);
        person[] nuevo = contexto.getPeople();
        for (person nuevo1 : nuevo) {
            System.out.println(nuevo1.getName() + " " + nuevo1.getAge() + " " + nuevo1.getDni());
        }

    }

}
